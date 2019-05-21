package com.exam.ts.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 考试表
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-21
 */
@TableName("ts_test")
public class TsTestDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "ts_id", type = IdType.AUTO)
    private String tsId;

    /**
     * 考试日期
     */
    private String tsDate;

    /**
     * 考场
     */
    private String tsRoom;

    /**
     * 考试专业
     */
    private String tsMajor;

    /**
     * 考试时间（分钟）
     */
    private Integer tsTime;

    /**
     * 创建人
     */
    private String tsCreateBy;

    /**
     * 0未开始，1已开始，2已结束
     */
    private Integer tsState;

    /**
     * 乐观锁
     */
    private Integer tsVersion;

    /**
     * 1正常0删除
     */
    private Integer tsDelete;


    public String getTsId() {
        return tsId;
    }

    public void setTsId(String tsId) {
        this.tsId = tsId;
    }

    public String getTsDate() {
        return tsDate;
    }

    public void setTsDate(String tsDate) {
        this.tsDate = tsDate;
    }

    public String getTsRoom() {
        return tsRoom;
    }

    public void setTsRoom(String tsRoom) {
        this.tsRoom = tsRoom;
    }

    public String getTsMajor() {
        return tsMajor;
    }

    public void setTsMajor(String tsMajor) {
        this.tsMajor = tsMajor;
    }

    public Integer getTsTime() {
        return tsTime;
    }

    public void setTsTime(Integer tsTime) {
        this.tsTime = tsTime;
    }

    public String getTsCreateBy() {
        return tsCreateBy;
    }

    public void setTsCreateBy(String tsCreateBy) {
        this.tsCreateBy = tsCreateBy;
    }

    public Integer getTsState() {
        return tsState;
    }

    public void setTsState(Integer tsState) {
        this.tsState = tsState;
    }

    public Integer getTsVersion() {
        return tsVersion;
    }

    public void setTsVersion(Integer tsVersion) {
        this.tsVersion = tsVersion;
    }

    public Integer getTsDelete() {
        return tsDelete;
    }

    public void setTsDelete(Integer tsDelete) {
        this.tsDelete = tsDelete;
    }

    @Override
    public String toString() {
        return "TsTestDO{" +
        "tsId=" + tsId +
        ", tsDate=" + tsDate +
        ", tsRoom=" + tsRoom +
        ", tsMajor=" + tsMajor +
        ", tsTime=" + tsTime +
        ", tsCreateBy=" + tsCreateBy +
        ", tsState=" + tsState +
        ", tsVersion=" + tsVersion +
        ", tsDelete=" + tsDelete +
        "}";
    }
}
