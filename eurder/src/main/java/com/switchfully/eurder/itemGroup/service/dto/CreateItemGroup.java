package com.switchfully.eurder.itemGroup.service.dto;

import jakarta.validation.constraints.NotEmpty;

public class CreateItemGroup {
    @NotEmpty(message = "Item id of item is required for creation of ItemGroup.")
    private String itemId;
    @NotEmpty(message = "Amount is required for creation of ItemGroup.")
    private int amount;


    public CreateItemGroup() {
    }

    public CreateItemGroup(String itemId, int amount) {
        this.itemId = itemId;
        this.amount = amount;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }
}
