package com.switchfully.eurder.user.service.dto;

import com.switchfully.eurder.user.domain.attributes.Address;
import com.switchfully.eurder.user.domain.attributes.Role;

public class UserDto {
    private String id;
    private String firstname;
    private String lastname;

    private Address address;
    private String email;
    private Role role;

    public UserDto(String id, String firstname, String lastname, Address address, String email, Role role) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.role = role;
    }

    public String getId() {
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

    public Role getRole() {
        return role;
    }
}
