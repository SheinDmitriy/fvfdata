package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.interfaces.iproviders.ILinkTypeProvider;

@Component
public class LinkTypeProvider implements ILinkTypeProvider {
    private final Sql2o sql2o;

    public LinkTypeProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }
}