package com.exam.ts.mapper;

import com.exam.core.pojo.Page;
import com.exam.ts.pojo.RoomDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 教室/考场表 Mapper 接口
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
public interface RoomMapper extends BaseMapper<RoomDO> {

    /**
     * 分页查询
     * @param page
     * @return
     */
    List<RoomDO> getListByPage(Page<RoomDO> page);

    /**
     * 查询总数
     * @param page
     * @return
     */
    Integer getCountByPage(Page<RoomDO> page);
}
