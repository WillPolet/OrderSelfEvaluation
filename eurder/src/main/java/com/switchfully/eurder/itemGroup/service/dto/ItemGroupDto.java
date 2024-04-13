package com.switchfully.eurder.itemGroup.service.dto;

public class ItemGroupDto {
    private String itemGroupId;
    private String itemId;
    private int amount;
    private String customerId;
    private String shippingDate;

    public ItemGroupDto(String itemGroupId, String itemId, int amount, String customerId, String shippingDate) {
        this.itemGroupId = itemGroupId;
        this.itemId = itemId;
        this.amount = amount;
        this.customerId = customerId;
        this.shippingDate = shippingDate;
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

    public String getCustomerId() {
        return customerId;
    }

    public String getShippingDate() {
        return shippingDate;
    }
}
