DROP TABLE IF EXISTS tcomplex;

create table tcomplex (
       id bigint not null auto_increment,
       complex_name varchar(255) not null,
       series_number varchar(255) not null unique,
       complex_place_id bigint,
       complex_type_id bigint,
       verification_id bigint,
       buh_data_id bigint,
       network_id bigint,
       primary key (id),
       constraint FK_COMPLEX_PLACE_ID foreign key (complex_place_id)
       references tcomplex_place (id),
       constraint FK_COMPLEX_TYPE_ID foreign key (complex_type_id)
       references tcomplex_type (id),
       constraint FK_VERIFICATION_ID foreign key (verification_id)
       references tverification (id),
       constraint FK_BUH_ID foreign key (buh_data_id)
       references tbuh_data (id),
       constraint FK_NETWORK_ID foreign key (network_id)
       references tnetwork (id)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;