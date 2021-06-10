DROP TABLE IF EXISTS tdocuments;

create table tdocuments (
        id bigint not null auto_increment,
        path varchar(255),
        primary key (id)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;