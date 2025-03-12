-- zp成员
CREATE TABLE genealogy (
   id int(32) NOT NULL AUTO_INCREMENT,
   name     varchar(128) NOT NULL,
   nickName varchar(256) DEFAULT NULL,
   living varchar(2) default 'Y',
   motto    varchar(512) DEFAULT NULL,
   remark   varchar(512) DEFAULT NULL,
   bornDate varchar(64) DEFAULT '',
   deathDay varchar(64) DEFAULT '',
   parentId varchar(32) DEFAULT '',
   sonId    varchar(32) DEFAULT '',
   partnerId varchar(32) default '',
   pwdId    text,
   createTime  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updateTime  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;