package com.switchfully.eurder.user.domain;

import com.switchfully.eurder.user.domain.attributes.Address;
import com.switchfully.eurder.user.domain.attributes.Rights;
import com.switchfully.eurder.user.domain.attributes.Role;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;
@Entity
@Getter
@Table(name = "customer")
public class Customer implements User {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "address_id", name = "address")
    private Address address;
    @Column(name = "password")
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;

    public Customer() {
    }

    public Customer(String firstname, String lastname, Address address, String email, String password, String phoneNumber) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
    public boolean passwordMatch(String pwd){
        return password.equals(pwd);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(firstname, customer.firstname) && Objects.equals(lastname, customer.lastname) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, email, password);
    }
}


