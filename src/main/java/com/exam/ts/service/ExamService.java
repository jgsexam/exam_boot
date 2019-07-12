package com.exam.ts.service;

import com.exam.core.pojo.Page;
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
}
