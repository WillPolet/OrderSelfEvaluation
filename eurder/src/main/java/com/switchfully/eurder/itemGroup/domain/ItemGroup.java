package com.switchfully.eurder.itemGroup.domain;

import com.switchfully.eurder.item.service.ItemService;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    ItemService itemService;

    private String itemGroupId;
    private String itemId;
    private int amount;

    private String customerId;

    private LocalDate shippingDate;

    public ItemGroup(String itemId, int amount, String customerId) {
        this.itemGroupId = UUID.randomUUID().toString();
        this.itemId = itemId;
        this.amount = amount;
        this.customerId = customerId;
        if (availibility()){
            this.shippingDate = LocalDate.now().plusDays(1);
        } else {
            this.shippingDate = LocalDate.now().plusDays(7);
        }
    }

    public String getItemGroupId() {
        return itemGroupId;
    }
    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    private boolean availibility(){
        return itemService.checkAvailibility(itemId, amount);
    }
}
