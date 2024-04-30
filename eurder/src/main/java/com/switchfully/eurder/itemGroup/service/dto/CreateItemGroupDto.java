package com.switchfully.eurder.itemGroup.service.dto;

import jakarta.validation.constraints.NotEmpty;

public class CreateItemGroupDto {
    @NotEmpty(message = "Item id of item is required for creation of ItemGroup.")
    private String itemId;
    @NotEmpty(message = "Amount is required for creation of ItemGroup.")
    private int amount;


    public CreateItemGroupDto() {
    }

    public CreateItemGroupDto(String itemId, int amount) {
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
