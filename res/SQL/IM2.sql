CREATE TABLE `groupp` (
	`code_g`	TEXT NOT NULL,
	`name_g`	TEXT,
	PRIMARY KEY(`code_g`)
);

CREATE TABLE `subgroup` (
	`code_sg`	TEXT NOT NULL,
	`name_sg`	TEXT,
	`code_g`	TEXT,
	FOREIGN KEY(`code_g`) REFERENCES `groupp`(`code_g`) ON DELETE SET NULL,
	PRIMARY KEY(`code_sg`)
);

CREATE TABLE `product` (
	`code_p`	TEXT NOT NULL,
	`name_p`	TEXT,
	`measure`	TEXT,
	`code_sg`	TEXT,
	FOREIGN KEY(`code_sg`) REFERENCES `subgroup`(`code_sg`) ON DELETE SET NULL,
	PRIMARY KEY(`code_p`)
);

CREATE TABLE `department`(
    `code_d`    TEXT NOT NULL,
    `name_d` 	TEXT,
    PRIMARY KEY(`code_d`)
);

CREATE TABLE `userim` (
	`code_u`	TEXT NOT NULL,
	`name_u`	TEXT,
	`password_u`	TEXT,
	PRIMARY KEY(`code_u`)
);

CREATE TABLE `rmovement` (
	`code_m`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`date_m`	DATE,
	`code_invoice`	TEXT,
	`type_m`	TEXT,
	`quantity`	NUMERIC,
	`code_p`	TEXT,
	`code_u`	TEXT,
	FOREIGN KEY(`code_u`) REFERENCES `userim`(`code_u`) ON DELETE SET NULL,
	FOREIGN KEY(`code_p`) REFERENCES `product`(`code_p`) ON DELETE SET NULL
);

CREATE TABLE `rmout` (
	`code_m`	INTEGER NOT NULL,
	`code_d`	TEXT,
	PRIMARY KEY(`code_m`),
	FOREIGN KEY(`code_d`) REFERENCES `department`(`code_d`) ON DELETE SET NULL
);

CREATE TABLE `rmin` (
	`code_m`	INTEGER NOT NULL,
	`account`	NUMERIC,
	`total_pryce`	NUMERIC,
	FOREIGN KEY(`code_m`) REFERENCES `rmovement`(`code_m`) ON DELETE CASCADE,
	PRIMARY KEY(`code_m`)
);

CREATE TABLE `rclosemonth` (
	`code_cm`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`date_cm`	DATE
);

CREATE TABLE `rinitialstock` (
	`code_m`	INTEGER NOT NULL,
	`code_cm`	INTEGER NOT NULL,
	`measure`	NUMERIC,
	FOREIGN KEY(`code_m`) REFERENCES `rmovement`(`code_m`) ON DELETE CASCADE,
	FOREIGN KEY(`code_cm`) REFERENCES `rclosemonth`(`code_cm`) ON DELETE CASCADE,
	PRIMARY KEY(`code_m`,`code_cm`)
);
