/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : eduonline
Target Host     : localhost:3306
Target Database : eduonline
Date: 2018-03-11 14:51:59
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '״̬   0������   1����ʾ',
  `remark` varchar(500) DEFAULT NULL COMMENT '��ע',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ϵͳ������Ϣ��';

-- ----------------------------
-- Records of sys_config
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '�û���',
  `operation` varchar(50) DEFAULT NULL COMMENT '�û�����',
  `method` varchar(200) DEFAULT NULL COMMENT '���󷽷�',
  `params` varchar(5000) DEFAULT NULL COMMENT '�������',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP��ַ',
  `create_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ϵͳ��־';

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '���˵�ID��һ���˵�Ϊ0',
  `name` varchar(50) DEFAULT NULL COMMENT '�˵�����',
  `url` varchar(200) DEFAULT NULL COMMENT '�˵�URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '��Ȩ(����ö��ŷָ����磺user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '����   0��Ŀ¼   1���˵�   2����ť',
  `icon` varchar(50) DEFAULT NULL COMMENT '�˵�ͼ��',
  `order_num` int(11) DEFAULT NULL COMMENT '����',
  `create_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  `modified_time` datetime DEFAULT NULL COMMENT '�޸�ʱ��',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='�˵�����';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'fa fa-cog', '0', '2017-09-16 23:13:52', '2017-09-16 23:13:55');
INSERT INTO `sys_menu` VALUES ('2', '1', '管理员列表', 'sys/user.flt', null, '1', 'fa fa-user', '1', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'sys/role.flt', null, '1', 'fa fa-user-secret', '2', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'sys/menu.flt', null, '1', 'fa fa-th-list', '3', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('5', '1', 'SQL监控', 'druid/sql.html', null, '1', 'fa fa-bug', '4', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:perms', '2', null, '0', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:perms', '2', null, '0', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('27', '1', '参数管理', 'sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-sun-o', '6', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('29', '1', '系统日志', 'sys/log.flt', 'sys:log:list', '1', 'fa fa-file-text-o', '7', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('30', '1', '文件上传', 'sys/oss.html', 'sys:oss:all', '1', 'fa fa-file-image-o', '6', '2017-09-16 22:45:14', '2017-09-16 22:45:19');
INSERT INTO `sys_menu` VALUES ('33', '40', '视频审核', 'video/examine.flt', null, '1', 'fa fa-eye', '1', '2017-11-12 17:20:56', '2017-11-12 17:20:56');
INSERT INTO `sys_menu` VALUES ('34', '40', '推荐管理', 'video/videoreCommend.flt', null, '1', 'fa fa-file-video-o', '2', '2017-11-12 17:49:16', '2018-03-02 00:44:17');
INSERT INTO `sys_menu` VALUES ('35', '0', '用户管理', null, null, '0', 'fa fa-user-o', '2', '2017-11-12 18:16:11', '2017-11-12 18:16:11');
INSERT INTO `sys_menu` VALUES ('36', '35', '用户列表', 'user/userList.flt', null, '1', 'fa fa-users', '0', '2017-11-12 18:17:35', '2017-11-12 18:17:35');
INSERT INTO `sys_menu` VALUES ('38', '40', '分类管理', 'video/sort.flt', '', '1', 'fa fa-sort', '0', '2018-02-08 00:32:11', '2018-03-07 17:28:48');
INSERT INTO `sys_menu` VALUES ('39', '40', '添加课程', 'video/addCourses.flt', null, '1', 'fa fa-newspaper-o', '0', '2018-02-10 08:52:32', '2018-03-07 17:29:58');
INSERT INTO `sys_menu` VALUES ('40', '0', 'App内容管理', null, null, '0', 'fa fa-mobile-phone', '1', '2018-03-01 05:17:46', '2018-03-07 17:27:34');
INSERT INTO `sys_menu` VALUES ('41', '40', '全部课程', 'video/allCourses.flt', null, '1', 'fa fa-th-large', '3', '2018-03-07 17:34:05', '2018-03-07 17:34:05');

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL��ַ',
  `create_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�ļ��ϴ�';

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '��ɫ����',
  `remark` varchar(100) DEFAULT NULL COMMENT '��ע',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '������ID',
  `create_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  `modified_time` datetime DEFAULT NULL COMMENT '�޸�ʱ��',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='��ɫ';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '拥有所有权限', '1', '2017-09-16 22:45:14', '2017-11-12 16:01:15');
INSERT INTO `sys_role` VALUES ('3', 'test', 'test', '1', '2017-11-12 15:36:44', '2017-11-12 15:55:46');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '��ɫID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '�˵�ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8 COMMENT='��ɫ��˵���Ӧ��ϵ';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('15', '1', '25');
INSERT INTO `sys_role_menu` VALUES ('16', '1', '26');
INSERT INTO `sys_role_menu` VALUES ('17', '1', '5');
INSERT INTO `sys_role_menu` VALUES ('18', '1', '6');
INSERT INTO `sys_role_menu` VALUES ('19', '1', '7');
INSERT INTO `sys_role_menu` VALUES ('20', '1', '8');
INSERT INTO `sys_role_menu` VALUES ('21', '1', '9');
INSERT INTO `sys_role_menu` VALUES ('22', '1', '10');
INSERT INTO `sys_role_menu` VALUES ('23', '1', '11');
INSERT INTO `sys_role_menu` VALUES ('24', '1', '12');
INSERT INTO `sys_role_menu` VALUES ('25', '1', '13');
INSERT INTO `sys_role_menu` VALUES ('26', '1', '14');
INSERT INTO `sys_role_menu` VALUES ('27', '1', '27');
INSERT INTO `sys_role_menu` VALUES ('28', '1', '30');
INSERT INTO `sys_role_menu` VALUES ('29', '1', '29');
INSERT INTO `sys_role_menu` VALUES ('33', '3', '1');
INSERT INTO `sys_role_menu` VALUES ('34', '3', '5');
INSERT INTO `sys_role_menu` VALUES ('35', '3', '29');
INSERT INTO `sys_role_menu` VALUES ('36', '3', '1');
INSERT INTO `sys_role_menu` VALUES ('37', '3', '2');
INSERT INTO `sys_role_menu` VALUES ('38', '3', '15');
INSERT INTO `sys_role_menu` VALUES ('39', '3', '16');
INSERT INTO `sys_role_menu` VALUES ('40', '3', '17');
INSERT INTO `sys_role_menu` VALUES ('41', '3', '18');
INSERT INTO `sys_role_menu` VALUES ('42', '3', '5');
INSERT INTO `sys_role_menu` VALUES ('43', '3', '29');
INSERT INTO `sys_role_menu` VALUES ('44', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('45', '1', '16');
INSERT INTO `sys_role_menu` VALUES ('46', '1', '17');
INSERT INTO `sys_role_menu` VALUES ('47', '1', '18');
INSERT INTO `sys_role_menu` VALUES ('48', '1', '3');
INSERT INTO `sys_role_menu` VALUES ('49', '1', '19');
INSERT INTO `sys_role_menu` VALUES ('50', '1', '20');
INSERT INTO `sys_role_menu` VALUES ('51', '1', '21');
INSERT INTO `sys_role_menu` VALUES ('52', '1', '22');
INSERT INTO `sys_role_menu` VALUES ('53', '1', '4');
INSERT INTO `sys_role_menu` VALUES ('54', '1', '23');
INSERT INTO `sys_role_menu` VALUES ('55', '1', '24');
INSERT INTO `sys_role_menu` VALUES ('56', '1', '25');
INSERT INTO `sys_role_menu` VALUES ('57', '1', '26');
INSERT INTO `sys_role_menu` VALUES ('58', '1', '5');
INSERT INTO `sys_role_menu` VALUES ('60', '4', '1');
INSERT INTO `sys_role_menu` VALUES ('61', '5', '1');
INSERT INTO `sys_role_menu` VALUES ('63', '6', '1');
INSERT INTO `sys_role_menu` VALUES ('65', '7', '1');
INSERT INTO `sys_role_menu` VALUES ('67', '8', '1');
INSERT INTO `sys_role_menu` VALUES ('69', '9', '1');
INSERT INTO `sys_role_menu` VALUES ('71', '10', '1');
INSERT INTO `sys_role_menu` VALUES ('73', '11', '1');
INSERT INTO `sys_role_menu` VALUES ('75', '12', '1');
INSERT INTO `sys_role_menu` VALUES ('77', '13', '1');
INSERT INTO `sys_role_menu` VALUES ('79', '14', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '�û���',
  `password` varchar(100) DEFAULT NULL COMMENT '����',
  `email` varchar(100) DEFAULT NULL COMMENT '����',
  `mobile` varchar(100) DEFAULT NULL COMMENT '�ֻ���',
  `status` tinyint(4) DEFAULT NULL COMMENT '״̬  0������   1������',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '������ID',
  `create_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  `modified_time` datetime DEFAULT NULL COMMENT '�޸�ʱ��',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='ϵͳ�û�';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'admin@email.com', '15622283782', '1', null, '2017-09-16 11:11:11', '2017-09-16 22:20:53');
INSERT INTO `sys_user` VALUES ('7', 'test1', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 'wrw@email.com', '15622283782', null, '1', '2018-03-01 05:17:46', '2018-03-01 05:17:46');
INSERT INTO `sys_user` VALUES ('13', 'wrw', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', null, null, '1', '1', '2017-11-12 15:00:46', '2017-11-12 15:00:46');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '�û�ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '��ɫID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='�û����ɫ��Ӧ��ϵ';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('6', '1', '1');
INSERT INTO `sys_user_role` VALUES ('15', '6', '1');
INSERT INTO `sys_user_role` VALUES ('16', '7', '1');

-- ----------------------------
-- Table structure for us_attachment
-- ----------------------------
DROP TABLE IF EXISTS `us_attachment`;
CREATE TABLE `us_attachment` (
  `id` bigint(200) NOT NULL,
  `filename` varchar(255) NOT NULL COMMENT '文件名',
  `path` varchar(255) NOT NULL COMMENT '视频地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for us_course
-- ----------------------------
DROP TABLE IF EXISTS `us_course`;
CREATE TABLE `us_course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '课程名',
  `introduce` varchar(200) NOT NULL COMMENT '简介',
  `create_time` date NOT NULL,
  `modify_time` date DEFAULT NULL,
  `pic_url` varchar(200) DEFAULT NULL COMMENT '课程封面',
  `free_state` varchar(2) NOT NULL COMMENT '是否免费',
  `cover_id` bigint(20) DEFAULT NULL,
  `salary` decimal(5,2) DEFAULT NULL,
  `commend_state` varchar(2) NOT NULL DEFAULT '0' COMMENT '0:未推荐,1:推荐',
  `offlinecourse_id` bigint(20) DEFAULT NULL,
  `state` varchar(2) NOT NULL DEFAULT '0' COMMENT '0:正常,1:删除',
  PRIMARY KEY (`id`),
  KEY `cover_id` (`cover_id`),
  KEY `offlinecourse_id` (`offlinecourse_id`),
  CONSTRAINT `us_course_ibfk_1` FOREIGN KEY (`cover_id`) REFERENCES `us_cover` (`id`),
  CONSTRAINT `us_course_ibfk_2` FOREIGN KEY (`offlinecourse_id`) REFERENCES `us_offlinecourse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_course
-- ----------------------------

-- ----------------------------
-- Table structure for us_course_sort
-- ----------------------------
DROP TABLE IF EXISTS `us_course_sort`;
CREATE TABLE `us_course_sort` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_id` bigint(20) NOT NULL,
  `sort_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`),
  KEY `sort_id` (`sort_id`),
  CONSTRAINT `us_course_sort_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `us_course` (`id`),
  CONSTRAINT `us_course_sort_ibfk_2` FOREIGN KEY (`sort_id`) REFERENCES `us_sort` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_course_sort
-- ----------------------------

-- ----------------------------
-- Table structure for us_course_video
-- ----------------------------
DROP TABLE IF EXISTS `us_course_video`;
CREATE TABLE `us_course_video` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `course_id` bigint(200) NOT NULL,
  `video_id` bigint(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`),
  KEY `video_id` (`video_id`),
  CONSTRAINT `us_course_video_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `us_course` (`id`),
  CONSTRAINT `us_course_video_ibfk_2` FOREIGN KEY (`video_id`) REFERENCES `us_video` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_course_video
-- ----------------------------

-- ----------------------------
-- Table structure for us_cover
-- ----------------------------
DROP TABLE IF EXISTS `us_cover`;
CREATE TABLE `us_cover` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `picurl` varchar(255) NOT NULL,
  `createtime` datetime NOT NULL,
  `modifytime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_cover
-- ----------------------------

-- ----------------------------
-- Table structure for us_offlinecourse
-- ----------------------------
DROP TABLE IF EXISTS `us_offlinecourse`;
CREATE TABLE `us_offlinecourse` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL COMMENT '活动标题',
  `cretate_time` datetime NOT NULL COMMENT '创建时间',
  `start_time` date NOT NULL COMMENT '活动开始时间',
  `end_time` date NOT NULL COMMENT '活动结束时间',
  `place` varchar(255) NOT NULL COMMENT '活动地点',
  `detail` varchar(255) NOT NULL COMMENT '活动详情',
  `state` varchar(2) NOT NULL DEFAULT '0' COMMENT '0:正常,1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_offlinecourse
-- ----------------------------

-- ----------------------------
-- Table structure for us_order
-- ----------------------------
DROP TABLE IF EXISTS `us_order`;
CREATE TABLE `us_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderno` varchar(255) NOT NULL COMMENT '订单号',
  `user_id` bigint(20) NOT NULL COMMENT '户用Id',
  `create_time` datetime NOT NULL,
  `state` varchar(2) NOT NULL DEFAULT '0' COMMENT '0:待支付 1:交易成功 2:取消订单',
  `summoney` decimal(10,0) DEFAULT NULL,
  `payment_type` varchar(2) NOT NULL DEFAULT '0' COMMENT '0:未支付,1:微信,2:支付宝',
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `us_order_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `us_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_order
-- ----------------------------

-- ----------------------------
-- Table structure for us_order_course
-- ----------------------------
DROP TABLE IF EXISTS `us_order_course`;
CREATE TABLE `us_order_course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL,
  `course_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `us_order_course_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `us_order` (`id`),
  CONSTRAINT `us_order_course_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `us_course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_order_course
-- ----------------------------

-- ----------------------------
-- Table structure for us_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `us_shopcar`;
CREATE TABLE `us_shopcar` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `course_id` bigint(200) NOT NULL,
  `create_time` datetime NOT NULL,
  `user_id` bigint(200) NOT NULL,
  `modify_time` datetime DEFAULT NULL,
  `state` varchar(2) NOT NULL DEFAULT '0' COMMENT '0:未处理,2:已删除',
  `order_state` varchar(2) NOT NULL DEFAULT '0' COMMENT '0:未提交.1:已提交',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `course_id` (`course_id`),
  CONSTRAINT `basket_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `us_user` (`id`),
  CONSTRAINT `us_shopcar_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `us_course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of us_shopcar
-- ----------------------------

-- ----------------------------
-- Table structure for us_sort
-- ----------------------------
DROP TABLE IF EXISTS `us_sort`;
CREATE TABLE `us_sort` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `create_time` date NOT NULL,
  `modify_time` datetime DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `type` varchar(255) NOT NULL COMMENT '0:一级分类,1: 二级分类,2:三级分类',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `us_sort_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `us_sort` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_sort
-- ----------------------------
INSERT INTO `us_sort` VALUES ('1', '办公效率', '2018-02-07', null, null, '0');
INSERT INTO `us_sort` VALUES ('2', '职业发展', '2018-02-07', null, null, '0');
INSERT INTO `us_sort` VALUES ('3', '编程开发', '2018-02-07', null, null, '0');
INSERT INTO `us_sort` VALUES ('4', '产品和设计', '2018-02-07', null, null, '0');
INSERT INTO `us_sort` VALUES ('5', '生活方式', '2018-02-07', null, null, '0');
INSERT INTO `us_sort` VALUES ('6', '亲子教育', '2018-02-07', null, null, '0');
INSERT INTO `us_sort` VALUES ('7', '语言学习', '2018-02-07', null, null, '0');
INSERT INTO `us_sort` VALUES ('8', '办公软件', '2018-02-07', null, '1', '1');
INSERT INTO `us_sort` VALUES ('9', '工作效率', '2018-02-07', null, '1', '1');
INSERT INTO `us_sort` VALUES ('10', '电脑基础', '2018-02-07', null, '1', '1');
INSERT INTO `us_sort` VALUES ('11', 'PPT', '2018-02-07', null, '8', '2');
INSERT INTO `us_sort` VALUES ('12', 'Excel', '2018-02-07', null, '8', '2');
INSERT INTO `us_sort` VALUES ('13', 'Word', '2018-02-07', null, '8', '2');
INSERT INTO `us_sort` VALUES ('15', 'Project', '2018-02-07', null, '10', '2');
INSERT INTO `us_sort` VALUES ('16', 'Outlook', '2018-02-07', null, '10', '2');
INSERT INTO `us_sort` VALUES ('17', 'Keynote', '2018-02-07', null, '10', '2');
INSERT INTO `us_sort` VALUES ('18', '更多软件', '2018-02-07', null, '10', '2');
INSERT INTO `us_sort` VALUES ('19', '时间管理', '2018-02-07', null, '9', '2');
INSERT INTO `us_sort` VALUES ('20', '思维导图', '2018-02-07', null, '9', '2');
INSERT INTO `us_sort` VALUES ('21', '基础操作', '2018-02-07', null, '10', '2');
INSERT INTO `us_sort` VALUES ('22', '常用工具', '2018-02-07', null, '10', '2');
INSERT INTO `us_sort` VALUES ('23', '求职应聘', '2018-02-07', null, '2', '1');
INSERT INTO `us_sort` VALUES ('26', '个人提升', '2018-02-07', null, '2', '1');
INSERT INTO `us_sort` VALUES ('28', '职场能力', '2018-02-07', null, '2', '1');
INSERT INTO `us_sort` VALUES ('29', '专业岗位', '2018-02-07', null, '2', '1');
INSERT INTO `us_sort` VALUES ('30', '管理能力', '2018-02-07', null, '2', '1');
INSERT INTO `us_sort` VALUES ('31', '职业考试', '2018-02-07', null, '2', '1');
INSERT INTO `us_sort` VALUES ('32', '市场营销', '2018-02-07', null, '2', '1');
INSERT INTO `us_sort` VALUES ('33', '商业创业', '2018-02-07', null, '2', '1');
INSERT INTO `us_sort` VALUES ('34', '编程语言', '2018-02-07', null, '3', '1');
INSERT INTO `us_sort` VALUES ('35', '人工智能与数据', '2018-02-07', null, '3', '1');
INSERT INTO `us_sort` VALUES ('36', '前端开发', '2018-02-07', null, '3', '1');
INSERT INTO `us_sort` VALUES ('37', '后端开发', '2018-02-07', null, '3', '1');
INSERT INTO `us_sort` VALUES ('38', '移动开发', '2018-02-07', null, '3', '1');
INSERT INTO `us_sort` VALUES ('39', '系统/硬件', '2018-02-07', null, '3', '1');
INSERT INTO `us_sort` VALUES ('40', '产品策划', '2018-02-07', null, '4', '1');
INSERT INTO `us_sort` VALUES ('41', '产品运维', '2018-02-07', null, '4', '1');
INSERT INTO `us_sort` VALUES ('42', '平面设计', '2018-02-07', null, '4', '1');
INSERT INTO `us_sort` VALUES ('43', '用户体验', '2018-02-07', null, '4', '1');
INSERT INTO `us_sort` VALUES ('44', '设计软件', '2018-02-07', null, '4', '1');
INSERT INTO `us_sort` VALUES ('45', '动漫设计', '2018-02-07', null, '4', '1');
INSERT INTO `us_sort` VALUES ('46', '游戏美术', '2018-02-07', null, '4', '1');
INSERT INTO `us_sort` VALUES ('47', '知识管理', '2018-02-07', null, '26', '2');
INSERT INTO `us_sort` VALUES ('48', '习惯养成', '2018-02-07', null, '26', '2');
INSERT INTO `us_sort` VALUES ('49', '演讲与口才', '2018-02-07', null, '26', '2');
INSERT INTO `us_sort` VALUES ('50', '个人品牌', '2018-02-07', null, '26', '2');
INSERT INTO `us_sort` VALUES ('51', '思维方式', '2018-02-07', null, '26', '2');

-- ----------------------------
-- Table structure for us_user
-- ----------------------------
DROP TABLE IF EXISTS `us_user`;
CREATE TABLE `us_user` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `account` varchar(11) NOT NULL COMMENT '账号',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `user_name` varchar(12) DEFAULT NULL COMMENT '昵称',
  `state` varchar(2) DEFAULT '0' COMMENT '0:正常 1:禁用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_user
-- ----------------------------

-- ----------------------------
-- Table structure for us_user_attend
-- ----------------------------
DROP TABLE IF EXISTS `us_user_attend`;
CREATE TABLE `us_user_attend` (
  `id` bigint(200) NOT NULL,
  `user_id` bigint(200) NOT NULL,
  `course_id` bigint(200) NOT NULL,
  `create_time` date NOT NULL COMMENT '参加时间',
  `attend_state` varchar(2) NOT NULL COMMENT '参加的类型——0:线上,1:线下',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `us_user_attend_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `us_user` (`id`),
  CONSTRAINT `us_user_attend_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `us_course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_user_attend
-- ----------------------------

-- ----------------------------
-- Table structure for us_user_collection
-- ----------------------------
DROP TABLE IF EXISTS `us_user_collection`;
CREATE TABLE `us_user_collection` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(200) NOT NULL,
  `course_id` bigint(200) NOT NULL,
  `create_time` date NOT NULL COMMENT '收藏时间',
  `collection` varchar(2) NOT NULL DEFAULT '0' COMMENT '0：未收藏，1：已收藏',
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `us_user_collection_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `us_user` (`id`),
  CONSTRAINT `us_user_collection_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `us_course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_user_collection
-- ----------------------------

-- ----------------------------
-- Table structure for us_user_join_plan
-- ----------------------------
DROP TABLE IF EXISTS `us_user_join_plan`;
CREATE TABLE `us_user_join_plan` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(200) NOT NULL COMMENT '用户id',
  `course_id` bigint(200) NOT NULL COMMENT '程课id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `clocksetting_state` varchar(2) NOT NULL DEFAULT '0' COMMENT '0:未设置 1:已设置',
  `join_state` varchar(2) NOT NULL DEFAULT '0' COMMENT '是否加入0：未加入1：已加入',
  `clock_state` varchar(2) NOT NULL DEFAULT '0' COMMENT '0：未启用 1：已启动',
  `content` varchar(255) DEFAULT NULL COMMENT '提示内容',
  `hour` varchar(255) DEFAULT NULL COMMENT '小时 0~23',
  `miuntes` varchar(255) DEFAULT NULL COMMENT '分钟 0~59',
  `daysofweek` varchar(255) DEFAULT NULL COMMENT '[1,2,3,4,5,6,7]--代表日、一、二、三、四、五、六',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `us_user_join_plan_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `us_user` (`id`),
  CONSTRAINT `us_user_join_plan_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `us_course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_user_join_plan
-- ----------------------------

-- ----------------------------
-- Table structure for us_user_offlinecourse
-- ----------------------------
DROP TABLE IF EXISTS `us_user_offlinecourse`;
CREATE TABLE `us_user_offlinecourse` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `offlinecourse_id` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` datetime DEFAULT NULL,
  `state` varchar(2) NOT NULL DEFAULT '0' COMMENT '0:正常,1:',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `offlinecourse_id` (`offlinecourse_id`),
  CONSTRAINT `us_user_offlinecourse_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `us_user` (`id`),
  CONSTRAINT `us_user_offlinecourse_ibfk_2` FOREIGN KEY (`offlinecourse_id`) REFERENCES `us_offlinecourse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_user_offlinecourse
-- ----------------------------

-- ----------------------------
-- Table structure for us_user_own_courses
-- ----------------------------
DROP TABLE IF EXISTS `us_user_own_courses`;
CREATE TABLE `us_user_own_courses` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `coursesIds` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `modity_time` datetime DEFAULT NULL,
  `state` varchar(255) DEFAULT '0' COMMENT '0:正常,1:禁用',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `us_user_own_courses_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `us_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_user_own_courses
-- ----------------------------

-- ----------------------------
-- Table structure for us_video
-- ----------------------------
DROP TABLE IF EXISTS `us_video`;
CREATE TABLE `us_video` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL COMMENT '视频标题',
  `create_time` datetime NOT NULL COMMENT '上传时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `path` varchar(255) NOT NULL COMMENT '封面存放位置',
  `examine_state` varchar(2) DEFAULT NULL COMMENT '审核状态',
  `attachment_id` bigint(200) DEFAULT NULL COMMENT '附件（视频本体）',
  `state` varchar(255) DEFAULT '0' COMMENT '0:正常 1:删除',
  PRIMARY KEY (`id`),
  KEY `attachment_id` (`attachment_id`),
  CONSTRAINT `us_video_ibfk_1` FOREIGN KEY (`attachment_id`) REFERENCES `us_attachment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of us_video
-- ----------------------------
