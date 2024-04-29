package com.switchfully.eurder.Eurder;

import com.switchfully.eurder.itemGroup.domain.ItemGroup;
import com.switchfully.eurder.user.domain.Customer;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "eurder")
@Getter
public class Eurder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "eurder_id")
    private UUID eurderId;
    @ManyToOne
    @JoinColumn(referencedColumnName = "customer_id")
    private Customer customer;

    public Eurder(UUID eurderId, Customer customer) {
        this.eurderId = eurderId;
        this.customer = customer;
    }

    public Eurder() {
    }
}
