DROP TABLE IF EXISTS troad_type;

create table troad_type (
        id bigint not null auto_increment,
        road_type varchar(255),
        primary key (id)
    ) engine=InnoDB