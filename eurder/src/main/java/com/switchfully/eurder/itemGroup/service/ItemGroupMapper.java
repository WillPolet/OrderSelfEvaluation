package com.switchfully.eurder.itemGroup.service;

import com.switchfully.eurder.itemGroup.domain.ItemGroup;
import com.switchfully.eurder.itemGroup.service.dto.CreateItemGroupDto;
import com.switchfully.eurder.itemGroup.service.dto.ItemGroupDto;
import org.springframework.stereotype.Component;

@Component
public class ItemGroupMapper {
    public ItemGroupDto toDto(ItemGroup itemGroup) {
        return new ItemGroupDto(itemGroup.getId(), itemGroup.getItemId(), itemGroup.getAmount(), itemGroup.getCustomerId(), itemGroup.getShippingDate().toString());
    }



    public ItemGroup fromDto(CreateItemGroupDto createItemGroupDto, String customerId) {
        return new ItemGroup(createItemGroupDto.getItemId(), createItemGroupDto.getAmount(), customerId);
    }
}
