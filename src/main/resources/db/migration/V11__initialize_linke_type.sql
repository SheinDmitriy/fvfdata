DROP TABLE IF EXISTS tlink_type;

create table tlink_type (
        id bigint not null auto_increment,
        link_type varchar(255),
        primary key (id)
    ) engine=InnoDB