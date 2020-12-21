package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.entitys.ComplexPlaceDB;
import ru.cbdd.fvf.interfaces.iproviders.IComplexPlaceProvider;

@Component
public class ComplexPlaceProvider implements IComplexPlaceProvider {
    private final Sql2o sql2o;

    private static final String SELECT_COMPLEX_PLACE_ID = "select * from complex_place where id = :id";

    public ComplexPlaceProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public ComplexPlaceDB findById(Long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_COMPLEX_PLACE_ID, false)
                    .addParameter("id", id)
                    .setColumnMappings(ComplexPlaceDB.COLUMN_MAPPINGS)
                    .executeAndFetchFirst(ComplexPlaceDB.class);
        }
    }
}
