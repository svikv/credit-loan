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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table credit-loan.client: ~4 rows (approximately)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`id`, `firstName`, `lastName`, `identificationNumber`, `phone`, `email`) VALUES
	(1, 'Vasiliy', 'Tymchenko', '2757832275', '2501245', 'vas@gmail.com'),
	(2, 'Evgeniy', 'Boiko', '2543543545', '2504524', 'evg77@gmail.com'),
	(3, 'Valeriy', 'Lomaka', '2457634234', '2403456', 'valery@gmail.com');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Dumping data for table credit-loan.creditline: ~8 rows (approximately)
/*!40000 ALTER TABLE `creditline` DISABLE KEYS */;
INSERT INTO `creditline` (`id`, `amount`, `period`, `rate`, `repayType`, `openingDate`, `closingDate`, `status`, `clientId`) VALUES
	(1, 1000, 60, 16, 'classical', '2015-03-29', NULL, b'0', 1),
	(2, 10000, 12, 10, 'classical', '2015-04-10', '2016-04-10', b'1', 1),
	(3, 100000, 60, 16, 'classical', '2014-05-29', '2015-05-29', b'1', 2),
	(14, 20000000, 24, 12, 'annuity', '2016-06-03', NULL, b'0', 2),
	(15, 150000, 12, 14, 'classical', '2016-06-08', NULL, b'0', 3),
	(16, 10000, 12, 16, 'annuity', '2016-06-08', NULL, b'0', 3);
/*!40000 ALTER TABLE `creditline` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=863 DEFAULT CHARSET=utf8;

-- Dumping data for table credit-loan.payment: ~7 rows (approximately)
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` (`id`, `monthPeriod`, `paymentAmount`, `creditLineId`) VALUES
	(779, 1, 1311736, 14),
	(780, 2, 1311736, 14),
	(781, 3, 1311736, 14),
	(782, 4, 1311736, 14),
	(783, 5, 1311736, 14),
	(784, 6, 1311736, 14),
	(785, 7, 1311736, 14),
	(786, 8, 1311736, 14),
	(787, 9, 1311736, 14),
	(788, 10, 1311736, 14),
	(789, 11, 1311736, 14),
	(790, 12, 1311736, 14),
	(791, 13, 1311736, 14),
	(792, 14, 1311736, 14),
	(793, 15, 1311736, 14),
	(794, 16, 1311736, 14),
	(795, 17, 1311736, 14),
	(796, 18, 1311736, 14),
	(797, 19, 1311736, 14),
	(798, 20, 1311736, 14),
	(799, 21, 1311736, 14),
	(800, 22, 1311736, 14),
	(801, 23, 1311736, 14),
	(802, 24, 1311736, 14),
	(803, 1, 3000, 3),
	(804, 2, 2977, 3),
	(805, 3, 2955, 3),
	(806, 4, 2933, 3),
	(807, 5, 2911, 3),
	(808, 6, 2888, 3),
	(809, 7, 2866, 3),
	(810, 8, 2844, 3),
	(811, 9, 2822, 3),
	(812, 10, 2800, 3),
	(813, 11, 2777, 3),
	(814, 12, 2755, 3),
	(815, 13, 2733, 3),
	(816, 14, 2711, 3),
	(817, 15, 2688, 3),
	(818, 16, 2666, 3),
	(819, 17, 2644, 3),
	(820, 18, 2622, 3),
	(821, 19, 2600, 3),
	(822, 20, 2577, 3),
	(823, 21, 2555, 3),
	(824, 22, 2533, 3),
	(825, 23, 2511, 3),
	(826, 24, 2488, 3),
	(827, 25, 2466, 3),
	(828, 26, 2444, 3),
	(829, 27, 2422, 3),
	(830, 28, 2400, 3),
	(831, 29, 2377, 3),
	(832, 30, 2355, 3),
	(833, 31, 2333, 3),
	(834, 32, 2311, 3),
	(835, 33, 2288, 3),
	(836, 34, 2266, 3),
	(837, 35, 2244, 3),
	(838, 36, 2222, 3),
	(839, 37, 2200, 3),
	(840, 38, 2177, 3),
	(841, 39, 2155, 3),
	(842, 40, 2133, 3),
	(843, 41, 2111, 3),
	(844, 42, 2088, 3),
	(845, 43, 2066, 3),
	(846, 44, 2044, 3),
	(847, 45, 2022, 3),
	(848, 46, 2000, 3),
	(849, 47, 1977, 3),
	(850, 48, 1955, 3),
	(851, 49, 1933, 3),
	(852, 50, 1911, 3),
	(853, 51, 1888, 3),
	(854, 52, 1866, 3),
	(855, 53, 1844, 3),
	(856, 54, 1822, 3),
	(857, 55, 1800, 3),
	(858, 56, 1777, 3),
	(859, 57, 1755, 3),
	(860, 58, 1733, 3),
	(861, 59, 1711, 3),
	(862, 60, 1688, 3);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table credit-loan.user: ~5 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `firstName`, `lastName`, `role`) VALUES
	(1, 'vicZ@mail.com', '1234', NULL, NULL, 'ROLE_OPERATOR'),
	(2, 'roman@mail.com', '1qaz', 'Roman', 'Zolotar', 'ROLE_OPERATOR'),
	(3, 'svikv84@gmail.com', 's', NULL, NULL, 'ROLE_OPERATOR'),
	(4, 'anton@mail.com', 'qw', 'Anton', 'Mykytiuk', 'ROLE_OPERATOR'),
	(5, 'manager@mail.com', '1234', NULL, NULL, 'ROLE_MANAGER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;