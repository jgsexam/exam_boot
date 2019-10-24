package com.exam.ts.controller;


import com.exam.core.exception.ExamException;
import com.exam.core.utils.Result;
import com.exam.ts.pojo.StudentAnswerDO;
import com.exam.ts.pojo.DTO.AnswerDTO;
import com.exam.ts.pojo.DTO.TopicDTO;
import com.exam.ts.service.StudentAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 学生做题答案表 前端控制器
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
@RestController
@RequestMapping("/studentAnswerDO")
public class StudentAnswerController {

    @Autowired
    private StudentAnswerService studentAnswerService;

    /**
     *  点击进入下一题
     */
    @RequestMapping(value = "/next", method = RequestMethod.POST)
    public Result next(@RequestBody AnswerDTO answerDTO) {
        TopicDTO topicDTO = null;
        try {
            topicDTO = studentAnswerService.saveThenNext(answerDTO);
            return new Result(topicDTO);
        } catch (ExamException e) {
            e.printStackTrace();
            return new Result("未知错误");
        }
    }

    /**
     * 提交试卷
     */
    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public Result submit(@RequestBody StudentAnswerDO studentAnswerDO){
        return new Result(studentAnswerService.submit(studentAnswerDO));
    }
}

