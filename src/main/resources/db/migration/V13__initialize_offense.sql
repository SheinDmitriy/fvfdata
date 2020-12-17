DROP TABLE IF EXISTS offense;

CREATE TABLE offense (
  id bigint not null auto_increment,
  type_offense varchar(255),
  PRIMARY KEY (id)
) ENGINE=InnoDB;
