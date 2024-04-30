package com.switchfully.eurder.itemGroup.service;

import com.switchfully.eurder.itemGroup.domain.ItemGroup;
import com.switchfully.eurder.itemGroup.service.dto.CreateItemGroupDto;
import com.switchfully.eurder.itemGroup.service.dto.ItemGroupDto;
import com.switchfully.eurder.user.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class ItemGroupMapper {
    public ItemGroupDto toDto(ItemGroup itemGroup) { //Second field, too much get (weird) and it should have a problem of type between UUID and String
        return new ItemGroupDto(
                itemGroup.getId(),
                itemGroup.getIdOfItem(),
                itemGroup.getAmount(),
                itemGroup.getCustomerId(),
                itemGroup.getShippingDate()
        );
    }



//    public ItemGroup fromDto(CreateItemGroupDto createItemGroupDto, String customerId) {
//        return new ItemGroup(createItemGroupDto.getItemId(), createItemGroupDto.getAmount(), customerId);
//    }
}
