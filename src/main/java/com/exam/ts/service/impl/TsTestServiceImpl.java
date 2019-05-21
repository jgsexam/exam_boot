package com.exam.ts.service.impl;

import com.exam.ts.pojo.TsTestDO;
import com.exam.ts.mapper.TsTestMapper;
import com.exam.ts.service.TsTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考试表 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-21
 */
@Service
public class TsTestServiceImpl extends ServiceImpl<TsTestMapper, TsTestDO> implements TsTestService {

}
