DROP TABLE IF EXISTS tcomplex_type;

create table tcomplex_type (
        id bigint not null auto_increment,
        complex_type varchar(255),
        complex_mark varchar(255),
        status_id bigint,
        primary key (id),
        CONSTRAINT FK_STATUS_ID FOREIGN KEY (status_id)
                REFERENCES tcomplex_status (id)
    ) engine=InnoDB