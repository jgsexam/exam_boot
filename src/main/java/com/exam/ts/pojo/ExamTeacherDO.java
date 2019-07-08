package com.exam.ts.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 考试-监考教师表
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
@TableName("te_exam_teacher")
public class ExamTeacherDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ttId", type = IdType.INPUT)
    private String ttId;

    /**
     * 考试id
     */
    private String ttExam;

    /**
     * 监考教师id
     */
    private String ttTeacher;


    public String getTtId() {
        return ttId;
    }

    public void setTtId(String ttId) {
        this.ttId = ttId;
    }

    public String getTtExam() {
        return ttExam;
    }

    public void setTtExam(String ttExam) {
        this.ttExam = ttExam;
    }

    public String getTtTeacher() {
        return ttTeacher;
    }

    public void setTtTeacher(String ttTeacher) {
        this.ttTeacher = ttTeacher;
    }

    @Override
    public String toString() {
        return "ExamTeacherDO{" +
        "ttId=" + ttId +
        ", ttExam=" + ttExam +
        ", ttTeacher=" + ttTeacher +
        "}";
    }
}
