package com.exam.ex.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.ex.mapper.QuestionAnswerMapper;
import com.exam.ex.pojo.QuestionAnswerDO;
import com.exam.ex.pojo.QuestionDO;
import com.exam.ex.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 其他题目答案 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-04-18
 */
@Service
public class QuestionAnswerServiceImpl extends ServiceImpl<QuestionAnswerMapper, QuestionAnswerDO> implements QuestionAnswerService {

    @Autowired
    private QuestionAnswerMapper questionAnswerMapper;

    /**
     * 删除旧小题
     * @param question
     */
    @Override
    public void deleteOldAnswer(QuestionDO question) {
        questionAnswerMapper.deleteOldAnswer(question);
    }
}
