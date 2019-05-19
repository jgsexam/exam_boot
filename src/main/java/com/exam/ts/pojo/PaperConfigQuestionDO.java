package com.exam.ts.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 试卷配置-题目表
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-19
 */
@TableName("ts_paper_config_question")
public class PaperConfigQuestionDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 配置id
     */
    private String questionConfig;

    /**
     * 题目id
     */
    private String questionId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionConfig() {
        return questionConfig;
    }

    public void setQuestionConfig(String questionConfig) {
        this.questionConfig = questionConfig;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "PaperConfigQuestionDO{" +
        "id=" + id +
        ", questionConfig=" + questionConfig +
        ", questionId=" + questionId +
        "}";
    }
}
