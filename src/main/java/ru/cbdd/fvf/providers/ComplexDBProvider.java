package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.entitys.ComplexDB;
import ru.cbdd.fvf.interfaces.iproviders.IComplexDBProvider;

import java.util.List;

@Component
public class ComplexDBProvider implements IComplexDBProvider {
    private final Sql2o sql2o;

    private static final String SELECT_ALL_COMPLEX = "select * from complex";

    public ComplexDBProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<ComplexDB> findAll() {
        try (Connection connection = sql2o.open()){
            return connection.createQuery(SELECT_ALL_COMPLEX, false)
                    .setColumnMappings(ComplexDB.COLUMN_MAPPINGS)
                    .executeAndFetch(ComplexDB.class);
        }
    }
}
