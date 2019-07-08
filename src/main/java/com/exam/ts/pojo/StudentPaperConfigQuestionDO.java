package com.exam.ts.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 学生试卷配置-题目表
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
@TableName("te_student_paper_config_question")
public class StudentPaperConfigQuestionDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 配置id
     */
    private String questionConfig;

    /**
     * 题目id
     */
    private String questionId;

    /**
     * 是否批改，0未批改，1已批改
     */
    private Integer questionState;


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

    public Integer getQuestionState() {
        return questionState;
    }

    public void setQuestionState(Integer questionState) {
        this.questionState = questionState;
    }

    @Override
    public String toString() {
        return "StudentPaperConfigQuestionDO{" +
        "id=" + id +
        ", questionConfig=" + questionConfig +
        ", questionId=" + questionId +
        ", questionState=" + questionState +
        "}";
    }
}
