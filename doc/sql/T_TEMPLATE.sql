# 模板表 [id userId caseId name location] [userId=-1 为公共]

DROP TABLE IF EXISTS T_TEMPLATE;

CREATE TABLE T_TEMPLATE (
  id       LONG                                                                              AUTO_INCREMENT PRIMARY KEY,
  userId LONG        NOT NULL                                                                     DEFAULT '-1'
  COMMENT '用户',
  caseId LONG NOT NULL                                                                     DEFAULT '0'
  COMMENT '分类',
  name   CHAR(64) NOT NULL                                                                 DEFAULT ''
  COMMENT '模板名，一般就是文件名',
  location CHAR(256) NOT NULL                                                                DEFAULT ''
  COMMENT '路径'
);