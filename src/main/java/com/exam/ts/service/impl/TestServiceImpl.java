package com.exam.ts.service.impl;

import com.exam.ts.pojo.TestDO;
import com.exam.ts.mapper.TestMapper;
import com.exam.ts.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考试表 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-19
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestDO> implements TestService {

}
