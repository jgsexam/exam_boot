package com.exam.ex.mapper;

import com.exam.core.pojo.Page;
import com.exam.ex.pojo.TypeDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 题型表 Mapper 接口
 * </p>
 *
 * @author 杨德石
 * @since 2019-03-28
 */
public interface TypeMapper extends BaseMapper<TypeDO> {

    /**
     * 分页查询
     * @param page
     * @return
     */
    List<TypeDO> getListByPage(Page<TypeDO> page);

    /**
     * 查询总数
     * @param page
     * @return
     */
    Integer getCountByPage(Page<TypeDO> page);

}
