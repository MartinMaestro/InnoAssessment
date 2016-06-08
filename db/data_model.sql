-- MySQL dump 10.13  Distrib 5.7.12, for Linux (x86_64)
--
-- Host: localhost    Database: innoassessment
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.13-MariaDB

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

DROP SCHEMA IF EXISTS `innoassessment`;
CREATE SCHEMA `innoassessment`;

USE `innoassessment`;

--
-- Table structure for table `Dimension`
--

DROP TABLE IF EXISTS `Dimension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Dimension` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_m7d18cl9o9ube0sk1allc2q7b` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Factor`
--

DROP TABLE IF EXISTS `Factor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Factor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `definition` varchar(2048) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_s773tay6qs8589toyw9ombbkg` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Model`
--

DROP TABLE IF EXISTS `Model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `version` varchar(255) NOT NULL,
  `year` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ModelItem`
--

DROP TABLE IF EXISTS `ModelItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ModelItem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `help` varchar(2048) NOT NULL,
  `impact` varchar(255) NOT NULL,
  `interpretation` varchar(2048) NOT NULL,
  `weight` varchar(255) NOT NULL,
  `dimension_id` int(11) DEFAULT NULL,
  `factor_id` int(11) DEFAULT NULL,
  `model_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tjsbko66dbmj58s94rd9b3of3` (`dimension_id`),
  KEY `FK_bjhmo08ho2jbf6hl7s69ihd9s` (`factor_id`),
  KEY `FK_2rkicx6tojcyo9gbxbp567gvh` (`model_id`),
  CONSTRAINT `FK_2rkicx6tojcyo9gbxbp567gvh` FOREIGN KEY (`model_id`) REFERENCES `Model` (`id`),
  CONSTRAINT `FK_bjhmo08ho2jbf6hl7s69ihd9s` FOREIGN KEY (`factor_id`) REFERENCES `Factor` (`id`),
  CONSTRAINT `FK_tjsbko66dbmj58s94rd9b3of3` FOREIGN KEY (`dimension_id`) REFERENCES `Dimension` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Product`
--

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `provider` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ProductVersion`
--

DROP TABLE IF EXISTS `ProductVersion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProductVersion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hrp5ti9rpa4n243w1yw9ycuxm` (`product_id`),
  CONSTRAINT `FK_hrp5ti9rpa4n243w1yw9ycuxm` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Questionnaire`
--

DROP TABLE IF EXISTS `Questionnaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Questionnaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `version` varchar(255) NOT NULL,
  `model_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hmv08batk27m18y4prqsc5k7i` (`model_id`),
  CONSTRAINT `FK_hmv08batk27m18y4prqsc5k7i` FOREIGN KEY (`model_id`) REFERENCES `Model` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `AssessmentLine`
--

DROP TABLE IF EXISTS `AssessmentLine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AssessmentLine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `modelItem_id` int(11) DEFAULT NULL,
  `questionnaire_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_buf1ylaxhr51wu1jqr6f466rs` (`modelItem_id`),
  KEY `FK_sr980qki10v2p54tkldobl8es` (`questionnaire_id`),
  CONSTRAINT `FK_buf1ylaxhr51wu1jqr6f466rs` FOREIGN KEY (`modelItem_id`) REFERENCES `ModelItem` (`id`),
  CONSTRAINT `FK_sr980qki10v2p54tkldobl8es` FOREIGN KEY (`questionnaire_id`) REFERENCES `Questionnaire` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Evaluation`
--

DROP TABLE IF EXISTS `Evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creationTimeStamp` datetime NOT NULL,
  `productVersion_id` int(11) DEFAULT NULL,
  `questionnaire_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_t7jdk0tcki2f83tw7i2yy0fpn` (`questionnaire_id`,`productVersion_id`,`creationTimeStamp`),
  KEY `FK_le46uu685c1xje3bd8oxe0062` (`productVersion_id`),
  CONSTRAINT `FK_le46uu685c1xje3bd8oxe0062` FOREIGN KEY (`productVersion_id`) REFERENCES `ProductVersion` (`id`),
  CONSTRAINT `FK_oniqd7wjcsy221x59v1ynpj7y` FOREIGN KEY (`questionnaire_id`) REFERENCES `Questionnaire` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `LineValue`
--

DROP TABLE IF EXISTS `LineValue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LineValue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valueData` int(11) NOT NULL,
  `valueName` varchar(255) DEFAULT NULL,
  `assessmentLine_id` int(11) DEFAULT NULL,
  `evaluation_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_qchmkv7ejufu68xdk7h92hd6w` (`assessmentLine_id`),
  KEY `FK_og0k1h5todw33521p0e7qr1ct` (`evaluation_id`),
  CONSTRAINT `FK_og0k1h5todw33521p0e7qr1ct` FOREIGN KEY (`evaluation_id`) REFERENCES `Evaluation` (`id`),
  CONSTRAINT `FK_qchmkv7ejufu68xdk7h92hd6w` FOREIGN KEY (`assessmentLine_id`) REFERENCES `AssessmentLine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SourceFile`
--

DROP TABLE IF EXISTS `SourceFile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SourceFile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) NOT NULL,
  `realpath` varchar(255) NOT NULL,
  `assessmentLine_id` int(11) DEFAULT NULL,
  `evaluation_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_sllsan68kq606sxvtqplfc6rq` (`assessmentLine_id`),
  KEY `FK_2f7ew4g3jv6v0gff6qtqbcaj0` (`evaluation_id`),
  CONSTRAINT `FK_2f7ew4g3jv6v0gff6qtqbcaj0` FOREIGN KEY (`evaluation_id`) REFERENCES `Evaluation` (`id`),
  CONSTRAINT `FK_sllsan68kq606sxvtqplfc6rq` FOREIGN KEY (`assessmentLine_id`) REFERENCES `AssessmentLine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SourceUrl`
--

DROP TABLE IF EXISTS `SourceUrl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SourceUrl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  `assessmentLine_id` int(11) DEFAULT NULL,
  `evaluation_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_i07j10igr57wjfks7qp7rsuvl` (`assessmentLine_id`),
  KEY `FK_e5jkqx7xnwygruv03ohlyudmu` (`evaluation_id`),
  CONSTRAINT `FK_e5jkqx7xnwygruv03ohlyudmu` FOREIGN KEY (`evaluation_id`) REFERENCES `Evaluation` (`id`),
  CONSTRAINT `FK_i07j10igr57wjfks7qp7rsuvl` FOREIGN KEY (`assessmentLine_id`) REFERENCES `AssessmentLine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-05  2:35:45
