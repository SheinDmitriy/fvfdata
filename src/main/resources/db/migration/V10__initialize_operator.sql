DROP TABLE IF EXISTS toperator;

create table toperator (
                         id bigint not null auto_increment,
                         title varchar(255),
                         contract varchar(255),
                         operator bigint,
                         date_until TIMESTAMP,
                         primary key (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;