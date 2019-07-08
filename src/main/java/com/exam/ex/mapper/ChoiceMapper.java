package com.exam.ex.mapper;

import com.exam.ex.dto.GaConfigDTO;
import com.exam.ex.pojo.ChoiceDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exam.core.pojo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 选择题表 Mapper 接口
 * </p>
 *
 * @author 杨德石
 * @since 2019-03-28
 */
public interface ChoiceMapper extends BaseMapper<ChoiceDO> {

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    List<ChoiceDO> getListByPage(Page<ChoiceDO> page);

    /**
     * 查询总数
     *
     * @param page
     * @return
     */
    Integer getCountByPage(Page<ChoiceDO> page);

    /**
     * 根据map中的参数查询全部
     *
     * @param paramsMap
     * @return
     */
    List<ChoiceDO> getListByMap(Map<String, Object> paramsMap);

    /**
     * 随机查询列表（遗传算法专用）
     *
     * @param configDTO
     * @return
     */
    List<ChoiceDO> getGaList(GaConfigDTO configDTO);

    /**
     * 遗传算法专用变异查询
     *
     * @param choiceDO
     * @param configDTO
     * @return
     */
    List<ChoiceDO> getMutateList(@Param("choice") ChoiceDO choiceDO, @Param("config") GaConfigDTO configDTO);
}
