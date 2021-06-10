DROP TABLE IF EXISTS tbuh_data;

CREATE TABLE tbuh_data (
  id                bigint NOT NULL AUTO_INCREMENT,
  contract_number   VARCHAR(50) DEFAULT NULL,
  data_start_up     TIMESTAMP,
  inventory_number  VARCHAR(50) DEFAULT NULL,
  price             DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;