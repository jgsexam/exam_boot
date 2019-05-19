package com.exam.ts.service.impl;

import com.exam.ts.pojo.TestStudentDO;
import com.exam.ts.mapper.TestStudentMapper;
import com.exam.ts.service.TestStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考试-学生表 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-19
 */
@Service
public class TestStudentServiceImpl extends ServiceImpl<TestStudentMapper, TestStudentDO> implements TestStudentService {

}
