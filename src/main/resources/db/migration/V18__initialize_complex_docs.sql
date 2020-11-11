DROP TABLE IF EXISTS complex_docs;

CREATE TABLE complex_docs (
  complex_id               bigint NOT NULL,
  docs_id               bigint NOT NULL,

  PRIMARY KEY (complex_id,docs_id),

  CONSTRAINT FK_COMPLEX_ID FOREIGN KEY (complex_id)
  REFERENCES complex (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT FK_DOCS_ID FOREIGN KEY (docs_id)
  REFERENCES documents (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET = utf8;