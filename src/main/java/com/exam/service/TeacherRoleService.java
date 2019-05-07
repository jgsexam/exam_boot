package com.exam.service;

import com.exam.pojo.TeacherDO;
import com.exam.pojo.TeacherRoleDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 教师-角色表 服务类
 * </p>
 *
 * @author 杨德石
 * @since 2019-04-05
 */
public interface TeacherRoleService extends IService<TeacherRoleDO> {

    /**
     * 查询老师的角色
     * @param teacherDO
     * @return
     */
    List<TeacherRoleDO> getByTeacher(TeacherDO teacherDO);

    /**
     * 为教师添加角色
     * @param list
     */
    void addRole(List<TeacherRoleDO> list);
}
