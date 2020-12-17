DROP TABLE IF EXISTS users_roles;

CREATE TABLE users_roles (
  user_id               bigint NOT NULL,
  role_id               bigint NOT NULL,

  PRIMARY KEY (user_id,role_id),

  CONSTRAINT FK_USER_ID_01 FOREIGN KEY (user_id)
  REFERENCES users (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT FK_ROLE_ID FOREIGN KEY (role_id)
  REFERENCES roles (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB;


