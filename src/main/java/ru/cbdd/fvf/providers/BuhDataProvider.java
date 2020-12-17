package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.entitys.BuhData;
import ru.cbdd.fvf.interfaces.iproviders.IBuhDataProvider;

@Component
public class BuhDataProvider implements IBuhDataProvider {
    private final Sql2o sql2o;

    private static final String SELECT_BUHDATA_BY_ID = "select * from buh_data where id = :id";

    public BuhDataProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public BuhData findById(Long id) {
        try (Connection connection = sql2o.open()){
            return connection.createQuery(SELECT_BUHDATA_BY_ID, false)
                    .addParameter("id", id)
                    .setColumnMappings(BuhData.COLUMN_MAPPINGS)
                    .executeAndFetchFirst(BuhData.class);
        }
    }
}
