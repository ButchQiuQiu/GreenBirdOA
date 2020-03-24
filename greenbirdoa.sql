/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50530
Source Host           : localhost:3306
Source Database       : greenbirdoa

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2020-03-24 21:04:29
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
INSERT INTO `depart` VALUES ('4', '董事长');

-- ----------------------------
-- Table structure for `flowstatus`
-- ----------------------------
DROP TABLE IF EXISTS `flowstatus`;
CREATE TABLE `flowstatus` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `status` varchar(10) COLLATE utf8_bin NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of jurisdiction
-- ----------------------------
INSERT INTO `jurisdiction` VALUES ('1', '普通职员');
INSERT INTO `jurisdiction` VALUES ('2', '部门领导');
INSERT INTO `jurisdiction` VALUES ('3', '董事长');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `user` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '账号',
  `pwd` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `name` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `fk_depart` int(10) NOT NULL COMMENT '部门表外键',
  `fk_jurisdiction` int(10) NOT NULL COMMENT '权限',
  `address` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '地址',
  `phone` int(11) NOT NULL COMMENT '手机号码',
  `lastsign` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '最后一次签到的日期,服务器由此判断今天是否缺勤',
  `absenteeism` int(10) NOT NULL COMMENT '缺勤的次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Qiu123456', '123456', '球球', '4', '3', '广州白云', '110110110', '2020-03-23', '0');

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of workflow
-- ----------------------------
