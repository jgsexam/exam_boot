package com.exam.ts.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 考试-学生表
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-21
 */
@TableName("ts_test_student")
public class TsTestStudentDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "st_id", type = IdType.AUTO)
    private String stId;

    /**
     * 考试id 
     */
    private String stTest;

    /**
     * 学生id
     */
    private String stStu;


    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getStTest() {
        return stTest;
    }

    public void setStTest(String stTest) {
        this.stTest = stTest;
    }

    public String getStStu() {
        return stStu;
    }

    public void setStStu(String stStu) {
        this.stStu = stStu;
    }

    @Override
    public String toString() {
        return "TsTestStudentDO{" +
        "stId=" + stId +
        ", stTest=" + stTest +
        ", stStu=" + stStu +
        "}";
    }
}
