# 账号表[ id name package role username password]

DROP TABLE IF EXISTS T_USER;

CREATE TABLE T_USER (
  id       LONG                                AUTO_INCREMENT PRIMARY KEY,
  name    CHAR(64)  NOT NULL                   DEFAULT ''
  COMMENT '姓名',
  package CHAR(256) NOT NULL                  DEFAULT ''
  COMMENT '包名',
  role    CHAR(64)  NOT NULL                  DEFAULT 'NORMAL'
  COMMENT '权限(伪',
  username CHAR(32) NOT NULL
  COMMENT '用户名',
  password CHAR(32) NOT NULL
  COMMENT '密码'
);