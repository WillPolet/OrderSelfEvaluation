package com.switchfully.eurder.item.service.dto;

import jakarta.validation.constraints.NotEmpty;

public class CreateItemDto {
    @NotEmpty(message = "Name is required for creation ot Item.")
    private String name;
    @NotEmpty(message = "Description is required for creation ot Item.")
    private String description;
    @NotEmpty(message = "Price is required for creation ot Item.")
    private double price;
    @NotEmpty(message = "Amount is required for creation ot Item.")
    private int amount;

    public CreateItemDto() {
    }

    public CreateItemDto(String name, String description, double price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
