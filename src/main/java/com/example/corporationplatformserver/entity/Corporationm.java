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
@TableName("corporationm_table")
public class Corporationm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 社团管理员ID（此处由学号代替）
     */
    @TableId
    private String cmid;

    /**
     * 社团ID,为6位数字
     */
    private String cid;

    /**
     * 社团管理人员的身份，1为管理人员，2为社长
     */
    private Integer cmlevel;

    /**
     * 条目创建时间
     */
    private LocalDateTime createTime;

    /**
     * 条目更新时间
     */
    private LocalDateTime updateTime;

    public String getCmid() {
        return cmid;
    }

    public void setCmid(String cmid) {
        this.cmid = cmid;
    }
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
    public Integer getCmlevel() {
        return cmlevel;
    }

    public void setCmlevel(Integer cmlevel) {
        this.cmlevel = cmlevel;
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
        return "Corporationm{" +
            "cmid=" + cmid +
            ", cid=" + cid +
            ", cmlevel=" + cmlevel +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
