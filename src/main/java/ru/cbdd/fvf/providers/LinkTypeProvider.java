package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.entitys.LinkType;
import ru.cbdd.fvf.interfaces.iproviders.ILinkTypeProvider;

@Component
public class LinkTypeProvider implements ILinkTypeProvider {
    private final Sql2o sql2o;

    private static final String SELECT_LINKTYPE_BY_ID = "select * from link_type where id = :id";

    public LinkTypeProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public LinkType findById(Long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_LINKTYPE_BY_ID, false)
                    .addParameter("id", id)
                    .setColumnMappings(LinkType.COLUMN_MAPPINGS)
                    .executeAndFetchFirst(LinkType.class);
        }
    }
}
