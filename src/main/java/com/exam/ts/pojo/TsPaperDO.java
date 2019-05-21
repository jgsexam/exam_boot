package com.exam.ts.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 学生试卷表
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-21
 */
@TableName("ts_paper")
public class TsPaperDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "paper_id", type = IdType.AUTO)
    private String paperId;

    /**
     * 所属题库中的试卷id
     */
    private String paperExId;

    /**
     * 属于哪一场考试
     */
    private String paperTest;

    /**
     * 试卷标题
     */
    private String paperTitle;

    /**
     * 难度系数
     */
    private BigDecimal paperDifficulty;

    /**
     * 总分
     */
    private BigDecimal paperScore;

    /**
     * 实际得分
     */
    private BigDecimal paperStudentScore;

    /**
     * 题量
     */
    private Integer paperQuestionNum;

    /**
     * 创建时间
     */
    private String paperCreateTime;

    /**
     * 所属学生
     */
    private String paperStudent;

    /**
     * 乐观锁
     */
    private Integer paperVersion;

    /**
     * 0删除1正常
     */
    private Integer paperDelete;


    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getPaperExId() {
        return paperExId;
    }

    public void setPaperExId(String paperExId) {
        this.paperExId = paperExId;
    }

    public String getPaperTest() {
        return paperTest;
    }

    public void setPaperTest(String paperTest) {
        this.paperTest = paperTest;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public BigDecimal getPaperDifficulty() {
        return paperDifficulty;
    }

    public void setPaperDifficulty(BigDecimal paperDifficulty) {
        this.paperDifficulty = paperDifficulty;
    }

    public BigDecimal getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(BigDecimal paperScore) {
        this.paperScore = paperScore;
    }

    public BigDecimal getPaperStudentScore() {
        return paperStudentScore;
    }

    public void setPaperStudentScore(BigDecimal paperStudentScore) {
        this.paperStudentScore = paperStudentScore;
    }

    public Integer getPaperQuestionNum() {
        return paperQuestionNum;
    }

    public void setPaperQuestionNum(Integer paperQuestionNum) {
        this.paperQuestionNum = paperQuestionNum;
    }

    public String getPaperCreateTime() {
        return paperCreateTime;
    }

    public void setPaperCreateTime(String paperCreateTime) {
        this.paperCreateTime = paperCreateTime;
    }

    public String getPaperStudent() {
        return paperStudent;
    }

    public void setPaperStudent(String paperStudent) {
        this.paperStudent = paperStudent;
    }

    public Integer getPaperVersion() {
        return paperVersion;
    }

    public void setPaperVersion(Integer paperVersion) {
        this.paperVersion = paperVersion;
    }

    public Integer getPaperDelete() {
        return paperDelete;
    }

    public void setPaperDelete(Integer paperDelete) {
        this.paperDelete = paperDelete;
    }

    @Override
    public String toString() {
        return "TsPaperDO{" +
        "paperId=" + paperId +
        ", paperExId=" + paperExId +
        ", paperTest=" + paperTest +
        ", paperTitle=" + paperTitle +
        ", paperDifficulty=" + paperDifficulty +
        ", paperScore=" + paperScore +
        ", paperStudentScore=" + paperStudentScore +
        ", paperQuestionNum=" + paperQuestionNum +
        ", paperCreateTime=" + paperCreateTime +
        ", paperStudent=" + paperStudent +
        ", paperVersion=" + paperVersion +
        ", paperDelete=" + paperDelete +
        "}";
    }
}
