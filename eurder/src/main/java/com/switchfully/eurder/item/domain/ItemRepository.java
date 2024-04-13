package com.switchfully.eurder.item.domain;

import com.switchfully.eurder.item.service.dto.CreateItemDto;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {
    private Map<String,Item> items;

    public ItemRepository() {
        this.items = new ConcurrentHashMap<>();
    }

    // It's a choice to only check on the name, should ask client more information about field that should be unique.
    public boolean itemExists(CreateItemDto createItemDto) {
        return items.values().stream()
                .anyMatch(item -> item.getName().equals(createItemDto.getName()));
    }

    public void saveItem(Item item) {
        items.put(item.getId(), item);
    }

    public Collection<Item> getAllItems() {
        return items.values();
    }

    public boolean checkAvailibility(String itemId, int amount) {
        return items.get(itemId).getAmount() >= amount;
    }
}
