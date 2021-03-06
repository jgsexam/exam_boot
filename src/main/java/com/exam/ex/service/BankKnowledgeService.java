package com.exam.ex.service;

import com.exam.ex.pojo.BankKnowledgeDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.core.pojo.Page;

/**
 * <p>
 * 知识点表 服务类
 * </p>
 *
 * @author 杨德石
 * @since 2019-04-11
 */
public interface BankKnowledgeService extends IService<BankKnowledgeDO> {

    /**
     * 分页查询
     * @param page
     * @return
     */
    Page<BankKnowledgeDO> getByPage(Page<BankKnowledgeDO> page);
}
