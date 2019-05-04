package com.exam.ga;

import com.exam.constant.TypeEnum;
import com.exam.dto.GaConfigDTO;
import com.exam.pojo.ChoiceDO;
import com.exam.pojo.CodeDO;
import com.exam.pojo.CompletionDO;
import com.exam.pojo.QuestionDO;
import com.exam.pojo.TrueFalseDO;
import com.exam.service.ChoiceService;
import com.exam.service.CodeService;
import com.exam.service.CompletionService;
import com.exam.service.TrueFalseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 遗传算法专用Service
 * 由于方法比较少所以不写接口了
 * @Author: 杨德石
 * @Date: 2019/5/3 0003 下午 4:48
 * @Version 1.0
 */
@Service
public class GaService {

    @Autowired
    private ChoiceService choiceService;
    @Autowired
    private TrueFalseService trueFalseService;
    @Autowired
    private CompletionService completionService;
    @Autowired
    private CodeService codeService;
    @Autowired
    private com.exam.service.QuestionService questionService;

    /**
     * 查询题目列表
     * @param configDTO
     * @return
     */
    public List getGaList(GaConfigDTO configDTO) {
        List list;
        // 根据dto查询出所有符合条件的题目
        if (configDTO.getTypeId().equals(TypeEnum.ONE_CHOICE.getCode().toString()) ||
                configDTO.getTypeId().equals(TypeEnum.MANY_CHOICE.getCode().toString())) {
            // 选择题
            list = choiceService.getGaList(configDTO);
        } else if (configDTO.getTypeId().equals(TypeEnum.JUDGEMENT.getCode().toString())) {
            // 判断题
            list = trueFalseService.getGaList(configDTO);
        } else if (configDTO.getTypeId().equals(TypeEnum.COMPLETION.getCode().toString())) {
            // 填空题
            list = completionService.getGaList(configDTO);
        } else if (configDTO.getTypeId().equals(TypeEnum.PROGRAMMING.getCode().toString())) {
            // 编程题
            list = codeService.getGaList(configDTO);
        } else {
            // 其他题
            list = questionService.getGaList(configDTO);
        }
        return list;
    }

    /**
     * 染色体变异，从题库中查询所有跟原题难度相同的题目
     * @param tmpQuestion
     * @return
     */
    public List getMutateList(Object tmpQuestion) {
        List list;
        // 根据dto查询出所有符合条件的题目
        if (tmpQuestion instanceof ChoiceDO) {
            // 选择题
            ChoiceDO choiceDO = (ChoiceDO) tmpQuestion;
            list = choiceService.getMutateList(choiceDO);
        } else if (tmpQuestion instanceof TrueFalseDO) {
            // 判断题
            TrueFalseDO trueFalseDO = (TrueFalseDO) tmpQuestion;
            list = trueFalseService.getMutateList(trueFalseDO);
        } else if (tmpQuestion instanceof CompletionDO) {
            // 填空题
            CompletionDO completionDO = (CompletionDO) tmpQuestion;
            list = completionService.getMutateList(completionDO);
        } else if (tmpQuestion instanceof CodeDO) {
            // 编程题
            CodeDO codeDO = (CodeDO) tmpQuestion;
            list = codeService.getMutateList(codeDO);
        } else {
            // 其他题
            QuestionDO questionDO = (QuestionDO) tmpQuestion;
            list = questionService.getMutateList(questionDO);
        }
        return list;
    }
}