package com.switchfully.eurder.itemGroup.domain;

import com.switchfully.eurder.Eurder.domain.Eurder;
import com.switchfully.eurder.item.domain.ItemCopy;
import com.switchfully.eurder.user.domain.Customer;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "item_group")
@Getter
public class ItemGroup {
    @Id
    @Column(name = "item_group_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Embedded
    private ItemCopy itemCopy;           ;
    private int amount;
    @ManyToOne
    @JoinColumn(referencedColumnName = "customer_id", name = "customer")
    private Customer customer;
    @Column(name = "shipping_date")
    private LocalDate shippingDate;
    @ManyToOne
    @JoinColumn(referencedColumnName = "eurder_id",name = "associatedOrder")
    private Eurder eurder;

    public ItemGroup(ItemCopy itemCopy, int amount, Customer customer, LocalDate shippingDate, Eurder eurder) {
        this.itemCopy = itemCopy;
        this.amount = amount;
        this.customer = customer;
        this.shippingDate = shippingDate;
        this.eurder = eurder;
    }

    public ItemGroup() {
    }

    public UUID getIdOfItem(){
        return this.itemCopy.getOrignalItem().getId();
    }

    public UUID getCustomerId(){
        return this.customer.getId();
    }
}
