DROP TABLE IF EXISTS operator;

create table operator (
                         id bigint not null auto_increment,
                         title varchar(255),
                         primary key (id)
) ENGINE=InnoDB;