DROP TABLE IF EXISTS roles;

CREATE TABLE roles (
  id                    INT(11) NOT NULL AUTO_INCREMENT,
  name                  VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;