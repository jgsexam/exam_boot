package com.exam.mapper;

import com.exam.dto.GaConfigDTO;
import com.exam.pojo.CompletionDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exam.pojo.Page;

import java.util.List;

/**
 * <p>
 * 填空题表 Mapper 接口
 * </p>
 *
 * @author 杨德石
 * @since 2019-03-28
 */
public interface CompletionMapper extends BaseMapper<CompletionDO> {

    /**
     * 分页查询
     * @param page
     * @return
     */
    List<CompletionDO> getListByPage(Page<CompletionDO> page);

    /**
     * 查询总数
     * @param page
     * @return
     */
    Integer getCountByPage(Page<CompletionDO> page);

    /**
     * 根据id列表查询
     * @param ids
     * @return
     */
    List<CompletionDO> getByIds(List<String> ids);

    /**
     * 遗传算法专用查询列表
     * @param configDTO
     * @return
     */
    List<CompletionDO> getGaList(GaConfigDTO configDTO);

    /**
     * 遗传算法专用变异查询
     * @param completionDO
     * @return
     */
    List<CompletionDO> getMutateList(CompletionDO completionDO);
}
