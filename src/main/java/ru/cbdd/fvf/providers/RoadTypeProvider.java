package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.entitys.RoadType;
import ru.cbdd.fvf.interfaces.iproviders.IRoadTypeProvider;

@Component
public class RoadTypeProvider implements IRoadTypeProvider {
    private final Sql2o sql2o;

    private static final String SELECT_ROADTYPE_BY_ID = "select * from road_type where id = :id";

    public RoadTypeProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public RoadType findById(Long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_ROADTYPE_BY_ID, false)
                    .addParameter("id", id)
                    .setColumnMappings(RoadType.COLUMN_MAPPINGS)
                    .executeAndFetchFirst(RoadType.class);
        }
    }
}
