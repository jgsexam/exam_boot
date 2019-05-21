package com.exam.ts.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 学生-试卷-每个题型-客观题得分表（一题一分）
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-21
 */
@TableName("ts_paper_type_obj_score")
public class TsPaperTypeObjScoreDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "qs_id", type = IdType.AUTO)
    private String qsId;

    /**
     * 所属ts_student_paper_type_score表的id
     */
    private String qsTsId;

    /**
     * 题目id
     */
    private String qsQuestion;

    /**
     * 得分
     */
    private BigDecimal qsScore;


    public String getQsId() {
        return qsId;
    }

    public void setQsId(String qsId) {
        this.qsId = qsId;
    }

    public String getQsTsId() {
        return qsTsId;
    }

    public void setQsTsId(String qsTsId) {
        this.qsTsId = qsTsId;
    }

    public String getQsQuestion() {
        return qsQuestion;
    }

    public void setQsQuestion(String qsQuestion) {
        this.qsQuestion = qsQuestion;
    }

    public BigDecimal getQsScore() {
        return qsScore;
    }

    public void setQsScore(BigDecimal qsScore) {
        this.qsScore = qsScore;
    }

    @Override
    public String toString() {
        return "TsPaperTypeObjScoreDO{" +
        "qsId=" + qsId +
        ", qsTsId=" + qsTsId +
        ", qsQuestion=" + qsQuestion +
        ", qsScore=" + qsScore +
        "}";
    }
}
