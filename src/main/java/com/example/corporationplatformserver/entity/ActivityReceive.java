package com.example.corporationplatformserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@TableName("activity_table")
@Data
public class ActivityReceive {

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
        private String sstarttime;

        /**
         * 活动结束报名时间
         */
        private String sendtime;

        /**
         * 活动开始时间
         */
        private String astarttime;

        /**
         * 活动结束时间
         */
        private String aendtime;

        /**
         * 活动状态(准备中，报名中，进行中，已结束)
         */
        private String pstatus;


        /**
         * 活动状态(准备中，报名中，进行中，已结束)
         */
        private String astatus;

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
         *
         * 活动审批人ID，长11位
         */
        private String pid;

        /**
         * 审批时间
         */
        private String processTime;

        /**
         * 条目创建时间
         */
        private String createTime;

        /**
         * 条目更新时间
         */
        private String updateTime;
}
