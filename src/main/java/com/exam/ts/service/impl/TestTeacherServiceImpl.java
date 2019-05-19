package com.exam.ts.service.impl;

import com.exam.ts.pojo.TestTeacherDO;
import com.exam.ts.mapper.TestTeacherMapper;
import com.exam.ts.service.TestTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考试-监考教师表 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-19
 */
@Service
public class TestTeacherServiceImpl extends ServiceImpl<TestTeacherMapper, TestTeacherDO> implements TestTeacherService {

}
