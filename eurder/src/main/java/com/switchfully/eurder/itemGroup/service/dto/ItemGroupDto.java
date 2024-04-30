package com.switchfully.eurder.itemGroup.service.dto;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroupDto {
    private String itemGroupId;
    private UUID itemId;
    private int amount;
    private UUID customerId;
    private LocalDate shippingDate;

    public ItemGroupDto(String itemGroupId, UUID itemId, int amount, UUID customerId, LocalDate shippingDate) {
        this.itemGroupId = itemGroupId;
        this.itemId = itemId;
        this.amount = amount;
        this.customerId = customerId;
        this.shippingDate = shippingDate;
    }

    public String getItemGroupId() {
        return itemGroupId;
    }
    public UUID getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
