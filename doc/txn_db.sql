-- MySQL dump 10.13  Distrib 8.0.40, for Linux (x86_64)
--
-- Host: localhost    Database: txn_db
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3k4cplvh82srueuttfkwnylq0` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES (4,'$2a$12$0Utj4ueGV3nj/zhW7/7xduoPv/1ompBILwZUlYbApX1XUIZQ/8MUu','ROLE_ADMIN','admin'),(5,'$2a$12$litaJkR8.WrYapq2clq16Ouk6cWDuc3aC13IsDibku18lwvULK8OO','ROLE_CLIENT','raju'),(6,'$2a$12$OcToEQ7q9AE8pu1J7vp0UO2rsVEHRB4I07AR.D4T6TPO42.mNrbhy','ROLE_CLIENT','ajay');
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `txn_details`
--

DROP TABLE IF EXISTS `txn_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `txn_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount_transaction` decimal(19,2) DEFAULT NULL,
  `bank_code` varchar(255) DEFAULT NULL,
  `card_acceptor_city` varchar(255) DEFAULT NULL,
  `card_acceptor_country_code` varchar(255) DEFAULT NULL,
  `card_acceptor_id` varchar(255) DEFAULT NULL,
  `card_acceptor_name` varchar(255) DEFAULT NULL,
  `card_acceptor_pin_code` varchar(255) DEFAULT NULL,
  `card_acceptor_state_code` varchar(255) DEFAULT NULL,
  `card_acceptor_street_address` varchar(255) DEFAULT NULL,
  `card_acceptor_tid` varchar(255) DEFAULT NULL,
  `card_number` varchar(255) DEFAULT NULL,
  `created_date_time` datetime(6) DEFAULT NULL,
  `expiry_date` datetime(6) DEFAULT NULL,
  `local_txn_date` datetime(6) DEFAULT NULL,
  `local_txn_time` time DEFAULT NULL,
  `mcc` varchar(255) DEFAULT NULL,
  `mti` varchar(255) DEFAULT NULL,
  `network` varchar(255) DEFAULT NULL,
  `ret_ref_number` varchar(255) DEFAULT NULL,
  `service_restriction_code` varchar(255) DEFAULT NULL,
  `stan` varchar(255) DEFAULT NULL,
  `token_identifier` varchar(255) DEFAULT NULL,
  `txn_currency_code` varchar(255) DEFAULT NULL,
  `txn_date_time` datetime(6) DEFAULT NULL,
  `txn_source` varchar(255) DEFAULT NULL,
  `txn_status` varchar(255) DEFAULT NULL,
  `unique_id` varchar(255) DEFAULT NULL,
  `updated_date_time` datetime(6) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5t07k5adq2jo2esing10ted0f` (`user_id`),
  CONSTRAINT `FK5t07k5adq2jo2esing10ted0f` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `txn_details`
--

LOCK TABLES `txn_details` WRITE;
/*!40000 ALTER TABLE `txn_details` DISABLE KEYS */;
INSERT INTO `txn_details` VALUES (13,500.00,'FDRL','kottayam','IND','000000000012345','Test Merchant','610021','KL','Test Address','00001234','02315654566465','2024-11-26 10:31:47.435000','2024-11-23 21:00:00.000000','2024-11-23 21:00:00.000000','14:30:00','5411','0110','MASTERCARD','424810001024','101','001024','9eb75a5b143e4112a1ff26aec3d57c7d','356','2024-12-10 21:00:00.000000','POS','SUCCESSFUL','0339cfa0-62a7-4d3e-9050-7e430bc46c3c','2024-11-26 10:31:47.435000',6),(14,500.00,'SBI','kottayam','IND','000000000012345','Test Merchant','610021','KL','Test Address','00001234','02315654566465','2024-11-26 10:32:41.825000','2024-11-23 21:00:00.000000','2024-11-23 21:00:00.000000','14:30:00','5411','0110','MASTERCARD','5464564566456','101','001024','9eb75a5b143e4112a1ff26aec3d57c7d','356','2024-08-10 21:00:00.000000','POS','SUCCESSFUL','0339cfa0-62a7-4d3e-9050-7e430bc46c3c','2024-11-26 10:32:41.825000',6);
/*!40000 ALTER TABLE `txn_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-26  5:28:23
