package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.constant.CoreConstant;
import com.exam.constant.SelectEnum;
import com.exam.mapper.PaperLogMapper;
import com.exam.pojo.Page;
import com.exam.pojo.PaperLogDO;
import com.exam.pojo.TeacherDO;
import com.exam.service.PaperLogService;
import com.exam.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 组卷日志表 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-01
 */
@Service
public class PaperLogServiceImpl extends ServiceImpl<PaperLogMapper, PaperLogDO> implements PaperLogService {

    @Autowired
    private PaperLogMapper paperLogMapper;

    @Override
    public Page<PaperLogDO> getByPage(Page<PaperLogDO> page) {
        // 处理参数
        page.filterParams();
        // 处理角色
        TeacherDO loginTeacher = ShiroUtils.getLoginTeacher();
        if(!SelectEnum.SELECT_ALL.getCode().equals(loginTeacher.getTeacherOrg())) {
            // 不是查询所有，就只查询自己学院的
            page.getParams().put("orgCollege", loginTeacher.getTeacherCollege());
        }
        // 设置每页显示条数
        if (page.getCurrentCount() == null) {
            page.setCurrentCount(CoreConstant.CURRENT_COUNT);
        }
        // 计算索引
        Integer index = (page.getCurrentPage() - 1) * page.getCurrentCount();
        page.setIndex(index);
        // 查询每页数据
        List<PaperLogDO> list = paperLogMapper.getListByPage(page);
        page.setList(list);
        Integer totalCount = paperLogMapper.getCountByPage(page);
        page.setTotalCount(totalCount);
        // 计算总页数
        page.setTotalPage((int) Math.ceil((page.getTotalCount() * 1.0) / page.getCurrentCount()));
        return page;
    }
}
