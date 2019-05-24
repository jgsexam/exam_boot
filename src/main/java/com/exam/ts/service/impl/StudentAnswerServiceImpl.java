package com.exam.ts.service.impl;

import com.exam.ts.pojo.StudentAnswerDO;
import com.exam.ts.mapper.StudentAnswerMapper;
import com.exam.ts.service.StudentAnswerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生做题答案表 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
@Service
public class StudentAnswerServiceImpl extends ServiceImpl<StudentAnswerMapper, StudentAnswerDO> implements StudentAnswerService {

}
