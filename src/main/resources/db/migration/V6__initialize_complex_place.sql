DROP TABLE IF EXISTS complex_place;

  create table complex_place (
       id bigint not null auto_increment,
       latitude varchar(255),
       longitude varchar(255),
       place varchar(255),
       road_type_id bigint,
       primary key (id),
       constraint FK_ROAD_TYPE_ID foreign key (road_type_id)
       references road_type (id)
    ) engine=InnoDB