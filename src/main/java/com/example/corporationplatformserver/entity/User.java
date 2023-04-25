package com.example.corporationplatformserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author YeKaihui
 * @since 2023-04-18
 */
@TableName("user_table")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID（此处由学号代替）
     */
    @TableId
    private String uid;

    /**
     * 密码
     */
    private String upassword;

    /**
     * 昵称
     */
    private String uname;

    /**
     * 头像链接
     */
    private String uavatar;

    /**
     * 学院
     */
    private String collage;

    /**
     * 专业班级
     */
    private String uclass;

    /**
     * 条目创建时间
     */
    private LocalDateTime createTime;

    /**
     * 条目更新时间
     */
    private LocalDateTime updateTime;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getUavatar() {
        return uavatar;
    }

    public void setUavatar(String uavatar) {
        this.uavatar = uavatar;
    }
    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }
    public String getUclass() {
        return uclass;
    }

    public void setUclass(String uclass) {
        this.uclass = uclass;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
            "uid=" + uid +
            ", upassword=" + upassword +
            ", uname=" + uname +
            ", uavatar=" + uavatar +
            ", collage=" + collage +
            ", uclass=" + uclass +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
