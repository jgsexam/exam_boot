package com.exam.ts.service.impl;

import com.exam.ts.pojo.ExamDO;
import com.exam.ts.mapper.ExamMapper;
import com.exam.ts.service.ExamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考试表 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, ExamDO> implements ExamService {

}
