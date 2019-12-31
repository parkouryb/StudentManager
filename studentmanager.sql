-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 30, 2019 lúc 04:03 PM
-- Phiên bản máy phục vụ: 10.4.6-MariaDB
-- Phiên bản PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `studentmanager`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`username`, `password`) VALUES
('dang', 'admin1'),
('hieu', 'admin3'),
('nhung', 'admin2'),
('nhung1', 'admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `Bill_ID` varchar(255) NOT NULL,
  `Bill_NAME` varchar(255) DEFAULT NULL,
  `Student_ID` varchar(255) DEFAULT 'NULL',
  `Room_money` float DEFAULT NULL,
  `Total_money` float DEFAULT NULL,
  `Water_money` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `contract`
--

CREATE TABLE `contract` (
  `Contract_ID` varchar(255) NOT NULL,
  `Day_in` datetime DEFAULT NULL,
  `Day_out` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `contract`
--

INSERT INTO `contract` (`Contract_ID`, `Day_in`, `Day_out`) VALUES
('18001171', '2019-12-30 00:00:00', '2025-11-30 00:00:00'),
('18001980', '2015-11-15 00:00:00', '2019-12-16 00:00:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dormitory`
--

CREATE TABLE `dormitory` (
  `Dorm_name` varchar(255) NOT NULL,
  `Location` varchar(255) DEFAULT NULL,
  `Phone_number` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `manager`
--

CREATE TABLE `manager` (
  `Manager_ID` varchar(255) NOT NULL,
  `Birthday` datetime DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Position` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `manager`
--

INSERT INTO `manager` (`Manager_ID`, `Birthday`, `Gender`, `Name`, `Position`) VALUES
('1', '2000-12-16 00:00:00', 'Male', 'Vu Hai Dang', 'Manager'),
('2', '2000-01-01 00:00:00', 'Female', 'Trinh Thi Cam Nhung', 'Manager');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `room`
--

CREATE TABLE `room` (
  `Room_ID` varchar(255) NOT NULL,
  `Room_money` float DEFAULT NULL,
  `Type_room` varchar(10) DEFAULT NULL,
  `Number` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `room`
--

INSERT INTO `room` (`Room_ID`, `Room_money`, `Type_room`, `Number`) VALUES
('A100', 3000, '1', 12),
('A101', 3000, '1', 12);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student`
--

CREATE TABLE `student` (
  `Student_ID` varchar(255) NOT NULL,
  `Name` varchar(255) DEFAULT 'NULL',
  `Gender` varchar(255) DEFAULT 'NULL',
  `Birthday` datetime DEFAULT NULL,
  `Educational_System` varchar(255) DEFAULT 'NULL',
  `Faculty` varchar(255) DEFAULT 'NULL',
  `Hometown` varchar(255) DEFAULT 'NULL',
  `Phone_Number` varchar(255) DEFAULT 'NULL',
  `Room_ID` varchar(255) DEFAULT 'NULL',
  `Contract_ID` varchar(255) DEFAULT NULL,
  `Course` int(11) DEFAULT NULL,
  `Status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `student`
--

INSERT INTO `student` (`Student_ID`, `Name`, `Gender`, `Birthday`, `Educational_System`, `Faculty`, `Hometown`, `Phone_Number`, `Room_ID`, `Contract_ID`, `Course`, `Status`) VALUES
('18001171', 'Trinh Thi Cam Nhung', 'Female', '2000-01-01 00:00:00', 'hus', 'K63Maytinh', 'Nghe An', '0929242155', 'A100', '18001171', 2018, 'FALSE'),
('18001980', 'Vu Hai Dang', 'Male', '2000-12-16 00:00:00', 'HUS', 'K63MayTinh', 'Ha Nam', '0929241612', 'A100', '18001980', 2018, 'false');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`Bill_ID`);

--
-- Chỉ mục cho bảng `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`Contract_ID`);

--
-- Chỉ mục cho bảng `dormitory`
--
ALTER TABLE `dormitory`
  ADD PRIMARY KEY (`Dorm_name`);

--
-- Chỉ mục cho bảng `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`Manager_ID`);

--
-- Chỉ mục cho bảng `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`Room_ID`);

--
-- Chỉ mục cho bảng `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`Student_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
