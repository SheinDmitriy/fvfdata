DROP TABLE IF EXISTS verification;

CREATE TABLE verification (
  id                bigint NOT NULL AUTO_INCREMENT,
  verification_number   VARCHAR(50) DEFAULT NULL,
  verification_date     TIMESTAMP,
  verification_date_until     TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;