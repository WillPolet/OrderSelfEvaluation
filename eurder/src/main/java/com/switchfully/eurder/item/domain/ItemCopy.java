package com.switchfully.eurder.item.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class ItemCopy {
    @ManyToOne
    private Item orignalItem;
    private String name;
    private double price;
    private String description;

    public ItemCopy() {
    }

    public ItemCopy(Item orignalItem, String name, double price, String description) {
        this.orignalItem = orignalItem;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
