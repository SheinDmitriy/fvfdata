DROP TABLE IF EXISTS complex_mark;

create table complex_mark (
        id bigint not null auto_increment,
        complex_mark varchar(255),
        primary key (id)
    ) engine=InnoDB