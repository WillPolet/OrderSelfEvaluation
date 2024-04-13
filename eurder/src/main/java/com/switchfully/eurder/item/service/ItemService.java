package com.switchfully.eurder.item.service;

import com.switchfully.eurder.exception.ItemAlreadyExistException;
import com.switchfully.eurder.item.domain.Item;
import com.switchfully.eurder.item.domain.ItemRepository;
import com.switchfully.eurder.item.service.dto.CreateItemDto;
import com.switchfully.eurder.item.service.dto.ItemDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;

    public ItemService(ItemMapper itemMapper, ItemRepository itemRepository) {
        this.itemMapper = itemMapper;
        this.itemRepository = itemRepository;
    }

    public ItemDto createItem(CreateItemDto createItemDto) {
        if (itemRepository.itemExists(createItemDto)) {
            throw new ItemAlreadyExistException("Item with this name already exists.");
        }
        Item item = itemMapper.fromDto(createItemDto);
        itemRepository.saveItem(item);
        return itemMapper.toDto(item);
    }

    public List<ItemDto> getAllItems() {
        return itemMapper.toDto(itemRepository.getAllItems().stream().toList());
    }

    public boolean checkAvailibility(String itemId, int amount) {
        return itemRepository.checkAvailibility(itemId, amount);
    }
}
