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
-- Create schema db_database13
--

CREATE DATABASE IF NOT EXISTS db_database13;
USE db_database13;

--
-- Definition of table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `age` int(10) unsigned NOT NULL,
  `sex` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_user`
--

/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` (`id`,`name`,`age`,`sex`) VALUES 
 (12,'Spring与Hibernate整合',20,'男');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;


--
-- Definition of table `tb_user2`
--

DROP TABLE IF EXISTS `tb_user2`;
CREATE TABLE `tb_user2` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `realname` varchar(45) NOT NULL,
  `age` varchar(45) NOT NULL,
  `tel` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_user2`
--

/*!40000 ALTER TABLE `tb_user2` DISABLE KEYS */;
INSERT INTO `tb_user2` (`id`,`username`,`password`,`realname`,`age`,`tel`) VALUES 
 (1,'user','123456','明日科技','26','13888******');
/*!40000 ALTER TABLE `tb_user2` ENABLE KEYS */;


--
-- Definition of table `tb_user3`
--

DROP TABLE IF EXISTS `tb_user3`;
CREATE TABLE `tb_user3` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `business` varchar(45) NOT NULL,
  `addTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_user3`
--

/*!40000 ALTER TABLE `tb_user3` DISABLE KEYS */;
INSERT INTO `tb_user3` (`id`,`name`,`business`,`addTime`) VALUES 
 (1,'明日科技0','高级工程师','2010-04-15 11:31:54'),
 (2,'明日科技1','高级工程师','2010-04-15 11:31:54'),
 (3,'明日科技2','高级工程师','2010-04-15 11:31:54'),
 (4,'明日科技3','高级工程师','2010-04-15 11:31:54'),
 (5,'明日科技4','高级工程师','2010-04-15 11:31:54'),
 (6,'明日科技0','高级工程师','2010-04-15 13:15:21'),
 (7,'明日科技1','高级工程师','2010-04-15 13:15:21'),
 (8,'明日科技2','高级工程师','2010-04-15 13:15:21'),
 (9,'明日科技3','高级工程师','2010-04-15 13:15:21'),
 (10,'明日科技4','高级工程师','2010-04-15 13:15:21'),
 (11,'明日科技5','高级工程师','2010-04-15 13:15:21');
/*!40000 ALTER TABLE `tb_user3` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
