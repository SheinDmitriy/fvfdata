DROP TABLE IF EXISTS toffense;

CREATE TABLE toffense (
  id                    bigint NOT NULL AUTO_INCREMENT,
  typeOffense                  VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;