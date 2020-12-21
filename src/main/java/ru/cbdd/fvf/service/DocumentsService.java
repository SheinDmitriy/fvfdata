package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.entitys.Document;
import ru.cbdd.fvf.interfaces.iproviders.IDocumentProvider;

import java.util.List;

@Service
public class DocumentsService {

    private IDocumentProvider documentProvider;

    @Autowired
    public DocumentsService(IDocumentProvider documentProvider) {
        this.documentProvider = documentProvider;
    }

    public List<Document> findById(Long id) {
        return documentProvider.findById(id);
    }
}
