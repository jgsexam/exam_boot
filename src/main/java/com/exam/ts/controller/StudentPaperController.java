package com.exam.ts.controller;


import com.exam.core.constant.ResultEnum;
import com.exam.core.utils.Result;
import com.exam.ts.pojo.StudentPaperDO;
import com.exam.ts.pojo.DTO.ExPaperDTO;
import com.exam.ts.service.StudentPaperService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 学生试卷表 前端控制器
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
@RestController
@RequestMapping("/studentPaperDO")
public class StudentPaperController {

    @Autowired
    private StudentPaperService studentPaperService;


    /**
     * 进行组卷
     */
    @PostMapping("/gaExam")
    @RequiresPermissions("paper:submit")
    public Result generateExam(@RequestBody ExPaperDTO exPaperDTO) throws Exception {
        studentPaperService.gaExam(exPaperDTO);
        return Result.ok("组卷成功！");
    }


    /**
     * 返回所选考试的试卷id
     */
    @GetMapping("/list/{id}")
    public Result listById(@PathVariable("id") String id){
        return Result.ok(studentPaperService.listById(id));
    }


    /**
     * 查询学生做题的试卷信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){
        try {
            StudentPaperDO paper = studentPaperService.getPaperInfo(id);
            return Result.ok(paper);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.ERROR.getCode(), "查询失败！");
        }
    }

    @RequestMapping("/paper/submit/{id}")
    public Result correctSubmit(@PathVariable("id") String paperId){
        try {
            studentPaperService.correctSubmit(paperId);
            return Result.ok("该学生成绩完成提交");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.ERROR.getCode(), "成绩提交失败");
        }
    }





}

