-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.6.25-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for credit-loan
CREATE DATABASE IF NOT EXISTS `credit-loan` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `credit-loan`;


-- Dumping structure for table credit-loan.client
DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `identificationNumber` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table credit-loan.creditline
DROP TABLE IF EXISTS `creditline`;
CREATE TABLE IF NOT EXISTS `creditline` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `amount` int(11) NOT NULL,
  `period` int(11) NOT NULL,
  `rate` int(11) NOT NULL,
  `repayType` varchar(50) NOT NULL,
  `openingDate` date NOT NULL,
  `closingDate` date DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `clientId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `clientId` (`clientId`),
  CONSTRAINT `FK_creditline_client` FOREIGN KEY (`clientId`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKdxiw9pgf294qlmgyc5tges755` FOREIGN KEY (`clientId`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table credit-loan.payment
DROP TABLE IF EXISTS `payment`;
CREATE TABLE IF NOT EXISTS `payment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `monthPeriod` int(11) NOT NULL DEFAULT '0',
  `paymentAmount` int(11) NOT NULL DEFAULT '0',
  `creditLineId` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FKjuo7axvr1dkqvery62uexupp1` (`creditLineId`),
  CONSTRAINT `FK_payment_creditline` FOREIGN KEY (`creditLineId`) REFERENCES `creditline` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKjuo7axvr1dkqvery62uexupp1` FOREIGN KEY (`creditLineId`) REFERENCES `creditline` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table credit-loan.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(75) COLLATE utf8_bin NOT NULL,
  `password` char(32) COLLATE utf8_bin NOT NULL,
  `firstName` varchar(75) COLLATE utf8_bin DEFAULT NULL,
  `lastName` varchar(75) COLLATE utf8_bin DEFAULT NULL,
  `role` varchar(15) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;