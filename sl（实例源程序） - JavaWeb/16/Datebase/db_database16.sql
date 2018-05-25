-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.39-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_database10
--

CREATE DATABASE IF NOT EXISTS db_database10;
USE db_database10;

--
-- Definition of table `tab_employee`
--

DROP TABLE IF EXISTS `tab_employee`;
CREATE TABLE `tab_employee` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `business` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  `remark` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tab_employee`
--

/*!40000 ALTER TABLE `tab_employee` DISABLE KEYS */;
INSERT INTO `tab_employee` (`id`,`name`,`sex`,`business`,`address`,`remark`) VALUES 
 (1,'小明','男','项目负责人','长春市南关区***','工作认真，领导能力强'),
 (2,'小红','女','客服人员1','长春市朝阳区***','工作认真负责'),
 (3,'小强','男','项目经理','长春市南关区***','领导能力强');
/*!40000 ALTER TABLE `tab_employee` ENABLE KEYS */;


--
-- Definition of table `tab_product`
--

DROP TABLE IF EXISTS `tab_product`;
CREATE TABLE `tab_product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(45) NOT NULL COMMENT '商品名称',
  `price` double NOT NULL COMMENT '商品价格',
  `factory` varchar(45) NOT NULL COMMENT '生产商',
  `remark` varchar(200) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tab_product`
--

/*!40000 ALTER TABLE `tab_product` DISABLE KEYS */;
INSERT INTO `tab_product` (`id`,`name`,`price`,`factory`,`remark`) VALUES 
 (1,'Java Web编程词典',79,'明日科技','明日科技出品');
/*!40000 ALTER TABLE `tab_product` ENABLE KEYS */;


--
-- Definition of table `tb_students`
--

DROP TABLE IF EXISTS `tb_students`;
CREATE TABLE `tb_students` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `studentCode` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `institute` varchar(45) NOT NULL,
  `department` varchar(45) NOT NULL,
  `classes` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90234 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_students`
--

/*!40000 ALTER TABLE `tb_students` DISABLE KEYS */;
INSERT INTO `tb_students` (`id`,`studentCode`,`name`,`sex`,`institute`,`department`,`classes`,`phone`,`address`) VALUES 
 (90233,'090233','小明','男','信息工程学院','计算机科学与技术','计算机091','138888888','吉林省二道区东胜大街***号');
/*!40000 ALTER TABLE `tb_students` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
