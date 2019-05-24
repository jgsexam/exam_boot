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
 * @since 2019-05-24
 */
@TableName("te_student_paper")
public class StudentPaperDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "paper_id", type = IdType.AUTO)
    private String paperId;

    /**
     * 试卷标题
     */
    private String paperTitle;

    /**
     * 考试id
     */
    private String paperExam;

    /**
     * 起始年度
     */
    private String paperStartYear;

    /**
     * 结束年度
     */
    private String paperEndYear;

    /**
     * 第几学期，1第一学期，2第二学期
     */
    private Integer paperSeme;

    /**
     * 学院，数据字典id
     */
    private String paperCollege;

    /**
     * 题库id
     */
    private String paperBank;

    /**
     * 0未启用，1已启用，用于在线考试
     */
    private Integer paperFlag;

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
     * 所属学生id
     */
    private String paperStudent;

    /**
     * 题量
     */
    private Integer paperQuestionNum;

    /**
     * 创建时间
     */
    private String paperCreateTime;

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

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getPaperExam() {
        return paperExam;
    }

    public void setPaperExam(String paperExam) {
        this.paperExam = paperExam;
    }

    public String getPaperStartYear() {
        return paperStartYear;
    }

    public void setPaperStartYear(String paperStartYear) {
        this.paperStartYear = paperStartYear;
    }

    public String getPaperEndYear() {
        return paperEndYear;
    }

    public void setPaperEndYear(String paperEndYear) {
        this.paperEndYear = paperEndYear;
    }

    public Integer getPaperSeme() {
        return paperSeme;
    }

    public void setPaperSeme(Integer paperSeme) {
        this.paperSeme = paperSeme;
    }

    public String getPaperCollege() {
        return paperCollege;
    }

    public void setPaperCollege(String paperCollege) {
        this.paperCollege = paperCollege;
    }

    public String getPaperBank() {
        return paperBank;
    }

    public void setPaperBank(String paperBank) {
        this.paperBank = paperBank;
    }

    public Integer getPaperFlag() {
        return paperFlag;
    }

    public void setPaperFlag(Integer paperFlag) {
        this.paperFlag = paperFlag;
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

    public String getPaperStudent() {
        return paperStudent;
    }

    public void setPaperStudent(String paperStudent) {
        this.paperStudent = paperStudent;
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
        return "StudentPaperDO{" +
        "paperId=" + paperId +
        ", paperTitle=" + paperTitle +
        ", paperExam=" + paperExam +
        ", paperStartYear=" + paperStartYear +
        ", paperEndYear=" + paperEndYear +
        ", paperSeme=" + paperSeme +
        ", paperCollege=" + paperCollege +
        ", paperBank=" + paperBank +
        ", paperFlag=" + paperFlag +
        ", paperDifficulty=" + paperDifficulty +
        ", paperScore=" + paperScore +
        ", paperStudentScore=" + paperStudentScore +
        ", paperStudent=" + paperStudent +
        ", paperQuestionNum=" + paperQuestionNum +
        ", paperCreateTime=" + paperCreateTime +
        ", paperVersion=" + paperVersion +
        ", paperDelete=" + paperDelete +
        "}";
    }
}
