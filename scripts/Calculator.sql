# Create Database
# ------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS Calculator DEFAULT CHARACTER SET = utf8mb4;

Use Calculator;


DROP TABLE IF EXISTS `DepositInterest`;

CREATE TABLE `DepositInterest` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `PeriodDescription` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'Period Description',
  `Period` DECIMAL(8,4) NOT NULL DEFAULT 0.0 COMMENT 'Period',
  `Interest` varchar(64) NOT NULL DEFAULT '0.0' COMMENT 'Interest',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='存款利率表';

INSERT INTO `DepositInterest` (Id, PeriodDescription, Period, Interest) VALUES (0, '活期', 0, '0.5');
INSERT INTO `DepositInterest` (Id, PeriodDescription, Period, Interest) VALUES (0, '三个月', 0.25, '2.85');
INSERT INTO `DepositInterest` (Id, PeriodDescription, Period, Interest) VALUES (0, '半年', 0.5, '3.05');
INSERT INTO `DepositInterest` (Id, PeriodDescription, Period, Interest) VALUES (0, '一年', 1, '3.25');
INSERT INTO `DepositInterest` (Id, PeriodDescription, Period, Interest) VALUES (0, '二年', 2, '4.15');
INSERT INTO `DepositInterest` (Id, PeriodDescription, Period, Interest) VALUES (0, '三年', 3, '4.75');
INSERT INTO `DepositInterest` (Id, PeriodDescription, Period, Interest) VALUES (0, '五年', 5, '5.25');


DROP TABLE IF EXISTS `LoanInterest`;

CREATE TABLE `LoanInterest` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `PeriodDescription` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'Period Description',
  `Period` DECIMAL(8,4) NOT NULL DEFAULT 0.0 COMMENT 'Period',
  `Interest` varchar(64) NOT NULL DEFAULT '0.0' COMMENT 'Interest',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='贷款利率表';

INSERT INTO `LoanInterest` (Id, PeriodDescription, Period, Interest) VALUES (0, '贷不了款', 0, '0.0');
INSERT INTO `LoanInterest` (Id, PeriodDescription, Period, Interest) VALUES (0, '六个月', 0.5, '5.85');
INSERT INTO `LoanInterest` (Id, PeriodDescription, Period, Interest) VALUES (0, '一年', 1, '6.31');
INSERT INTO `LoanInterest` (Id, PeriodDescription, Period, Interest) VALUES (0, '一到三年', 1, '6.40');
INSERT INTO `LoanInterest` (Id, PeriodDescription, Period, Interest) VALUES (0, '三到五年', 3, '6.65');
INSERT INTO `LoanInterest` (Id, PeriodDescription, Period, Interest) VALUES (0, '五年', 5, '6.80');


DROP TABLE IF EXISTS `CalculateResult`;

CREATE TABLE `CalculateResult` (
   `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
   `Expression` varchar(128) NOT NULL DEFAULT '' COMMENT 'Expression',
   `Result` varchar(128) NOT NULL DEFAULT '' COMMENT 'Result',
   PRIMARY KEY (`Id`),
   KEY `IX_EXPRESSION` (`Expression`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='计算结果表';