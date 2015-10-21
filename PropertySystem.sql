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
  `salt` varchar(15) DEFAULT NULL,
  `nickname` varchar(45) DEFAULT NULL,
  `register_time` bigint(25) DEFAULT NULL COMMENT '时间戳',
  `status` tinyint(2) DEFAULT '0' COMMENT '-1为删除,1为正常,0为禁用',
  `last_login` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES ('18144240528','123456',NULL,'kangbiao',144444505050,1,NULL);
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
  `pay_status` tinyint(2) DEFAULT '0',
  `pay_type` tinyint(2) DEFAULT NULL,
  `pay_time` bigint(25) DEFAULT NULL,
  `bill_generation_time` bigint(25) DEFAULT NULL,
  `overdue_fee` decimal(11,2) DEFAULT '0.00',
  `payer` varchar(45) DEFAULT NULL COMMENT '付款人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (185,1,'绿化费:55.00;清洁费:1.00',0,NULL,NULL,1445342542163,NULL,NULL),(186,2,'绿化费:55.00;清洁费:1.00',0,NULL,NULL,1445342542437,NULL,NULL),(187,7,'楼道维修费:322.00;管理费:6752.00;维护费:55.00',0,NULL,NULL,1445342542509,NULL,NULL),(188,8,'楼道维修费:322.00;管理费:3488.00;维护费:55.00',0,NULL,NULL,1445342542559,NULL,NULL),(189,9,'楼道维修费:322.00;管理费:3456.00;维护费:55.00',0,NULL,NULL,1445342542614,NULL,NULL),(190,10,'楼道维修费:322.00;管理费:3424.00;维护费:55.00',0,NULL,NULL,1445342542703,NULL,NULL),(191,11,'楼道维修费:322.00;管理费:3360.00;管理费:3360.00;维护费:55.00',0,NULL,NULL,1445342542764,NULL,NULL),(192,24,'快递寄存费:2320677.00;费用一:65934.00',0,NULL,NULL,1444900130987,NULL,NULL),(193,28,'费用一:57552.00',0,NULL,NULL,1444900131055,NULL,NULL);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brake`
--

DROP TABLE IF EXISTS `brake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brake` (
  `brake_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `village_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`brake_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brake`
--

LOCK TABLES `brake` WRITE;
/*!40000 ALTER TABLE `brake` DISABLE KEYS */;
INSERT INTO `brake` VALUES (1,'DZ001','道闸一','',5);
/*!40000 ALTER TABLE `brake` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` VALUES (1,5,'','G1B1','园区1的楼栋1'),(2,4,'','G2B1','园区2的楼栋1'),(3,4,'','LD002','测试楼栋'),(5,7,'独栋','LD001','楼栋一');
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
  `phone` varchar(15) DEFAULT NULL,
  `time` bigint(25) DEFAULT NULL,
  `image_id_list` varchar(20) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `cu_id` int(10) unsigned DEFAULT NULL,
  `remark` tinyint(4) DEFAULT NULL,
  `result` varchar(200) DEFAULT NULL COMMENT '处理投诉人员填写处理说明',
  PRIMARY KEY (`id`),
  KEY `FK_axsavu84vcq195a7mqw9x2xj4` (`cu_id`),
  CONSTRAINT `FK_axsavu84vcq195a7mqw9x2xj4` FOREIGN KEY (`cu_id`) REFERENCES `console_user` (`cu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complain`
--

LOCK TABLES `complain` WRITE;
/*!40000 ALTER TABLE `complain` DISABLE KEYS */;
INSERT INTO `complain` VALUES (5,'楼下太吵','dfssad','打算倒萨','18144240528',23663323056,NULL,1,0,1,NULL,NULL),(9,'eeeeee','eeeee','eeeee','18980485651',1444561809750,NULL,0,0,NULL,NULL,NULL),(10,'车辆乱停','楼下车辆乱停乱放，每次回家车都要堵很久','楼下车辆乱停乱放，每次回家车都要堵很久','15114052120',1444829922188,'',NULL,0,NULL,NULL,NULL),(11,'垃圾乱放','楼下垃圾没有人管理，很臭','楼下垃圾没有人管理，很臭','15114052120',1444978958534,NULL,NULL,0,NULL,NULL,NULL),(12,'test','testcontent','testcontent','18224425362',1445328800249,'6',NULL,0,NULL,NULL,NULL),(13,'test','testcontent','testcontent','18224425362',1445328829931,'7,8',NULL,0,NULL,NULL,NULL),(14,'test','testcontent','testcontent','18224425362',1445337145666,'9,10',NULL,0,NULL,NULL,NULL),(15,'test','testcontent','testcontent','18224425362',1445337566310,'',NULL,0,NULL,NULL,NULL),(16,'test','testcontent','testcontent','18224425362',1445337567104,'',NULL,0,NULL,NULL,NULL),(17,'test','testcontent','testcontent','18224425362',1445337571365,'',NULL,0,NULL,NULL,NULL);
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
INSERT INTO `console_user` VALUES (1,'123456','kangbiao',NULL,NULL,'kangbiao',NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family`
--

LOCK TABLES `family` WRITE;
/*!40000 ALTER TABLE `family` DISABLE KEYS */;
INSERT INTO `family` VALUES (2,'18224425362','康彪的家属',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,1),(4,'13688195630','xcz',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_item`
--

LOCK TABLES `fee_item` WRITE;
/*!40000 ALTER TABLE `fee_item` DISABLE KEYS */;
INSERT INTO `fee_item` VALUES (1,'维护费','',0,3,1,4),(2,'楼道维修费','653653',0,2,1,4),(4,'绿化费',NULL,0,4,1,5),(5,'清洁费',NULL,0,5,1,5),(10,'管理费',NULL,0,10,NULL,4),(17,'快递寄存费;1441123200000;14211111111000',NULL,0,17,NULL,6),(19,'服务费','提供物业服务',1,19,0,NULL),(20,'物管费;1444492800000;1444752000000',NULL,0,20,NULL,7),(21,'费用一;1445270400000;1446134400000',NULL,0,21,NULL,6),(22,'1','{\"payStartTime\":1443628800000,\"payEndTime\":1446048000000,\"monthPrice\":\"5545.5\",\"perTimePrice\":\"5.5\"}',2,22,NULL,4),(24,'2','{\"payStartTime\":1443628800000,\"payEndTime\":1443888000000,\"monthPrice\":\"545\",\"perTimePrice\":\"5.5\"}',2,24,NULL,6),(25,'2','{\"payStartTime\":1443628800000,\"payEndTime\":1444060800000,\"monthPrice\":\"66\",\"perTimePrice\":\"2\"}',2,25,NULL,5);
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
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_item_order`
--

LOCK TABLES `fee_item_order` WRITE;
/*!40000 ALTER TABLE `fee_item_order` DISABLE KEYS */;
INSERT INTO `fee_item_order` VALUES (168,4,2,0),(169,5,2,0),(170,6,2,0),(171,7,2,0),(172,8,2,0),(173,9,2,0),(174,10,2,0),(175,11,2,0),(176,1,4,0),(177,2,4,0),(178,3,4,0),(179,1,5,0),(180,2,5,0),(181,3,5,0),(189,11,10,0),(190,4,10,0),(191,5,10,0),(192,6,10,0),(193,7,10,0),(194,8,10,0),(195,9,10,0),(196,10,10,0),(197,11,10,0),(198,24,17,0),(223,24,21,0),(224,28,21,0),(225,7,1,0),(226,8,1,0),(227,9,1,0),(228,10,1,0),(229,11,1,0);
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
  `expiretime` bigint(25) DEFAULT NULL,
  `cu_id` int(10) unsigned DEFAULT NULL COMMENT '发布者的id',
  PRIMARY KEY (`notice_id`),
  KEY `FK_1nyd0erg10vfu0etf8fc8h0va` (`cu_id`),
  CONSTRAINT `FK_1nyd0erg10vfu0etf8fc8h0va` FOREIGN KEY (`cu_id`) REFERENCES `console_user` (`cu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (4,'测试公告','<h1>内容</h1>',1444899774481,NULL,'描述',NULL,1445356800000,1),(6,'周本顺杨栋梁严重违纪被双开','<span class=\"img_descr\"></span> \n<div class=\"img_wrapper\" align=\"center\">\n	<img alt=\"周本顺。资料图\" src=\"http://n.sinaimg.cn/transform/20151016/9T3d-fxivsch3638703.jpg\" /> <span class=\"img_descr\">周本顺。资料图</span> \n</div>\n<p>\n	<strong>河北省委原书记、省人大常委会原主任周本顺严重违纪被开除党籍和公职</strong>\n</p>\n<p>\n	日前，经中共中央批准，中共中央纪委对第十八届中央委员，河北省委原书记、省人大常委会原主任<a href=\"http://news.sina.com.cn/2015-09-01/doc-ifxhkafe6245218.shtml\" target=\"_blank\">周本顺严重违纪问题</a>进行了立案审查。\n</p>\n<p>\n	经查，<span>周本顺</span>严重违反政治纪律和政治规矩，在重大问题上发表违背中央精神的言论，不认真落实党风廉政建设主体责任，\n干扰、妨碍组织审查；严重违反组织纪律，为提拔职务进行非组织活动，违规选拔任用干部，隐瞒不报个人有关事项；严重违反中央八项规定精神，超标准公务接\n待、公款吃喝，频繁出入私人会所，生活奢侈、挥霍浪费，违反中央精简会议文件、改进宣传报道的有关规定；严重违反廉洁纪律，利用职务上的便利在企业经营等\n方面为他人谋取利益并收受财物，收受礼金、礼品，为其子经营活动谋取利益，家风败坏、对配偶子女放任纵容；严重违反工作纪律，私存涉密资料，泄露党和国家\n秘密。其中，利用职务上的便利为他人谋取利益，收受财物问题涉嫌犯罪。\n</p>\n<p>\n	周本顺身为中央委员，理想信念丧失，严重违反党的纪律，且党的十八大后仍不收敛、不收手，性质恶劣、情节特别严重。依据《中国共产党纪律处分条\n例》等有关规定，经中央纪委常委会议研究并报中共中央政治局会议审议，决定给予周本顺开除党籍、开除公职处分；收缴其违纪所得；将其涉嫌犯罪问题、线索及\n所涉款物移送司法机关依法处理。给予其开除党籍的处分，待召开中央委员会全体会议时予以追认。\n</p>\n<p>\n	<strong>国家安全生产监督管理总局原党组书记、局长杨栋梁严重违纪被开除党籍和公职</strong>\n</p>\n<p>\n	日前，经中共中央批准，中共中央纪委对第十八届中央委员，国家安全生产监督管理总局原党组书记、局长<a href=\"http://news.sina.com.cn/c/nd/2015-08-26/doc-ifxhcvry1080625.shtml\" target=\"_blank\">杨栋梁严重违纪问题</a>进行了立案审查。\n</p>',1444977998184,NULL,'河北省委原书记、省人大常委会原主任周本顺严重违纪被开除党籍和公职',NULL,1445443200000,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (1,'18144240528','康彪',0,1441641600000,'何科松','18224489342',0,'511321199305205856','','',1541214000),(2,'18224489342','何科松',0,737827200000,'小红','120819186555',0,'510819120196123185',NULL,'1',165874000),(3,'18980485651','江谊',0,NULL,NULL,NULL,1,'511811000000000000',NULL,NULL,1445184000000),(4,'18565656262','test',1,NULL,NULL,NULL,1,'5555',NULL,NULL,1444233600000),(10,'15114052120','小明',0,NULL,NULL,NULL,1,'510704199405281715',NULL,NULL,1445616000000);
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parking_lot`
--

DROP TABLE IF EXISTS `parking_lot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parking_lot` (
  `pl_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL COMMENT '车位编号',
  `floor` varchar(45) DEFAULT NULL COMMENT '楼层',
  `location` varchar(100) DEFAULT NULL,
  `type` tinyint(2) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `brake_id` int(10) unsigned DEFAULT NULL,
  `village_id` int(10) unsigned DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`pl_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parking_lot`
--

LOCK TABLES `parking_lot` WRITE;
/*!40000 ALTER TABLE `parking_lot` DISABLE KEYS */;
INSERT INTO `parking_lot` VALUES (1,'CW001',NULL,'蓝光米兰香洲道闸一',2,NULL,1,6,0),(2,'CW002',NULL,'车位地址二',1,'巴拉巴拉',1,6,0),(3,'CW009',NULL,'园区一道闸一',2,'',1,5,0);
/*!40000 ALTER TABLE `parking_lot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parklot_owner_info`
--

DROP TABLE IF EXISTS `parklot_owner_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parklot_owner_info` (
  `poi_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pl_id` int(10) unsigned DEFAULT NULL,
  `owner_phone` varchar(15) DEFAULT NULL,
  `owner_type` tinyint(2) DEFAULT NULL,
  `brake_id` int(10) unsigned DEFAULT NULL,
  `enter_brake_allowed` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`poi_id`),
  KEY `FK_9ey4yw5vexd37wpqp8eeb6wbl` (`pl_id`),
  CONSTRAINT `FK_9ey4yw5vexd37wpqp8eeb6wbl` FOREIGN KEY (`pl_id`) REFERENCES `parking_lot` (`pl_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parklot_owner_info`
--

LOCK TABLES `parklot_owner_info` WRITE;
/*!40000 ALTER TABLE `parklot_owner_info` DISABLE KEYS */;
INSERT INTO `parklot_owner_info` VALUES (7,1,'18144240528',1,NULL,1),(9,3,'18144240528',3,NULL,1);
/*!40000 ALTER TABLE `parklot_owner_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `upload_time` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
INSERT INTO `picture` VALUES (15,'20151020185229_238.jpg',1445338349298),(16,'20151020185229_726.jpg',1445338349304),(17,'20151020200424_586.jpg',1445342664309),(18,'20151020200424_142.jpg',1445342664326);
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
  `location` varchar(100) DEFAULT NULL COMMENT '房产证上位置信息',
  `type` tinyint(2) DEFAULT NULL COMMENT '1:普通住房；2:商铺；3:车位',
  `property_square` decimal(11,2) DEFAULT NULL,
  `owner_type` tinyint(2) DEFAULT NULL COMMENT '1：个人所有；2:物业所有',
  `village_id` int(10) unsigned DEFAULT NULL COMMENT '园区',
  `building_id` int(10) unsigned NOT NULL,
  `status` tinyint(2) DEFAULT NULL COMMENT '1.自住 ／出租\n2.已入住／未入住\n3.已收房／未收房',
  `open_door_status` tinyint(2) DEFAULT '1',
  PRIMARY KEY (`property_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (28,'A001','半山蓝湾一单元',1,115.55,1,5,1,1,1),(29,'A002','半山蓝湾二单元',1,222.11,1,5,1,1,1);
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property_owner_info`
--

DROP TABLE IF EXISTS `property_owner_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `property_owner_info` (
  `poi_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `property_id` int(10) unsigned DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `status` tinyint(2) DEFAULT '0',
  `user_role` tinyint(2) DEFAULT NULL,
  `building_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`poi_id`),
  KEY `FK_7oq20rni7t96houjm1d7flnox` (`property_id`),
  KEY `FK_cmeyqayotl7586xjrqrlnvgm1` (`phone`),
  CONSTRAINT `FK_cmeyqayotl7586xjrqrlnvgm1` FOREIGN KEY (`phone`) REFERENCES `app_user` (`phone`),
  CONSTRAINT `FK_7oq20rni7t96houjm1d7flnox` FOREIGN KEY (`property_id`) REFERENCES `property` (`property_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property_owner_info`
--

LOCK TABLES `property_owner_info` WRITE;
/*!40000 ALTER TABLE `property_owner_info` DISABLE KEYS */;
INSERT INTO `property_owner_info` VALUES (1,28,'18144240528',1,3,NULL),(2,29,'18144240528',1,2,NULL);
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
  `phone` varchar(15) DEFAULT NULL,
  `time` bigint(25) DEFAULT NULL,
  `image_id_list` varchar(50) DEFAULT NULL,
  `status` tinyint(2) DEFAULT '0' COMMENT '1.未提交2.已提交未处理3.处理中4处理完',
  `remark` varchar(10) DEFAULT NULL,
  `remark_text` varchar(100) DEFAULT NULL,
  `cu_id` int(10) unsigned DEFAULT NULL,
  `result` varchar(200) DEFAULT NULL COMMENT '维修人员填写的处理说明',
  `repirman_phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_oc5vf2v77386b82n98ejj4qcd` (`cu_id`),
  CONSTRAINT `FK_oc5vf2v77386b82n98ejj4qcd` FOREIGN KEY (`cu_id`) REFERENCES `console_user` (`cu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repair`
--

LOCK TABLES `repair` WRITE;
/*!40000 ALTER TABLE `repair` DISABLE KEYS */;
INSERT INTO `repair` VALUES (13,'test','testcontent','testcontent','18224425362',1445342664296,'17,18',1,NULL,NULL,1,NULL,'15114052120');
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule`
--

LOCK TABLES `rule` WRITE;
/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
INSERT INTO `rule` VALUES (2,322.00,'family',NULL,5.00,'day',1441555200000,1443542400000),(3,55.00,'family',NULL,55.00,'day',NULL,NULL),(4,55.00,'family',NULL,454.00,'day',NULL,NULL),(5,1.00,'family',NULL,2.00,'day',NULL,NULL),(6,32.00,'squre',NULL,NULL,NULL,1441814400000,1442419200000),(7,32.00,'per',NULL,NULL,NULL,1441814400000,1442419200000),(8,56.00,'per',NULL,NULL,NULL,1441814400000,1441641600000),(9,43.00,'squre',NULL,NULL,NULL,1441641600000,1444233600000),(10,32.00,'squre',NULL,3.00,'month',1422720000000,1454601600000),(11,32.00,'squre',NULL,4.00,'day',1441036800000,1441382400000),(12,3.00,'squre',NULL,3.00,'day',NULL,NULL),(13,2.00,'per',NULL,NULL,NULL,NULL,NULL),(14,21.00,'per',NULL,NULL,NULL,NULL,NULL),(15,3.00,'per',NULL,NULL,NULL,1441641600000,1442160000000),(16,3.00,'per',NULL,NULL,NULL,1441641600000,1442160000000),(17,2323.00,'squre',NULL,12.00,'day',1441036800000,1442937600000),(18,21.00,'squre',NULL,NULL,NULL,1441036800000,1442246400000),(19,55.00,'squre',NULL,NULL,NULL,1444060800000,1469030400000),(20,1.50,'squre',NULL,3.00,'day',1444492800000,1444752000000),(21,66.00,'squre',NULL,99.00,'month',1443628800000,1446220800000),(22,55.55,NULL,NULL,5.00,'day',1443628800000,1451577600000),(24,55.55,NULL,NULL,6.00,'month',1443628800000,1454256000000),(25,99.00,NULL,NULL,33.00,'day',1443628800000,1448899200000);
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
  `control_id` int(10) unsigned DEFAULT NULL,
  `village_id` int(10) unsigned DEFAULT NULL,
  `symbol` varchar(45) DEFAULT NULL,
  `secret` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `type` tinyint(2) NOT NULL,
  PRIMARY KEY (`sc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ssid_secret`
--

LOCK TABLES `ssid_secret` WRITE;
/*!40000 ALTER TABLE `ssid_secret` DISABLE KEYS */;
INSERT INTO `ssid_secret` VALUES (11,3,4,'YCWY_D_001','00000000','01234567',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant`
--

LOCK TABLES `tenant` WRITE;
/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
INSERT INTO `tenant` VALUES (4,'18224489343','康彪的租户',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,1),(5,'18224489258','康彪的租户',0,813772800000,'何科松','18224489342',0,'511321199305205852',NULL,NULL,NULL,0,7),(6,'18224456832','小明的租客',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `village`
--

LOCK TABLES `village` WRITE;
/*!40000 ALTER TABLE `village` DISABLE KEYS */;
INSERT INTO `village` VALUES (4,'测试园区','YQ002',''),(5,'园区一','YQ001',''),(7,'万科城市花园','wk001','川师附近');
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

-- Dump completed on 2015-10-21 22:47:34
