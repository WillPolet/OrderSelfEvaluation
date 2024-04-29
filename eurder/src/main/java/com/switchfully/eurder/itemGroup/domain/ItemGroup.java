package com.switchfully.eurder.itemGroup.domain;

import com.switchfully.eurder.Eurder.Eurder;
import com.switchfully.eurder.item.domain.Item;
import com.switchfully.eurder.item.domain.ItemCopy;
import com.switchfully.eurder.user.domain.Customer;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
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
    private ItemCopy itemCopy;            ;
    private int amount;
    @ManyToOne
    @JoinColumn(referencedColumnName = "customer_id", name = "customer")
    private Customer customer;
    @Column(name = "shipping_date")
    private LocalDate shippingDate;
    @ManyToOne
    @JoinColumn(referencedColumnName = "eurder_id",name = "associatedOrder")
    private Eurder eurder;

    public ItemGroup(ItemCopy itemCopy, int amount, Customer customer, LocalDate shippingDate) {
        this.itemCopy = itemCopy;
        this.amount = amount;
        this.customer = customer;
        this.shippingDate = shippingDate;
    }

    public ItemGroup() {
    }
}
