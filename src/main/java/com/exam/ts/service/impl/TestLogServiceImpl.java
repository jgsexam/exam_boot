package com.exam.ts.service.impl;

import com.exam.ts.pojo.TestLogDO;
import com.exam.ts.mapper.TestLogMapper;
import com.exam.ts.service.TestLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考试日志表 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-19
 */
@Service
public class TestLogServiceImpl extends ServiceImpl<TestLogMapper, TestLogDO> implements TestLogService {

}
