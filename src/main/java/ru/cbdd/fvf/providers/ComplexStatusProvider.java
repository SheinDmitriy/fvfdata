package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.entitys.ComplexStatus;
import ru.cbdd.fvf.interfaces.iproviders.IComplexStatusProvider;

@Component
public class ComplexStatusProvider implements IComplexStatusProvider {
    private final Sql2o sql2o;

    private static final String SELECT_STATUS_BY_ID = "select * from complex_status where id = :id";

    public ComplexStatusProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public ComplexStatus findById(Long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_STATUS_BY_ID, false)
                    .addParameter("id", id)
                    .setColumnMappings(ComplexStatus.COLUMN_MAPPINGS)
                    .executeAndFetchFirst(ComplexStatus.class);
        }
    }
}
