-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 04, 2021 at 04:52 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chifacom`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `address_id` int(11) NOT NULL,
  `office_location` varchar(300) NOT NULL,
  `province` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  `address_link` varchar(300) NOT NULL,
  `address_lat` double NOT NULL,
  `address_long` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`address_id`, `office_location`, `province`, `state`, `address_link`, `address_lat`, `address_long`) VALUES
(11, 'cite djenaine', 'sidi merouane', 'mila', 'https://www.google.com/maps/place/Constantine+Province/@36.5227989,6.262338,497m/data=!3m1!1e3!4m5!3m4!1s0x12f10cb470246509:0x5e2ae1969309f737!8m2!3d36.3373911!4d6.663812', 36.52306169788467, 6.26314185637305);

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `admin_firstname` varchar(100) NOT NULL,
  `admin_lastname` varchar(100) NOT NULL,
  `admin_email` varchar(100) NOT NULL,
  `admin_pass` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `appointement`
--

CREATE TABLE `appointement` (
  `app_id` int(11) NOT NULL,
  `patient_fullname` varchar(150) NOT NULL,
  `subsriber_fullname` varchar(150) NOT NULL,
  `tow_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cabinet`
--

CREATE TABLE `cabinet` (
  `cabinet_id` int(11) NOT NULL,
  `cabinet_name` varchar(100) NOT NULL,
  `cabinet_address` varchar(150) NOT NULL,
  `cabinet_speciality` varchar(100) NOT NULL,
  `office_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cabinet_doctor`
--

CREATE TABLE `cabinet_doctor` (
  `cd_id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `cabinet_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `clinic`
--

CREATE TABLE `clinic` (
  `clinic_id` int(11) NOT NULL,
  `clinic_name` varchar(100) NOT NULL,
  `clinic_description` varchar(300) NOT NULL,
  `office_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `clinic_doctor`
--

CREATE TABLE `clinic_doctor` (
  `cld_id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `clinic_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `conversation`
--

CREATE TABLE `conversation` (
  `conversation_id` int(11) NOT NULL,
  `sender_type` varchar(50) NOT NULL,
  `sender_id` int(11) NOT NULL,
  `reciever_type` varchar(50) NOT NULL,
  `reciever_id` int(11) NOT NULL,
  `subject` varchar(100) NOT NULL,
  `content` varchar(300) NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `days`
--

CREATE TABLE `days` (
  `day_id` int(11) NOT NULL,
  `day` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `doctor_id` int(11) NOT NULL,
  `doctor_firstname` varchar(100) NOT NULL,
  `doctor_firstname_AR` varchar(100) NOT NULL,
  `doctor_lastname` varchar(100) NOT NULL,
  `doctor_lastname_AR` varchar(100) NOT NULL,
  `doctor_speciality` varchar(150) NOT NULL,
  `birthdate` date NOT NULL,
  `birthplace` varchar(100) NOT NULL,
  `doctor_address` int(11) NOT NULL,
  `office_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`doctor_id`, `doctor_firstname`, `doctor_firstname_AR`, `doctor_lastname`, `doctor_lastname_AR`, `doctor_speciality`, `birthdate`, `birthplace`, `doctor_address`, `office_id`) VALUES
(21, 'j', 'h', 'hj', 'm', 'dh', '0000-00-00', '', 11, 28);

-- --------------------------------------------------------

--
-- Table structure for table `doc_office`
--

CREATE TABLE `doc_office` (
  `office_id` int(11) NOT NULL,
  `office_username` varchar(100) NOT NULL,
  `office_mail` varchar(100) NOT NULL,
  `office_pass` varchar(200) NOT NULL,
  `office_type` varchar(100) NOT NULL,
  `phone` int(11) NOT NULL,
  `office_picture` varchar(300) NOT NULL,
  `isActive` int(11) NOT NULL DEFAULT 0,
  `office_createdAt` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doc_office`
--

INSERT INTO `doc_office` (`office_id`, `office_username`, `office_mail`, `office_pass`, `office_type`, `phone`, `office_picture`, `isActive`, `office_createdAt`) VALUES
(28, '666', 'bil@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'doctor', 66, '', 0, '2021-02-04 15:50:44');

-- --------------------------------------------------------

--
-- Table structure for table `time_of_work`
--

CREATE TABLE `time_of_work` (
  `tow_id` int(11) NOT NULL,
  `office_id` int(11) NOT NULL,
  `day_id` int(11) NOT NULL,
  `time_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `time_w`
--

CREATE TABLE `time_w` (
  `time_id` int(11) NOT NULL,
  `time_start` time NOT NULL,
  `time_end` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `vocation`
--

CREATE TABLE `vocation` (
  `vocation_id` int(11) NOT NULL,
  `day_start` varchar(50) NOT NULL,
  `day_end` varchar(50) NOT NULL,
  `office_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`address_id`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `appointement`
--
ALTER TABLE `appointement`
  ADD PRIMARY KEY (`app_id`),
  ADD KEY `time_of_work_id_c` (`tow_id`);

--
-- Indexes for table `cabinet`
--
ALTER TABLE `cabinet`
  ADD PRIMARY KEY (`cabinet_id`),
  ADD KEY `office_id` (`office_id`);

--
-- Indexes for table `cabinet_doctor`
--
ALTER TABLE `cabinet_doctor`
  ADD PRIMARY KEY (`cd_id`),
  ADD KEY `doctor_id` (`doctor_id`),
  ADD KEY `cabinet_id` (`cabinet_id`);

--
-- Indexes for table `clinic`
--
ALTER TABLE `clinic`
  ADD PRIMARY KEY (`clinic_id`),
  ADD KEY `office_id` (`office_id`);

--
-- Indexes for table `clinic_doctor`
--
ALTER TABLE `clinic_doctor`
  ADD PRIMARY KEY (`cld_id`),
  ADD KEY `doctor_id` (`doctor_id`),
  ADD KEY `clinic_id` (`clinic_id`);

--
-- Indexes for table `days`
--
ALTER TABLE `days`
  ADD PRIMARY KEY (`day_id`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`doctor_id`),
  ADD KEY `office_id_c` (`office_id`),
  ADD KEY `doctor_address` (`doctor_address`);

--
-- Indexes for table `doc_office`
--
ALTER TABLE `doc_office`
  ADD PRIMARY KEY (`office_id`);

--
-- Indexes for table `time_of_work`
--
ALTER TABLE `time_of_work`
  ADD PRIMARY KEY (`tow_id`),
  ADD KEY `office_id_c_time` (`office_id`),
  ADD KEY `time_id_c` (`time_id`),
  ADD KEY `day_id_c` (`day_id`);

--
-- Indexes for table `time_w`
--
ALTER TABLE `time_w`
  ADD PRIMARY KEY (`time_id`);

--
-- Indexes for table `vocation`
--
ALTER TABLE `vocation`
  ADD PRIMARY KEY (`vocation_id`),
  ADD KEY `office_id_c_vocation` (`office_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `address_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `appointement`
--
ALTER TABLE `appointement`
  MODIFY `app_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cabinet`
--
ALTER TABLE `cabinet`
  MODIFY `cabinet_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cabinet_doctor`
--
ALTER TABLE `cabinet_doctor`
  MODIFY `cd_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `clinic`
--
ALTER TABLE `clinic`
  MODIFY `clinic_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `clinic_doctor`
--
ALTER TABLE `clinic_doctor`
  MODIFY `cld_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `doctor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `doc_office`
--
ALTER TABLE `doc_office`
  MODIFY `office_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `time_of_work`
--
ALTER TABLE `time_of_work`
  MODIFY `tow_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vocation`
--
ALTER TABLE `vocation`
  MODIFY `vocation_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointement`
--
ALTER TABLE `appointement`
  ADD CONSTRAINT `time_of_work_id_c` FOREIGN KEY (`tow_id`) REFERENCES `time_of_work` (`tow_id`);

--
-- Constraints for table `cabinet`
--
ALTER TABLE `cabinet`
  ADD CONSTRAINT `office_id_c_cabinet` FOREIGN KEY (`office_id`) REFERENCES `doc_office` (`office_id`);

--
-- Constraints for table `cabinet_doctor`
--
ALTER TABLE `cabinet_doctor`
  ADD CONSTRAINT `cabinet_id_c_dc` FOREIGN KEY (`cabinet_id`) REFERENCES `cabinet` (`cabinet_id`),
  ADD CONSTRAINT `doctor_id_c_dc` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`);

--
-- Constraints for table `clinic`
--
ALTER TABLE `clinic`
  ADD CONSTRAINT `office_id_c_clinic` FOREIGN KEY (`office_id`) REFERENCES `doc_office` (`office_id`);

--
-- Constraints for table `clinic_doctor`
--
ALTER TABLE `clinic_doctor`
  ADD CONSTRAINT `clinic_id_c_cld` FOREIGN KEY (`clinic_id`) REFERENCES `clinic` (`clinic_id`),
  ADD CONSTRAINT `doctor_id_c_cld` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`);

--
-- Constraints for table `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `doctor_addr_c` FOREIGN KEY (`doctor_address`) REFERENCES `address` (`address_id`),
  ADD CONSTRAINT `office_id_c` FOREIGN KEY (`office_id`) REFERENCES `doc_office` (`office_id`);

--
-- Constraints for table `time_of_work`
--
ALTER TABLE `time_of_work`
  ADD CONSTRAINT `day_id_c` FOREIGN KEY (`day_id`) REFERENCES `days` (`day_id`),
  ADD CONSTRAINT `office_id_c_time` FOREIGN KEY (`office_id`) REFERENCES `doc_office` (`office_id`),
  ADD CONSTRAINT `time_id_c` FOREIGN KEY (`time_id`) REFERENCES `time_w` (`time_id`);

--
-- Constraints for table `vocation`
--
ALTER TABLE `vocation`
  ADD CONSTRAINT `office_id_c_vocation` FOREIGN KEY (`office_id`) REFERENCES `doc_office` (`office_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
