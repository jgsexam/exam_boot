package com.exam.ts.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.core.constant.CoreConstant;
import com.exam.core.constant.ExamEnum;
import com.exam.core.pojo.Page;
import com.exam.core.utils.IdWorker;
import com.exam.core.utils.ShiroUtils;
import com.exam.ts.mapper.ExamMapper;
import com.exam.ts.pojo.ExamDO;
import com.exam.ts.pojo.RoomDO;
import com.exam.ts.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 考试表 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, ExamDO> implements ExamService {

    @Autowired
    private ExamMapper examMapper;
    @Autowired
    private IdWorker idWorker;

    /**
     * 添加考试
     * @param exam
     */
    @Override
    public void addExam(ExamDO exam) {
        // 设置属性
        exam.setExamId(idWorker.nextId()+"");
        exam.setExamCreateBy(ShiroUtils.getLoginTeacher().getTeacherId());
        // 状态未开始
        exam.setExamState(ExamEnum.NOT_STARTED.getCode());
        // 存入
        examMapper.insert(exam);
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @Override
    public Page<ExamDO> getByPage(Page<ExamDO> page) {
        // 处理参数
        page.filterParams();
        // 设置每页显示条数
        if (page.getCurrentCount() == null) {
            page.setCurrentCount(CoreConstant.CURRENT_COUNT);
        }
        // 计算索引
        Integer index = (page.getCurrentPage() - 1) * page.getCurrentCount();
        page.setIndex(index);
        // 查询每页数据
        List<ExamDO> list = examMapper.getListByPage(page);
        page.setList(list);
        Integer totalCount = examMapper.getCountByPage(page);
        page.setTotalCount(totalCount);
        // 计算总页数
        page.setTotalPage((int) Math.ceil((page.getTotalCount() * 1.0) / page.getCurrentCount()));
        return page;
    }
}
