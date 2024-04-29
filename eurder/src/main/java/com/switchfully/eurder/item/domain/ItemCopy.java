package com.switchfully.eurder.item.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Embeddable
@Getter
public class ItemCopy {
    private String name;
    private double price;
    private String description;

    public ItemCopy() {
    }
}
