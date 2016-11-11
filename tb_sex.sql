-- phpMyAdmin SQL Dump
-- version 4.2.10.1
-- http://www.phpmyadmin.net
--
-- Host: 202.12.97.33
-- Generation Time: Nov 11, 2016 at 09:54 AM
-- Server version: 5.5.45-37.4-log
-- PHP Version: 5.3.10-1ubuntu3.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cleft2`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_sex`
--

CREATE TABLE IF NOT EXISTS `tb_sex` (
`id_sex` int(11) NOT NULL,
  `sex_content` varchar(100) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_sex`
--

INSERT INTO `tb_sex` (`id_sex`, `sex_content`) VALUES
(1, 'ชาย'),
(2, 'หญิง');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_sex`
--
ALTER TABLE `tb_sex`
 ADD PRIMARY KEY (`id_sex`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_sex`
--
ALTER TABLE `tb_sex`
MODIFY `id_sex` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
