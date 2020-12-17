package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.entitys.Operator;
import ru.cbdd.fvf.interfaces.iproviders.IOperatorProvider;

@Component
public class OperatorProvider implements IOperatorProvider {
    private final Sql2o sql2o;

    private static final String SELECT_OPERATOR_BY_ID = "select * from operator where id = :id";

    public OperatorProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Operator findById(Long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_OPERATOR_BY_ID, false)
                    .addParameter("id", id)
                    .setColumnMappings(Operator.COLUMN_MAPPINGS)
                    .executeAndFetchFirst(Operator.class);
        }
    }
}
