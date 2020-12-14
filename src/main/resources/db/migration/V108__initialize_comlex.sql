DROP TABLE IF EXISTS complex;

create table complex (
       id bigint not null auto_increment,
       complex_name varchar(255) not null,
       series_number varchar(255) not null unique,
       complex_place_id bigint,
       complex_type_id bigint,
       complex_mark_id bigint,
       complex_status_id bigint,
       verification_id bigint,
       buh_data_id bigint,
       network_id bigint,
       primary key (id),
       constraint FK_COMPLEX_PLACE_ID foreign key (complex_place_id)
              references complex_place (id),
       constraint FK_COMPLEX_TYPE_ID foreign key (complex_type_id)
              references complex_type (id),
       constraint FK_COMPLEX_MARK_ID foreign key (complex_mark_id)
              references complex_mark (id),
       constraint FK_COMPLEX_STATUS_ID foreign key (complex_status_id)
              references complex_status (id),
       constraint FK_VERIFICATION_ID foreign key (verification_id)
              references verification (id),
       constraint FK_BUH_ID foreign key (buh_data_id)
              references buh_data (id),
       constraint FK_NETWORK_ID foreign key (network_id)
              references network (id)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

