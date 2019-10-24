package com.exam.ts.mapper;

import com.exam.core.pojo.Page;
import com.exam.ts.pojo.ExamLogDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 考试日志表 Mapper 接口
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
public interface ExamLogMapper extends BaseMapper<ExamLogDO> {

    /**
     * 分页查询
     */
    List<ExamLogDO> getListByPage(Page<ExamLogDO> page);


    Integer getCountByPage(Page<ExamLogDO> page);
}
