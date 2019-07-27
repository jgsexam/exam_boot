package com.exam.ts.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.core.constant.CoreConstant;
import com.exam.core.constant.ExamEnum;
import com.exam.core.constant.RoomEnum;
import com.exam.core.constant.SelectEnum;
import com.exam.core.pojo.Page;
import com.exam.core.utils.DateUtils;
import com.exam.core.utils.IdWorker;
import com.exam.core.utils.ShiroUtils;
import com.exam.ex.mapper.PaperMapper;
import com.exam.ex.pojo.PaperDO;
import com.exam.ex.pojo.TeacherDO;
import com.exam.ts.mapper.ExamMapper;
import com.exam.ts.mapper.ExamStudentMapper;
import com.exam.ts.mapper.ExamTeacherMapper;
import com.exam.ts.mapper.RoomMapper;
import com.exam.ts.pojo.ExamDO;
import com.exam.ts.pojo.ExamStudentDO;
import com.exam.ts.pojo.ExamTeacherDO;
import com.exam.ts.pojo.RoomDO;
import com.exam.ts.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private RoomMapper roomMapper;
    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private ExamStudentMapper examStudentMapper;
    @Autowired
    private ExamTeacherMapper examTeacherMapper;
    @Autowired
    private IdWorker idWorker;

    /**
     * 添加考试
     *
     * @param exam
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addExam(ExamDO exam) {
        // 设置属性
        exam.setExamId(idWorker.nextId() + "");
        exam.setExamCreateBy(ShiroUtils.getLoginTeacher().getTeacherId());
        // 状态未开始
        exam.setExamState(ExamEnum.NOT_STARTED.getCode());
        exam.setExamCreateTime(DateUtils.newDateTime());
        // 存入
        examMapper.insert(exam);

        // 查询对应的考场，将状态改为已占用
        RoomDO room = roomMapper.selectById(exam.getExamRoom());
        room.setRoomState(RoomEnum.APPLY.getCode());
        roomMapper.updateById(room);
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @Override
    public Page<ExamDO> getByPage(Page<ExamDO> page) {
        // 处理参数
        page.filterParams();
        TeacherDO loginTeacher = ShiroUtils.getLoginTeacher();
        if (SelectEnum.SELECT_COLLEGE.getCode().equals(loginTeacher.getTeacherOrg())) {
            // 查询学院
            page.getParams().put("orgCollege", loginTeacher.getTeacherCollege());
        }
        if (SelectEnum.SELECT_SELF.getCode().equals(loginTeacher.getTeacherOrg())) {
            // 查询自己
            page.getParams().put("orgTeacher", loginTeacher.getTeacherId());
        }
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

    /**
     * 修改考试，同时更新考场状态
     *
     * @param exam
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateExam(ExamDO exam) {
        // 查询原始数据
        ExamDO old = examMapper.selectById(exam.getExamId());
        String oldRoomId = old.getExamRoom();
        // 如果旧的考场id和新的考场id不一样，就更新考场
        if (!oldRoomId.equals(exam.getExamRoom())) {
            // 旧考场更新为空闲
            RoomDO oldRoom = roomMapper.selectById(oldRoomId);
            oldRoom.setRoomState(RoomEnum.FREE.getCode());
            roomMapper.updateById(oldRoom);
            // 新考场更新为已占用
            RoomDO newRoom = roomMapper.selectById(exam.getExamRoom());
            newRoom.setRoomState(RoomEnum.APPLY.getCode());
            roomMapper.updateById(newRoom);
        }
        examMapper.updateById(exam);
    }

    /**
     * 删除考试，同时更新考场状态
     *
     * @param id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteExam(String id) {
        // 查询
        ExamDO examDO = examMapper.selectById(id);
        RoomDO roomDO = roomMapper.selectById(examDO.getExamRoom());
        roomDO.setRoomState(RoomEnum.FREE.getCode());
        roomMapper.updateById(roomDO);
        examMapper.deleteById(id);
    }

    /**
     * 根据id查询考试信息
     *
     * @param id
     * @return
     */
    @Override
    public ExamDO getInfo(String id) {
        // 先查基本信息
        ExamDO examDo = examMapper.selectById(id);
        // 查询考生
        List<ExamStudentDO> studentList = examStudentMapper.getListByExam(id);
        examDo.setStudentList(studentList);
        // 查询试卷信息
        PaperDO paperDO = paperMapper.selectById(examDo.getExamPaper());
        examDo.setPaper(paperDO);
        // 查询监考教师
        List<ExamTeacherDO> teacherList = examTeacherMapper.getByExamId(id);
        examDo.setTeacherList(teacherList);
        // 查询考场
        RoomDO roomDO = roomMapper.selectById(examDo.getExamRoom());
        examDo.setRoom(roomDO);
        return examDo;
    }
}
