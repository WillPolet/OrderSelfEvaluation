package com.switchfully.eurder.item.service;

import com.switchfully.eurder.exception.ItemAlreadyExistException;
import com.switchfully.eurder.item.domain.Item;
import com.switchfully.eurder.item.domain.ItemRepository;
import com.switchfully.eurder.item.service.dto.CreateItemDto;
import com.switchfully.eurder.item.service.dto.ItemDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ItemService {

    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;

    public ItemService(ItemMapper itemMapper, ItemRepository itemRepository) {
        this.itemMapper = itemMapper;
        this.itemRepository = itemRepository;
    }

    public ItemDto createItem(CreateItemDto createItemDto) {
        if (itemRepository.findByName(createItemDto.getName()).isPresent()) {
            throw new ItemAlreadyExistException("Item with this name already exists.");
        }
        Item item = itemMapper.fromDto(createItemDto);
        itemRepository.save(item);
        return itemMapper.toDto(item);
    }

    public List<ItemDto> getAllItems() {
        return itemMapper.toDto(itemRepository.findAll());
    }

    public Item findItemById(UUID itemId) {
        return itemRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("Item with id " + itemId + " not found."));
    }

    public double getPriceById(UUID itemId) {
        return itemRepository.getPriceById(itemId);
    }

//    public boolean checkAvailibility(String itemId, int amount) {
//        return itemRepository.checkAvailibility(itemId, amount);
//    }
}
