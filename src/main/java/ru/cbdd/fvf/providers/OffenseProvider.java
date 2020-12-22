package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.entitys.Offense;
import ru.cbdd.fvf.interfaces.iproviders.IOffenseProvider;

import java.util.List;

@Component
public class OffenseProvider implements IOffenseProvider {
    private final Sql2o sql2o;

    private static final String SELECT_OFFENSE_BY_COMPLEX_ID = "select offense.* from offense join complex_offense where complex_offense.complex_id = :c_id and complex_offense.offense_id = offense.id";

    public OffenseProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Offense> findById(Long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_OFFENSE_BY_COMPLEX_ID, false)
                    .addParameter("c_id", id)
                    .setColumnMappings(Offense.COLUMN_MAPPINGS)
                    .executeAndFetch(Offense.class);
        }
    }
}
