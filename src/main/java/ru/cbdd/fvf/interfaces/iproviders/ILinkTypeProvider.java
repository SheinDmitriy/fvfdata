package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.LinkType;

public interface ILinkTypeProvider {

    LinkType findById (Long id);
}
