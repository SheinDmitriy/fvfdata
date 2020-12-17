DROP TABLE IF EXISTS roles;

CREATE TABLE roles (
  id                    bigint NOT NULL AUTO_INCREMENT,
  name                  VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;