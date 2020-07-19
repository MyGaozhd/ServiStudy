CREATE TABLE FOO (ID INT IDENTITY, BAR VARCHAR(64));

-- `servi-db`.`user` definition

CREATE TABLE `user_0` (
  `id` double NOT NULL AUTO_INCREMENT,
  `user_id` double DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

CREATE TABLE `user_1` (
  `id` double NOT NULL AUTO_INCREMENT,
  `user_id` double DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;