package com.switchfully.eurder.itemGroup.domain;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemGroupRepository {
    private Map<String, ItemGroup> itemGroupRepo;
    public ItemGroupRepository() {
        this.itemGroupRepo = new ConcurrentHashMap<>();
    }

    public void saveItemGroup(ItemGroup itemGroup) {
        itemGroupRepo.put(itemGroup.getId(), itemGroup);
    }



}
