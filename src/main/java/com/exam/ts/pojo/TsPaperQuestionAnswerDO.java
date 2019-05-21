package com.exam.ts.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 试卷-题目-答案表
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-21
 */
@TableName("ts_paper_question_answer")
public class TsPaperQuestionAnswerDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "answer_id", type = IdType.AUTO)
    private String answerId;

    /**
     * 题目id
     */
    private String answerQuestion;

    /**
     * 答案内容
     */
    private String answerContent;

    /**
     * 题型
     */
    private String answerType;

    /**
     * 学生id
     */
    private String answerStudent;

    /**
     * 试卷id
     */
    private String answerPaper;


    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getAnswerQuestion() {
        return answerQuestion;
    }

    public void setAnswerQuestion(String answerQuestion) {
        this.answerQuestion = answerQuestion;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public String getAnswerStudent() {
        return answerStudent;
    }

    public void setAnswerStudent(String answerStudent) {
        this.answerStudent = answerStudent;
    }

    public String getAnswerPaper() {
        return answerPaper;
    }

    public void setAnswerPaper(String answerPaper) {
        this.answerPaper = answerPaper;
    }

    @Override
    public String toString() {
        return "TsPaperQuestionAnswerDO{" +
        "answerId=" + answerId +
        ", answerQuestion=" + answerQuestion +
        ", answerContent=" + answerContent +
        ", answerType=" + answerType +
        ", answerStudent=" + answerStudent +
        ", answerPaper=" + answerPaper +
        "}";
    }
}
