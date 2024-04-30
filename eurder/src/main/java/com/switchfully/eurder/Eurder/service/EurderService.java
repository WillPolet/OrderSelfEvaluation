package com.switchfully.eurder.Eurder.service;

import com.switchfully.eurder.Eurder.domain.Eurder;
import com.switchfully.eurder.Eurder.domain.EurderRepository;
import com.switchfully.eurder.Eurder.service.dto.CreateEurderDto;
import com.switchfully.eurder.Eurder.service.dto.EurderDto;
import com.switchfully.eurder.item.service.ItemService;
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

    private ItemService itemService;

    private EurderMapper eurderMapper;

    public EurderService(EurderRepository eurderRepository, ItemGroupService itemGroupService, ItemService itemService, EurderMapper eurderMapper) {
        this.eurderRepository = eurderRepository;
        this.itemGroupService = itemGroupService;
        this.itemService = itemService;
        this.eurderMapper = eurderMapper;
    }

    public EurderDto createEurder(CreateEurderDto createEurderDto, User connectedUser) {
        Eurder eurder = new Eurder((Customer) connectedUser); //Not sure about downcasting even if the User is for sure a Customer at this point
        eurderRepository.save(eurder);
        List<ItemGroupDto> itemGroupDtos = itemGroupService.createItemGroups(createEurderDto.getListOfItemGroup(), eurder, (Customer) connectedUser);
        //Need to calculate total price to put in eurder
        double totalPrice = getTotalPrice(itemGroupDtos);
        return eurderMapper.toDto(eurder, totalPrice);
    }

    private double getTotalPrice(List<ItemGroupDto> itemGroupDtos) {
        double totalPrice = 0;
        for (ItemGroupDto itemGroupDto : itemGroupDtos){
            double priceOfItem = itemService.getPriceById(itemGroupDto.getItemId());
            totalPrice += itemGroupDto.getAmount() * priceOfItem;
        }
        return totalPrice;
    }
}
