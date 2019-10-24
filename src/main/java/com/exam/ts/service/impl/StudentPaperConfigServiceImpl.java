package com.exam.ts.service.impl;

import com.exam.ex.pojo.PaperDO;
import com.exam.ts.mapper.ExamMapper;
import com.exam.ts.pojo.ExamDO;
import com.exam.ts.pojo.StudentPaperConfigDO;
import com.exam.ts.mapper.StudentPaperConfigMapper;
import com.exam.ts.service.StudentPaperConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 学生试卷配置表 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
@Service
public class StudentPaperConfigServiceImpl extends ServiceImpl<StudentPaperConfigMapper, StudentPaperConfigDO> implements StudentPaperConfigService {

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private StudentPaperConfigMapper studentPaperConfigMapper;


    /**
     * 查询试卷中每个题型的数量
     * @param id
     * @return
     */
    @Override
    public List<StudentPaperConfigDO> getQuestionNum(String id) {
        ExamDO examDO = examMapper.selectById(id);
        if(examDO != null){
            List<StudentPaperConfigDO> list = studentPaperConfigMapper.getQuestionNum(examDO.getPaper().getPaperId());
        }
        return null;
    }
}
