/*
Navicat MySQL Data Transfer

Source Server         : cool
Source Server Version : 50543
Source Host           : localhost:3306
Source Database       : cool

Target Server Type    : MYSQL
Target Server Version : 50543
File Encoding         : 65001

Date: 2018-01-18 17:44:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(60) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  `forbiden` int(1) DEFAULT NULL COMMENT '0禁止登陆1不禁止',
  `is_delete` int(1) DEFAULT NULL COMMENT '0未删除1删除',
  `male` int(1) DEFAULT NULL COMMENT '0女1男',
  `age` int(3) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '柯柯', '4QrcOUm6Wau+VuBX8g+IPg==', '2015-11-28 21:58:52', null, '1', '0', '1', '30', '2015-11-28', '福建福州', '1103206765@qq.com', '15074816437');
INSERT INTO `user` VALUES ('2', 'keke', 'ot/qWYF/1lZ6ESGk2yzvCQ==', '2015-12-08 00:48:13', null, null, '0', null, null, null, null, '18850149410@qq.com', null);
INSERT INTO `user` VALUES ('3', '小明', 'Sl6hGwMOwc+8i5lH/fLIcg==', '2015-12-08 00:48:13', null, null, '0', null, null, null, null, '18850149410@qq.com', null);
INSERT INTO `user` VALUES ('4', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', null, null, null, null, null, null, null, 'water', null);
INSERT INTO `user` VALUES ('5', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('6', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('7', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('8', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('9', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('10', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('11', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('12', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('13', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('14', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('15', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('16', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('17', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('18', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('19', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('20', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('21', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('22', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
INSERT INTO `user` VALUES ('23', 'water', 'lGA3C7DKHJinebG8xoYcLA==', '2017-08-24 17:04:52', '2018-01-18 17:42:00', null, null, null, null, '2018-01-18', '', 'water', '');
