package com.exam.ts.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 考试-监考教师表
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-21
 */
@TableName("ts_test_teacher")
public class TsTestTeacherDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "tt_id", type = IdType.AUTO)
    private String ttId;

    /**
     * 考试id
     */
    private String ttTest;

    /**
     * 监考教师
     */
    private String ttTeacher;


    public String getTtId() {
        return ttId;
    }

    public void setTtId(String ttId) {
        this.ttId = ttId;
    }

    public String getTtTest() {
        return ttTest;
    }

    public void setTtTest(String ttTest) {
        this.ttTest = ttTest;
    }

    public String getTtTeacher() {
        return ttTeacher;
    }

    public void setTtTeacher(String ttTeacher) {
        this.ttTeacher = ttTeacher;
    }

    @Override
    public String toString() {
        return "TsTestTeacherDO{" +
        "ttId=" + ttId +
        ", ttTest=" + ttTest +
        ", ttTeacher=" + ttTeacher +
        "}";
    }
}
