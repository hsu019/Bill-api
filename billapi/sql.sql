-- --------------------------------------------------------
-- 主机:                           47.101.198.61
-- Server version:               10.3.21-MariaDB - MariaDB Server
-- Server OS:                    Linux
-- HeidiSQL 版本:                  10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for api_bill
CREATE DATABASE IF NOT EXISTS `api_bill` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `api_bill`;

-- Dumping structure for table api_bill.user_balance
DROP TABLE IF EXISTS `user_balance`;
CREATE TABLE IF NOT EXISTS `user_balance` (
  `user_id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `balance_amount` float DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table api_bill.user_balance: ~0 rows (approximately)
DELETE FROM `user_balance`;
/*!40000 ALTER TABLE `user_balance` DISABLE KEYS */;
INSERT INTO `user_balance` (`user_id`, `balance_amount`) VALUES
	('abc', 50);
/*!40000 ALTER TABLE `user_balance` ENABLE KEYS */;

-- Dumping structure for table api_bill.user_bill
DROP TABLE IF EXISTS `user_bill`;
CREATE TABLE IF NOT EXISTS `user_bill` (
  `user_id` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bill_time` date DEFAULT NULL,
  `bill_year` int(11) DEFAULT NULL,
  `bill_month` int(11) DEFAULT NULL,
  `bill_week` int(11) DEFAULT NULL,
  `bill_type` int(11) DEFAULT NULL,
  `bill_amount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table api_bill.user_bill: ~0 rows (approximately)
DELETE FROM `user_bill`;
/*!40000 ALTER TABLE `user_bill` DISABLE KEYS */;
INSERT INTO `user_bill` (`user_id`, `bill_time`, `bill_year`, `bill_month`, `bill_week`, `bill_type`, `bill_amount`) VALUES
	('abc', '2021-01-07', 2021, 1, 53, 1, 200);
/*!40000 ALTER TABLE `user_bill` ENABLE KEYS */;

-- Dumping structure for table api_bill.user_info
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE IF NOT EXISTS `user_info` (
  `user_id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_passwd` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_transwd` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `last_time` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table api_bill.user_info: ~1 rows (approximately)
DELETE FROM `user_info`;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`user_id`, `user_passwd`, `user_transwd`, `create_time`, `last_time`) VALUES
	('abc', '123456', '54321', '2021-01-07', '2021-01-07');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
