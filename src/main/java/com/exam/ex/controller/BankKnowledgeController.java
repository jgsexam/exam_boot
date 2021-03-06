package com.exam.ex.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exam.core.constant.ResultEnum;
import com.exam.ex.pojo.BankKnowledgeDO;
import com.exam.core.pojo.Page;
import com.exam.ex.service.BankKnowledgeService;
import com.exam.core.utils.IdWorker;
import com.exam.core.utils.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 知识点表 前端控制器
 * </p>
 *
 * @author 杨德石
 * @since 2019-04-11
 */
@RestController
@RequestMapping("/bankKnowledge")
public class BankKnowledgeController {

    @Autowired
    private BankKnowledgeService knowledgeService;
    @Autowired
    private IdWorker idWorker;

    /**
     * 添加知识点
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresPermissions("know:add")
    public Result add(@RequestBody BankKnowledgeDO knowledge) {
        try {
            knowledge.setKnowId(idWorker.nextId() + "");
            knowledgeService.save(knowledge);
            return Result.ok("添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.ERROR.getCode(), "添加失败！");
        }
    }

    /**
     * 分页查询知识点
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @RequiresPermissions("know:list")
    public Result list(@RequestBody Page<BankKnowledgeDO> page) {
        try {
            page = knowledgeService.getByPage(page);
            return Result.ok(page);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.ERROR.getCode(), "查询失败！");
        }
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @RequiresPermissions("know:update")
    public Result update(@RequestBody BankKnowledgeDO knowledgeDO) {
        try {
            knowledgeService.updateById(knowledgeDO);
            return Result.ok("修改成功！");
        }catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.ERROR.getCode(), "修改失败！");
        }
    }

    /**
     * 根据id删除
     */
    @RequestMapping(value = "/delete/{knowId}", method = RequestMethod.DELETE)
    @RequiresPermissions("know:delete")
    public Result delete(@PathVariable String knowId) {
        try {
            knowledgeService.removeById(knowId);
            return Result.ok("删除成功！");
        }catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.ERROR.getCode(), "删除失败！");
        }
    }

    /**
     * 根据id查询
     */
    @RequestMapping(value = "/get/{knowId}", method = RequestMethod.GET)
    public Result get(@PathVariable String knowId) {
        try {
            BankKnowledgeDO knowledgeDO = knowledgeService.getById(knowId);
            return Result.ok(knowledgeDO);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultEnum.ERROR.getCode(), "查询失败！");
        }
    }

    /**
     * 查询所有
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Result all() {
        return Result.ok(knowledgeService.list());
    }

    /**
     * 根据题库id查询所有
     */
    @RequestMapping(value = "/all/{bankId}", method = RequestMethod.GET)
    public Result all(@PathVariable String bankId) {
        return Result.ok(knowledgeService.list(new QueryWrapper<BankKnowledgeDO>().eq("know_bank", bankId)));
    }

}

