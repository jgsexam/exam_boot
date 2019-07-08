package com.exam.ts.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 考试-学生对应表
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
@TableName("te_exam_student")
public class ExamStudentDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "st_id", type = IdType.INPUT)
    private String stId;

    /**
     * 考试id
     */
    private String stExam;

    /**
     * 学生id
     */
    private String stStu;


    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getStExam() {
        return stExam;
    }

    public void setStExam(String stExam) {
        this.stExam = stExam;
    }

    public String getStStu() {
        return stStu;
    }

    public void setStStu(String stStu) {
        this.stStu = stStu;
    }

    @Override
    public String toString() {
        return "ExamStudentDO{" +
        "stId=" + stId +
        ", stExam=" + stExam +
        ", stStu=" + stStu +
        "}";
    }
}
