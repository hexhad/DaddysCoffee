-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 28, 2020 at 09:00 AM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coffee`
--

-- --------------------------------------------------------

--
-- Table structure for table `coffee_table`
--

DROP TABLE IF EXISTS `coffee_table`;
CREATE TABLE IF NOT EXISTS `coffee_table` (
  `id` int(11) NOT NULL,
  `c_desc` varchar(255) DEFAULT NULL,
  `c_name` varchar(255) DEFAULT NULL,
  `c_order` varchar(255) DEFAULT NULL,
  `c_imag` varchar(255) DEFAULT NULL,
  `c_price` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coffee_table`
--

INSERT INTO `coffee_table` (`id`, `c_desc`, `c_name`, `c_order`, `c_imag`, `c_price`) VALUES
(1, 'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Fuga quae expedita', 'Black Coffee', '1', 'https://images.hdqwalls.com/download/morning-coffee-mug-on-table-4k-tf-240x320.jpg', '200'),
(2, 'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Fuga quae expedita', 'Latte', '1', 'https://images.hdqwalls.com/download/coffee-love-240x400.jpg', '750'),
(3, 'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Fuga quae expedita', 'Cappuccino', '1', 'https://images.hdqwalls.com/download/coffee-cup-beans-4k-4c-240x320.jpg', '500'),
(4, 'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Fuga quae expedita', 'Espresso', '1', 'https://images.hdqwalls.com/download/coffee-beside-coffee-beans-pp-240x320.jpg', '100'),
(5, 'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Fuga quae expedita', 'Americano', '2', 'https://images.hdqwalls.com/download/morning-coffee-cg-240x320.jpg', '400');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
