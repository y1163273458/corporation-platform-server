package com.example.corporationplatformserver.entity;

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
@TableName("corporation_table")
public class Corporation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 社团ID,为6位数字
     */
    private String cid;

    /**
     * 社团名称
     */
    private String cname;

    /**
     * 条目创建时间
     */
    private LocalDateTime createTime;

    /**
     * 条目更新时间
     */
    private LocalDateTime updateTime;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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
        return "Corporation{" +
            "cid=" + cid +
            ", cname=" + cname +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
