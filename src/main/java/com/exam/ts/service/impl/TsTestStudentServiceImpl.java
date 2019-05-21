package com.exam.ts.service.impl;

import com.exam.ts.pojo.TsTestStudentDO;
import com.exam.ts.mapper.TsTestStudentMapper;
import com.exam.ts.service.TsTestStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考试-学生表 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-21
 */
@Service
public class TsTestStudentServiceImpl extends ServiceImpl<TsTestStudentMapper, TsTestStudentDO> implements TsTestStudentService {

}
