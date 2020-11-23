DROP TABLE IF EXISTS complex_status;

create table complex_status (
        id bigint not null auto_increment,
        complex_status varchar(255),
        primary key (id)
    ) engine=InnoDB