package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.entitys.Complex;
import ru.cbdd.fvf.interfaces.iproviders.IComplexProvider;

import java.util.List;

@Component
public class ComplexProvider implements IComplexProvider {
    private final Sql2o sql2o;

    private static final String SELECT_ALL_COMPLEX = "select * from complex";

    public ComplexProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Complex> findAll() {
        try (Connection connection = sql2o.open()){
            return connection.createQuery(SELECT_ALL_COMPLEX, false)
                    .setColumnMappings(Complex.COLUMN_MAPPINGS)
                    .executeAndFetch(Complex.class);
        }
    }
}
