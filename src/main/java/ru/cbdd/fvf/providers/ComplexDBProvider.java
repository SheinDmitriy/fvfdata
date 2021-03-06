package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.entitys.Complex;
import ru.cbdd.fvf.entitys.ComplexDB;
import ru.cbdd.fvf.interfaces.iproviders.IComplexDBProvider;

import java.util.List;

@Component
public class ComplexDBProvider implements IComplexDBProvider {
    private final Sql2o sql2o;

    private static final String SELECT_ALL_COMPLEX = "select * from complex";

    private static final String SELECT_COMPLEX_BY_ID = "select * from complex where id = :id";

    private static final String SELECT_COMPLEX_BY_SN = "select * from complex where series_number = :sn";

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

    @Override
    public ComplexDB findBySN(String sn) {
        try (Connection connection = sql2o.open()){
            return connection.createQuery(SELECT_COMPLEX_BY_SN, false)
                    .addParameter("sn", sn)
                    .setColumnMappings(ComplexDB.COLUMN_MAPPINGS)
                    .executeAndFetchFirst(ComplexDB.class);
        }
    }

    @Override
    public ComplexDB findById(Long id) {
        try (Connection connection = sql2o.open()){
            return connection.createQuery(SELECT_COMPLEX_BY_ID, false)
                    .addParameter("id", id)
                    .setColumnMappings(ComplexDB.COLUMN_MAPPINGS)
                    .executeAndFetchFirst(ComplexDB.class);
        }
    }
}
