CREATE TABLE door_user (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL,
  `FullName` varchar(256) DEFAULT NULL,
  `password` varchar(256) NOT NULL,
  `status` varchar(8) DEFAULT '0',
  `user_role` varchar(64) default 'employee',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `remark` varchar(512) DEFAULT NULL,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `age` int(11) DEFAULT NULL,
  `bornDate` varchar(256) DEFAULT NULL,
  `resource` varchar(256) DEFAULT '系统创建',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;