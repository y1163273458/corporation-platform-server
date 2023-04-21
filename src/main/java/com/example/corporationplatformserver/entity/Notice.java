package com.example.corporationplatformserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
@TableName("notice_table")
@Data
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 通知ID,12位数字
     */
    @TableId(value = "nid", type = IdType.AUTO)
    private long nid;

    /**
     * 通知内容
     */
    private String ncontent;

    /**
     * 未读，已读
     */
    private String nstatus;

    /**
     * 发送通知的用户ID（此处由学号代替）
     */
    private String suid;

    /**
     * 昵称
     */
    private String suname;

    /**
     * 接收通知的用户ID（此处由学号代替）
     */
    private String guid;

    /**
     * 条目创建时间
     */
    private LocalDateTime createTime;

    /**
     * 条目更新时间
     */
    private LocalDateTime updateTime;

    public Notice(){}
    public Notice(Notice notice) {
        this.nid = notice.getNid();
        this.ncontent = notice.getNcontent();
        this.nstatus = notice.getNstatus();
        this.suid = notice.getSuid();
        this.suname = notice.getSuname();
        this.guid = notice.getGuid();
        this.createTime = notice.getCreateTime();
        this.updateTime = notice.getUpdateTime();
    }

//    public Integer getNid() {
//        return nid;
//    }
//
//    public void setNid(Integer nid) {
//        this.nid = nid;
//    }
//    public String getNcontent() {
//        return ncontent;
//    }
//
//    public void setNcontent(String ncontent) {
//        this.ncontent = ncontent;
//    }
//    public String getNstatus() {
//        return nstatus;
//    }
//
//    public void setNstatus(String nstatus) {
//        this.nstatus = nstatus;
//    }
//    public String getSuid() {
//        return suid;
//    }
//
//    public void setSuid(String suid) {
//        this.suid = suid;
//    }
//    public String getSuname() {
//        return suname;
//    }
//
//    public void setSuname(String suname) {
//        this.suname = suname;
//    }
//    public String getGuid() {
//        return guid;
//    }
//
//    public void setGuid(String guid) {
//        this.guid = guid;
//    }
//    public LocalDateTime getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(LocalDateTime createTime) {
//        this.createTime = createTime;
//    }
//    public LocalDateTime getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(LocalDateTime updateTime) {
//        this.updateTime = updateTime;
//    }
//
//    @Override
//    public String toString() {
//        return "Notice{" +
//            "nid=" + nid +
//            ", ncontent=" + ncontent +
//            ", nstatus=" + nstatus +
//            ", suid=" + suid +
//            ", suname=" + suname +
//            ", guid=" + guid +
//            ", createTime=" + createTime +
//            ", updateTime=" + updateTime +
//        "}";
//    }
}
