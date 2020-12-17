package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.entitys.Network;
import ru.cbdd.fvf.interfaces.iproviders.INetworkProvider;

@Component
public class NetworkProvider implements INetworkProvider {
    private final Sql2o sql2o;

    private static final String SELECT_NETWORK_BY_ID = "select * from network where id = :id";

    public NetworkProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Network findById(Long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_NETWORK_BY_ID, false)
                    .addParameter("id", id)
                    .setColumnMappings(Network.COLUMN_MAPPINGS)
                    .executeAndFetchFirst(Network.class);
        }
    }
}
