DROP TABLE IF EXISTS link_type;

create table link_type (
        id bigint not null auto_increment,
        link_type varchar(255),
        primary key (id)
    ) engine=InnoDB;