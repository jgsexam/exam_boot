package com.exam.ts.service.impl;

import com.exam.ts.pojo.ExamStudentDO;
import com.exam.ts.mapper.ExamStudentMapper;
import com.exam.ts.service.ExamStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考试-学生对应表 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
@Service
public class ExamStudentServiceImpl extends ServiceImpl<ExamStudentMapper, ExamStudentDO> implements ExamStudentService {

}
