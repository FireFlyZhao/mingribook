/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-12-04 15:45:37
*/
USE test
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_stu`
-- ----------------------------
DROP TABLE IF EXISTS `tb_stu`;
CREATE TABLE `tb_stu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_stu
-- ----------------------------
INSERT INTO tb_stu(id,name,sex,birthday) VALUES ( 1,'小明', '男', '2015-11-02');
INSERT INTO tb_stu(id,name,sex,birthday) VALUES ( 2,'小红', '女', '2015-09-01');
INSERT INTO tb_stu(id,name,sex,birthday) VALUES ( 3,'张三', '男', '2010-02-12');
INSERT INTO tb_stu(id,name,sex,birthday) VALUES ( 4,'李四', '女', '2009-09-10');
