package com.switchfully.eurder.itemGroup.domain;

import com.switchfully.eurder.item.service.ItemService;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    //Maybe add a field to say if it has been ordered to keep a track of itemGroup ordrered in DB ?
    ItemService itemService;

    private String itemGroupId;
    private String itemId;
    private int amount;

    private String customerId;

    private LocalDate shippingDate;

    private boolean ordered;

    public ItemGroup(String itemId, int amount, String customerId) {
        this.itemGroupId = UUID.randomUUID().toString();
        this.itemId = itemId;
        this.amount = amount;
        this.customerId = customerId;
        if (availability()){
            this.shippingDate = LocalDate.now().plusDays(1);
        } else {
            this.shippingDate = LocalDate.now().plusDays(7);
        }
        this.ordered = false;
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

    private boolean availability(){
        return itemService.checkAvailibility(itemId, amount);
    }

    public String getId() {
        return itemGroupId;
    }

    public boolean isOrdered() {
        return ordered;
    }
}
