/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50530
Source Host           : localhost:3306
Source Database       : greenbirdoa

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2020-03-30 18:40:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `depart`
-- ----------------------------
DROP TABLE IF EXISTS `depart`;
CREATE TABLE `depart` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of depart
-- ----------------------------
INSERT INTO `depart` VALUES ('1', '人事部');
INSERT INTO `depart` VALUES ('2', '开发部');
INSERT INTO `depart` VALUES ('3', '营销部');
INSERT INTO `depart` VALUES ('4', '管理层');

-- ----------------------------
-- Table structure for `flowstatus`
-- ----------------------------
DROP TABLE IF EXISTS `flowstatus`;
CREATE TABLE `flowstatus` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of flowstatus
-- ----------------------------

-- ----------------------------
-- Table structure for `jurisdiction`
-- ----------------------------
DROP TABLE IF EXISTS `jurisdiction`;
CREATE TABLE `jurisdiction` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '权限详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of jurisdiction
-- ----------------------------
INSERT INTO `jurisdiction` VALUES ('1', '普通职员');
INSERT INTO `jurisdiction` VALUES ('2', '中级职员');
INSERT INTO `jurisdiction` VALUES ('3', '高级职员');

-- ----------------------------
-- Table structure for `sex`
-- ----------------------------
DROP TABLE IF EXISTS `sex`;
CREATE TABLE `sex` (
  `id` int(10) NOT NULL,
  `name` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sex
-- ----------------------------
INSERT INTO `sex` VALUES ('1', '男性');
INSERT INTO `sex` VALUES ('2', '女性');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user` varchar(99) COLLATE utf8_bin NOT NULL COMMENT '账号',
  `pwd` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `name` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `fk_sex` int(10) NOT NULL COMMENT '性别',
  `address` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '地址',
  `phone` varchar(11) COLLATE utf8_bin NOT NULL COMMENT '手机号码',
  `salary` double(10,0) NOT NULL DEFAULT '0' COMMENT '工资',
  `lastsign` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '没签到' COMMENT '最后一次签到的日期,服务器由此判断今天是否缺勤',
  `absenteeism` int(10) NOT NULL DEFAULT '0' COMMENT '缺勤的次数',
  `fk_jurisdiction` int(10) NOT NULL COMMENT '权限',
  `fk_depart` int(10) NOT NULL COMMENT '部门表外键',
  PRIMARY KEY (`user`),
  KEY `fk_sex` (`fk_sex`),
  KEY `fk_jurisdiction` (`fk_jurisdiction`),
  KEY `fk_depart` (`fk_depart`),
  CONSTRAINT `fk_depart` FOREIGN KEY (`fk_depart`) REFERENCES `depart` (`id`),
  CONSTRAINT `fk_jurisdiction` FOREIGN KEY (`fk_jurisdiction`) REFERENCES `jurisdiction` (`id`),
  CONSTRAINT `fk_sex` FOREIGN KEY (`fk_sex`) REFERENCES `sex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('Qiu123456', '123456', '球球', '2', '广州白云', '13266523659', '100000', '2020-03-29', '6', '3', '4');
INSERT INTO `user` VALUES ('Qiu1234561', '123456', '张三', '2', '广州天河', '18022352234', '5000', '未签到', '1', '1', '1');
INSERT INTO `user` VALUES ('Qiu12345611', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu1234561110', '123456', '秃头', '1', '广州珠江新城', '119', '10000', '未签到', '1', '1', '2');
INSERT INTO `user` VALUES ('Qiu1234561111', '123456', '秃头', '1', '广州珠江新城', '119', '10000', '未签到', '1', '1', '2');
INSERT INTO `user` VALUES ('Qiu1234561112', '123456', '秃头', '1', '广州珠江新城', '119', '10000', '未签到', '1', '1', '2');
INSERT INTO `user` VALUES ('Qiu1234561113', '123456', '秃头', '1', '广州珠江新城', '119', '10000', '未签到', '1', '1', '2');
INSERT INTO `user` VALUES ('Qiu1234561114', '123456', '秃头', '1', '广州珠江新城', '119', '10000', '未签到', '1', '1', '2');
INSERT INTO `user` VALUES ('Qiu1234561115', '123456', '秃头', '1', '广州珠江新城', '119', '10000', '未签到', '1', '1', '2');
INSERT INTO `user` VALUES ('Qiu123456113', '123456', '秃头', '1', '广州珠江新城', '119', '10000', '未签到', '1', '2', '2');
INSERT INTO `user` VALUES ('Qiu123456114', '123456', '秃头', '1', '广州珠江新城', '119', '10000', '未签到', '1', '1', '2');
INSERT INTO `user` VALUES ('Qiu123456115', '123456', '秃头', '1', '广州珠江新城', '119', '10000', '未签到', '1', '1', '2');
INSERT INTO `user` VALUES ('Qiu123456116', '123456', '秃头', '1', '广州珠江新城', '119', '10000', '未签到', '1', '1', '2');
INSERT INTO `user` VALUES ('Qiu123456117', '123456', '秃头', '1', '广州珠江新城', '119', '10000', '未签到', '1', '1', '2');
INSERT INTO `user` VALUES ('Qiu123456118', '123456', '秃头', '1', '广州珠江新城', '119', '10000', '未签到', '1', '1', '2');
INSERT INTO `user` VALUES ('Qiu123456119', '123456', '秃头', '1', '广州珠江新城', '119', '10000', '未签到', '1', '1', '2');
INSERT INTO `user` VALUES ('Qiu12345616', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3003', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu1234562', '123456', '张4', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '1');
INSERT INTO `user` VALUES ('Qiu12345624', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu12345625', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '3', '3');
INSERT INTO `user` VALUES ('Qiu12345626', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu12345627', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu12345628', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu12345629', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu1234563', '123456', '李四', '1', '广州天河', '18022352234', '10000', '未签到', '1', '2', '1');
INSERT INTO `user` VALUES ('Qiu12345630', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu12345631', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu12345632', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu12345633', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu12345634', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu12345635', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu12345636', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu12345637', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu12345638', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu12345639', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu1234564', '123456', '李5', '1', '广州天河', '18022352234', '10000', '未签到', '1', '2', '2');
INSERT INTO `user` VALUES ('Qiu12345640', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu1234565', '123456', '李6', '2', '广州天河', '18022352234', '10000', '未签到', '1', '1', '2');
INSERT INTO `user` VALUES ('Qiu1234566', '123456', '王五', '2', '广州天河', '18022352234', '10000', '2020-03-30', '1', '2', '2');
INSERT INTO `user` VALUES ('Qiu1234567', '123456', '鲁人甲', '2', '广州天河', '18022352234', '8000', '未签到', '1', '2', '3');
INSERT INTO `user` VALUES ('Qiu1234568', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');
INSERT INTO `user` VALUES ('Qiu1234569', '123456', '螺丝钉', '2', '广州天河', '18022352234', '3000', '未签到', '1', '1', '3');

-- ----------------------------
-- Table structure for `workflow`
-- ----------------------------
DROP TABLE IF EXISTS `workflow`;
CREATE TABLE `workflow` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `message` varchar(1000) COLLATE utf8_bin NOT NULL COMMENT '工作流的内容',
  `fk_user_initiator` int(10) NOT NULL COMMENT '发起者的user外键id',
  `fk_user_receiver` int(10) NOT NULL COMMENT '接收者的user外键id',
  `remark` varchar(1000) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '备注',
  `fk_flowstatus` int(10) NOT NULL COMMENT '工作流状态',
  `createtime` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '工作流创建的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of workflow
-- ----------------------------
