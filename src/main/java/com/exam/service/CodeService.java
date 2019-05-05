package com.exam.service;

import com.exam.dto.GaConfigDTO;
import com.exam.pojo.CodeDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.pojo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 编程题 服务类
 * </p>
 *
 * @author 杨德石
 * @since 2019-04-17
 */
public interface CodeService extends IService<CodeDO> {

    /**
     * 添加编程题
     *
     * @param code
     */
    void addCode(CodeDO code);

    /**
     * 更新编程题
     *
     * @param codeDO
     */
    void updateCode(CodeDO codeDO);

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    Page<CodeDO> getByPage(Page<CodeDO> page);

    /**
     * 随机查询列表（遗传算法专用）
     *
     * @param configDTO
     * @return
     */
    List<CodeDO> getGaList(GaConfigDTO configDTO);

    /**
     * 遗传算法专用变异查询
     *
     * @param codeDO
     * @param ids
     * @return
     */
    List<CodeDO> getMutateList(@Param("code") CodeDO codeDO, @Param("ids") List<String> ids);
}
