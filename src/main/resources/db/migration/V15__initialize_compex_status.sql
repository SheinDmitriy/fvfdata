DROP TABLE IF EXISTS tcomplex_status;

create table tcomplex_status (
        id bigint not null auto_increment,
        complex_status varchar(255),
        primary key (id)
    ) engine=InnoDB