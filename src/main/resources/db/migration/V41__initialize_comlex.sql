DROP TABLE IF EXISTS complex;

create table complex (
       id bigint not null auto_increment,
       complex_name varchar(255) not null,
       series_number varchar(255) not null unique,
       complex_place_id bigint,
       primary key (id),
       constraint FK_COMPLEX_PLACE_TYPE_ID foreign key (complex_place_id)
       references complex_place (id)
    ) engine=InnoDB

