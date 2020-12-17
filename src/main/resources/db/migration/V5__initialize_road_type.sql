DROP TABLE IF EXISTS road_type;

create table road_type (
        id bigint not null auto_increment,
        road_type varchar(255),
        primary key (id)
    ) engine=InnoDB;

