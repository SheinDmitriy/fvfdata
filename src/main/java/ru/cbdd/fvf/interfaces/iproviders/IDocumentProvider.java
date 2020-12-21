package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.Document;

import java.util.List;

public interface IDocumentProvider {
    List<Document> findById(Long id);
}
