package com.exam.ts.service.impl;

import com.exam.ts.pojo.ExamLogDO;
import com.exam.ts.mapper.ExamLogMapper;
import com.exam.ts.service.ExamLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考试日志表 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
@Service
public class ExamLogServiceImpl extends ServiceImpl<ExamLogMapper, ExamLogDO> implements ExamLogService {

}
