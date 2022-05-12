CREATE DATABASE  IF NOT EXISTS `meteown_proyecto` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `meteown_proyecto`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: meteown_proyecto
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `username` varchar(255) NOT NULL,
  `authority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('Albitadinamita','ROLE_USER'),('BBDD','ROLE_USER'),('dEIGUS','ROLE_USER'),('donPepito','ROLE_USER'),('eeee','ROLE_USER'),('error','ROLE_USER'),('error2','ROLE_USER'),('error3','ROLE_USER'),('final','ROLE_USER'),('Klabitos','ROLE_ADMIN'),('PaBleT','ROLE_USER'),('Pcruz','ROLE_USER'),('Prueba','ROLE_USER'),('PrUEBA1','ROLE_USER'),('prueba10','ROLE_USER'),('prueba2','ROLE_USER'),('Prueba3','ROLE_USER'),('prueba4','ROLE_USER'),('prueba5','ROLE_USER'),('prueba6','ROLE_USER'),('registro','ROLE_USER'),('rubentxogg','ROLE_USER'),('VictorMer','ROLE_USER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conjuntousuario`
--

DROP TABLE IF EXISTS `conjuntousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conjuntousuario` (
  `idConjuntoUsuario` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int NOT NULL,
  `idPrendaCabeza` int NOT NULL,
  `idPrendaTorso` int NOT NULL,
  `idPrendaPierna` int NOT NULL,
  `idPrendaPies` int NOT NULL,
  `numConjunto` int NOT NULL,
  `nombreConjunto` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`idConjuntoUsuario`),
  KEY `id_usuario` (`idUsuario`),
  KEY `id_prenda_cabeza` (`idPrendaCabeza`),
  KEY `id_prenda_torso` (`idPrendaTorso`),
  KEY `id_prenda_pierna` (`idPrendaPierna`),
  KEY `id_prenda_pies` (`idPrendaPies`),
  CONSTRAINT `conjuntousuario_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `conjuntousuario_ibfk_2` FOREIGN KEY (`idPrendaCabeza`) REFERENCES `ropa` (`idRopa`),
  CONSTRAINT `conjuntousuario_ibfk_3` FOREIGN KEY (`idPrendaTorso`) REFERENCES `ropa` (`idRopa`),
  CONSTRAINT `conjuntousuario_ibfk_4` FOREIGN KEY (`idPrendaPies`) REFERENCES `ropa` (`idRopa`),
  CONSTRAINT `conjuntousuario_ibfk_5` FOREIGN KEY (`idPrendaPierna`) REFERENCES `ropa` (`idRopa`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conjuntousuario`
--

LOCK TABLES `conjuntousuario` WRITE;
/*!40000 ALTER TABLE `conjuntousuario` DISABLE KEYS */;
INSERT INTO `conjuntousuario` VALUES (15,63,7,13,16,20,1,'Chandal Chulo'),(16,64,8,11,17,21,1,'PaBleT heehe'),(17,64,7,14,18,19,2,'PaBleT 2'),(18,65,8,11,17,21,1,'deCalle'),(19,65,9,13,15,19,3,'los Picolos'),(20,65,8,10,15,19,4,'12,.,@#'),(21,67,7,11,18,21,1,'asd'),(22,67,9,13,16,20,3,'sdad'),(23,67,7,14,17,20,2,'hgghg'),(24,68,8,13,17,21,1,'majo pero no me liaria'),(25,68,9,14,16,20,3,'jiji'),(26,68,8,11,15,19,2,'comunista'),(27,68,8,14,18,19,4,'outift pa el viñarock'),(28,69,7,11,17,21,2,'Test'),(29,70,7,10,16,20,2,' nb'),(30,71,7,13,16,20,1,'Chulazo'),(31,73,7,13,16,20,1,'ReXulo'),(32,75,8,11,18,21,1,'PUTERÍO'),(33,80,7,11,16,20,2,'fhdxg'),(34,81,7,12,16,20,2,'dfgdfg'),(35,73,8,14,18,19,2,'Vaquerito'),(36,73,9,10,15,20,3,'Fontanero'),(37,83,7,13,16,20,1,'Chandal'),(38,79,7,11,16,20,1,'hj'),(39,84,7,10,18,20,2,'asdasdasd');
/*!40000 ALTER TABLE `conjuntousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ropa`
--

DROP TABLE IF EXISTS `ropa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ropa` (
  `idRopa` int NOT NULL AUTO_INCREMENT,
  `tipoRopa` int NOT NULL,
  `nombreRopa` varchar(24) DEFAULT NULL,
  `urlRelativa` varchar(100) DEFAULT NULL,
  `valorCalorPorDefecto` double DEFAULT NULL,
  PRIMARY KEY (`idRopa`),
  KEY `tipoRopa` (`tipoRopa`) /*!80000 INVISIBLE */
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ropa`
--

LOCK TABLES `ropa` WRITE;
/*!40000 ALTER TABLE `ropa` DISABLE KEYS */;
INSERT INTO `ropa` VALUES (7,1,'gorroVerde','cabeza/gorro1.webp',7),(8,1,'sombreroRojo','cabeza/sombrero1.png',3),(9,1,'vacio','cabeza/blanca.png',0),(10,2,'camisetaDeportiva','torso/camiseta1.png',4),(11,2,'camisetaSinMangas','torso/camiseta2.png',3),(12,2,'camisetaRosa','torso/camiseta3.png',3),(13,2,'abrigo','torso/abrigo1.webp',8),(14,2,'cazadoraVaquera','torso/abrigo2.png',5),(15,3,'pantalonGris','piernas/pantalon1.png',5),(16,3,'pantalonChandal','piernas/pantalon22.png',5.2),(17,3,'faldaLarga','piernas/falda1.png',3.5),(18,3,'vaqueros1','piernas/vaqueros1.png',5.2),(19,4,'chanclas','pies/chanclas1.webp',1),(20,4,'deportivas','pies/deportivas1.png',3),(21,4,'tacones','pies/tacones1.png',2.5);
/*!40000 ALTER TABLE `ropa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ropatipo`
--

DROP TABLE IF EXISTS `ropatipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ropatipo` (
  `tipoRopa` int NOT NULL AUTO_INCREMENT,
  `zonaCuerpo` varchar(24) NOT NULL,
  PRIMARY KEY (`tipoRopa`),
  CONSTRAINT `ropatipo_ibfk_1` FOREIGN KEY (`tipoRopa`) REFERENCES `ropa` (`tipoRopa`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ropatipo`
--

LOCK TABLES `ropatipo` WRITE;
/*!40000 ALTER TABLE `ropatipo` DISABLE KEYS */;
INSERT INTO `ropatipo` VALUES (1,'CABEZA'),(2,'CUERPO'),(3,'PIERNA'),(4,'PIES');
/*!40000 ALTER TABLE `ropatipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ropausuario`
--

DROP TABLE IF EXISTS `ropausuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ropausuario` (
  `idRopa` int NOT NULL,
  `idUsuario` int NOT NULL,
  `valorCalorRopa` double DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`,`idRopa`,`idUsuario`),
  KEY `idRopa` (`idRopa`),
  KEY `idUsuario` (`idUsuario`),
  CONSTRAINT `ropausuario_ibfk_1` FOREIGN KEY (`idRopa`) REFERENCES `ropa` (`idRopa`),
  CONSTRAINT `ropausuario_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=392 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ropausuario`
--

LOCK TABLES `ropausuario` WRITE;
/*!40000 ALTER TABLE `ropausuario` DISABLE KEYS */;
INSERT INTO `ropausuario` VALUES (7,60,1.2,57),(8,60,0.5,58),(9,60,0,59),(10,60,0.7,60),(12,60,0.5,61),(11,60,0.6,62),(13,60,1.2,63),(14,60,1,64),(15,60,1,65),(16,60,0.9,66),(17,60,0.5,67),(18,60,0.6,68),(19,60,0.2,69),(20,60,0.4,70),(21,60,0.3,71),(7,61,1.2,72),(8,61,0.5,73),(9,61,0,74),(10,61,0.7,75),(11,61,0.6,76),(12,61,0.5,77),(14,61,1,78),(13,61,1.2,79),(15,61,1,80),(16,61,0.9,81),(18,61,0.6,82),(17,61,0.5,83),(20,61,0.4,84),(21,61,0.3,85),(19,61,0.2,86),(7,62,1.2,87),(8,62,0.5,88),(9,62,0,89),(10,62,0.7,90),(11,62,0.6,91),(12,62,0.5,92),(13,62,1.2,93),(14,62,1,94),(15,62,1,95),(16,62,0.9,96),(17,62,0.5,97),(18,62,0.6,98),(19,62,0.2,99),(20,62,0.4,100),(21,62,0.3,101),(7,63,0.30999999999999994,106),(8,63,0.5,107),(9,63,0,108),(10,63,-0.30000000000000004,109),(11,63,0.6,110),(12,63,0.5,111),(14,63,1,112),(13,63,1.2,113),(15,63,1,114),(16,63,0.9,115),(17,63,0.5,116),(19,63,0.2,117),(18,63,0.6,118),(21,63,0.3,119),(20,63,0.4,120),(7,66,1.2,121),(8,66,0.5,122),(9,66,0,123),(10,66,0.7,124),(11,66,0.6,125),(12,66,0.5,126),(13,66,1.2,127),(14,66,1,128),(15,66,1,129),(16,66,0.9,130),(17,66,0.5,131),(18,66,0.6,132),(19,66,0.2,133),(20,66,0.4,134),(21,66,0.3,135),(7,67,1.2,136),(8,67,1.5,137),(9,67,-0.17,138),(10,67,0.7,139),(11,67,0.6,140),(12,67,-0.5,141),(13,67,1.2,142),(16,67,0.9,143),(14,67,2,144),(15,67,1,145),(18,67,0.6,146),(17,67,0.5,147),(19,67,-0.42,148),(20,67,0.4,149),(21,67,0.3,150),(7,68,1.2,151),(8,68,0.5,152),(9,68,0,153),(10,68,0.7,154),(11,68,0.6,155),(12,68,0.5,156),(14,68,1,157),(13,68,1.2,158),(15,68,1,159),(16,68,0.9,160),(18,68,0.6,161),(17,68,0.5,162),(19,68,0.2,163),(20,68,0.4,164),(21,68,0.3,165),(7,69,0.1399999999999999,166),(8,69,0.5,167),(9,69,0,168),(10,69,0.7,169),(11,69,0.6,170),(12,69,0.5,171),(13,69,1.2,172),(14,69,1,173),(16,69,0.9,174),(15,69,1,175),(17,69,0.5,176),(18,69,0.6,177),(19,69,0.2,178),(20,69,0.4,179),(21,69,0.3,180),(7,70,7,181),(8,70,3,182),(9,70,0,183),(10,70,4,184),(11,70,3,185),(12,70,3,186),(13,70,8,187),(14,70,5,188),(15,70,5,189),(16,70,5.2,190),(17,70,3.5,191),(18,70,4.71,192),(19,70,1,193),(20,70,3,194),(21,70,2.5,196),(7,71,7,197),(8,71,3,198),(9,71,0,199),(10,71,4,200),(11,71,3,201),(12,71,3,202),(13,71,5.72,203),(14,71,5,204),(15,71,5,205),(16,71,5.2,206),(17,71,3.5,207),(18,71,5.2,208),(19,71,1,209),(20,71,3,210),(21,71,2.5,211),(7,73,6.16,212),(8,73,3,213),(9,73,0,214),(11,73,4,215),(10,73,4,216),(12,73,3,217),(13,73,8,218),(14,73,5,219),(15,73,5,220),(16,73,5.2,221),(17,73,3.5,222),(18,73,5.2,223),(19,73,1,224),(20,73,3,225),(21,73,2.5,226),(7,75,7,227),(8,75,3,228),(9,75,0,229),(10,75,4,230),(11,75,3,231),(12,75,3,232),(14,75,5,233),(13,75,8,234),(15,75,5,235),(16,75,5.2,236),(17,75,3.5,237),(18,75,5.2,238),(19,75,1,239),(20,75,3,240),(21,75,2.5,241),(7,76,7,242),(8,76,3,243),(9,76,0,244),(10,76,4,245),(12,76,3,246),(11,76,3,247),(13,76,8,248),(14,76,5,249),(15,76,5,250),(16,76,5.2,251),(17,76,3.5,252),(18,76,5.2,253),(19,76,1,254),(20,76,3,255),(21,76,2.5,256),(7,77,7,257),(8,77,3,258),(9,77,0,259),(10,77,4,260),(11,77,3,261),(12,77,3,262),(13,77,8,263),(14,77,5,264),(15,77,5,265),(16,77,5.2,266),(17,77,3.5,267),(18,77,5.2,268),(19,77,1,269),(20,77,3,270),(21,77,2.5,271),(7,78,7,272),(8,78,3,273),(9,78,0,274),(10,78,4,275),(11,78,3,276),(12,78,3,277),(13,78,8,278),(14,78,5,279),(15,78,5,280),(16,78,5.2,281),(17,78,3.5,282),(18,78,5.2,283),(19,78,1,284),(21,78,2.5,285),(20,78,3,286),(7,79,7,287),(8,79,3,288),(9,79,0,289),(10,79,4,290),(11,79,3,291),(12,79,3,292),(13,79,8,293),(14,79,5,294),(16,79,5.2,295),(15,79,5,296),(18,79,5.2,297),(19,79,1,298),(17,79,3.5,299),(20,79,3,300),(21,79,2.5,301),(7,80,7,302),(8,80,3,303),(9,80,0,304),(10,80,4,305),(11,80,3,306),(12,80,3,307),(13,80,8,308),(14,80,5,309),(15,80,5,310),(16,80,5.2,311),(18,80,5.2,312),(17,80,3.5,313),(19,80,1,314),(20,80,3,315),(21,80,2.5,316),(7,81,7,317),(8,81,3,318),(9,81,0,319),(10,81,4,320),(11,81,3,321),(12,81,3,322),(14,81,5,323),(13,81,8,324),(15,81,5,325),(16,81,5.2,326),(17,81,3.5,327),(18,81,5.2,328),(19,81,1,329),(20,81,3,330),(21,81,2.5,331),(7,82,7,332),(8,82,3,333),(9,82,0,334),(10,82,4,335),(11,82,3,336),(12,82,3,337),(14,82,5,338),(13,82,8,339),(15,82,5,340),(16,82,5.2,341),(17,82,3.5,342),(18,82,5.2,343),(19,82,1,344),(20,82,3,345),(21,82,2.5,346),(7,83,26,347),(8,83,3,348),(9,83,0,349),(10,83,4,350),(11,83,3,351),(12,83,3,352),(13,83,8,353),(14,83,5,354),(16,83,5.2,355),(15,83,5,356),(17,83,3.5,357),(18,83,5.2,358),(19,83,1,359),(20,83,3,360),(21,83,2.5,361),(8,84,3,362),(7,84,7,363),(9,84,0,364),(10,84,5,365),(11,84,3,366),(13,84,8,367),(12,84,3,368),(14,84,5,369),(15,84,5,370),(17,84,3.5,371),(16,84,5.2,372),(18,84,5.2,373),(19,84,1,374),(21,84,2.5,375),(20,84,3,376),(7,85,7,377),(8,85,3,378),(9,85,0,379),(10,85,4,380),(12,85,3,381),(11,85,3,382),(13,85,8,383),(15,85,5,384),(14,85,5,385),(16,85,5.2,386),(17,85,3.5,387),(18,85,5.2,388),(19,85,1,389),(20,85,3,390),(21,85,2.5,391);
/*!40000 ALTER TABLE `ropausuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `enabled` tinyint DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`username`) REFERENCES `usuario` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('Albitadinamita','$2a$10$Z7XTwut7a9nxTDTBBqmS1.Bwb.sZq2q8NAxfxLDkRZ8xokDguXYau',1),('BBDD','$2a$10$K2OFP1bz4gGjTLpCIQ8tbuoxlLKyr0KNxA83SewPvxbhmSQr6yMMC',1),('dEIGUS','$2a$10$O9r35uZjZyLEijhFbP5WOejUQhz8q2EYX2vlBM2L9FqNdWoZh/8bS',1),('donPepito','$2a$10$dSXBI3FUffARJDfQuh30E.YuVBc.EcVeUJ4ospRWJztMvSz.BxYA2',1),('eeee','$2a$10$Hm7QmhvAIIgaTxkr1f4mReydFMwkfbsnNpTQSlzfPzR4vgrQVs6XG',1),('error','$2a$10$vto352j41wIbkgipkpHZke5fW/7.W.BCPLxM66V3tUKkWEFWDxaou',1),('error2','$2a$10$GQ1hdoPK5BbzhW2DPZV14.DhYwJXCh5oibnGN0ox1ul.wcj16xgjq',1),('error3','$2a$10$VoJSqmsckPO24zs9P5I7XOJhPiHut.jrbCxs34c77OAlxMV/gwMsC',1),('final','$2a$10$FYHQmqWzMWqdHKkH1/TXEufRtZc0JQuFLQslsx9yPxwWK/RubxdK6',1),('Klabitos','$2a$10$x4xhwz.3P.QropZkbYuS3upCvBeEJWqh/KkD5rxbIDJljghJc5ZfW',1),('PaBleT','$2a$10$7t6gHF3DmuvTAb9Iw/XZ0e.ka0lTMkpZOySZ6imMyJqnPCVsHwJPy',1),('Pcruz','$2a$10$Hy9NG.lncymutAECwYuWMOovuPE0CnP/zmSnnTzri9HxgGordg7Vm',1),('Prueba','$2a$10$ZQ5nuJq5KuatjoIl81bK2eWGGE0jYL1APF/UQtJRjRT8TkAD173NG',1),('PrUEBA1','$2a$10$Y4TBmeaFt5wxDI0KZ0q3XOfsNQqBlmGKSewdUNlHiejS.VEpj5jQK',1),('prueba10','$2a$10$yEp5ZIebfWdora2PrF.6mOEOx4.dQIf6KtxOAGqHHsNZENVJj5wlu',1),('prueba2','$2a$10$.1jpdqhwEaz8463SfbeYQO8mhg0Z1IjpOU3B.iqxwt1alkf6lF81e',1),('Prueba3','$2a$10$75KLepwF5OeYPvFB7BdNAO/2OAGehE8Jjnnq/45zEEPekRy3Gkto2',1),('prueba4','$2a$10$IqGbHu7pietIMjAngRGt8O0VhyRGOEZxPsdR6BjC0q2YQ7RRxRtbi',1),('prueba5','$2a$10$uWcZ05NzbQzcphLOdLD2meKz2OnDErqoBYwH7jQ67VsIBkxGglfPa',1),('prueba6','$2a$10$L/Dcza9DQnCEjUYzjEI7R.fIcEvrmuMp6tdnep60mxPVQlAKsmbPq',1),('registro','$2a$10$c3yBBZMjjrbJwkDzzXi44eSsPpjKFwGNAvaNyJuNCNIhSHVmx5cea',1),('rubentxogg','$2a$10$XhgLGP.I.qvyDB3gUyzZSeF.8tRgjaZ319PEdZllpHLqxVAy7GqY2',1),('VictorMer','$2a$10$ujqaI99WOb8KN7cl/qgLSOrkaVT/244Yxfw5WLO0xfyiKc3VE8cHe',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `email` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `surname` varchar(64) DEFAULT NULL,
  `nickname` varchar(64) NOT NULL,
  `idCiudad` int DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `usuario_nickname_idx` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (60,'prueba@gmail.com','Prueba','1','Prueba',3115609,'2022-03-30'),(61,'sdasd@GMAIL.COM','Pablo','Cruz','PrUEBA1',3115609,'2022-04-12'),(62,'cruzygalan@yahoo.es','Pedro','Cruz','Pcruz',3111108,'1968-02-08'),(63,'uhsdfusdofh@gmail.com','Victor','Merchán','VictorMer',3111108,'2022-03-30'),(64,'pablodominguezalonso148@gmail.com','Pablo','Domínguez Alonso','PaBleT',3111108,'2001-08-14'),(65,'pablo@yopmail.com','pablo','don pepeito','donPepito',3111108,'2020-04-29'),(66,'sdffsdfsd@gmail.com','dzcds','adad','aaa',3109718,'2022-04-07'),(67,'ramon@usal.es','Hermano de Ramonito','Fernandez','Ramonito',5,'1998-06-12'),(68,'albacruzrodriguez11@gmail.com','Alba','Cruz','Albitadinamita',6355234,'2002-09-20'),(69,'dfdfgdfg@gmail.com','PruebaBBDD','BBDD','BBDD',6359189,'2022-05-06'),(70,'prueba2@gmail.com','Prueba','Dos','prueba2',3130717,'2022-04-27'),(71,'pruebaSeguridad@gmail.com','Prueba','Seguridad','Prueba3',6355286,'2022-05-11'),(73,'klabitos@gmail.com','Pablo','Cruz','Klabitos',3111108,'1998-06-12'),(74,'rubentxogg@hotmail.com','Rubén','García','rubentxogg',3111108,'2022-05-05'),(75,'dasasda@diego.com','Diego','Diego','dEIGUS',3115609,'2022-04-27'),(76,'KLABITOS@PRUEBA.COM','Prueba 3','Prueba 3','prueba4',3336897,'2022-05-04'),(77,'alsdjkasod@gmail.com','apdjasdf','asodjasd','prueba5',3128026,'2022-05-04'),(78,'asdasd@gmail.com','asdasd','fsdasdasd','prueba6',3109716,'2022-05-05'),(79,'sdfdsdf@gmail.com','asdads','asdasd','error',3109718,'2022-05-03'),(80,'asdasd@gmaoil.com','asdasd','fasdda','error2',3119841,'2022-04-26'),(81,'asdasd@gfmail.com','aesdhjghjgjghjghj','asdasd','error3',3109716,'2022-05-04'),(82,'asdasd@gmail.com','asdd','asdasd','registro',3109718,'2022-05-11'),(83,'cxvvdzfasd@gmail.com','sdfjnsdf','asdasdasd','prueba10',3111108,'2022-04-28'),(84,'asdasdsda@gmail.com','zdsdf','adsfsadf','final',3128026,'2211-12-12'),(85,'kasdnasnd@gmail.com','qsdfsdf','asdfasd','eeee',3128026,'2022-05-03');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-12 17:25:24
