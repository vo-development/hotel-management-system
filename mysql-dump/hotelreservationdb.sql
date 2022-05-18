-- MySQL dump 10.13  Distrib 8.0.25, for Linux (x86_64)
--
-- Host: localhost    Database: hms_db
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `calisanotel`
--

DROP TABLE IF EXISTS `calisanotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calisanotel` (
  `calisan_id` int DEFAULT NULL,
  `otel_id` int DEFAULT NULL,
  KEY `calisan_id` (`calisan_id`),
  KEY `otel_id` (`otel_id`),
  CONSTRAINT `calisanotel_ibfk_2` FOREIGN KEY (`otel_id`) REFERENCES `otel` (`id`),
  CONSTRAINT `calisanotel_ibfk_3` FOREIGN KEY (`calisan_id`) REFERENCES `kullanici` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calisanotel`
--

LOCK TABLES `calisanotel` WRITE;
/*!40000 ALTER TABLE `calisanotel` DISABLE KEYS */;
INSERT INTO `calisanotel` VALUES (3,4),(4,3);
/*!40000 ALTER TABLE `calisanotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kullanici`
--

DROP TABLE IF EXISTS `kullanici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kullanici` (
  `id` int NOT NULL AUTO_INCREMENT,
  `isim` text NOT NULL,
  `sifre` text NOT NULL,
  `email` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kullanici`
--

LOCK TABLES `kullanici` WRITE;
/*!40000 ALTER TABLE `kullanici` DISABLE KEYS */;
INSERT INTO `kullanici` VALUES (1,'Vedat Aslan','vedat2121','vedataslan@gmail.com'),(2,'Cetin Mutlu Onal','cetin3838','cetinmutlu@gmail.com'),(3,'Onur Kablan','onur3434','onurkablan@hotmail.com'),(4,'Emir Kadir Aktas','emir12345678','emirkadir@hotmail.com');
/*!40000 ALTER TABLE `kullanici` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kullanicirol`
--

DROP TABLE IF EXISTS `kullanicirol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kullanicirol` (
  `kullanici_id` int NOT NULL,
  `rol_id` int NOT NULL,
  KEY `kullanici_id` (`kullanici_id`,`rol_id`),
  KEY `rol_id` (`rol_id`),
  CONSTRAINT `kullanicirol_ibfk_2` FOREIGN KEY (`rol_id`) REFERENCES `roller` (`id`),
  CONSTRAINT `kullanicirol_ibfk_3` FOREIGN KEY (`kullanici_id`) REFERENCES `kullanici` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kullanicirol`
--

LOCK TABLES `kullanicirol` WRITE;
/*!40000 ALTER TABLE `kullanicirol` DISABLE KEYS */;
INSERT INTO `kullanicirol` VALUES (1,1),(2,1),(3,2),(4,2);
/*!40000 ALTER TABLE `kullanicirol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musteri`
--

DROP TABLE IF EXISTS `musteri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musteri` (
  `id` int NOT NULL AUTO_INCREMENT,
  `isim` text NOT NULL,
  `sifre` text NOT NULL,
  `mail` text NOT NULL,
  `telefon_no` varchar(25) NOT NULL,
  `kimlik_no` varchar(25) NOT NULL,
  `adres` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musteri`
--

LOCK TABLES `musteri` WRITE;
/*!40000 ALTER TABLE `musteri` DISABLE KEYS */;
INSERT INTO `musteri` VALUES (1,'Fatih Terim','imparator1905','fatihterim@gmail.com','53519051953','19050537800','Istanbul'),(2,'Cem Yilmaz','cmylmz1973','cmylmz@fikirsanat.com','5463457865','93845958346','Istanbul'),(3,'Onur Timur','timur1234','onurtimur@hotmail.com','5123940506','25436475432','Izmir');
/*!40000 ALTER TABLE `musteri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oda`
--

DROP TABLE IF EXISTS `oda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fiyat` int NOT NULL,
  `numara` int NOT NULL,
  `otel_id` int NOT NULL,
  `rezervasyon_id` int DEFAULT NULL,
  `yatak_sayisi` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `rezz` (`rezervasyon_id`),
  KEY `rezervasyon_id` (`rezervasyon_id`),
  KEY `otel_id` (`otel_id`),
  KEY `id` (`id`),
  CONSTRAINT `oda_ibfk_3` FOREIGN KEY (`rezervasyon_id`) REFERENCES `rezervasyon` (`id`),
  CONSTRAINT `oda_ibfk_4` FOREIGN KEY (`otel_id`) REFERENCES `otel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oda`
--

LOCK TABLES `oda` WRITE;
/*!40000 ALTER TABLE `oda` DISABLE KEYS */;
INSERT INTO `oda` VALUES (1,100,2,1,NULL,1),(2,100,3,1,NULL,2),(22,200,305,1,3,1),(24,300,308,1,5,2),(33,250,101,2,NULL,1),(34,450,102,2,NULL,2),(35,250,101,3,NULL,1),(36,475,102,3,NULL,2),(37,450,101,4,NULL,1),(38,800,102,4,NULL,2),(39,150,101,5,NULL,1),(40,275,102,5,NULL,2);
/*!40000 ALTER TABLE `oda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `otel`
--

DROP TABLE IF EXISTS `otel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `otel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `otel_isim` text NOT NULL,
  `sehir` text,
  `ilce` text,
  `aciklama` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otel`
--

LOCK TABLES `otel` WRITE;
/*!40000 ALTER TABLE `otel` DISABLE KEYS */;
INSERT INTO `otel` VALUES (1,'KYK Suite','Tekirdag','Corlu','3 yildizli'),(2,'Degirmenalti Palace','Tekirdag','Degirmenalti','4 Yildizli'),(3,'EsAngeles Deluxe','Istanbul','Esenyurt','4 Yildizli'),(4,'Belek Golf Hotel','Antalya','Serik','5 Yildizli'),(5,'Kordon VIP Hotel','Izmir','Bornova','3 Yildizli');
/*!40000 ALTER TABLE `otel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rezervasyon`
--

DROP TABLE IF EXISTS `rezervasyon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rezervasyon` (
  `id` int NOT NULL AUTO_INCREMENT,
  `baslangic_tarihi` date NOT NULL,
  `bitis_tarihi` date NOT NULL,
  `musteri_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_rezervasyon_1_idx` (`musteri_id`),
  CONSTRAINT `rezervasyon_ibfk_1` FOREIGN KEY (`musteri_id`) REFERENCES `musteri` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rezervasyon`
--

LOCK TABLES `rezervasyon` WRITE;
/*!40000 ALTER TABLE `rezervasyon` DISABLE KEYS */;
INSERT INTO `rezervasyon` VALUES (1,'2022-05-02','2022-05-10',NULL),(3,'2022-06-02','2022-06-10',NULL),(5,'2022-07-30','2022-08-30',2),(8,'2022-08-15','2022-08-30',NULL),(9,'2021-01-01','2021-01-02',NULL),(10,'2021-01-01','2021-01-02',NULL);
/*!40000 ALTER TABLE `rezervasyon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roller`
--

DROP TABLE IF EXISTS `roller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roller` (
  `id` int NOT NULL,
  `rol_isim` varchar(50) NOT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roller`

--
-- insert islemleri icin
SET foreign_key_checks = 0;
--

LOCK TABLES `roller` WRITE;
/*!40000 ALTER TABLE `roller` DISABLE KEYS */;
INSERT INTO `roller` VALUES (1,'Sistem Yöneticisi'),(2,'Sistem Kullanıcısı');
/*!40000 ALTER TABLE `roller` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-18 20:16:10
