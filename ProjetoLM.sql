-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: pintegradoruc10
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cadfamilia`
--

DROP TABLE IF EXISTS `cadfamilia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cadfamilia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nomeFamilia` varchar(45) NOT NULL,
  `nrFamilia` int DEFAULT NULL,
  `endereco` varchar(200) NOT NULL,
  `obs` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadfamilia`
--

LOCK TABLES `cadfamilia` WRITE;
/*!40000 ALTER TABLE `cadfamilia` DISABLE KEYS */;
INSERT INTO `cadfamilia` VALUES (20,'Moura Silva',3,'Rua Z, 17, Santos/SP',''),(25,'Tupi',1,'Mata Atlântica, s/n',''),(26,'Xavantes',1,'Floresta Amazonica',''),(27,'Souza',1,'Rua da Mônica, 122',''),(28,'Dumont',1,'Rua do Passaredo 59 Santos',''),(29,'Coralina',1,'Rua dos Mundurucus, 233, Santos',''),(30,'Bandeira',1,'Rua Dos Imortais, s/n',''),(32,'Souza',1,'Rua da Mônica, 122',''),(40,'Lima',3,'Rua Gusmões, 1039, São Paulo',''),(41,'Teste',1,'Rua','');
/*!40000 ALTER TABLE `cadfamilia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cadindividuo`
--

DROP TABLE IF EXISTS `cadindividuo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cadindividuo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `idade` varchar(10) DEFAULT NULL,
  `telefone` varchar(14) DEFAULT NULL,
  `nomefamilia` varchar(45) NOT NULL,
  `escolaridade` varchar(45) DEFAULT NULL,
  `trabalha` varchar(20) DEFAULT NULL,
  `obs` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadindividuo`
--

LOCK TABLES `cadindividuo` WRITE;
/*!40000 ALTER TABLE `cadindividuo` DISABLE KEYS */;
INSERT INTO `cadindividuo` VALUES (2,'Silva e Silva','222-222.222-22','40','(13)2345.1234','Silva','primario','não',''),(3,'Maria das Dores','333-333.333-33','35','(13)91234.1234','Dores','não','não',''),(6,'Ubirajara','999.999.999-99','67','(13)99999.9999','Tupi','Superior','não',''),(7,'Pereira Barreto','111.222.333-44','10','(13)99991.1234','Barreto','Superior','Aposentado',''),(8,'Carlos Dumount','343.232.454-55','12','(12)11111.1111','Dumount','Superior','Trabalha','.'),(9,'Cora Coralina','233.334.455-55','102','(13)99999.1111','Coralina','','',''),(17,'Teste3','123.456.789-00','1','(13)12345.1234','teste','teste','teste','');
/*!40000 ALTER TABLE `cadindividuo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-23  8:14:14
