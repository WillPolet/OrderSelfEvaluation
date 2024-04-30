package com.switchfully.eurder.user.service.dto;

import com.switchfully.eurder.user.domain.attributes.Address;
import com.switchfully.eurder.user.domain.attributes.Role;

import java.util.UUID;

public class CustomerDto {
    private UUID id;
    private String firstname;
    private String lastname;

    private Address address;
    private String email;
    private String phoneNumber;

    public CustomerDto(UUID id, String firstname, String lastname, Address address, String email, String phoneNumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
