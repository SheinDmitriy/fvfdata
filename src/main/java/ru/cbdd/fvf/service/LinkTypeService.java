package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.entitys.LinkType;
import ru.cbdd.fvf.interfaces.iproviders.ILinkTypeProvider;

@Service
public class LinkTypeService {

    private ILinkTypeProvider linkTypeProvider;

    @Autowired
    public LinkTypeService(ILinkTypeProvider linkTypeProvider) {
        this.linkTypeProvider = linkTypeProvider;
    }


    public LinkType findById(Long id) {
        return linkTypeProvider.findById(id);
    }
}
