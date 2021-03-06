package com.exam.ex.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.core.exception.ExamException;
import com.exam.ex.pojo.PaperConfigDO;

import java.util.List;

/**
 * <p>
 * 试卷配置表 服务类
 * </p>
 *
 * @author 杨德石
 * @since 2019-04-12
 */
public interface PaperConfigService extends IService<PaperConfigDO> {

    /**
     * 添加题目到试卷中
     * @param config
     * @throws ExamException
     */
    void addQuestionToPaper(PaperConfigDO config) throws ExamException;

    /**
     * 查询试卷中每个题型的数量
     * @param paperId
     * @return
     */
    List<PaperConfigDO> getQuestionNum(String paperId);

    /**
     * 根据试卷id和题目id查询
     * @param paperId
     * @param questionId
     * @return
     */
    PaperConfigDO getByPaperAndQuestion(String paperId, String questionId);
}
