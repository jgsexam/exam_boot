package com.exam.controller;

import com.exam.constant.ResultEnum;
import com.exam.pojo.Page;
import com.exam.pojo.PaperLogDO;
import com.exam.service.PaperLogService;
import com.exam.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 组卷日志表 前端控制器
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-01
 */
@RestController
@RequestMapping("/paperLog")
public class PaperLogController {

    @Autowired
    private PaperLogService paperLogService;

    /**
     * 分页查询
     * @param page
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody Page<PaperLogDO> page) {
        try {
            page = paperLogService.getByPage(page);
            return Result.ok(page);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.ERROR.getCode(), "查询失败！");
        }
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        try {
            paperLogService.removeById(id);
            return Result.ok("删除成功！");
        }catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.ERROR.getCode(), "删除失败！");
        }
    }

}

