DROP TABLE IF EXISTS complex;

create table complex (
       id bigint not null auto_increment,
        complex_name varchar(255) not null,
        ip_address varchar(255) unique,
        series_number varchar(255) not null unique,
        primary key (id)
    ) engine=InnoDB

