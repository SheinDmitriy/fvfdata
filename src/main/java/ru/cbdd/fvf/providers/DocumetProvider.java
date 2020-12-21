package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.entitys.Document;
import ru.cbdd.fvf.interfaces.iproviders.IDocumentProvider;

import java.util.List;

@Component
public class DocumetProvider implements IDocumentProvider {
    private final Sql2o sql2o;

    private static final String SELECT_DOCUMENTS_BY_COMPLEX_ID = "select documents.* from documents join complex_docs where complex_docs.complex_id = :c_id and complex_docs.docs_id = documents.id";

    public DocumetProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Document> findById(Long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_DOCUMENTS_BY_COMPLEX_ID, false)
                    .addParameter("c_id", id)
                    .setColumnMappings(Document.COLUMN_MAPPINGS)
                    .executeAndFetch(Document.class);
        }
    }
}
