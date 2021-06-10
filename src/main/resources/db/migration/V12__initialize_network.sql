DROP TABLE IF EXISTS tnetwork;

create table tnetwork (
        id bigint not null auto_increment,
        ip_address varchar(255),
        mask varchar(255),
        gateway varchar(255),
        link_type_id bigint,
        operator_id bigint,
        PRIMARY KEY (id),
  CONSTRAINT FK_LINK_TYPE_ID FOREIGN KEY (link_type_id)
  REFERENCES tlink_type (id),
  CONSTRAINT FK_OPERATOR_ID FOREIGN KEY (operator_id)
  REFERENCES toperator (id)
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8;