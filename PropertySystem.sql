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
INSERT INTO `app_user` VALUES ('10969123451','123',1,'1234',NULL,-1,NULL),('11112222333','111',0,'111',NULL,1,NULL),('11122233344','111',0,'444',NULL,1,NULL),('11223344556','1',0,'1234',NULL,1,NULL),('11445588123','12345',0,'12345',NULL,1,NULL),('12222222222','1',0,'11',NULL,1,NULL),('12341234123','111',0,'1234',NULL,1,NULL),('12344444444','1',0,'123',NULL,1,NULL),('12344555566','123',0,'123',NULL,1,NULL),('12345412345','111111',0,'111111',NULL,1,NULL),('12345612345','123',0,'123',NULL,1,NULL),('12345678890','12',0,'1234',NULL,1,NULL),('12345678909','123',0,'123',NULL,1,NULL),('12345678910','123',0,'12345',NULL,1,NULL),('12345678991','111',0,'111',NULL,1,NULL),('12378945612','123444',1,'123456',NULL,1,NULL),('13000000000','1234',0,'1234',NULL,1,NULL),('13011111111','123',0,'123',NULL,1,NULL),('13222222222','111',0,'123',NULL,1,NULL),('13333333333','1111',0,'1111',NULL,1,NULL),('13444444444','11111',0,'11111',NULL,1,NULL),('13444445555','1',0,'12345',NULL,1,NULL),('13666666666','11',0,'1234',NULL,1,NULL),('13688888888','12',0,'1234',NULL,1,NULL),('13955552236','123456',3,'xiaoming',15525520000,1,NULL),('14714714712','1111',1,'111',NULL,1,NULL),('14725836910','1',2,'æ',NULL,1,NULL),('14785296312','111',0,'1423',NULL,1,NULL),('147852963123','111111',0,'12345',NULL,1,NULL),('15114052120','1234',0,'1234',NULL,1,NULL),('15114052121','123456',0,'kangbiao',NULL,0,NULL),('18144240528','123456',2,'kangbiao',152210000,1,1),('18224455555','111111',0,'111111',NULL,1,NULL),('18224478963','1111',0,'111111',NULL,1,NULL),('18224488888','11111',0,'11111',NULL,1,NULL),('18224489333','1111',0,'1111',NULL,1,NULL),('18224489342','1111',1,'8888',NULL,1,NULL),('18224489343','1111',2,'hehehe',NULL,1,NULL),('18224489345','1111',0,'hekesong',NULL,1,NULL),('18224489346','1111',0,'gggggg',NULL,1,NULL),('18224489347','1111',0,'aaaaa',NULL,1,NULL),('18224489354','1111',0,'heee',NULL,1,NULL),('18224489369','1111',0,'ffff',NULL,1,NULL),('18544488881','1',0,'1234',NULL,1,NULL),('19216813211','22',0,'2222',NULL,1,NULL),('22244466687','111',1,'123456',NULL,1,NULL),('45678512345','123444',0,'123444',NULL,1,NULL),('4684654665','123',0,'64465',NULL,1,NULL),('55555555555','1111',0,'11211',NULL,1,NULL),('55557777777','111111',0,'222222',NULL,1,NULL),('686549865','123',0,'5456465',NULL,1,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,1,'水电费:100;停车费:100;煤气费:200',0,NULL,NULL,NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` VALUES (1,5,'sad','G1B1','园区1的楼栋1'),(2,4,'ds','G2B1','园区2的楼栋1'),(3,4,'fds','fdsf','dsf'),(4,6,'有1单元和2单元','z001','1栋');
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
  `property_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`family_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family`
--

LOCK TABLES `family` WRITE;
/*!40000 ALTER TABLE `family` DISABLE KEYS */;
INSERT INTO `family` VALUES (1,'12378945612','123456',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,8),(2,'12378945612','123456',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,8),(3,'10969123451','1234',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,8);
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_item`
--

LOCK TABLES `fee_item` WRITE;
/*!40000 ALTER TABLE `fee_item` DISABLE KEYS */;
INSERT INTO `fee_item` VALUES (1,'gbbcv','543653',0,3,1,4),(2,'fdgfdg','653653',0,2,1,4),(4,'bvcbcv',NULL,0,4,1,5),(5,'bvcbcvb',NULL,0,5,1,5),(6,'dfdsfd','gfdgdfgssss',1,6,0,5),(7,'dfdsfd','gfdgdfgssssm',1,7,0,5),(8,'规范的广泛的','546',1,8,0,6),(9,'干活你发个','回滚',1,9,0,6),(10,'dsadfsad',NULL,0,10,NULL,4),(11,'efds;545;545',NULL,0,11,NULL,6),(12,'df',NULL,0,12,NULL,5),(13,'dds','21',1,13,0,5),(14,'rtrt','121',1,14,0,6),(15,'fdg','323',1,15,0,6),(16,'fdg','323v',1,16,0,4),(17,'feiyong;1441123200000;1442332800000',NULL,0,17,NULL,6),(18,'wdsa','dsdfd',1,18,0,5);
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
  PRIMARY KEY (`id`),
  KEY `FK_2eom30ry9yaakqhlrplfvs9u9` (`fee_item_id`),
  CONSTRAINT `FK_2eom30ry9yaakqhlrplfvs9u9` FOREIGN KEY (`fee_item_id`) REFERENCES `fee_item` (`fi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_item_order`
--

LOCK TABLES `fee_item_order` WRITE;
/*!40000 ALTER TABLE `fee_item_order` DISABLE KEYS */;
INSERT INTO `fee_item_order` VALUES (1,1,1,NULL),(2,1,2,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (24,'ceshi','<p>\n	<img src=\"/oa/file/kindeditor/image/20150922/20150922223447_960.png\" alt=\"\" />\n</p>\n<p>\n	fdsfdsfsdfdsfdsfdsf<strong>fdsfdsfdsf</strong>\n</p>\n<p>\n	<strong>sdsadsadasdasd</strong>\n</p>',1442932501295,NULL,'fdsfsdfsdfdsfsd',NULL,NULL,2),(25,'测试','打分是对方但是<img src=\"/oa/file/kindeditor/image/20150922/20150922223733_353.png\" alt=\"\" />',1442932655520,NULL,'地方山东省',NULL,NULL,2),(26,'hgfhfgh','<p style=\"text-align:center;\">\r\n	<img id=\"currentImg\" src=\"http://img01.imgcdc.com/news/zh_cn/focus/xjpfm/11174229/20150925/20468725_2015092522024347968300.jpg\" alt=\"习近平白宫致辞谈中美关系：随时而动 顺势而为(全文)\" title=\"习近平白宫致辞谈中美关系：随时而动 顺势而为(全文)\" border=\"0\" height=\"309\" width=\"550\" />\r\n</p>\r\n<p>\r\n	&nbsp;&nbsp;&nbsp;&nbsp;习近平参加奥巴马欢迎仪式，在白宫欢迎仪式上致辞。\r\n</p>\r\n<p>\r\n	&nbsp;&nbsp;&nbsp;&nbsp;首先我要感谢奥巴马对我的盛情邀请和盛情接待，我代表13亿中国人转达最真挚感谢和问候，中国和美国都是伟大的国家，中国人民和美国人民都是伟大的人民，36年前建交以来，乘风破浪取得历史性进展.\r\n</p>\r\n<p>\r\n	&nbsp;&nbsp;&nbsp;&nbsp;2013年夏天，我和他在庄园构建了决策。2年来，中美两国人民取得重大进展。中美两国携手合作，可以产生1+1大于2的力量，要随时而动，顺势而为。\r\n</p>\r\n<p>\r\n	&nbsp;&nbsp;&nbsp;&nbsp;我们要坚持增进战略互信，以宽广的胸怀坚信2国友好和信心。我们要坚持互利共赢，拓宽合作领域，给两国人民带来福祉。我们要坚持增进人民友谊，鼓励两国各界相向而行。我们要坚持促进世界和平和发展，促进地区协调。\r\n</p>\r\n<p>\r\n	&nbsp;&nbsp;&nbsp;&nbsp;30年前，我第一次访问美国的时候，住在美国艾奥瓦州小城马斯卡廷的老百姓家里，他们热情美好，临走时，我们紧紧拥抱，30年后，我又回去\r\n了，他们说，友谊是一件大事，这让我对中美关系的未来抱有信心。尊敬的奥巴马总统和夫人，事在人为，中美关系在新的起点，合作共赢是新的道路。让我们一起\r\n携手。<span class=\"artiLogo\"><a href=\"http://news.china.com/\" target=\"_blank\"><img src=\"http://img02.imgcdc.com/smallpic/articleLogo.png\" alt=\"新闻频道\" height=\"16\" width=\"16\" /></a></span>\r\n</p>',1443190521468,NULL,'hgfhgfhdd',NULL,NULL,2),(27,'test','this is test<br />',1443415043878,NULL,'testtest',NULL,NULL,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (1,'18144240528','康彪',0,150515510000,'小明','131627828989',1,'510704199405281715','5426d;dsds5','1;2',1541214000),(2,'13981111434','何可送',1,15534454000,'小红','120819186555',0,'510819120196123185',NULL,'1',165874000),(3,'15182372278','owner001',1,NULL,NULL,NULL,1,'1255',NULL,NULL,-360057600000);
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
  `building_id` int(10) unsigned NOT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '1.自住 ／出租\n2.已入住／未入住\n3.已收房／未收房',
  PRIMARY KEY (`property_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (1,'B638',NULL,'半山蓝湾-2栋-17号',1,188.00,NULL,1,1,-1),(2,'D546',NULL,'半山蓝湾-2栋-27号',2,199.21,NULL,2,1,1),(3,'b222',NULL,'location1',1,182.02,2,1,1,1),(4,'b222',NULL,'location1',1,182.02,1,1,2,1),(5,'b222',NULL,'location1',1,182.02,1,1,2,-1),(6,'b222',NULL,'location1',1,182.02,1,1,2,-1),(7,'B123432',NULL,'的撒旦',1,21321.00,NULL,1,2,-1),(8,'yc001',NULL,'抚琴西路199号1栋1单元10号',2,109.00,NULL,1,2,-1),(9,'yc002',NULL,'抚琴西路199号1栋1单元9号',2,108.00,NULL,2,2,-1),(10,'yc003',NULL,'抚琴西路199号1栋1单元8号',1,107.00,NULL,1,3,-1),(11,'yc004',NULL,'抚琴西路199号1栋1单元6好',1,105.00,NULL,2,3,-1),(24,'test001',NULL,'testadress',1,999.00,NULL,6,4,-1);
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
  PRIMARY KEY (`po_id`),
  KEY `FK_7oq20rni7t96houjm1d7flnox` (`property_id`),
  CONSTRAINT `FK_7oq20rni7t96houjm1d7flnox` FOREIGN KEY (`property_id`) REFERENCES `property` (`property_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property_owner_info`
--

LOCK TABLES `property_owner_info` WRITE;
/*!40000 ALTER TABLE `property_owner_info` DISABLE KEYS */;
INSERT INTO `property_owner_info` VALUES (1,1,1,'18144240528',1),(2,7,1,'18144240528',0),(3,8,1,'18144240528',0),(4,9,1,'13981111434',0),(5,10,2,'18144240528',0),(6,11,1,'13981111434',0),(15,24,NULL,'18144240528',NULL),(16,24,NULL,'15182372278',NULL);
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
  `repirman_phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repair`
--

LOCK TABLES `repair` WRITE;
/*!40000 ALTER TABLE `repair` DISABLE KEYS */;
INSERT INTO `repair` VALUES (2,'下水道坏了','dsdadsad','dasdasda',1,121210000,NULL,1,NULL,'',NULL,'','15114052120');
/*!40000 ALTER TABLE `repair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repair_man`
--

DROP TABLE IF EXISTS `repair_man`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `repair_man` (
  `rp_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(15) NOT NULL COMMENT '手机号码',
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repair_man`
--

LOCK TABLES `repair_man` WRITE;
/*!40000 ALTER TABLE `repair_man` DISABLE KEYS */;
/*!40000 ALTER TABLE `repair_man` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule`
--

LOCK TABLES `rule` WRITE;
/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
INSERT INTO `rule` VALUES (2,322.00,'family',NULL,5.00,'day',1441555200000,1443542400000),(3,55.00,'family',NULL,55.00,'day',NULL,NULL),(4,55.00,'family',NULL,454.00,'day',NULL,NULL),(5,1.00,'family',NULL,2.00,'day',NULL,NULL),(6,32.00,'squre',NULL,NULL,NULL,1441814400000,1442419200000),(7,32.00,'per',NULL,NULL,NULL,1441814400000,1442419200000),(8,56.00,'per',NULL,NULL,NULL,1441814400000,1441641600000),(9,43.00,'squre',NULL,NULL,NULL,1441641600000,1444233600000),(10,32.00,'squre',NULL,3.00,'month',1422720000000,1454601600000),(11,32.00,'squre',NULL,4.00,'day',1441036800000,1441382400000),(12,3.00,'squre',NULL,3.00,'day',NULL,NULL),(13,2.00,'per',NULL,NULL,NULL,NULL,NULL),(14,21.00,'per',NULL,NULL,NULL,NULL,NULL),(15,3.00,'per',NULL,NULL,NULL,1441641600000,1442160000000),(16,3.00,'per',NULL,NULL,NULL,1441641600000,1442160000000),(17,2323.00,'squre',NULL,12.00,'day',1441036800000,1442937600000),(18,21.00,'squre',NULL,NULL,NULL,1441036800000,1442246400000);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ssid_secret`
--

LOCK TABLES `ssid_secret` WRITE;
/*!40000 ALTER TABLE `ssid_secret` DISABLE KEYS */;
INSERT INTO `ssid_secret` VALUES (1,1,'ssid1','dsfdsfdsfsd'),(2,1,'ssid1','ddssfdsfsd'),(3,1,'ssid1','ddssfdsfsd'),(4,1,'ssid12','ddssfdsfsd'),(5,1,'gfd','gfdd'),(6,4,'2334','范德萨范德萨是'),(7,4,'ssid0001','10000001'),(8,4,'ssid002','00000000');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant`
--

LOCK TABLES `tenant` WRITE;
/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
INSERT INTO `tenant` VALUES (1,'1998985629','租客',1,19284955000,'小明','19845947574',1,'8510890521425421',18153512100,12124541120,122451210,1,1),(2,'18144240528','kangbiao',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,1),(3,'18224489343','hehehe',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,8),(4,'14725836910','æ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,9);
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
  `code` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`village_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `village`
--

LOCK TABLES `village` WRITE;
/*!40000 ALTER TABLE `village` DISABLE KEYS */;
INSERT INTO `village` VALUES (4,'dfds','vb222',''),(5,'fdsdsf','dfdsds','fdsds'),(6,'蓝光米兰香洲','gp001','服务物业公司：蓝光物业');
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

-- Dump completed on 2015-10-07 22:31:49
