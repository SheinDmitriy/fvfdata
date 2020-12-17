DROP TABLE IF EXISTS complex_type;

create table complex_type (
        id bigint not null auto_increment,
        complex_type varchar(255),
        primary key (id)
    ) engine=InnoDB;