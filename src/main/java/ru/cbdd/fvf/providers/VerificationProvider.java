package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.entitys.Verification;
import ru.cbdd.fvf.interfaces.iproviders.IVerificationProvider;

@Component
public class VerificationProvider implements IVerificationProvider {
    private final Sql2o sql2o;

    private static final String SELECT_VERIFICATION_BY_ID = "select * from verification where id = :id";

    public VerificationProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Verification findById(Long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_VERIFICATION_BY_ID, false)
                    .addParameter("id", id)
                    .setColumnMappings(Verification.COLUMN_MAPPINGS)

                    .executeAndFetchFirst(Verification.class);
        }
    }
}
