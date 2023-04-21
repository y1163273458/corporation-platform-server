-- 创建user-用户表，并向其中添加数据
CREATE TABLE user_table(
                           uid CHAR(11) PRIMARY KEY NOT NULL COMMENT '用户ID，长11位',
                           upassword VARCHAR(255) NOT NULL COMMENT '密码',
                           uname VARCHAR(20) NOT NULL COMMENT '昵称',
                           uavatar VARCHAR(255)  COMMENT '头像链接',
                           collage VARCHAR(20)  COMMENT '学院',
                           uclass VARCHAR(20)  COMMENT '专业班级',
                           create_time datetime COMMENT '条目创建时间',
                           update_time datetime COMMENT '条目更新时间'
);

INSERT INTO user_table SET uid='19401190216',upassword='123456', uname='叶凯辉',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', uclass='网络工程191', create_time=NOW(), update_time=NOW();
INSERT INTO user_table SET uid='19401190211',upassword='123456', uname='金骏杰',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', uclass='网络工程191', create_time=NOW(), update_time=NOW();
INSERT INTO user_table SET uid='19401190212',upassword='123456', uname='余伟康',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', uclass='网络工程191', create_time=NOW(), update_time=NOW();
INSERT INTO user_table SET uid='19401190217',upassword='123456', uname='董浩斌',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', uclass='网络工程191', create_time=NOW(), update_time=NOW();
INSERT INTO user_table SET uid='19401190220',upassword='123456', uname='金浩添',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', uclass='网络工程191', create_time=NOW(), update_time=NOW();
INSERT INTO user_table SET uid='19401190320',upassword='123456', uname='张三',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', uclass='网络工程191', create_time=NOW(), update_time=NOW();
INSERT INTO user_table SET uid='19401190321',upassword='123456', uname='李四',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', uclass='网络工程191', create_time=NOW(), update_time=NOW();
INSERT INTO user_table SET uid='19401190322',upassword='123456', uname='王五',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', uclass='网络工程192', create_time=NOW(), update_time=NOW();
INSERT INTO user_table SET uid='19401190323',upassword='123456', uname='季七',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', uclass='网络工程192', create_time=NOW(), update_time=NOW();
INSERT INTO user_table SET uid='19401190324',upassword='123456', uname='何擎',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', uclass='网络工程192', create_time=NOW(), update_time=NOW();
INSERT INTO user_table SET uid='19401190325',upassword='123456', uname='宋泰',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', uclass='网络工程192', create_time=NOW(), update_time=NOW();
INSERT INTO user_table SET uid='19401190326',upassword='123456', uname='朱木',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', uclass='网络工程192', create_time=NOW(), update_time=NOW();
INSERT INTO user_table SET uid='19401190327',upassword='123456', uname='周玫',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', uclass='网络工程192', create_time=NOW(), update_time=NOW();
INSERT INTO user_table SET uid='19401190328',upassword='123456', uname='彭星',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', uclass='网络工程192', create_time=NOW(), update_time=NOW();
INSERT INTO user_table SET uid='19401190329',upassword='123456', uname='苏乐',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', uclass='网络工程192', create_time=NOW(), update_time=NOW();
INSERT INTO user_table SET uid='19401190330',upassword='123456', uname='周凡',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', uclass='网络工程191', create_time=NOW(), update_time=NOW();
INSERT INTO user_table SET uid='12345678910',upassword='123456', uname='管理员',uavatar='/static/head-img/DiDi.jpg', create_time=NOW(), update_time=NOW();

-- 创建corporation_table-社团表
CREATE TABLE corporation_table(
                                  cid CHAR(6) PRIMARY KEY NOT NULL COMMENT '社团ID,为6位数字',
                                  cname  VARCHAR(20)  DEFAULT NULL COMMENT '社团名称',
                                  create_time datetime COMMENT '条目创建时间',
                                  update_time datetime COMMENT '条目更新时间'
);

INSERT INTO corporation_table SET cid='100001',cname='电影社',create_time=NOW(), update_time=NOW();
INSERT INTO corporation_table SET cid='100002',cname='话剧社',create_time=NOW(), update_time=NOW();
INSERT INTO corporation_table SET cid='100003',cname='电竞社',create_time=NOW(), update_time=NOW();

-- 创建corporationm_table-社团管理人员表
CREATE TABLE corporationm_table(
                                   cmid CHAR(11) PRIMARY KEY NOT NULL COMMENT '社团管理员ID,长11位',
                                   cid CHAR(6) COMMENT '社团ID,为6位数字',
                                   cmlevel int DEFAULT 1 COMMENT '社团管理人员的身份，1为部门人员，2为社长，3位管理员',
                                   create_time datetime COMMENT '条目创建时间',
                                   update_time datetime COMMENT '条目更新时间',
                                   FOREIGN KEY (cmid) REFERENCES user_table(uid),
                                   FOREIGN KEY (cid) REFERENCES corporation_table(cid)
);

INSERT INTO corporationm_table SET cmid='19401190212',cid='100003',cmlevel='2',create_time=NOW(), update_time=NOW();
INSERT INTO corporationm_table SET cmid='19401190320',cid='100003',cmlevel='1',create_time=NOW(), update_time=NOW();
INSERT INTO corporationm_table SET cmid='19401190321',cid='100001',cmlevel='2',create_time=NOW(), update_time=NOW();
INSERT INTO corporationm_table SET cmid='19401190330',cid='100001',cmlevel='1',create_time=NOW(), update_time=NOW();
INSERT INTO corporationm_table SET cmid='19401190329',cid='100002',cmlevel='2',create_time=NOW(), update_time=NOW();
INSERT INTO corporationm_table SET cmid='19401190211',cid='100003',cmlevel='2',create_time=NOW(), update_time=NOW();
INSERT INTO corporationm_table SET cmid='12345678910',cmlevel='3',create_time=NOW(), update_time=NOW();

-- 创建activity_table-社团活动表
CREATE TABLE activity_table(
                               aid INT(8) PRIMARY KEY NOT NULL auto_increment COMMENT '活动ID,8位数字',
                               aname VARCHAR(20)  NOT NULL COMMENT '活动名称',
                               aimage VARCHAR(255) COMMENT '活动封面图片',
                               sstarttime datetime COMMENT '活动开始报名时间',
                               sendtime datetime COMMENT '活动结束报名时间',
                               astarttime datetime COMMENT '活动开始时间',
                               aendtime datetime COMMENT '活动结束时间',
                               pstatus VARCHAR(10) COMMENT '审核状态(审核中，未通过，已通过)',
                               astatus VARCHAR(10) COMMENT '活动状态(准备中，报名中，进行中，已结束)',
                               acomment TEXT COMMENT '活动介绍',
                               aaddr VARCHAR(255) COMMENT '活动地点',
                               cid CHAR(6) NOT NULL COMMENT '社团ID,为6位数字',
                               pid CHAR(11) COMMENT '活动审批人ID，长11位',
                               process_time datetime COMMENT '审批时间',
                               cmid CHAR(11) NOT NULL COMMENT '活动负责人ID，长11位',
                               create_time datetime COMMENT '条目创建时间',
                               update_time datetime COMMENT '条目更新时间',
                               FOREIGN KEY (cid) REFERENCES corporation_table(cid),
                               FOREIGN KEY (cmid) REFERENCES corporationm_table(cmid)
);

INSERT INTO activity_table SET aid=10000001,aname='流浪地球12连看',aimage='/static/swiper-img/1.jpg',sstarttime='2023-4-18 12:00:00',sendtime='2023-4-19 12:00:00',astarttime='2023-4-20 12:00:00',aendtime='2023-4-21 12:00:00',astatus='准备中',acomment='小剧院放流浪地球！',aaddr='小剧院',cid='100001',cmid='19401190321',create_time=NOW(), update_time=NOW(),pid="12345678910",pstatus="已通过",process_time="2023-4-1 12:00:00";
INSERT INTO activity_table SET aid=10000002,aname='复仇者联盟1234连看',aimage='/static/swiper-img/1.jpg',sstarttime='2023-4-17 12:00:00',sendtime='2023-4-17 20:00:00',astarttime='2023-4-18 11:00:00',aendtime='2023-4-18 23:00:00',astatus='进行中',acomment='小剧院看复仇者联盟！',aaddr='小剧院',cid='100001',cmid='19401190330',create_time=NOW(), update_time=NOW(),pid="12345678910",pstatus="已通过";
INSERT INTO activity_table SET aid=10000003,aname='apex高校赛',aimage='/static/swiper-img/1.jpg',sstarttime='2023-4-10 12:00:00',sendtime='2023-4-11 12:00:00',astarttime='2023-4-13 8:00:00',aendtime='2023-4-15 13:00:00',astatus='已结束',acomment='apex高校联赛赛事！',aaddr='学生活动中心1F',cid='100003',cmid='19401190212',create_time=NOW(), update_time=NOW(),pid="12345678910",pstatus="已通过";
INSERT INTO activity_table SET aid=10000004,aname='英雄联盟高校联赛',aimage='/static/swiper-img/1.jpg',sstarttime='2023-4-15 12:00:00',sendtime='2023-4-18 12:00:00',astarttime='2023-4-18 18:00:00',aendtime='2023-4-21 22:00:00',astatus='报名中',acomment='英雄联盟高校联赛赛事！',aaddr='学生活动中心1F',cid='100003',cmid='19401190320',create_time=NOW(), update_time=NOW(),pid="12345678910",pstatus="已通过";
INSERT INTO activity_table SET aid=10000005,aname='话剧交流会',aimage='/static/swiper-img/1.jpg',sstarttime='2023-5-1 00:00:00',sendtime='2023-5-11 00:00:00',astarttime='2023-5-11 12:00:00',aendtime='2023-5-11 17:00:00',astatus='准备中',acomment='话剧交流会',aaddr='学生活动中心1F',cid='100002',cmid='19401190329',create_time=NOW(), update_time=NOW(),pid="12345678910",pstatus="已通过";
INSERT INTO activity_table SET aid=10000006,aname='话剧发展史',aimage='/static/swiper-img/1.jpg',sstarttime='2023-4-1 12:00:00',sendtime='2023-4-3 12:00:00',astarttime='2023-4-18 12:00:00',aendtime='2023-4-18 15:00:00',astatus='进行中',acomment='开展话剧发展史的讲座',aaddr='教二110',cid='100002',cmid='19401190329',create_time=NOW(), update_time=NOW(),pid="12345678910",pstatus="已通过";
INSERT INTO activity_table SET aid=10000007,aname='原批交流会',aimage='/static/swiper-img/1.jpg',sstarttime='2023-4-21 12:00:00',sendtime='2023-4-22 00:00:00',astarttime='2023-4-22 8:30:00',aendtime='2023-4-21 12:00:00',astatus='准备中',acomment='宁工电竞社原批交流大会火热举报中',aaddr='阶四101',cid='100003',cmid='19401190211',create_time=NOW(), update_time=NOW(),pid="12345678910",pstatus="已通过";
INSERT INTO activity_table SET aid=10000008,aname='看星际穿越',aimage='/static/swiper-img/1.jpg',sstarttime='2023-4-18 18:00:00',sendtime='2023-4-19 12:00:00',astarttime='2023-4-19 18:30:00',aendtime='2023-4-19 23:00:00',astatus='准备中',acomment='小剧院看星际穿越！',aaddr='小剧院',cid='100001',cmid='19401190330',create_time=NOW(), update_time=NOW(),pid="12345678910",pstatus="已通过";
INSERT INTO activity_table SET aid=10000011,aname='异形1234连看',aimage='/static/swiper-img/1.jpg',sstarttime='2023-4-18 12:00:00',sendtime='2023-4-19 12:00:00',astarttime='2023-4-20 12:00:00',aendtime='2023-4-21 12:00:00',pstatus='审核中',acomment='小剧院放异形1234！',aaddr='小剧院',cid='100001',cmid='19401190321',create_time=NOW(), update_time=NOW();
INSERT INTO activity_table SET aid=10000012,aname='看举起手来',aimage='/static/swiper-img/1.jpg',sstarttime='2023-4-17 12:00:00',sendtime='2023-4-17 20:00:00',astarttime='2023-4-18 11:00:00',aendtime='2023-4-18 23:00:00',pstatus='审核中',acomment='小剧院看举起手来！',aaddr='小剧院',cid='100001',cmid='19401190330',create_time=NOW(), update_time=NOW();

-- 创建notice_table-通知表
CREATE TABLE notice_table(
                             nid BIGINT(16) PRIMARY KEY NOT NULL auto_increment COMMENT '通知ID,12位数字',
                             ncontent VARCHAR(255) NOT NULL COMMENT '通知内容',
                             nstatus VARCHAR(10) COMMENT '未读，已读',
                             suid CHAR(11) NOT NULL COMMENT '发送通知的用户ID，长11位',
                             suname VARCHAR(20) DEFAULT NULL COMMENT '昵称',
                             guid CHAR(11) NOT NULL COMMENT '接收通知的用户ID，长11位',
                             create_time datetime COMMENT '条目创建时间',
                             update_time datetime COMMENT '条目更新时间',
                             FOREIGN KEY (suid) REFERENCES user_table(uid),
                             FOREIGN KEY (guid) REFERENCES user_table(uid)
);

INSERT INTO notice_table SET nid=100000000001,ncontent='前天天气真不错',nstatus='未读',suid='19401190212',suname='余伟康',guid='19401190216',create_time=NOW(), update_time=NOW();
INSERT INTO notice_table SET nid=100000000002,ncontent='昨天天气真不错',nstatus='未读',suid='19401190212',suname='余伟康',guid='19401190216',create_time=NOW(), update_time=NOW();
INSERT INTO notice_table SET nid=100000000003,ncontent='今天天气真不错',nstatus='未读',suid='19401190212',suname='余伟康',guid='19401190211',create_time=NOW(), update_time=NOW();
INSERT INTO notice_table SET nid=100000000004,ncontent='明天天气真不错',nstatus='未读',suid='19401190212',suname='余伟康',guid='19401190216',create_time=NOW(), update_time=NOW();
INSERT INTO notice_table SET nid=100000000005,ncontent='后天天气真不错',nstatus='未读',suid='19401190212',suname='余伟康',guid='19401190216',create_time=NOW(), update_time=NOW();
INSERT INTO notice_table SET nid=100000000006,ncontent='大后天天气真不错',nstatus='未读',suid='19401190212',suname='余伟康',guid='19401190216',create_time=NOW(), update_time=NOW();
INSERT INTO notice_table SET nid=100000000007,ncontent='大大后天天气真不错',nstatus='未读',suid='19401190212',suname='余伟康',guid='19401190216',create_time=NOW(), update_time=NOW();
