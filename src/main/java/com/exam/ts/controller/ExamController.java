package com.exam.ts.controller;

import com.exam.core.constant.ResultEnum;
import com.exam.core.utils.Result;
import com.exam.ts.pojo.ExamDO;
import com.exam.ts.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 考试表 前端控制器
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    /**
     * 创建考试
     * 只创建基本信息，包括所用试卷
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result createExam(@RequestBody ExamDO exam) {
        try {
            return Result.ok("操作成功！请通知学生及时考试！");
        }catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.ERROR.getCode(), "操作失败！");
        }
    }

}

