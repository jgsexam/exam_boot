package com.exam.ts.service.impl;

import com.exam.ts.pojo.StudentPaperDO;
import com.exam.ts.mapper.StudentPaperMapper;
import com.exam.ts.service.StudentPaperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生试卷表 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
@Service
public class StudentPaperServiceImpl extends ServiceImpl<StudentPaperMapper, StudentPaperDO> implements StudentPaperService {

}
