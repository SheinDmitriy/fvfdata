DROP TABLE IF EXISTS complex_offense;

CREATE TABLE complex_offense (
  complex_id               bigint NOT NULL,
  offense_id               bigint NOT NULL,

  PRIMARY KEY (complex_id,offense_id),

  CONSTRAINT FK_COMPLEX_ID_2 FOREIGN KEY (complex_id)
  REFERENCES complex (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT FK_OFFENSE_ID FOREIGN KEY (offense_id)
  REFERENCES offense (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB;