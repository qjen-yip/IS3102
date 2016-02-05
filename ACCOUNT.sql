-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 05, 2016 at 07:12 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smart`
--

-- --------------------------------------------------------

--
-- Table structure for table `ACCOUNT`
--

CREATE TABLE `ACCOUNT` (
  `ID` bigint(20) NOT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `STAFFID` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ACCOUNT`
--

INSERT INTO `ACCOUNT` (`ID`, `EMAIL`, `NAME`, `PASSWORD`, `STAFFID`) VALUES
(17812931982520, '111', 'nnn', '111', '111'),
(62764047499659, NULL, 'yingwei', '1234', '001'),
(71154855810884, NULL, 'yingwei', '1234', '002'),
(71456337636622, '@1234', 'yingwei', '1234', '003');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ACCOUNT`
--
ALTER TABLE `ACCOUNT`
  ADD PRIMARY KEY (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
