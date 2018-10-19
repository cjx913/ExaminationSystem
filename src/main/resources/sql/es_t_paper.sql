-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: es
-- ------------------------------------------------------
-- Server version	5.7.23-log

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
-- Table structure for table `t_paper`
--

DROP TABLE IF EXISTS `t_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_paper` (
  `id` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `subject_id` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `panduanti` int(2) NOT NULL DEFAULT '0',
  `danxuanti` int(2) NOT NULL DEFAULT '0',
  `duoxuanti` int(2) NOT NULL DEFAULT '0',
  `tiankongti` int(2) NOT NULL DEFAULT '0',
  `jiedati` int(2) NOT NULL DEFAULT '0',
  `exam_time` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_paper_subject` (`subject_id`),
  CONSTRAINT `fk_paper_subject` FOREIGN KEY (`subject_id`) REFERENCES `t_subject` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_paper`
--

LOCK TABLES `t_paper` WRITE;
/*!40000 ALTER TABLE `t_paper` DISABLE KEYS */;
INSERT INTO `t_paper` VALUES ('070c8a25cdc311e88e71308d99796187','11','hello',5,10,8,5,4,120),('123','312','2018年6月全国大学生英语等级考试CET-6（A卷）',5,8,6,5,6,120),('1231','312','2018年6月全国大学生英语等级考试CET-6（B卷）',0,0,0,0,0,120),('12312','312','2018年6月全国大学生英语等级考试CET-4（A卷）',0,0,0,0,0,150),('1233','11','2018年6月全国大学生英语等级考试CET-4（B卷）',0,0,0,0,0,120),('1a1dc395cdc311e88e71308d99796187','11','hello',5,10,8,5,4,45),('22c36fc4cdc611e88e71308d99796187','11','111hello',5,10,8,5,4,90),('33a04ce4cdca11e88e71308d99796187','11','hello',5,10,8,5,4,120),('4063a033cdc611e88e71308d99796187','11','111hello',5,10,8,5,4,120),('6a50047acdc611e88e71308d99796187','11','111hello',5,10,8,5,4,90),('6d660c52cdc811e88e71308d99796187','11','hello',5,10,8,5,4,90),('9c4374bfcdc111e88e71308d99796187','11','hello',5,10,8,5,4,90),('b8d58ff6cdc711e88e71308d99796187','11','hello',5,10,8,5,4,120),('cdb91d54cdc511e88e71308d99796187','11','111hello',5,10,8,5,4,120),('d15ba2ebcdc211e88e71308d99796187','11','hello',5,10,8,5,4,150),('e9a52f44cdc611e88e71308d99796187','11','hello',5,10,8,5,4,150);
/*!40000 ALTER TABLE `t_paper` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-17 20:14:09
