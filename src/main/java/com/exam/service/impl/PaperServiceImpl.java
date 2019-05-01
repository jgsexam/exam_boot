package com.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.constant.CoreConstant;
import com.exam.constant.PatternConstant;
import com.exam.constant.SubmitConstant;
import com.exam.constant.TypeEnum;
import com.exam.mapper.ChoiceMapper;
import com.exam.mapper.CodeMapper;
import com.exam.mapper.CompletionMapper;
import com.exam.mapper.PaperConfigMapper;
import com.exam.mapper.PaperMapper;
import com.exam.mapper.QuestionMapper;
import com.exam.mapper.TrueFalseMapper;
import com.exam.pojo.ChoiceAnswerDO;
import com.exam.pojo.ChoiceDO;
import com.exam.pojo.CodeDO;
import com.exam.pojo.CompletionDO;
import com.exam.pojo.Page;
import com.exam.pojo.PaperConfigDO;
import com.exam.pojo.PaperConfigQuestionDO;
import com.exam.pojo.PaperDO;
import com.exam.pojo.QuestionDO;
import com.exam.pojo.TrueFalseDO;
import com.exam.service.PaperConfigQuestionService;
import com.exam.service.PaperService;
import com.exam.utils.StringUtils;
import com.exam.utils.ToWordUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <p>
 * 试卷表 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-04-20
 */
@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, PaperDO> implements PaperService {

    @Autowired
    private PaperConfigQuestionService paperConfigQuestionService;
    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private PaperConfigMapper paperConfigMapper;
    @Autowired
    private ChoiceMapper choiceMapper;
    @Autowired
    private TrueFalseMapper trueFalseMapper;
    @Autowired
    private CompletionMapper completionMapper;
    @Autowired
    private CodeMapper codeMapper;
    @Autowired
    private QuestionMapper questionMapper;

    private static final Pattern UNDER_LINE_PATTERN = PatternConstant.THREE_UNDER_LINE_PATTERN;

    /**
     * 分页查询
     */
    @Override
    public Page<PaperDO> getByPage(Page<PaperDO> page) {
        // 处理参数
        page.filterParams();
        // 设置每页显示条数
        if (page.getCurrentCount() == null) {
            page.setCurrentCount(CoreConstant.CURRENT_COUNT);
        }
        // 计算索引
        Integer index = (page.getCurrentPage() - 1) * page.getCurrentCount();
        page.setIndex(index);
        // 查询每页数据
        List<PaperDO> list = paperMapper.getListByPage(page);

        page.setList(list);
        Integer totalCount = paperMapper.getCountByPage(page);
        page.setTotalCount(totalCount);
        // 计算总页数
        page.setTotalPage((int) Math.ceil((page.getTotalCount() * 1.0) / page.getCurrentCount()));
        return page;
    }

    /**
     * 查询题目列表
     * 查询试卷的配置和配置题目
     * 遍历试卷的配置，查询出每个题目列表，封装进集合
     */
    @Override
    public PaperDO getQuestion(String paperId) {
        // 连表一次查询出试卷内容
        PaperDO paper = paperMapper.getPaperQuestion(paperId);
        List<PaperConfigDO> configList = paper.getConfigList();
        // 遍历集合，对集合分组
        Map<String, List<String>> configMap = Maps.newHashMap();
        for (PaperConfigDO configDO : configList) {
            List<String> questionIds = configMap.get(configDO.getConfigType());
            if (questionIds == null) {
                questionIds = Lists.newArrayList();
            }
            questionIds.addAll(configDO.getQuestionList().stream().map(PaperConfigQuestionDO::getQuestionId).collect(Collectors.toList()));
            configMap.put(configDO.getConfigType(), questionIds);
        }
        // 查询每个题型的分值、题目数
        List<PaperConfigDO> newConfigList = paperConfigMapper.getQuestionNum(paperId);

        // 分组完毕，遍历map，查询题目列表
        for (PaperConfigDO paperConfigDO : newConfigList) {
            String key = paperConfigDO.getConfigType();
            List<String> questionIds = configMap.get(key);
            // 获取id列表
            if (key.equals(TypeEnum.ONE_CHOICE.getCode().toString()) || key.equals(TypeEnum.MANY_CHOICE.getCode().toString())) {
                // 选择题
                Map<String, Object> paramsMap = Maps.newHashMap();
                paramsMap.put("choiceType", key);
                paramsMap.put("choiceIds", questionIds);
                List<ChoiceDO> choiceList = choiceMapper.getListByMap(paramsMap);
                // 过滤正确答案选项
                choiceList.forEach(e -> {
                    List<String> numberList = e.getChoiceAnswer().stream().filter(ChoiceAnswerDO::getAnswerTrue)
                            .map(ChoiceAnswerDO::getAnswerNumber).collect(Collectors.toList());
                    e.setChoiceTrue(StringUtils.join(numberList, ", "));
                });
                paperConfigDO.setQuestionDetailList(choiceList);
            } else if (key.equals(TypeEnum.JUDGEMENT.getCode().toString())) {
                // 判断题
                List<TrueFalseDO> trueFalseDOList = trueFalseMapper.selectBatchIds(questionIds);
                paperConfigDO.setQuestionDetailList(trueFalseDOList);
            } else if (key.equals(TypeEnum.COMPLETION.getCode().toString())) {
                // 填空题
                List<CompletionDO> completionDOList = completionMapper.getByIds(questionIds);
                paperConfigDO.setQuestionDetailList(completionDOList);
            } else if (key.equals(TypeEnum.PROGRAMMING.getCode().toString())) {
                // 编程题
                List<CodeDO> codeDOList = codeMapper.getByIds(questionIds);
                paperConfigDO.setQuestionDetailList(codeDOList);
            } else {
                // 其他题
                List<QuestionDO> questionDOList = questionMapper.getByIds(questionIds);
                paperConfigDO.setQuestionDetailList(questionDOList);
            }
        }

        // 排一下序
        newConfigList.sort(Comparator.comparingInt(c -> Integer.parseInt(c.getConfigType())));
        // 设置新的配置
        paper.setConfigList(newConfigList);
        return paper;
    }

    /**
     * 提交组卷
     * 将试卷组卷状态改为已提交
     * 根据模板生成一份试卷
     * 更新试卷的下载链接
     *
     * @param paperId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void submit(String paperId) throws Exception {
        // 先生成试卷
        PaperDO paper = getQuestion(paperId);
        // 下面生成一份试卷在服务器里
        ToWordUtil toWordUtil = new ToWordUtil(CoreConstant.TEMPLATE_FOLD);
        toWordUtil.setTemplateName(CoreConstant.TEMPLATE_FILE_NAME);

        String filename = paper.getPaperTitle() + ".docx";

        toWordUtil.setFileName(filename);
        toWordUtil.setFilePath(CoreConstant.PAPER_URL);
        toWordUtil.createWord(paper);
        // 创建试卷成功
        // 更新状态为已提交
        paper.setPaperSubmit(SubmitConstant.SUBMIT.getCode());
        // 更新试卷下载链接
        String downloadUrl = CoreConstant.SERVER_FILE_URL + filename;
        paper.setPaperDownload(downloadUrl);
        paperMapper.updateById(paper);
    }

    /**
     * 根据分类id和题目id从试卷中删除题目
     *
     * @param paperId
     * @param questionId
     */
    @Override
    public void deleteQuestion(String paperId, String questionId) {

        // 查询到配置、试卷
        PaperDO paperDO = paperMapper.selectById(paperId);

        // 先查询试卷配置
        PaperConfigDO paperConfigDO = paperConfigMapper.getByPaperAndQuestion(paperId, questionId);

        String configType = paperConfigDO.getConfigType();

        // 删除试卷配置
        paperConfigQuestionService.remove(new QueryWrapper<PaperConfigQuestionDO>()
                .eq("question_config", paperConfigDO.getConfigId())
                .eq("question_id", questionId));

        // 删除之后，根据配置id和题目id查询题目，获取到分值和难度系数
        BigDecimal score;
        Integer difficulty;
        if (TypeEnum.ONE_CHOICE.getCode().toString().equalsIgnoreCase(configType) ||
                TypeEnum.MANY_CHOICE.getCode().toString().equals(configType)) {
            // 是选择题
            ChoiceDO choiceDO = choiceMapper.selectById(questionId);
            score = choiceDO.getChoiceScore();
            difficulty = choiceDO.getChoiceDifficulty();
        } else if (TypeEnum.JUDGEMENT.getCode().toString().equals(configType)) {
            // 判断题
            TrueFalseDO trueFalseDO = trueFalseMapper.selectById(questionId);
            score = trueFalseDO.getTfScore();
            difficulty = trueFalseDO.getTfDifficulty();
        } else if (TypeEnum.COMPLETION.getCode().toString().equals(configType)) {
            // 填空题
            CompletionDO completionDO = completionMapper.selectById(questionId);
            score = completionDO.getCompScore();
            difficulty = completionDO.getCompDifficulty();
        } else if (TypeEnum.PROGRAMMING.getCode().toString().equals(configType)) {
            CodeDO codeDO = codeMapper.selectById(questionId);
            score = codeDO.getCodeScore();
            difficulty = codeDO.getCodeDifficulty();
        } else {
            // 是其他题
            QuestionDO questionDO = questionMapper.selectById(questionId);
            score = questionDO.getQuestionScore();
            difficulty = questionDO.getQuestionDifficulty();
        }

        // 重新计算配置和试卷的分值、题目亮、难度系数
        // 计算配置的
        paperConfigDO.setConfigScore(paperConfigDO.getConfigScore().subtract(score));
        paperConfigDO.setConfigQuestionNum(paperConfigDO.getConfigQuestionNum() - 1);
        paperConfigMapper.updateById(paperConfigDO);

        // 计算试卷的
        Integer oldNum = paperDO.getPaperQuestionNum();
        BigDecimal oldDiff = paperDO.getPaperDifficulty();
        Integer newNum = oldNum - 1;
        BigDecimal newDiff = oldDiff.multiply(new BigDecimal(oldNum)).subtract(new BigDecimal(difficulty)).divide(new BigDecimal(newNum), 1);

        paperDO.setPaperDifficulty(newDiff);
        paperDO.setPaperScore(paperDO.getPaperScore().subtract(score));
        paperDO.setPaperQuestionNum(newNum);
        paperMapper.updateById(paperDO);
    }
}
