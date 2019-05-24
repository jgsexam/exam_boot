package com.exam.ts.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 考试表
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
@TableName("te_exam")
public class ExamDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "exam_id", type = IdType.AUTO)
    private String examId;

    /**
     * 考试日期
     */
    private String examDate;

    /**
     * 考场id
     */
    private String examRoom;

    /**
     * 考试时间
     */
    private Integer examTime;

    /**
     * 考试所用试卷id
     */
    private String examPaper;

    /**
     * 创建人id
     */
    private String examCreateBy;

    /**
     * 考试类型，0平常测试，1普通考试，2补考
     */
    private Integer examType;

    /**
     * 0未开始，1已开始，2已结束
     */
    private Integer examState;

    /**
     * 备注
     */
    private String examComment;

    /**
     * 乐观锁
     */
    private Integer examVersion;

    /**
     * 1正常0删除
     */
    private Integer examDelete;


    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamRoom() {
        return examRoom;
    }

    public void setExamRoom(String examRoom) {
        this.examRoom = examRoom;
    }

    public Integer getExamTime() {
        return examTime;
    }

    public void setExamTime(Integer examTime) {
        this.examTime = examTime;
    }

    public String getExamPaper() {
        return examPaper;
    }

    public void setExamPaper(String examPaper) {
        this.examPaper = examPaper;
    }

    public String getExamCreateBy() {
        return examCreateBy;
    }

    public void setExamCreateBy(String examCreateBy) {
        this.examCreateBy = examCreateBy;
    }

    public Integer getExamType() {
        return examType;
    }

    public void setExamType(Integer examType) {
        this.examType = examType;
    }

    public Integer getExamState() {
        return examState;
    }

    public void setExamState(Integer examState) {
        this.examState = examState;
    }

    public String getExamComment() {
        return examComment;
    }

    public void setExamComment(String examComment) {
        this.examComment = examComment;
    }

    public Integer getExamVersion() {
        return examVersion;
    }

    public void setExamVersion(Integer examVersion) {
        this.examVersion = examVersion;
    }

    public Integer getExamDelete() {
        return examDelete;
    }

    public void setExamDelete(Integer examDelete) {
        this.examDelete = examDelete;
    }

    @Override
    public String toString() {
        return "ExamDO{" +
        "examId=" + examId +
        ", examDate=" + examDate +
        ", examRoom=" + examRoom +
        ", examTime=" + examTime +
        ", examPaper=" + examPaper +
        ", examCreateBy=" + examCreateBy +
        ", examType=" + examType +
        ", examState=" + examState +
        ", examComment=" + examComment +
        ", examVersion=" + examVersion +
        ", examDelete=" + examDelete +
        "}";
    }
}
