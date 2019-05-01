package com.exam.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 组卷日志表
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-01
 */
@TableName("ex_paper_log")
@Data
public class PaperLogDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志id
     */
    @TableId(value = "pl_id", type = IdType.AUTO)
    private String plId;

    /**
     * 组卷教师的id
     */
    private String plTeacher;

    /**
     * 难度系数
     */
    private BigDecimal plDifficulty;

    /**
     * 试卷分值
     */
    private BigDecimal plScore;

    /**
     * 组卷时间
     */
    private String plTime;

    /**
     * 乐观锁
     */
    @Version
    private Integer plVersion;

    /**
     * 1正常0删除
     */
    @TableLogic
    private Integer plDelete;

    @Override
    public String toString() {
        return "PaperLogDO{" +
        "plId=" + plId +
        ", plTeacher=" + plTeacher +
        ", plDifficulty=" + plDifficulty +
        ", plScore=" + plScore +
        ", plTime=" + plTime +
        ", plVersion=" + plVersion +
        ", plDelete=" + plDelete +
        "}";
    }
}
