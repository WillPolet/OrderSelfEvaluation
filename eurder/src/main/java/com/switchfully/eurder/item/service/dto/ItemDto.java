package com.switchfully.eurder.item.service.dto;

import java.util.UUID;

public class ItemDto {
    private UUID id;
    private String name;
    private String description;
    private double price;
    private int amount;

    public ItemDto() {
    }

    public ItemDto(UUID id, String name, String description, double price, int amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
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
