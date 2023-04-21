-- 创建user-用户表，并向其中添加数据
CREATE TABLE user_table(
                           uid CHAR(11) PRIMARY KEY NOT NULL COMMENT '用户ID（此处由学号代替）',
                           upassword VARCHAR(255) COMMENT '密码',
                           uname VARCHAR(20) DEFAULT NULL COMMENT '昵称',
                           uavatar VARCHAR(255) DEFAULT NULL COMMENT '头像链接',
                           collage VARCHAR(20) DEFAULT NULL COMMENT '学院',
                           class VARCHAR(20) DEFAULT NULL COMMENT '专业班级',
                           create_time datetime COMMENT '条目创建时间',
                           update_time datetime COMMENT '条目更新时间'
);

INSERT into user_table set uid='19401190216',upassword='123456', uname='叶凯辉',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', class='网络工程191', create_time=NOW(), update_time=NOW();
INSERT into user_table set uid='19401190211',upassword='123456', uname='金骏杰',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', class='网络工程191', create_time=NOW(), update_time=NOW();
INSERT into user_table set uid='19401190212',upassword='123456', uname='余伟康',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', class='网络工程191', create_time=NOW(), update_time=NOW();
INSERT into user_table set uid='19401190217',upassword='123456', uname='董浩斌',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', class='网络工程191', create_time=NOW(), update_time=NOW();
INSERT into user_table set uid='19401190220',upassword='123456', uname='金浩添',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', class='网络工程191', create_time=NOW(), update_time=NOW();
INSERT into user_table set uid='19401190320',upassword='123456', uname='张三',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', class='网络工程191', create_time=NOW(), update_time=NOW();
INSERT into user_table set uid='19401190321',upassword='123456', uname='李四',uavatar='/static/head-img/DiDi.jpg', collage='网安学院', class='网络工程191', create_time=NOW(), update_time=NOW();

-- 创建corporationm_table-社团管理人员表
CREATE TABLE corporationm_table(
                                   cmid CHAR(11) PRIMARY KEY NOT NULL COMMENT '社团管理员ID（此处由学号代替）',
                                   cmpassword VARCHAR(255) COMMENT '密码',
                                   cmname VARCHAR(20)  DEFAULT NULL COMMENT '昵称',
                                   cpname  VARCHAR(20)  DEFAULT NULL COMMENT '所属社团名称',
                                   cmlevel int DEFAULT 1 COMMENT '社团管理人员的权限等级，1为普通权限，2为高级权限',
                                   create_time datetime COMMENT '条目创建时间',
                                   update_time datetime COMMENT '条目更新时间',
                                   FOREIGN KEY (cmid) REFERENCES user_table(uid)
);