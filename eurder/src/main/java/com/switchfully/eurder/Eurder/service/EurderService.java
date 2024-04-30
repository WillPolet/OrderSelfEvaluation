package com.switchfully.eurder.Eurder.service;

import com.switchfully.eurder.Eurder.domain.Eurder;
import com.switchfully.eurder.Eurder.domain.EurderRepository;
import com.switchfully.eurder.Eurder.service.dto.CreateEurderDto;
import com.switchfully.eurder.Eurder.service.dto.EurderDto;
import com.switchfully.eurder.itemGroup.service.ItemGroupService;
import com.switchfully.eurder.itemGroup.service.dto.ItemGroupDto;
import com.switchfully.eurder.user.domain.Customer;
import com.switchfully.eurder.user.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EurderService {

    private EurderRepository eurderRepository;
    private ItemGroupService itemGroupService;

    public EurderService(EurderRepository eurderRepository, ItemGroupService itemGroupService) {
        this.eurderRepository = eurderRepository;
        this.itemGroupService = itemGroupService;
    }

    public EurderDto createEurder(CreateEurderDto createEurderDto, User connectedUser) {
        // 1) créer l'order sans les itemGroup
        Eurder eurder = new Eurder((Customer) connectedUser); //Not sure about downcasting even if the User is for sure a Customer at this point
        eurderRepository.save(eurder);
        List<ItemGroupDto> itemGroupDtos = itemGroupService.createItemGroups(createEurderDto.getListOfItemGroup(), eurder, (Customer) connectedUser);
    }
}
