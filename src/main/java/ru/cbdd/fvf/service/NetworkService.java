package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.entitys.Network;
import ru.cbdd.fvf.entitys.NetworkDB;
import ru.cbdd.fvf.interfaces.iproviders.INetworkProvider;

@Service
public class NetworkService {
    
    private INetworkProvider networkProvider;
    private LinkTypeService linkTypeService;
    private OperatorService operatorService;

    @Autowired
    public NetworkService(INetworkProvider networkProvider, LinkTypeService linkTypeService, OperatorService operatorService) {
        this.networkProvider = networkProvider;
        this.linkTypeService = linkTypeService;
        this.operatorService = operatorService;
    }

    public Network findById(Long id) {
        return makeNetwork(networkProvider.findById(id));
    }

    private Network makeNetwork(NetworkDB networkDB) {
       return Network.builder()
                    .id(networkDB.getId())
                    .ipAddress(networkDB.getIpAddress())
                    .mask(networkDB.getMask())
                    .gateway(networkDB.getGateway())
                    .linkType(linkTypeService.findById(networkDB.getLinkType_id()))
                    .operator(operatorService.findById(networkDB.getOperator_id()))
                    .build();
    }
}
