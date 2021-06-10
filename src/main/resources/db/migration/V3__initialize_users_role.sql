DROP TABLE IF EXISTS tusers_roles;

CREATE TABLE tusers_roles (
  user_id               bigint NOT NULL,
  role_id               bigint NOT NULL,

  PRIMARY KEY (user_id,role_id),

  CONSTRAINT FK_USER_ID_01 FOREIGN KEY (user_id)
  REFERENCES tusers (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT FK_ROLE_ID FOREIGN KEY (role_id)
  REFERENCES troles (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET = utf8;