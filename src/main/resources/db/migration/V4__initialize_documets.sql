DROP TABLE IF EXISTS documents;

create table documents (
        id bigint not null auto_increment,
        path varchar(255),
        primary key (id)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;