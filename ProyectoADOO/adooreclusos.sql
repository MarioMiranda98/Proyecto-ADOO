-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: adooreclusos
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `condenas`
--

DROP TABLE IF EXISTS `condenas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `condenas` (
  `idcondenas` int(3) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`idcondenas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `condenas`
--

LOCK TABLES `condenas` WRITE;
/*!40000 ALTER TABLE `condenas` DISABLE KEYS */;
INSERT INTO `condenas` VALUES (1,'Robo con lujo de violencia ','GRAVES'),(2,'Privacion de la libertad','GRAVES'),(3,'Venta de narcoticos a menores de edad','GRAVES');
/*!40000 ALTER TABLE `condenas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delito`
--

DROP TABLE IF EXISTS `delito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delito` (
  `iddelito` int(3) NOT NULL,
  `delitonombre` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`iddelito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delito`
--

LOCK TABLES `delito` WRITE;
/*!40000 ALTER TABLE `delito` DISABLE KEYS */;
INSERT INTO `delito` VALUES (1,'Robo a mano armada','CONTRA LA PAZ Y SEGURIDAD DE LAS PERSONAS'),(2,'Trata de Blancas','CONTRA LA LIBERTAD SEXUAL'),(3,'Narcotraficante','CONTRA LA VIDA Y LA SALUD');
/*!40000 ALTER TABLE `delito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ficha`
--

DROP TABLE IF EXISTS `ficha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ficha` (
  `idficha` int(3) NOT NULL,
  `delito_iddelito` int(3) NOT NULL,
  `recluso_idrecluso` varchar(18) NOT NULL,
  `condenas_idcondenas` int(3) NOT NULL,
  `fianza` varchar(10) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  `fechaingreso` varchar(10) NOT NULL,
  `estadoFicha` varchar(50) NOT NULL,
  PRIMARY KEY (`idficha`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ficha`
--

LOCK TABLES `ficha` WRITE;
/*!40000 ALTER TABLE `ficha` DISABLE KEYS */;
INSERT INTO `ficha` VALUES (1,1,'FOSO980223HDFLNM07',2,'100000','24/03/2029','02/08/2015','Cumplida'),(2,2,'MISM980805HMCRNR03',2,'1000000','10/02/2025','02/08/2015','Cumplida'),(3,2,'WWWWWWWWWW',1,'150000','12/04/2032','02/08/2015','Curso'),(4,3,'FOSO980223HDFLNM07',3,'100000','14/11/2025','14/11/2019','Cumplida'),(5,2,'FOSO980223HDFLNM07',2,'150000','15/11/2025','15/11/2019','Cumplida'),(6,3,'MISM980805HMCRNR03',2,'100000','15/11/2030','15/11/2019','Curso');
/*!40000 ALTER TABLE `ficha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recluso`
--

DROP TABLE IF EXISTS `recluso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recluso` (
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `edad` int(3) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `curp` varchar(18) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`curp`,`estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recluso`
--

LOCK TABLES `recluso` WRITE;
/*!40000 ALTER TABLE `recluso` DISABLE KEYS */;
INSERT INTO `recluso` VALUES ('Omar','Flores Santos',22,'M','FOSO980223HDFLNM07','Libre '),('Mario','Miranda',21,'M','MISM980805HMCRNR03','Libre '),('Wicho','Rojas Alvarado',21,'M','WWWWWWWWWW','Recluso');
/*!40000 ALTER TABLE `recluso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `nombreusuario` varchar(30) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `edad` int(3) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `domicilio` varchar(80) NOT NULL,
  `CURP` varchar(18) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`nombreusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('MarioConsultor','Miranda Sandoval',21,'M','San Mateo No 2','MISM980805HMCRNR03','qwerty','Consultor','Mario Alberto'),('MarioPrincipal','Miranda Sandoval',21,'M','San Mateo no 2','MISM980805HMCRNR03','EMveIGJeOGu5deu0e3RhDg==','administrador','Mario'),('MarioRegistrador','Miranda Sandoval',21,'M','San Mateo No. 2','MISM980805HMRNR03','EMveIGJeOGu5deu0e3RhDg==','Registrador','Mario'),('OmarFS','Flores Santos',21,'M','Av.  Santa Elena, Cuautitlán, EDOMEX','FOSO980223HDFLNM07','6mhQqzciLYlwn4Kae5nZPQ==','Registrador','Omar');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-16 19:38:59
