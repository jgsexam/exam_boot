package com.exam.ts.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 学生-试卷-题型得分总表
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-19
 */
@TableName("ts_paper_type_score")
public class PaperTypeScoreDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sc_id", type = IdType.AUTO)
    private String scId;

    /**
     * 题型id
     */
    private String scType;

    /**
     * 试卷id
     */
    private String scPaper;

    /**
     * 得分
     */
    private BigDecimal scScore;


    public String getScId() {
        return scId;
    }

    public void setScId(String scId) {
        this.scId = scId;
    }

    public String getScType() {
        return scType;
    }

    public void setScType(String scType) {
        this.scType = scType;
    }

    public String getScPaper() {
        return scPaper;
    }

    public void setScPaper(String scPaper) {
        this.scPaper = scPaper;
    }

    public BigDecimal getScScore() {
        return scScore;
    }

    public void setScScore(BigDecimal scScore) {
        this.scScore = scScore;
    }

    @Override
    public String toString() {
        return "PaperTypeScoreDO{" +
        "scId=" + scId +
        ", scType=" + scType +
        ", scPaper=" + scPaper +
        ", scScore=" + scScore +
        "}";
    }
}
