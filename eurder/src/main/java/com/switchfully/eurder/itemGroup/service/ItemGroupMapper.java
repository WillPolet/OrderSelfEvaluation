//package com.switchfully.eurder.itemGroup.service;
//
//import com.switchfully.eurder.item.domain.Item;
//import com.switchfully.eurder.item.service.dto.ItemDto;
//import com.switchfully.eurder.itemGroup.domain.ItemGroup;
//import com.switchfully.eurder.itemGroup.service.dto.CreateItemGroup;
//import com.switchfully.eurder.itemGroup.service.dto.ItemGroupDto;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ItemGroupMapper {
//    public ItemGroupDto toDto(ItemGroup itemGroup) {
//        return new ItemGroupDto(itemGroup.getItemGroupId(), itemGroup.getItemId(), itemGroup.getAmount(), itemGroup.getShippingDate().toString(), itemGroup.getCustomerId());
//    }
//
//    public ItemGroup fromDto(CreateItemGroup createItemGroup, String customerId) {
//        return new ItemGroup(createItemGroup.getItemId(), createItemGroup.getAmount(), customerId);
//    }
//}
