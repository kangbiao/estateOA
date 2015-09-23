-- MySQL dump 10.13  Distrib 5.5.44, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: PropertySystem
-- ------------------------------------------------------
-- Server version	5.5.44-0ubuntu0.14.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `apartment`
--

DROP TABLE IF EXISTS `apartment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apartment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `unit_code` int(11) DEFAULT NULL COMMENT '楼栋单元号',
  `code` int(11) DEFAULT NULL COMMENT '房号',
  `building_id` int(10) unsigned DEFAULT NULL,
  `property_id` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apartment`
--

LOCK TABLES `apartment` WRITE;
/*!40000 ALTER TABLE `apartment` DISABLE KEYS */;
/*!40000 ALTER TABLE `apartment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_user` (
  `phone` varchar(15) NOT NULL COMMENT '手机号码',
  `passwd` varchar(45) DEFAULT NULL,
  `user_role` tinyint(2) DEFAULT NULL COMMENT '1-注册用户；2-业主绑定用户；3-家属用户；4-租户；5-物业认证用户',
  `user_name` varchar(45) DEFAULT NULL,
  `register_time` bigint(25) DEFAULT NULL COMMENT '时间戳',
  `status` tinyint(2) DEFAULT '1',
  `owner_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES ('13955552236','123456',3,'xiaoming',15525520000,-1,NULL),('18144240528','123456',1,'kangbiao',152210000,1,1);
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authenticated_record`
--

DROP TABLE IF EXISTS `authenticated_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authenticated_record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `applicant` varchar(45) DEFAULT NULL COMMENT '申请人\n',
  `application_time` bigint(25) DEFAULT NULL,
  `application_type` tinyint(2) DEFAULT NULL COMMENT '1.亲属2租户3物业认可人员',
  `auth_id` int(10) unsigned DEFAULT NULL COMMENT '授权人id即业主id（owner_id）或者是物业管理人员具有相应权限的id（console_user_id）',
  `auth_result` tinyint(4) DEFAULT NULL,
  `auth_time` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authenticated_record`
--

LOCK TABLES `authenticated_record` WRITE;
/*!40000 ALTER TABLE `authenticated_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `authenticated_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authenticated_user`
--

DROP TABLE IF EXISTS `authenticated_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authenticated_user` (
  `au_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `identity_id` varchar(45) DEFAULT NULL,
  `owner_relationship` varchar(20) DEFAULT NULL,
  `birthday` bigint(25) DEFAULT NULL,
  `register_time` bigint(25) DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL,
  `bound_time` bigint(25) DEFAULT NULL,
  `is_bound` tinyint(1) DEFAULT NULL,
  `familycol` varchar(45) DEFAULT NULL,
  `owner_id` int(10) unsigned DEFAULT NULL,
  `user_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`au_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authenticated_user`
--

LOCK TABLES `authenticated_user` WRITE;
/*!40000 ALTER TABLE `authenticated_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `authenticated_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `property_id` int(10) unsigned DEFAULT NULL,
  `fee_item_fee` varchar(255) DEFAULT NULL COMMENT '存放由fee_item_id《＝》fee_amount组成的键值对，以逗号间隔。',
  `pay_status` tinyint(2) DEFAULT NULL,
  `pay_type` tinyint(2) DEFAULT NULL,
  `pay_time` bigint(25) DEFAULT NULL,
  `bill_generation_time` bigint(25) DEFAULT NULL,
  `overdue_fee` decimal(11,2) DEFAULT NULL,
  `payer` varchar(45) DEFAULT NULL COMMENT '付款人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `building` (
  `building_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `village_id` int(10) unsigned DEFAULT NULL COMMENT '园区和楼栋构成主键',
  `description` varchar(45) DEFAULT NULL,
  `building_code` varchar(45) DEFAULT NULL,
  `building_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`building_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` VALUES (1,1,'sad','aaaa','dsa');
/*!40000 ALTER TABLE `building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complain`
--

DROP TABLE IF EXISTS `complain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `complain` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `description` varchar(100) DEFAULT NULL,
  `user_id` int(10) unsigned DEFAULT NULL,
  `time` bigint(25) DEFAULT NULL,
  `image_id_list` varchar(50) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `remark` tinyint(4) DEFAULT NULL,
  `result` varchar(200) DEFAULT NULL COMMENT '处理投诉人员填写处理说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complain`
--

LOCK TABLES `complain` WRITE;
/*!40000 ALTER TABLE `complain` DISABLE KEYS */;
INSERT INTO `complain` VALUES (2,'下水道老坏','balabababbabababbababsdfsadasdsa','dsadasd',1,19540055400,'',NULL,0,1,NULL,'');
/*!40000 ALTER TABLE `complain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `console_group`
--

DROP TABLE IF EXISTS `console_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `console_group` (
  `cg_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `authorization` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `console_group`
--

LOCK TABLES `console_group` WRITE;
/*!40000 ALTER TABLE `console_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `console_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `console_user`
--

DROP TABLE IF EXISTS `console_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `console_user` (
  `cu_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `password` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `console_group_id` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `identity_type` tinyint(4) DEFAULT NULL,
  `identity_id` varchar(45) DEFAULT NULL,
  `remark` int(11) DEFAULT NULL COMMENT '物业人员收到的评价',
  PRIMARY KEY (`cu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `console_user`
--

LOCK TABLES `console_user` WRITE;
/*!40000 ALTER TABLE `console_user` DISABLE KEYS */;
INSERT INTO `console_user` VALUES (1,'123456','15182372278',NULL,NULL,'kangbiao',NULL,NULL,NULL);
/*!40000 ALTER TABLE `console_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `family`
--

DROP TABLE IF EXISTS `family`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `family` (
  `family_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(15) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL,
  `birthday` bigint(25) DEFAULT NULL,
  `urgent_name` varchar(45) DEFAULT NULL,
  `urgent_phone` varchar(15) DEFAULT NULL,
  `identity_type` tinyint(2) DEFAULT NULL,
  `identity_code` varchar(45) DEFAULT NULL,
  `owner_relationship` varchar(20) DEFAULT NULL,
  `authentication_time` bigint(25) DEFAULT NULL COMMENT '放到审批记录表',
  `vehicle_id_list` varchar(50) DEFAULT NULL,
  `auth_status` tinyint(2) DEFAULT NULL,
  `owner_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`family_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family`
--

LOCK TABLES `family` WRITE;
/*!40000 ALTER TABLE `family` DISABLE KEYS */;
INSERT INTO `family` VALUES (1,'19585689466','康彪的家人1',0,19426747000,NULL,NULL,1,'654219015941542514','子女',NULL,NULL,NULL,1),(2,'15521121121','康彪的家人2',0,NULL,NULL,NULL,0,'425452424524524524','父亲',NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `family` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fee_item`
--

DROP TABLE IF EXISTS `fee_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fee_item` (
  `fi_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `decription` varchar(200) DEFAULT NULL,
  `fee_type_id` int(10) unsigned DEFAULT NULL,
  `rule_id` int(10) unsigned DEFAULT NULL,
  `is_periodic` tinyint(1) DEFAULT NULL,
  `village_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`fi_id`),
  KEY `FK_mqd7psd6dy1apcdpf38h51m9v` (`rule_id`),
  CONSTRAINT `FK_mqd7psd6dy1apcdpf38h51m9v` FOREIGN KEY (`rule_id`) REFERENCES `rule` (`rule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_item`
--

LOCK TABLES `fee_item` WRITE;
/*!40000 ALTER TABLE `fee_item` DISABLE KEYS */;
INSERT INTO `fee_item` VALUES (2,'fdgfdg',NULL,0,2,1,NULL),(3,'gbbcv',NULL,0,3,1,NULL),(4,'bvcbcv',NULL,0,4,1,NULL),(5,'bvcbcvb',NULL,0,5,1,NULL),(6,'dfdsfd','gfdgdfgssss',1,6,0,NULL),(7,'dfdsfd','gfdgdfgssssm',1,7,0,NULL),(8,'规范的广泛的','546',1,8,0,NULL),(9,'干活你发个','回滚',1,9,0,NULL),(10,'dsadfsad',NULL,0,10,NULL,NULL),(11,'efds;545;545',NULL,0,11,NULL,NULL),(12,'df',NULL,0,12,NULL,NULL),(13,'dds','21',1,13,0,NULL),(14,'rtrt','121',1,14,0,NULL),(15,'fdg','323',1,15,0,NULL),(16,'fdg','323v',1,16,0,NULL);
/*!40000 ALTER TABLE `fee_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fee_item_order`
--

DROP TABLE IF EXISTS `fee_item_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fee_item_order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `property_id` int(10) unsigned DEFAULT NULL,
  `fee_item_id` int(10) unsigned DEFAULT NULL COMMENT '允许重复（一次性的费用）',
  `is_billed` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_item_order`
--

LOCK TABLES `fee_item_order` WRITE;
/*!40000 ALTER TABLE `fee_item_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `fee_item_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fee_type`
--

DROP TABLE IF EXISTS `fee_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fee_type` (
  `ft_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ft_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_type`
--

LOCK TABLES `fee_type` WRITE;
/*!40000 ALTER TABLE `fee_type` DISABLE KEYS */;
INSERT INTO `fee_type` VALUES (1,'车位费',''),(2,'物业服务费',NULL),(3,'物业费',NULL);
/*!40000 ALTER TABLE `fee_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `notice_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` text COMMENT '通知图文信息',
  `time` bigint(25) DEFAULT NULL,
  `picture_id_list` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL COMMENT '1.',
  `type` tinyint(2) DEFAULT NULL,
  `expiretime` int(11) DEFAULT NULL COMMENT '填写有效时间，以天为单位',
  `cu_id` int(10) unsigned DEFAULT NULL COMMENT '发布者的id',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (24,'ceshi','<p>\n	<img src=\"/oa/file/kindeditor/image/20150922/20150922223447_960.png\" alt=\"\" />\n</p>\n<p>\n	fdsfdsfsdfdsfdsfdsf<strong>fdsfdsfdsf</strong>\n</p>\n<p>\n	<strong>sdsadsadasdasd</strong>\n</p>',1442932501295,NULL,'fdsfsdfsdfdsfsd',NULL,NULL,2),(25,'测试','打分是对方但是<img src=\"/oa/file/kindeditor/image/20150922/20150922223733_353.png\" alt=\"\" />',1442932655520,NULL,'地方山东省',NULL,NULL,2);
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `open_door_record`
--

DROP TABLE IF EXISTS `open_door_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `open_door_record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned DEFAULT NULL,
  `open_time` bigint(25) DEFAULT NULL,
  `open_code` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `open_door_record`
--

LOCK TABLES `open_door_record` WRITE;
/*!40000 ALTER TABLE `open_door_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `open_door_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `owner` (
  `owner_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(15) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL,
  `birthday` bigint(25) DEFAULT NULL,
  `urgent_name` varchar(45) DEFAULT NULL,
  `urgent_phone` varchar(20) DEFAULT NULL,
  `identity_type` tinyint(2) DEFAULT NULL COMMENT '证件类型',
  `identity_code` varchar(45) DEFAULT NULL COMMENT '证件代码',
  `vehicle_id_ist` varchar(50) DEFAULT NULL COMMENT '1-n个车牌用分隔符＃作为分隔符',
  `property_id_list` varchar(50) DEFAULT NULL COMMENT '1-n个物业，用，号作为分隔符',
  `authentication_time` bigint(25) DEFAULT NULL COMMENT '放到审批记录表',
  PRIMARY KEY (`owner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (1,'18144240528','康彪',0,150515510000,'小明','131627828989',1,'510704199405281715','5426d;dsds5','1;2',1541214000),(2,'13981111434','何可送',1,15534454000,'小红','120819186555',0,'510819120196123185',NULL,'1',165874000);
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parking_lot`
--

DROP TABLE IF EXISTS `parking_lot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parking_lot` (
  `property_id` int(10) unsigned DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL COMMENT '车位编号',
  `floor` varchar(45) DEFAULT NULL COMMENT '楼层书',
  `type` tinyint(2) DEFAULT NULL COMMENT '1:标准车位，2：大车位，3：子母车位，4，小车位，5，地上临时位',
  `description` varchar(100) DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parking_lot`
--

LOCK TABLES `parking_lot` WRITE;
/*!40000 ALTER TABLE `parking_lot` DISABLE KEYS */;
/*!40000 ALTER TABLE `parking_lot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture` (
  `picture_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `dir` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`picture_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
INSERT INTO `picture` VALUES (1,NULL,NULL,'14421511594042015-08-28 19:22:01屏幕截图.png'),(2,NULL,NULL,'14421512159072015-08-28 19:22:01屏幕截图.png'),(3,NULL,NULL,'14421512199932015-08-28 19:22:01屏幕截图.png'),(4,NULL,NULL,'14421513269892015-08-28 19:22:01屏幕截图.png'),(5,NULL,NULL,'14421517764232015-08-28 19:22:01屏幕截图.png');
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `property` (
  `property_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL COMMENT '房产证编码',
  `owner_name_list` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL COMMENT '房产证上位置信息',
  `type` tinyint(2) DEFAULT NULL COMMENT '1:普通住房；2:商铺；3:车位',
  `property_square` decimal(11,2) DEFAULT NULL,
  `owner_type` tinyint(2) DEFAULT NULL COMMENT '1：个人所有；2:物业所有',
  `village_id` int(10) unsigned DEFAULT NULL COMMENT '园区',
  `status` tinyint(4) DEFAULT NULL COMMENT '1.自住 ／出租\n2.已入住／未入住\n3.已收房／未收房',
  PRIMARY KEY (`property_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (1,'B638',NULL,'半山蓝湾-2栋-17号',1,188.00,NULL,1,0),(2,'D546',NULL,'半山蓝湾-2栋-27号',NULL,199.21,NULL,NULL,1),(3,'b222',NULL,'location1',1,182.02,1,1,NULL),(4,'b222',NULL,'location1',1,182.02,1,1,NULL),(5,'b222',NULL,'location1',1,182.02,1,1,NULL),(6,'b222',NULL,'location1',1,182.02,1,1,NULL);
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property_owner_info`
--

DROP TABLE IF EXISTS `property_owner_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `property_owner_info` (
  `po_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `property_id` int(10) unsigned DEFAULT NULL,
  `building_id` int(10) unsigned DEFAULT NULL,
  `owner_phone` varchar(15) DEFAULT NULL,
  `open_door_allowed` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`po_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property_owner_info`
--

LOCK TABLES `property_owner_info` WRITE;
/*!40000 ALTER TABLE `property_owner_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `property_owner_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repair`
--

DROP TABLE IF EXISTS `repair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `repair` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `description` varchar(100) DEFAULT NULL,
  `user_id` int(10) unsigned DEFAULT NULL,
  `time` bigint(25) DEFAULT NULL,
  `image_id_list` varchar(50) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL COMMENT '1.未提交2.已提交未处理3.处理中4处理完',
  `remark` int(11) DEFAULT NULL,
  `remark_text` varchar(100) DEFAULT NULL,
  `admin_id` int(10) unsigned DEFAULT NULL,
  `result` varchar(200) DEFAULT NULL COMMENT '维修人员填写的处理说明',
  `repirman_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repair`
--

LOCK TABLES `repair` WRITE;
/*!40000 ALTER TABLE `repair` DISABLE KEYS */;
INSERT INTO `repair` VALUES (1,'dfsf','fdsfs',NULL,1,154221515000,'1',1,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `repair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rule`
--

DROP TABLE IF EXISTS `rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rule` (
  `rule_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `unit_price` decimal(11,2) DEFAULT NULL COMMENT '单位价格',
  `unit` varchar(10) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `overdue_unit_price` decimal(11,2) DEFAULT NULL,
  `overdue_unit` varchar(10) DEFAULT NULL,
  `start_time` bigint(25) DEFAULT NULL,
  `end_time` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`rule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule`
--

LOCK TABLES `rule` WRITE;
/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
INSERT INTO `rule` VALUES (2,322.00,'family',NULL,5.00,'day',1441555200000,1443542400000),(3,55.00,'family',NULL,55.00,'day',NULL,NULL),(4,55.00,'family',NULL,454.00,'day',NULL,NULL),(5,1.00,'family',NULL,2.00,'day',NULL,NULL),(6,32.00,'squre',NULL,NULL,NULL,1441814400000,1442419200000),(7,32.00,'per',NULL,NULL,NULL,1441814400000,1442419200000),(8,56.00,'per',NULL,NULL,NULL,1441814400000,1441641600000),(9,43.00,'squre',NULL,NULL,NULL,1441641600000,1444233600000),(10,32.00,'squre',NULL,3.00,'month',1422720000000,1454601600000),(11,32.00,'squre',NULL,4.00,'day',1441036800000,1441382400000),(12,3.00,'squre',NULL,3.00,'day',NULL,NULL),(13,2.00,'per',NULL,NULL,NULL,NULL,NULL),(14,21.00,'per',NULL,NULL,NULL,NULL,NULL),(15,3.00,'per',NULL,NULL,NULL,1441641600000,1442160000000),(16,3.00,'per',NULL,NULL,NULL,1441641600000,1442160000000);
/*!40000 ALTER TABLE `rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop` (
  `property_id` int(10) unsigned DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL COMMENT '街道门牌号',
  `village_id` int(11) DEFAULT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES (1,'2121hg',1,1),(NULL,'b222',1,2),(NULL,'b222',1,3),(NULL,'b222',1,4),(6,'b222',1,5);
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ssid_secret`
--

DROP TABLE IF EXISTS `ssid_secret`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ssid_secret` (
  `sc_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `building_id` int(10) unsigned DEFAULT NULL,
  `ssid` varchar(45) DEFAULT NULL,
  `secret` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sc_id`),
  KEY `FK_9xomlrhqs9xd7b1aycq618olq` (`building_id`),
  CONSTRAINT `FK_9xomlrhqs9xd7b1aycq618olq` FOREIGN KEY (`building_id`) REFERENCES `building` (`building_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ssid_secret`
--

LOCK TABLES `ssid_secret` WRITE;
/*!40000 ALTER TABLE `ssid_secret` DISABLE KEYS */;
INSERT INTO `ssid_secret` VALUES (1,1,'ssid1','dsfdsfdsfsd'),(2,1,'ssid1','ddssfdsfsd'),(3,1,'ssid1','ddssfdsfsd'),(4,1,'ssid12','ddssfdsfsd'),(5,1,'gfd','gfdd');
/*!40000 ALTER TABLE `ssid_secret` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant`
--

DROP TABLE IF EXISTS `tenant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tenant` (
  `tenant_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(15) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL,
  `birthday` bigint(25) DEFAULT NULL,
  `urgent_name` varchar(45) DEFAULT NULL,
  `urgent_phone` varchar(15) DEFAULT NULL,
  `identity_type` tinyint(2) DEFAULT NULL,
  `identity_code` varchar(45) DEFAULT NULL,
  `start_time` bigint(25) DEFAULT NULL,
  `end_time` bigint(25) DEFAULT NULL,
  `authentication_time` bigint(25) DEFAULT NULL,
  `auth_status` tinyint(2) DEFAULT NULL,
  `property_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant`
--

LOCK TABLES `tenant` WRITE;
/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
INSERT INTO `tenant` VALUES (1,'1998985629','租客',1,19284955000,'小明','19845947574',1,'8510890521425421',18153512100,12124541120,122451210,1,1);
/*!40000 ALTER TABLE `tenant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `village`
--

DROP TABLE IF EXISTS `village`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `village` (
  `village_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`village_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `village`
--

LOCK TABLES `village` WRITE;
/*!40000 ALTER TABLE `village` DISABLE KEYS */;
/*!40000 ALTER TABLE `village` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-23 22:16:44
