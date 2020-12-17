package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.entitys.ComplexMark;
import ru.cbdd.fvf.interfaces.iproviders.IComplexMarkProvider;

@Component
public class ComplexMarkProvider implements IComplexMarkProvider {
    private final Sql2o sql2o;

    private static final String SELECT_MARK_BY_ID = "select * from complex_mark where id = :id";

    public ComplexMarkProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public ComplexMark findById(Long id) {
        try (Connection connection = sql2o.open()){
            return connection.createQuery(SELECT_MARK_BY_ID, false)
                    .addParameter("id", id)
                    .setColumnMappings(ComplexMark.COLUMN_MAPPINGS)
                    .executeAndFetchFirst(ComplexMark.class);
        }
    }
}
