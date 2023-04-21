package com.example.corporationplatformserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2023-04-20
 */
@TableName("process_table")
public class Process implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 活动ID,8位数字
     */
    @TableId(value = "aid", type = IdType.AUTO)
    private Integer aid;

    /**
     * 活动名称
     */
    private String aname;

    /**
     * 活动封面图片
     */
    private String aimage;

    /**
     * 活动开始报名时间
     */
    private LocalDateTime sstarttime;

    /**
     * 活动结束报名时间
     */
    private LocalDateTime sendtime;

    /**
     * 活动开始时间
     */
    private LocalDateTime astarttime;

    /**
     * 活动结束时间
     */
    private LocalDateTime aendtime;

    /**
     * 审核状态(审核中，未通过)
     */
    private String pstatus;

    /**
     * 活动介绍
     */
    private String acomment;

    /**
     * 活动地点
     */
    private String aaddr;

    /**
     * 社团ID,为6位数字
     */
    private String cid;

    /**
     * 活动负责人ID，长11位
     */
    private String cmid;

    /**
     * 条目创建时间
     */
    private LocalDateTime createTime;

    /**
     * 条目更新时间
     */
    private LocalDateTime updateTime;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }
    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }
    public String getAimage() {
        return aimage;
    }

    public void setAimage(String aimage) {
        this.aimage = aimage;
    }
    public LocalDateTime getSstarttime() {
        return sstarttime;
    }

    public void setSstarttime(LocalDateTime sstarttime) {
        this.sstarttime = sstarttime;
    }
    public LocalDateTime getSendtime() {
        return sendtime;
    }

    public void setSendtime(LocalDateTime sendtime) {
        this.sendtime = sendtime;
    }
    public LocalDateTime getAstarttime() {
        return astarttime;
    }

    public void setAstarttime(LocalDateTime astarttime) {
        this.astarttime = astarttime;
    }
    public LocalDateTime getAendtime() {
        return aendtime;
    }

    public void setAendtime(LocalDateTime aendtime) {
        this.aendtime = aendtime;
    }
    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }
    public String getAcomment() {
        return acomment;
    }

    public void setAcomment(String acomment) {
        this.acomment = acomment;
    }
    public String getAaddr() {
        return aaddr;
    }

    public void setAaddr(String aaddr) {
        this.aaddr = aaddr;
    }
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
    public String getCmid() {
        return cmid;
    }

    public void setCmid(String cmid) {
        this.cmid = cmid;
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
        return "Process{" +
            "aid=" + aid +
            ", aname=" + aname +
            ", aimage=" + aimage +
            ", sstarttime=" + sstarttime +
            ", sendtime=" + sendtime +
            ", astarttime=" + astarttime +
            ", aendtime=" + aendtime +
            ", pstatus=" + pstatus +
            ", acomment=" + acomment +
            ", aaddr=" + aaddr +
            ", cid=" + cid +
            ", cmid=" + cmid +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
