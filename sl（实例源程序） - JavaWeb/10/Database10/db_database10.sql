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
-- Create schema db_database10
--

CREATE DATABASE IF NOT EXISTS db_database10;
USE db_database10;

--
-- Definition of table `tb_books`
--

DROP TABLE IF EXISTS `tb_books`;
CREATE TABLE `tb_books` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `bookCount` int(10) unsigned NOT NULL,
  `author` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_books`
--

/*!40000 ALTER TABLE `tb_books` DISABLE KEYS */;
INSERT INTO `tb_books` (`id`,`name`,`price`,`bookCount`,`author`) VALUES 
 (6,'JavaWeb从入门到精通',57,1240,'明日科技'),
 (7,'Java从入门到精通',59,234,'明日科技'),
 (8,'学通JavaWeb的24堂课',69,120,'明日科技');
/*!40000 ALTER TABLE `tb_books` ENABLE KEYS */;


--
-- Definition of table `tb_product`
--

DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `num` int(10) unsigned NOT NULL,
  `unit` varchar(45) NOT NULL,
  PRIMARY KEY (`id`,`name`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_product`
--

/*!40000 ALTER TABLE `tb_product` DISABLE KEYS */;
INSERT INTO `tb_product` (`id`,`name`,`price`,`num`,`unit`) VALUES 
 (1,'西红柿',22.8,30,'箱'),
 (2,'柚子',55.5,100,'箱'),
 (3,'梨',15.8,55,'箱'),
 (4,'橘子',40.5,80,'箱'),
 (5,'苹果',60,100,'箱');
/*!40000 ALTER TABLE `tb_product` ENABLE KEYS */;


--
-- Definition of table `tb_student_batch`
--

DROP TABLE IF EXISTS `tb_student_batch`;
CREATE TABLE `tb_student_batch` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `sex` tinyint(3) unsigned NOT NULL,
  `age` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_student_batch`
--

/*!40000 ALTER TABLE `tb_student_batch` DISABLE KEYS */;
INSERT INTO `tb_student_batch` (`id`,`name`,`sex`,`age`) VALUES 
 (1,'??0',1,10),
 (2,'??1',0,14),
 (3,'??2',1,14),
 (4,'??3',0,13),
 (5,'??4',1,14),
 (6,'??5',0,11),
 (7,'??6',1,14),
 (8,'??7',0,10),
 (9,'??8',1,10),
 (10,'??9',0,12);
/*!40000 ALTER TABLE `tb_student_batch` ENABLE KEYS */;


--
-- Definition of procedure `findAllBook`
--

DROP PROCEDURE IF EXISTS `findAllBook`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `findAllBook`()
BEGIN
  SELECT * FROM tb_books order by id desc;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
