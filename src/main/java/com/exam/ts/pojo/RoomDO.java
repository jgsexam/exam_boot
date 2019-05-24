package com.exam.ts.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 教室/考场表
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
@TableName("te_room")
public class RoomDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "room_id", type = IdType.AUTO)
    private String roomId;

    /**
     * 教室名
     */
    private String roomName;

    /**
     * 几栋
     */
    private String roomBuilding;

    /**
     * 状态，1空闲，2占用
     */
    private String roomState;

    /**
     * 备注
     */
    private String roomComment;

    /**
     * 乐观锁
     */
    private Integer roomVersion;

    /**
     * 0删除1正常
     */
    private Integer roomDelete;


    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomBuilding() {
        return roomBuilding;
    }

    public void setRoomBuilding(String roomBuilding) {
        this.roomBuilding = roomBuilding;
    }

    public String getRoomState() {
        return roomState;
    }

    public void setRoomState(String roomState) {
        this.roomState = roomState;
    }

    public String getRoomComment() {
        return roomComment;
    }

    public void setRoomComment(String roomComment) {
        this.roomComment = roomComment;
    }

    public Integer getRoomVersion() {
        return roomVersion;
    }

    public void setRoomVersion(Integer roomVersion) {
        this.roomVersion = roomVersion;
    }

    public Integer getRoomDelete() {
        return roomDelete;
    }

    public void setRoomDelete(Integer roomDelete) {
        this.roomDelete = roomDelete;
    }

    @Override
    public String toString() {
        return "RoomDO{" +
        "roomId=" + roomId +
        ", roomName=" + roomName +
        ", roomBuilding=" + roomBuilding +
        ", roomState=" + roomState +
        ", roomComment=" + roomComment +
        ", roomVersion=" + roomVersion +
        ", roomDelete=" + roomDelete +
        "}";
    }
}
