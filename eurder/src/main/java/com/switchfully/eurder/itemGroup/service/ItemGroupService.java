package com.switchfully.eurder.itemGroup.service;

import com.switchfully.eurder.Eurder.domain.Eurder;
import com.switchfully.eurder.Eurder.service.dto.CreateEurderDto;
import com.switchfully.eurder.item.domain.Item;
import com.switchfully.eurder.item.domain.ItemCopy;
import com.switchfully.eurder.item.service.ItemService;
import com.switchfully.eurder.itemGroup.domain.ItemGroup;
import com.switchfully.eurder.itemGroup.domain.ItemGroupRepository;
import com.switchfully.eurder.itemGroup.service.dto.CreateItemGroupDto;
import com.switchfully.eurder.itemGroup.service.dto.ItemGroupDto;
import com.switchfully.eurder.user.domain.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ItemGroupService {
    private ItemService itemService;

    private ItemGroupRepository itemGroupRepository;
    private ItemGroupMapper itemGroupMapper;

    public ItemGroupService(ItemService itemService, ItemGroupRepository itemGroupRepository, ItemGroupMapper itemGroupMapper) {
        this.itemService = itemService;
        this.itemGroupRepository = itemGroupRepository;
        this.itemGroupMapper = itemGroupMapper;
    }

    public List<ItemGroupDto> createItemGroups(List<CreateItemGroupDto> itemGroupsDto, Eurder eurder, Customer customer) {
        return itemGroupsDto.stream()
                .map(createItemGroupDto -> {
                    Item item = itemService.findItemById(UUID.fromString(createItemGroupDto.getItemId()));
                    ItemCopy itemCopy = new ItemCopy(item, item.getName(), item.getPrice(), item.getDescription());
                    LocalDate dateOfShipping = (item.getStock() - createItemGroupDto.getAmount() >= 0)
                            ? LocalDate.now().plusDays(1)
                            : LocalDate.now().plusWeeks(1);
                    ItemGroup itemGroup = new ItemGroup(itemCopy, createItemGroupDto.getAmount(), customer, dateOfShipping, eurder);
                    itemGroupRepository.save(itemGroup);
                    return itemGroupMapper.toDto(itemGroup);
                })
                .collect(Collectors.toList());
    }
}
