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
-- Create schema db_database11
--

CREATE DATABASE IF NOT EXISTS db_database11;
USE db_database11;

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
-- Definition of table `tab_factory`
--

DROP TABLE IF EXISTS `tab_factory`;
CREATE TABLE `tab_factory` (
  `factoryid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `factoryname` varchar(45) NOT NULL COMMENT '生产商名称',
  PRIMARY KEY (`factoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tab_factory`
--

/*!40000 ALTER TABLE `tab_factory` DISABLE KEYS */;
INSERT INTO `tab_factory` (`factoryid`,`factoryname`) VALUES 
 (1,'明日科技'),
 (2,'明日*****');
/*!40000 ALTER TABLE `tab_factory` ENABLE KEYS */;


--
-- Definition of table `tab_idcard`
--

DROP TABLE IF EXISTS `tab_idcard`;
CREATE TABLE `tab_idcard` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IDcard_code` varchar(45) NOT NULL COMMENT '身份证号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tab_idcard`
--

/*!40000 ALTER TABLE `tab_idcard` DISABLE KEYS */;
INSERT INTO `tab_idcard` (`id`,`IDcard_code`) VALUES 
 (1,'22019523321*****'),
 (2,'22296325413*****'),
 (3,'12245435878*****');
/*!40000 ALTER TABLE `tab_idcard` ENABLE KEYS */;


--
-- Definition of table `tab_mapping`
--

DROP TABLE IF EXISTS `tab_mapping`;
CREATE TABLE `tab_mapping` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tab_mapping`
--

/*!40000 ALTER TABLE `tab_mapping` DISABLE KEYS */;
INSERT INTO `tab_mapping` (`id`,`user_id`,`role_id`) VALUES 
 (1,1,1),
 (2,1,2),
 (3,1,3),
 (4,3,2),
 (5,2,2),
 (6,2,3);
/*!40000 ALTER TABLE `tab_mapping` ENABLE KEYS */;


--
-- Definition of table `tab_people`
--

DROP TABLE IF EXISTS `tab_people`;
CREATE TABLE `tab_people` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `age` int(10) unsigned NOT NULL,
  `sex` varchar(2) NOT NULL,
  `card_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tab_people`
--

/*!40000 ALTER TABLE `tab_people` DISABLE KEYS */;
INSERT INTO `tab_people` (`id`,`name`,`age`,`sex`,`card_id`) VALUES 
 (1,'小明',22,'男',1),
 (2,'小红',20,'女',2),
 (3,'小刚',30,'男',3);
/*!40000 ALTER TABLE `tab_people` ENABLE KEYS */;


--
-- Definition of table `tab_person`
--

DROP TABLE IF EXISTS `tab_person`;
CREATE TABLE `tab_person` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `age` int(10) unsigned NOT NULL,
  `sex` varchar(2) NOT NULL,
  `school` varchar(45) NOT NULL DEFAULT '无',
  `company` varchar(45) NOT NULL DEFAULT '无',
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tab_person`
--

/*!40000 ALTER TABLE `tab_person` DISABLE KEYS */;
INSERT INTO `tab_person` (`id`,`name`,`age`,`sex`,`school`,`company`,`type`) VALUES 
 (1,'小明',12,'男','明日希望小学','无','学生'),
 (2,'小红',25,'女','无','明日科技','职员');
/*!40000 ALTER TABLE `tab_person` ENABLE KEYS */;


--
-- Definition of table `tab_person1`
--

DROP TABLE IF EXISTS `tab_person1`;
CREATE TABLE `tab_person1` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `age` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tab_person1`
--

/*!40000 ALTER TABLE `tab_person1` DISABLE KEYS */;
INSERT INTO `tab_person1` (`id`,`name`,`sex`,`age`) VALUES 
 (1,'小明','男',12),
 (2,'小红','女',25);
/*!40000 ALTER TABLE `tab_person1` ENABLE KEYS */;


--
-- Definition of table `tab_product`
--

DROP TABLE IF EXISTS `tab_product`;
CREATE TABLE `tab_product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT '产品名称',
  `price` double NOT NULL COMMENT '产品价格',
  `factoryid` int(10) unsigned NOT NULL COMMENT '关联的产品信息id',
  PRIMARY KEY (`id`),
  KEY `FK_tab_product` (`factoryid`),
  CONSTRAINT `FK_tab_product` FOREIGN KEY (`factoryid`) REFERENCES `tab_factory` (`factoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tab_product`
--

/*!40000 ALTER TABLE `tab_product` DISABLE KEYS */;
INSERT INTO `tab_product` (`id`,`name`,`price`,`factoryid`) VALUES 
 (1,'Java Web编程宝典',79,1),
 (2,'Java编程宝典',79,1),
 (3,'测试数据',88,1),
 (4,'编程词典',368,2);
/*!40000 ALTER TABLE `tab_product` ENABLE KEYS */;


--
-- Definition of table `tab_role`
--

DROP TABLE IF EXISTS `tab_role`;
CREATE TABLE `tab_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `rolename` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tab_role`
--

/*!40000 ALTER TABLE `tab_role` DISABLE KEYS */;
INSERT INTO `tab_role` (`id`,`rolename`) VALUES 
 (1,'系统管理员'),
 (2,'新闻管理员'),
 (3,'广告管理员');
/*!40000 ALTER TABLE `tab_role` ENABLE KEYS */;


--
-- Definition of table `tab_staffer`
--

DROP TABLE IF EXISTS `tab_staffer`;
CREATE TABLE `tab_staffer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `company` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tab_staffer`
--

/*!40000 ALTER TABLE `tab_staffer` DISABLE KEYS */;
INSERT INTO `tab_staffer` (`id`,`company`) VALUES 
 (2,'明日科技');
/*!40000 ALTER TABLE `tab_staffer` ENABLE KEYS */;


--
-- Definition of table `tab_staffer2`
--

DROP TABLE IF EXISTS `tab_staffer2`;
CREATE TABLE `tab_staffer2` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `company` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `age` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tab_staffer2`
--

/*!40000 ALTER TABLE `tab_staffer2` DISABLE KEYS */;
INSERT INTO `tab_staffer2` (`id`,`company`,`name`,`sex`,`age`) VALUES 
 (2,'明日科技','小红','女',25);
/*!40000 ALTER TABLE `tab_staffer2` ENABLE KEYS */;


--
-- Definition of table `tab_student`
--

DROP TABLE IF EXISTS `tab_student`;
CREATE TABLE `tab_student` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `school` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tab_student`
--

/*!40000 ALTER TABLE `tab_student` DISABLE KEYS */;
INSERT INTO `tab_student` (`id`,`school`) VALUES 
 (1,'明日希望小学');
/*!40000 ALTER TABLE `tab_student` ENABLE KEYS */;


--
-- Definition of table `tab_student2`
--

DROP TABLE IF EXISTS `tab_student2`;
CREATE TABLE `tab_student2` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `school` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `age` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tab_student2`
--

/*!40000 ALTER TABLE `tab_student2` DISABLE KEYS */;
INSERT INTO `tab_student2` (`id`,`school`,`name`,`sex`,`age`) VALUES 
 (1,'明日希望小学','小明','男',12);
/*!40000 ALTER TABLE `tab_student2` ENABLE KEYS */;


--
-- Definition of table `tab_user`
--

DROP TABLE IF EXISTS `tab_user`;
CREATE TABLE `tab_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tab_user`
--

/*!40000 ALTER TABLE `tab_user` DISABLE KEYS */;
INSERT INTO `tab_user` (`id`,`name`) VALUES 
 (1,'admin'),
 (2,'test'),
 (3,'newsManger');
/*!40000 ALTER TABLE `tab_user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
