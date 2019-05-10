package com.exam.service;

import com.exam.dto.GaConfigDTO;
import com.exam.pojo.ChoiceDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.pojo.Page;
import com.exam.utils.Result;

import java.util.List;

/**
 * <p>
 * 选择题表 服务类
 * </p>
 *
 * @author 杨德石
 * @since 2019-03-28
 */
public interface ChoiceService extends IService<ChoiceDO> {

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    Page<ChoiceDO> getByPage(Page<ChoiceDO> page);

    /**
     * 添加或修改单选题
     *
     * @param choice
     * @return
     */
    Result addOrUpdateOneChoice(ChoiceDO choice);

    /**
     * 添加或修改多选题
     *
     * @param choice
     * @return
     */
    Result addOrUpdateManyChoice(ChoiceDO choice);

    /**
     * 随机查询列表（遗传算法专用）
     *
     * @param configDTO
     * @return
     */
    List<ChoiceDO> getGaList(GaConfigDTO configDTO);

    /**
     * 遗传算法专用 变异查询
     *
     * @param choiceDO
     * @param configDTO
     * @return
     */
    List<ChoiceDO> getMutateList(ChoiceDO choiceDO, GaConfigDTO configDTO);
}
