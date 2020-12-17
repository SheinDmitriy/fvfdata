DROP TABLE IF EXISTS buh_data;

CREATE TABLE buh_data (
  id                bigint NOT NULL AUTO_INCREMENT,
  contract_number   VARCHAR(50) DEFAULT NULL,
  data_start_up     TIMESTAMP,
  inventory_number  VARCHAR(50) DEFAULT NULL,
  price             DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;