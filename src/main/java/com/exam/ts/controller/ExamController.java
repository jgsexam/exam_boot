package com.exam.ts.controller;

import com.exam.core.constant.ResultEnum;
import com.exam.core.pojo.Page;
import com.exam.core.utils.Result;
import com.exam.ts.pojo.ExamDO;
import com.exam.ts.service.ExamService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequiresPermissions("ex:exam:add")
    public Result createExam(@RequestBody ExamDO exam) {
        try {
            examService.addExam(exam);
            return Result.ok("操作成功！请通知学生及时考试！");
        }catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.ERROR.getCode(), "操作失败！");
        }
    }

    /**
     * 根据id删除
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @RequiresPermissions("ex:exam:delete")
    public Result delete(@PathVariable String id) {
        try {
            examService.removeById(id);
            return Result.ok("删除成功！");
        }catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.ERROR.getCode(), "删除失败！");
        }
    }

    /**
     * 根据id获取
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Result get(@PathVariable String id) {
        try {
            ExamDO examDO = examService.getById(id);
            return Result.ok(examDO);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.ERROR.getCode(), "查询失败！");
        }
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @RequiresPermissions("ex:exam:update")
    public Result update(@RequestBody ExamDO exam) {
        try {
            examService.updateById(exam);
            return Result.ok("修改成功！");
        }catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.ERROR.getCode(), "修改失败！");
        }
    }

    /**
     * 分页查询
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @RequiresPermissions("ex:exam:list")
    public Result list(@RequestBody Page<ExamDO> page) {
        try {
            page = examService.getByPage(page);
            return Result.ok(page);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.ERROR.getCode(), "查询失败！");
        }
    }

}

