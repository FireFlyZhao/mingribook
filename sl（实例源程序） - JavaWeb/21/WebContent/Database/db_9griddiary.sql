-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.40-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_9griddiary
--

CREATE DATABASE IF NOT EXISTS db_9griddiary;
USE db_9griddiary;

--
-- Definition of table `tb_diary`
--

DROP TABLE IF EXISTS `tb_diary`;
CREATE TABLE `tb_diary` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(60) NOT NULL,
  `address` varchar(50) NOT NULL COMMENT '日记保存的地址',
  `writeTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间',
  `userid` int(10) unsigned NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=gbk;

--
-- Dumping data for table `tb_diary`
--

/*!40000 ALTER TABLE `tb_diary` DISABLE KEYS */;
INSERT INTO `tb_diary` (`id`,`title`,`address`,`writeTime`,`userid`) VALUES 
 (6,'请在此输入标题','-1625618782951844312','2011-05-26 09:40:10',1),
 (8,'请在此输入标题','-5039247624120215442','2011-05-27 10:26:47',1),
 (9,'心情不错','241344336121425196','2011-05-28 14:00:43',1),
 (10,'无题','2030326276105596531','2011-05-28 14:03:08',1),
 (11,'无尽的牵挂','-2201304326449572193','2011-05-28 14:09:18',2),
 (14,'心情很好','7076008621496558673','2011-06-09 16:31:07',1);
/*!40000 ALTER TABLE `tb_diary` ENABLE KEYS */;


--
-- Definition of table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `pwd` varchar(50) NOT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT 'E-mail',
  `question` varchar(45) DEFAULT NULL COMMENT '密码提示问题',
  `answer` varchar(45) DEFAULT NULL COMMENT '提示问题答案',
  `city` varchar(30) DEFAULT NULL COMMENT '所在地',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

--
-- Dumping data for table `tb_user`
--

/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` (`id`,`username`,`pwd`,`email`,`question`,`answer`,`city`) VALUES 
 (1,'mr','mrsoft',NULL,'','',''),
 (2,'wgh','111',NULL,'我的工作单位','明日科技','长春'),
 (3,'qq','w123456','wgh717@sohu.com','6','6','长春'),
 (4,'h','hhhhhh','wgh717@sohu.com','','','北京'),
 (5,'w','wwwwww','www@sina.com','','','北京'),
 (6,'qiqi','qq123456','wgh8007@163.com','我的工作单位','明日科技','长春'),
 (7,'kk','kkkkkk','wgh@gggg.com','','','长春'),
 (8,'888','wwwwww','www@si.com','','','葫芦岛');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
