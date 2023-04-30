-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: mudi
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.24-MariaDB

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
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('maria','ROLE_USER'),('vini','ROLE_USER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oferta`
--

DROP TABLE IF EXISTS `oferta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oferta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comentario` varchar(255) DEFAULT NULL,
  `data_da_entrega` date DEFAULT NULL,
  `valor` decimal(38,2) DEFAULT NULL,
  `pedido_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp77nqk9cw6q3n828hb87vqv7` (`pedido_id`),
  CONSTRAINT `FKp77nqk9cw6q3n828hb87vqv7` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oferta`
--

LOCK TABLES `oferta` WRITE;
/*!40000 ALTER TABLE `oferta` DISABLE KEYS */;
INSERT INTO `oferta` VALUES (1,'dgsdgdsdgs','2011-12-14',456.00,6),(2,'dfk,snmlfsd','2008-08-12',125.00,6),(3,'dfk,snmlfsdjjj','2008-08-12',1250.00,6),(4,'dfk,snmlfsdjjjhjh','2008-08-12',12504.00,6),(5,'dfk,snmlfsdjjjhjhi','2008-08-12',12504.00,6),(6,'dfk,snmlfsdjjjhjhihgf','2008-08-12',12504.00,6),(7,'dfk,snmlfsdjjjhjhihgfbg','2008-08-12',12504.00,6),(8,'fgdgfddf','2198-09-01',720.00,6);
/*!40000 ALTER TABLE `oferta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_da_entrega` date DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `nome_produto` varchar(255) DEFAULT NULL,
  `url_imagem` varchar(255) DEFAULT NULL,
  `url_produto` varchar(255) DEFAULT NULL,
  `valor_negociado` decimal(38,2) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `user_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjgvb1pj32pv4ub09dofgm2eoh` (`user_username`),
  CONSTRAINT `FKjgvb1pj32pv4ub09dofgm2eoh` FOREIGN KEY (`user_username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,'2023-11-02','O Guia Definitivo das Melhores Práticas com Java ― Atualizado para o Java 7, 8 e 9 Desde a publicação anterior de Java Efetivo, após o lançamento da versão 6, o Java mudou radicalmente.','Java efetivo: as melhores práticas para a plataforma Java','https://m.media-amazon.com/images/I/51TLbX9OSnL._SX352_BO1,204,203,200_.jpg','https://www.amazon.com.br/Java-Efetivo-Melhores-Pr%C3%A1ticas-Plataforma/dp/8550804622/ref=sr_1_1?keywords=java+efetivo&qid=1674320692&sprefix=java+%2Caps%2C235&sr=8-1',60.00,'APROVADO','maria'),(5,'2023-02-11','É bom Notebook','Notebook Acer Chromebook N4020 D.Core 32gb 4gb Ram Sem Lan','https://m.media-amazon.com/images/I/61L0Qt9gD2L._AC_SX679_.jpg','https://www.amazon.com.br/Notebook-Acer-Chromebook-N4020-D-Core/dp/B09SK887PT?ref_=Oct_DLandingS_D_38757d2e_60',4850.00,'AGUARDANDO','vini'),(6,NULL,'Alguma coisa','Notebook Lenovo Ultrafino IdeaPad 3 Ryzen 5 5500U 8GB 256GB SSD Prata 15.6\' Windows 11','https://m.media-amazon.com/images/G/32/apparel/rcxgs/tile._CB483369971_.gif','https://www.amazon.com.br/Notebook-Lenovo-Ultrafino-R5-5500U-82MF0003BR/dp/B09LFJ13X9',NULL,'AGUARDANDO','maria'),(7,NULL,'','rewrewrwe','https://m.media-amazon.com/images/G/32/apparel/rcxgs/tile._CB483369971_.gif','https://www.amazon.com.br/Shampoo-Anticaspa-Hidrata%C3%A7%C3%A3o-Intensa-Clear/dp/B07LFGJKG2/?_encoding=UTF8&pd_rd_w=HNjem&content-id=amzn1.sym.00cfee2b-7050-411f-8cd3-6c38164b39da&pf_rd_p=00cfee2b-7050-411f-8cd3-6c38164b39da&pf_rd_r=QGRG51D3Y6NMXCNJXV6M&',NULL,'ENTREGUE','vini');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('maria','$2a$16$BrYXXyzgreq0q2q1.imeT.cnmN7pidiNAGcoVWpaU/bbnzaUpO9ke',1),('vini','$2a$16$MF6fbUaJNjphglpaXnJ.GuHtJf7zXyXQmqig4jZGKVN0lBVIHKpPq',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'mudi'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-30 16:51:23
