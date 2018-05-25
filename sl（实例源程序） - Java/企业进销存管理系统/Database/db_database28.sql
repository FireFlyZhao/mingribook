/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : db1

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-11-30 15:35:42
*/

CREATE DATABASE db_database28;
USE db_database28
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_gysinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tb_gysinfo`;
CREATE TABLE `tb_gysinfo` (
  `id` varchar(50) NOT NULL,
  `name` varchar(60) NOT NULL,
  `jc` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `bianma` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `lian` varchar(50) DEFAULT NULL,
  `ltel` varchar(50) DEFAULT NULL,
  `yh` varchar(50) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tb_jsr`
-- ----------------------------
DROP TABLE IF EXISTS `tb_jsr`;
CREATE TABLE `tb_jsr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `sex` char(2) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `enable` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tb_khinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tb_khinfo`;
CREATE TABLE `tb_khinfo` (
  `id` varchar(50) NOT NULL,
  `khname` varchar(50) DEFAULT NULL,
  `jian` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `bianma` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `lian` varchar(50) DEFAULT NULL,
  `ltel` varchar(50) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `xinhang` varchar(60) DEFAULT NULL,
  `hao` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tb_kucun`
-- ----------------------------
DROP TABLE IF EXISTS `tb_kucun`;
CREATE TABLE `tb_kucun` (
  `id` varchar(30) NOT NULL DEFAULT '',
  `spname` varchar(50) NOT NULL,
  `jc` varchar(25) DEFAULT NULL,
  `cd` varchar(50) DEFAULT NULL,
  `gg` varchar(50) DEFAULT NULL,
  `bz` varchar(50) DEFAULT NULL,
  `dw` varchar(10) DEFAULT NULL,
  `dj` decimal(10,2) DEFAULT NULL,
  `kcsl` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tb_rkth_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_rkth_detail`;
CREATE TABLE `tb_rkth_detail` (
  `rkthID` varchar(30) NOT NULL,
  `spid` varchar(50) NOT NULL,
  `dj` decimal(10,2) NOT NULL,
  `sl` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tb_rkth_main`
-- ----------------------------
DROP TABLE IF EXISTS `tb_rkth_main`;
CREATE TABLE `tb_rkth_main` (
  `rkthID` varchar(30) NOT NULL,
  `pzs` float NOT NULL,
  `je` decimal(10,2) NOT NULL,
  `ysjl` varchar(50) DEFAULT NULL,
  `gysname` varchar(100) NOT NULL,
  `rtdate` datetime NOT NULL,
  `czy` varchar(30) NOT NULL,
  `jsr` varchar(30) NOT NULL,
  `jsfs` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tb_ruku_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_ruku_detail`;
CREATE TABLE `tb_ruku_detail` (
  `rkID` varchar(30) NOT NULL,
  `spid` varchar(50) NOT NULL,
  `dj` decimal(10,2) NOT NULL,
  `sl` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tb_ruku_main`
-- ----------------------------
DROP TABLE IF EXISTS `tb_ruku_main`;
CREATE TABLE `tb_ruku_main` (
  `rkID` varchar(30) NOT NULL,
  `pzs` int(11) NOT NULL,
  `je` decimal(10,2) NOT NULL,
  `ysjl` varchar(50) NOT NULL,
  `gysname` varchar(100) NOT NULL,
  `rkdate` datetime NOT NULL,
  `czy` varchar(30) NOT NULL,
  `jsr` varchar(30) NOT NULL,
  `jsfs` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tb_sell_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sell_detail`;
CREATE TABLE `tb_sell_detail` (
  `sellID` varchar(30) NOT NULL,
  `spid` varchar(50) NOT NULL,
  `dj` decimal(10,2) NOT NULL,
  `sl` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tb_sell_main`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sell_main`;
CREATE TABLE `tb_sell_main` (
  `sellID` varchar(30) NOT NULL,
  `pzs` int(11) NOT NULL,
  `je` decimal(10,2) NOT NULL,
  `ysjl` varchar(50) DEFAULT NULL,
  `khname` varchar(100) NOT NULL,
  `xsdate` datetime NOT NULL,
  `czy` varchar(30) NOT NULL,
  `jsr` varchar(30) NOT NULL,
  `jsfs` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tb_spinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tb_spinfo`;
CREATE TABLE `tb_spinfo` (
  `id` varchar(50) NOT NULL,
  `spname` varchar(50) NOT NULL,
  `jc` varchar(50) DEFAULT NULL,
  `cd` varchar(60) DEFAULT NULL,
  `dw` varchar(50) NOT NULL,
  `gg` varchar(50) NOT NULL,
  `bz` varchar(50) DEFAULT NULL,
  `ph` varchar(50) DEFAULT NULL,
  `pzwh` varchar(50) DEFAULT NULL,
  `memo` varchar(90) DEFAULT NULL,
  `gysname` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tb_userlist`
-- ----------------------------
DROP TABLE IF EXISTS `tb_userlist`;
CREATE TABLE `tb_userlist` (
  `name` varchar(30) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tb_xsth_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_xsth_detail`;
CREATE TABLE `tb_xsth_detail` (
  `xsthID` varchar(30) NOT NULL,
  `spid` varchar(50) NOT NULL,
  `dj` decimal(10,2) NOT NULL,
  `sl` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tb_xsth_main`
-- ----------------------------
DROP TABLE IF EXISTS `tb_xsth_main`;
CREATE TABLE `tb_xsth_main` (
  `xsthID` varchar(30) NOT NULL,
  `pzs` int(11) NOT NULL,
  `je` decimal(10,2) NOT NULL,
  `ysjl` varchar(50) DEFAULT NULL,
  `khname` varchar(100) NOT NULL,
  `thdate` datetime NOT NULL,
  `czy` varchar(30) NOT NULL,
  `jsr` varchar(30) NOT NULL,
  `jsfs` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into tb_jsr(name,sex,age,tel,enable) values('lx','女',25,'136******',0);
insert into tb_jsr(name,sex,age,tel,enable) values('liuxin','男',25,'136******',1);

insert into tb_gysinfo values('gys1007','***供应商公司','GYS','长春市二道区','130031','2132','1111','32121','231231','231213','231231');
insert into tb_gysinfo values('gys1002','新*纪文化百货商城','新百','吉林省辽源市','1363','0437-6930**','52186**','于X','138686*****','中国人民银行','y*@etang.com');
insert into tb_gysinfo values('gys1004','吉林省明日*业有限公司','JLMRSY','长春市东盛大街89号','','0431-4972**','','ww','','','');
insert into tb_gysinfo values('gys1005','笔*有限公司','BHYXGS','长在市','1111','1212','2151','毛皮','44411','8*@1*.com','8885');

insert into tb_khinfo values('kh1001','明日科技有限公司','明日','长春市东盛大街','111111','111111','111111','高经理','544444','888@**.com','544554','454545');
insert into tb_khinfo values('kh1002','吉林省明日科技有限公司','明日科技','长春市二道区','1111110','52415','54252','高经理','136524','mingrisoft@mingrisoft.com.cn','建设银
行','231586');
insert into tb_khinfo values('kh1003','五*缤纷','五彩','长春市','122','45644','8888','路路','1000402','0*@*4.com','25250','020202');
insert into tb_khinfo values('kh1004','小小公司','XXGS','长春市','1010','1111','1111','明子','121212','88*@.com','8888','88');

insert into tb_kucun values('sp1005','润*滴眼液','RZDYY','山*正大福*达制药有限公司','10ml/支','纸盒','盒',40.00,19400);
insert into tb_kucun values('sp1007','铅笔','QB','长春','9*','沿着','铅笔厂',10.00,4);
insert into tb_kucun values('sp1008','手工艺品','SAYP','长春市','1','5','长春',10.00,999);
insert into tb_kucun values('sp1003','碧**莉香型洗衣粉','BLMLXXXYF','广**保洁公司','350g','塑包','袋',0.00,6);

insert into tb_rkth_detail values('RT20050923001','sp1003',3.5000,1);
insert into tb_rkth_detail values('RT20050926001','sp1003',3.4000,10);
insert into tb_rkth_detail values('RT20051005002','sp1003',3.4000,1);
insert into tb_rkth_detail values('RT20051005002','sp1002',890.0000,1);
insert into tb_rkth_detail values('RT20071020001','sp1005',431.0000,10);
insert into tb_rkth_detail values('RT20071020001','sp1004',120.0000,2);
insert into tb_rkth_detail values('RT20071109001','sp1001',101.0000,1000);
insert into tb_rkth_detail values('RT20071109002','sp1005',40.0000,10);
insert into tb_rkth_detail values('RT20080403001','sp1002',23.0000,462);
insert into tb_rkth_detail values('RT20080410005','sp1002',432.0000,0);
insert into tb_rkth_detail values('RT20080521001','sp1007',10.0000,5);

insert into tb_rkth_main values('RT20050923001',1.0,3.5000,'3.50','新*纪文化百货商城','2005-09-23 15:19:24.0','admin','wgh','现金');
insert into tb_rkth_main values('RT20050926001',1.0,34.0000,'0.00','振撼*琴行','2005-09-26 14:01:48.0','admin','wg','现金');
insert into tb_rkth_main values('RT20051005001',1.0,3.4000,'0.00','振撼*琴行','2005-10-05 09:09:34.0','admin','hj','现金');
insert into tb_rkth_main values('RT20051005002',2.0,893.4000,'0.00','振撼*琴行','2005-10-05 13:05:35.0','admin','wq','现金');
insert into tb_rkth_main values('RT20071020001',2.0,4550.0000,'33333','振撼*琴行','2007-10-20 09:10:49.0','mr','33333','现金');
insert into tb_rkth_main values('RT20071109001',1.0,101000.0000,'合格','振撼*琴行','2007-11-09 14:32:39.0','mr','00','现金');
insert into tb_rkth_main values('RT20071109002',1.0,400.0000,'质量有问题','振撼*琴行','2007-11-09 15:50:03.0','mr','11','现金');
insert into tb_rkth_main values('RT20080403001',1.0,10626.0000,'4444','新*纪文化百货商城','2008-04-03 15:52:16.0','','44','现金');
insert into tb_rkth_main values('RT20080410001',1.0,432.0000,'1','新*纪文化百货商城','2008-04-10 10:33:51.0','','1','现金');
insert into tb_rkth_main values('RT20080410002',1.0,0.0000,'12','新*纪文化百货商城','2008-04-10 10:37:56.0','tsoft','范德萨','现金');
insert into tb_rkth_main values('RT20080410003',1.0,-432.0000,'12','新*纪文化百货商城','2008-04-10 10:38:23.0','tsoft','范德萨','现金');
insert into tb_rkth_main values('RT20080521001',1.0,50.0000,'合格','新*纪文化百货商城','2008-05-21 14:47:37.0','tsoft','范德萨','现金');
insert into tb_rkth_main values('RT20080410004',1.0,0.0000,'12','新*纪文化百货商城','2008-04-10 10:39:13.0','tsoft','范德萨','现金');
insert into tb_rkth_main values('RT20080410005',1.0,0.0000,'12','新*纪文化百货商城','2008-04-10 10:40:31.0','tsoft','范德萨','现金');

insert into tb_ruku_detail values('RK20071016001','sp1004',12.0000,1142);
insert into tb_ruku_detail values('RK20071016001','sp1001',10.0000,100);
insert into tb_ruku_detail values('RK20071016002','sp1001',10.0000,400);
insert into tb_ruku_detail values('RK20071016003','sp1005',10.0000,400);
insert into tb_ruku_detail values('RK20071016003','sp1001',10.0000,500);
insert into tb_ruku_detail values('RK20071016004','sp1005',10.0000,100);
insert into tb_ruku_detail values('RK20071016004','sp1001',10.0000,10);
insert into tb_ruku_detail values('RK20071016005','sp1004',10.0000,110);
insert into tb_ruku_detail values('RK20071016005','sp1005',100.0000,1000);
insert into tb_ruku_detail values('RK20071016006','sp1004',321.0000,432);
insert into tb_ruku_detail values('RK20071016006','sp1005',432.0000,3330);
insert into tb_ruku_detail values('RK20071020001','sp1004',12.0000,232);
insert into tb_ruku_detail values('RK20071109001','sp1002',22.0000,22);
insert into tb_ruku_detail values('RK20071109002','sp1007',10.0000,10);
insert into tb_ruku_detail values('RK20071109003','sp1005',40.0000,100);
insert into tb_ruku_detail values('RK20071112001','sp1008',10.0000,1000);
insert into tb_ruku_detail values('RK20080403001','sp1002',43.0000,32);
insert into tb_ruku_detail values('RK20080403002','sp1002',23.0000,430);
insert into tb_ruku_detail values('RK20080410007','sp1003',3.0000,2);
insert into tb_ruku_detail values('RK20080410008','sp1002',432.0000,432);
insert into tb_ruku_detail values('RK20080410009','sp1003',0.0000,0);
insert into tb_ruku_detail values('RK20080521001','sp1007',10.0000,10);
insert into tb_ruku_detail values('RK20100209001','sp1009',1.0000,100);
insert into tb_ruku_detail values('RK20080410009','sp1007',0.0000,0);

insert into tb_ruku_main values('RK20071016001',2,14704.0000,'合格','振撼*琴行','2007-10-16 10:32:26.0','测试人员','某人','现金');
insert into tb_ruku_main values('RK20071016002',1,4000.0000,'合格','振撼*琴行','2007-10-16 10:39:28.0','测试人员','小小','现金');
insert into tb_ruku_main values('RK20071016003',2,9000.0000,'合格','振撼*琴行','2007-10-16 10:40:00.0','测试人员','小小','现金');
insert into tb_ruku_main values('RK20071016004',2,1100.0000,'1111','振撼*琴行','2007-10-16 10:42:18.0','测试人员','1111','现金');
insert into tb_ruku_main values('RK20071016005',2,101100.0000,'fdsa','振撼*琴行','2007-10-16 10:45:14.0','测试人员','fds','现金');
insert into tb_ruku_main values('RK20071016006',2,1577232.0000,'fdsa','振撼*琴行','2007-10-16 10:45:31.0','测试人员','fds','现金');
insert into tb_ruku_main values('RK20071020001',1,2784.0000,'fff','振撼*琴行','2007-10-20 09:04:36.0','mr','lzw','现金');
insert into tb_ruku_main values('RK20071109001',1,484.0000,'合格','新*纪文化百货商城','2007-11-09 14:27:56.0','mr','玲子','现金');
insert into tb_ruku_main values('RK20071109002',1,100.0000,'合格','新*纪文化百货商城','2007-11-09 14:28:24.0','mr','玲子','现金');
insert into tb_ruku_main values('RK20071109003',1,4000.0000,'合格','振撼*琴行','2007-11-09 15:49:32.0','mr','小百','现金');
insert into tb_ruku_main values('RK20071112001',1,10000.0000,'010','吉林省明日*业有限公司','2007-11-12 10:47:31.0','mr','11','现金');
insert into tb_ruku_main values('RK20080403001',1,1376.0000,'ds','新*纪文化百货商城','2008-04-03 00:00:00.0','null','ggf','现金结款');
insert into tb_ruku_main values('RK20080403002',1,9890.0000,'ftf','新*纪文化百货商城','2008-04-03 00:00:00.0','小陈','33','现金结款');
insert into tb_ruku_main values('RK20080410001',1,0.0000,'23','新*纪文化百货商城','2008-04-10 00:00:00.0','范德萨','范德萨','现金结款');
insert into tb_ruku_main values('RK20080410002',1,0.0000,'543','新*纪文化百货商城','2008-04-10 00:00:00.0','范德萨','范德萨','现金结款');
insert into tb_ruku_main values('RK20080410003',1,8.0000,'111','新*纪文化百货商城','2008-04-10 00:00:00.0','范德萨','范德萨','现金结款');
insert into tb_ruku_main values('RK20080410004',1,2795.0000,'432','新*纪文化百货商城','2008-04-10 00:00:00.0','范德萨','范德萨','现金结款');
insert into tb_ruku_main values('RK20080410007',1,6.0000,'2321','新*纪文化百货商城','2008-04-10 00:00:00.0','范德萨','范德萨','现金结款');
insert into tb_ruku_main values('RK20080410008',1,186624.0000,'32','新*纪文化百货商城','2008-04-10 00:00:00.0','范德萨','范德萨','现金结款');
insert into tb_ruku_main values('RK20080521001',1,100.0000,'合格','新*纪文化百货商城','2008-05-21 00:00:00.0','范德萨','范德萨','现金结款');
insert into tb_ruku_main values('RK20100209001',1,100.0000,'10','笔*有限公司','2010-02-09 00:00:00.0','liuxin','liuxin','现金结款');
insert into tb_ruku_main values('RK20080410005',1,0.0000,'g','新*纪文化百货商城','2008-04-10 00:00:00.0','范德萨','范德萨','现金结款');
insert into tb_ruku_main values('RK20080410006',1,736.0000,'111','新*纪文化百货商城','2008-04-10 00:00:00.0','范德萨','范德萨','现金结款');
insert into tb_ruku_main values('RK20080410009',2,0.0000,'22','新*纪文化百货商城','2008-04-10 00:00:00.0','范德萨','范德萨','现金结款');

insert into tb_sell_detail values('XS20050923001','sp1003',3.5000,1.0);
insert into tb_sell_detail values('XS20050923001','sp1001',789.0000,1.0);
insert into tb_sell_detail values('XS20050923002','sp1003',3.5000,2.0);
insert into tb_sell_detail values('XS20050926001','sp1005',10.0000,1.0);
insert into tb_sell_detail values('XS20051004001','sp1005',8.7000,2.0);
insert into tb_sell_detail values('XS20050104001','sp1002',890.0000,1.0);
insert into tb_sell_detail values('XS20050104002','sp1002',890.0000,1.0);
insert into tb_sell_detail values('XS20050120001','sp1002',890.0000,1.0);
insert into tb_sell_detail values('XS20050220001','sp1002',890.0000,1.0);
insert into tb_sell_detail values('XS20051004002','sp1002',890.0000,1.0);
insert into tb_sell_detail values('XS20051004003','sp1005',8.7000,2.0);
insert into tb_sell_detail values('XS20051004004','sp1003',3.4000,4.0);
insert into tb_sell_detail values('XS20050309001','sp1001',1500.0000,1.0);
insert into tb_sell_detail values('XS20050309002','sp1002',890.0000,1.0);
insert into tb_sell_detail values('XS20050309002','sp1001',1500.0000,1.0);
insert into tb_sell_detail values('XS20051005001','sp1001',1500.0000,1.0);
insert into tb_sell_detail values('XS20051005002','sp1002',890.0000,1.0);
insert into tb_sell_detail values('XS20051005002','sp1005',8.7000,1.0);
insert into tb_sell_detail values('XS20051005003','sp1003',3.4000,1.0);
insert into tb_sell_detail values('XS20051005004','sp1004',790.0000,1.0);
insert into tb_sell_detail values('XS20051005004','sp1001',1500.0000,1.0);
insert into tb_sell_detail values('XS20051006001','sp1003',3.4000,1.0);
insert into tb_sell_detail values('XS20071016001','sp1004',321.0000,16.0);
insert into tb_sell_detail values('XS20071017001','sp1004',321.0000,1668.0);
insert into tb_sell_detail values('XS20071109001','sp1007',10.0000,5.0);
insert into tb_sell_detail values('XS20071115001','sp1002',22.0000,22.0);
insert into tb_sell_detail values('XS20080410003','sp1002',432.0000,0.0);
insert into tb_sell_detail values('XS20080521001','sp1007',10.0000,1.0);
insert into tb_sell_detail values('XS20150507001','sp1009',1.0000,200.0);
insert into tb_sell_detail values('XS20150507002','sp1008',10.0000,1.0);
insert into tb_sell_detail values('XS20150507002','sp1007',10.0000,1.0);
insert into tb_sell_detail values('XS20150507002','sp1009',1.0000,3.0);

insert into tb_sell_main values('XS20050104001',1,890.0000,'100.00','新*纪文化百货用品商城','2005-01-04 15:27:48.0','admin','gh','现金');
insert into tb_sell_main values('XS20050104002',1,890.0000,'100.00','新*纪文化百货用品商城','2005-01-04 15:28:10.0','admin','wg','现金');
insert into tb_sell_main values('XS20050120001',1,890.0000,'200.00','新*纪文化百货用品商城','2005-01-20 15:28:51.0','admin','g','现金');
insert into tb_sell_main values('XS20050220001',1,890.0000,'100.00','新*纪文化百货用品商城','2005-02-20 15:29:31.0','admin','gh','现金');
insert into tb_sell_main values('XS20050309001',1,1500.0000,'0.00','新*纪文化百货用品商城','2005-03-09 15:42:32.0','admin','kk','现金');
insert into tb_sell_main values('XS20050309002',2,2390.0000,'2000.00','新*纪文化百货用品商城','2005-03-09 17:20:00.0','admin','言','现金');
insert into tb_sell_main values('XS20050923001',2,792.5000,'792.50','新*纪文化百货用品商城','2005-09-23 13:12:45.0','admin','wgh','现金');
insert into tb_sell_main values('XS20050923002',1,7.0000,'7.00','新*纪文化百货用品商城','2005-09-23 13:13:04.0','admin','wgh','现金');
insert into tb_sell_main values('XS20050926001',1,10.0000,'10.00','新*纪文化百货用品商城','2005-09-26 13:58:30.0','admin','wgh','现金');
insert into tb_sell_main values('XS20051004001',1,17.4000,'17.40','新*纪文化百货用品商城','2005-10-04 13:19:03.0','admin','wgh','现金');
insert into tb_sell_main values('XS20051004002',1,890.0000,'0.00','新*纪文化百货用品商城','2005-10-04 15:30:04.0','admin','wgh','现金');
insert into tb_sell_main values('XS20051004003',1,17.4000,'0.00','新*纪文化百货用品商城','2005-10-04 15:30:23.0','admin','gh','现金');
insert into tb_sell_main values('XS20051004004',1,13.6000,'0.00','新*纪文化百货用品商城','2005-10-04 15:31:38.0','admin','w','现金');
insert into tb_sell_main values('XS20051005001',1,1500.0000,'0.00','新*纪文化百货用品商城','2005-10-05 08:24:02.0','admin','ttt','现金');
insert into tb_sell_main values('XS20051005002',2,898.7000,'0.00','新*纪文化百货用品商城','2005-10-05 08:24:28.0','admin','eee','现金');
insert into tb_sell_main values('XS20051005003',1,3.4000,'3.40','新*纪文化百货用品商城','2005-10-05 08:41:07.0','admin','ww','现金');
insert into tb_sell_main values('XS20051005004',2,2290.0000,'2000.00','新*纪文化百货用品商城','2005-10-05 08:42:29.0','admin','eutwin','现金');
insert into tb_sell_main values('XS20051006001',1,3.4000,'2.40','新*纪文化百货用品商城','2005-10-06 08:54:38.0','yan','yyy','现金');
insert into tb_sell_main values('XS20071016001',1,5136.0000,'fds','明日科技有限公司','2007-10-16 17:00:08.0','测试人员','伙','现金');
insert into tb_sell_main values('XS20071017001',1,535428.0000,'4321','明日科技有限公司','2007-10-17 08:49:34.0','测试人员','4321','现金');
insert into tb_sell_main values('XS20071109001',1,50.0000,'合格','明日科技有限公司','2007-11-09 14:41:40.0','mr','小刘','现金');
insert into tb_sell_main values('XS20071115001',1,484.0000,'ggg','明日科技有限公司','2007-11-15 18:41:15.0','mr','00','现金');
insert into tb_sell_main values('XS20080410001',2,219024.0000,'e2','明日科技有限公司','2008-04-10 10:26:47.0','','范德萨','现金');
insert into tb_sell_main values('XS20080410002',1,0.0000,'e2','明日科技有限公司','2008-04-10 10:27:51.0','','范德萨','现金');
insert into tb_sell_main values('XS20080410003',1,0.0000,'e2','明日科技有限公司','2008-04-10 10:28:54.0','','范德萨','现金');
insert into tb_sell_main values('XS20080521001',1,10.0000,'10','明日科技有限公司','2008-05-21 14:57:55.0','tsoft','范德萨','现金');
insert into tb_sell_main values('XS20150507001',1,200.0000,'测试是否会出库大于库存','明日科技有限公司','2015-05-07 15:44:33.0','tsoft','liuxin','现金');
insert into tb_sell_main values('XS20150507002',3,23.0000,'1111111111111','明日科技有限公司','2015-05-07 16:31:10.0','tsoft','liuxin','现金');

insert into tb_spinfo values('sp1001','电吉他','吉他1','中**连','把','FD－3100','盒','56217','23232','无限延音功能、自带效果器','新*纪文化百货商城');
insert into tb_spinfo values('sp1002','木吉他','吉他','中**海','把','HM2100','盒','32286','875845624','可接电','新*纪文化百货商城');
insert into tb_spinfo values('sp1005','润*滴眼液','RZDYY','山*正大福*达制药有限公司','盒','10ml/支','纸盒','20040728','鲁*消备字','','振撼*琴行');
insert into tb_spinfo values('sp1006','电吉他','电吉他','电吉他','电吉他','电吉他','','','','','');
insert into tb_spinfo values('sp1007','铅笔','QB','长春','铅笔厂','9*','沿着','14**','222**','无','新*纪文化百货商城');
insert into tb_spinfo values('sp1008','手工艺品','SAYP','长春市','长春','1','5','25','212','很不错','吉林省明日*业有限公司');
insert into tb_spinfo values('sp1009','锅巴','锅巴','吉林','袋','200G/袋','袋','001','2131213','无','笔*有限公司');

insert into tb_userlist values('tsoft','111');

insert into tb_xsth_detail values('XT20051005001','sp1004',790.0000,1);
insert into tb_xsth_detail values('XT20051005002','sp1002',890.0000,1);
insert into tb_xsth_detail values('XT20051005003','sp1002',890.0000,1);
insert into tb_xsth_detail values('XT20051216001','sp1004',790.0000,1);
insert into tb_xsth_detail values('XT20071017001','sp1005',432.0000,4830);
insert into tb_xsth_detail values('XT20071017002','sp1005',432.0000,9660);
insert into tb_xsth_detail values('XT20071109001','sp1007',10.0000,1);
insert into tb_xsth_detail values('XT20080410001','sp1001',151.0000,-1000);
insert into tb_xsth_detail values('XT20080521001','sp1007',10.0000,1);

insert into tb_xsth_main values('XT20051005001',1,790.0000,'0.00','新*纪文化百货用品商城','2005-10-05 13:17:31.0','admin','jh','现金');
insert into tb_xsth_main values('XT20051005002',1,890.0000,'90.00','新*纪文化百货用品商城','2005-10-05 13:25:52.0','admin','hj','现金');
insert into tb_xsth_main values('XT20051005003',1,890.0000,'0.00','新*纪文化百货用品商城','2005-10-05 13:32:38.0','admin','wgh','现金');
insert into tb_xsth_main values('XT20051216001',1,790.0000,'90.00','新*纪文化百货用品商城','2005-12-16 17:24:46.0','admin','kk','现金');
insert into tb_xsth_main values('XT20071017001',1,2086560.0000,'432','明日科技有限公司','2007-10-17 08:50:05.0','测试人员','432','现金');
insert into tb_xsth_main values('XT20071017002',1,4173120.0000,'432','明日科技有限公司','2007-10-17 08:50:12.0','测试人员','432','现金');
insert into tb_xsth_main values('XT20071109001',1,10.0000,'不合格','明日科技有限公司','2007-11-09 14:42:12.0','mr','99','现金');
insert into tb_xsth_main values('XT20080410001',1,-151000.0000,'321','明日科技有限公司','2008-04-10 10:34:27.0','tsoft','范德萨','现金');
insert into tb_xsth_main values('XT20080521001',1,10.0000,'10','明日科技有限公司','2008-05-21 14:58:18.0','tsoft','范德萨','现金');

CREATE VIEW v_rukuView
AS
SELECT     tb_ruku_main.rkID, tb_ruku_detail.spid, tb_spinfo.spname, tb_spinfo.gg, tb_ruku_detail.dj, tb_ruku_detail.sl, 
                      tb_ruku_detail.dj * tb_ruku_detail.sl AS je, tb_spinfo.gysname, tb_ruku_main.rkdate, tb_ruku_main.czy, tb_ruku_main.jsr, 
                      tb_ruku_main.jsfs
FROM         tb_ruku_detail INNER JOIN
                      tb_ruku_main ON tb_ruku_detail.rkID = tb_ruku_main.rkID INNER JOIN
                      tb_spinfo ON tb_ruku_detail.spid = tb_spinfo.id;

CREATE VIEW v_sellView
AS
SELECT     tb_sell_main.sellID, tb_spinfo.spname, tb_sell_detail.spid, tb_spinfo.gg, tb_sell_detail.dj, tb_sell_detail.sl, 
                      tb_sell_detail.sl * tb_sell_detail.dj AS je, tb_sell_main.khname, tb_sell_main.xsdate, tb_sell_main.czy, tb_sell_main.jsr, 
                      tb_sell_main.jsfs
FROM         tb_sell_detail INNER JOIN
                      tb_sell_main ON tb_sell_detail.sellID = tb_sell_main.sellID INNER JOIN
                      tb_spinfo ON tb_sell_detail.spid = tb_spinfo.id;










