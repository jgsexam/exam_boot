package com.exam.ts.service;

import com.exam.core.exception.ExamException;
import com.exam.core.pojo.Page;
import com.exam.ex.dto.GaPaperDTO;
import com.exam.ts.pojo.ExamDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 考试表 服务类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
public interface ExamService extends IService<ExamDO> {

    /**
     * 添加考试
     * @param exam
     */
    void addExam(ExamDO exam);

    /**
     * 分页查询
     * @param page
     * @return
     */
    Page<ExamDO> getByPage(Page<ExamDO> page);

    /**
     * 修改考试
     * @param exam
     */
    void updateExam(ExamDO exam);

    /**
     * 删除考试
     * @param id
     */
    void deleteExam(String id);

    /**
     * 根据id查询考试信息
     * @param id
     * @return
     */
    ExamDO getInfo(String id);

    /**
     * 生成试卷
     * @param paperDTO
     */
    void createPaper(GaPaperDTO paperDTO) throws ExamException;
}
