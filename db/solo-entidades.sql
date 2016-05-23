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

--
-- Table structure for table `models`
--

DROP TABLE IF EXISTS `models`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `models` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `year` varchar(4) COLLATE latin1_spanish_ci NOT NULL,
  `version` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `description` varchar(250) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dimensions`
--

DROP TABLE IF EXISTS `dimensions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dimensions` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(30) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `factors`
--

DROP TABLE IF EXISTS `factors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factors` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `definition` varchar(2048) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `modelitems`
--

DROP TABLE IF EXISTS `modelitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modelitems` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `modelId` INT NOT NULL,
  FOREIGN KEY (modelId) REFERENCES models(id) ON DELETE CASCADE,
  `dimId`  INT NOT NULL,
  FOREIGN KEY (dimId) REFERENCES dimensions(id) ON DELETE CASCADE,
  `factorId`   INT NOT NULL,
  FOREIGN KEY (factorId) REFERENCES factors(id) ON DELETE CASCADE,
  `impact` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `weight` float NOT NULL,
  `interpretation` varchar(2048) COLLATE latin1_spanish_ci NOT NULL,
  `help` varchar(2048) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `questionnaires`
--

DROP TABLE IF EXISTS `questionnaires`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionnaires` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `modelId` INT,
  FOREIGN KEY (modelId) REFERENCES models(id) ON DELETE CASCADE,
  `name` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `version` varchar(10) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `assessmentlines`
--

DROP TABLE IF EXISTS `assessmentlines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assessmentlines` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `questionnaireId` INT NOT NULL,
  FOREIGN KEY (questionnaireId) REFERENCES questionnaires(id) ON DELETE CASCADE,
  `modItemId` INT NOT NULL,
  FOREIGN KEY (modItemId) REFERENCES modelitems(id) ON DELETE CASCADE,
  `type` varchar(20) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `version` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `provider` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `description` varchar(250) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `linevalues`
--

DROP TABLE IF EXISTS `linevalues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linevalues` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `questionnaireId` INT NOT NULL,
  FOREIGN KEY (questionnaireId) REFERENCES questionnaires(id) ON DELETE CASCADE,
  `productId` INT NOT NULL,
  FOREIGN KEY (productId) REFERENCES products(id) ON DELETE CASCADE,
  `value` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `date` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `time` varchar(5) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sourcesfiles`
--

DROP TABLE IF EXISTS `sourcesfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sourcesfiles` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `questionnaireId` INT NOT NULL,
  FOREIGN KEY (questionnaireId) REFERENCES questionnaires(id) ON DELETE CASCADE,
  `lineId` INT NOT NULL,
  FOREIGN KEY (lineId) REFERENCES linevalues(id) ON DELETE CASCADE,
  `productId` INT NOT NULL,
  FOREIGN KEY (productId) REFERENCES products(id) ON DELETE CASCADE,
  `date` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `time` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `filename` varchar(255) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `realpath` varchar(255) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sourcesurl`
--

DROP TABLE IF EXISTS `sourcesurl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sourcesurl` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `questionnaireId` INT NOT NULL,
  FOREIGN KEY (questionnaireId) REFERENCES questionnaires(id) ON DELETE CASCADE,
  `lineId` INT NOT NULL,
  FOREIGN KEY (lineId) REFERENCES linevalues(id) ON DELETE CASCADE,
  `productId` INT NOT NULL,
  FOREIGN KEY (productId) REFERENCES products(id) ON DELETE CASCADE,
  `date` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `time` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `url` varchar(255) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL
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

-- Dump completed on 2016-05-21 12:28:01
