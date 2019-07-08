package com.exam.ts.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 学生做题答案表
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
@TableName("te_student_answer")
public class StudentAnswerDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "answer_id", type = IdType.INPUT)
    private String answerId;

    /**
     * 答案内容
     */
    private String answerContent;

    /**
     * 学生id
     */
    private String answerStudent;

    /**
     * 哪个配置
     */
    private String answerConf;

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

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public String getAnswerStudent() {
        return answerStudent;
    }

    public void setAnswerStudent(String answerStudent) {
        this.answerStudent = answerStudent;
    }

    public String getAnswerConf() {
        return answerConf;
    }

    public void setAnswerConf(String answerConf) {
        this.answerConf = answerConf;
    }

    public String getAnswerPaper() {
        return answerPaper;
    }

    public void setAnswerPaper(String answerPaper) {
        this.answerPaper = answerPaper;
    }

    @Override
    public String toString() {
        return "StudentAnswerDO{" +
        "answerId=" + answerId +
        ", answerContent=" + answerContent +
        ", answerStudent=" + answerStudent +
        ", answerConf=" + answerConf +
        ", answerPaper=" + answerPaper +
        "}";
    }
}
