package com.switchfully.eurder.user.service.dto;

import com.switchfully.eurder.user.domain.attributes.Address;
import com.switchfully.eurder.user.domain.attributes.Role;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class CreateUserDto {
    @NotEmpty(message = "Please provide a firstname for user.")
    private String firstname;
    @NotEmpty(message = "Please provide a lastname for user.")
    private String lastname;
    @Valid
    private Address address;
    @NotEmpty(message = "Please provide a email for user.")
    @Email(message = "Email invalid. Provide name@domain.com")
    private String email;
    @NotEmpty(message = "You must provide a password.")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).{7,}$", message = "Password must contain at least 1 uppercase letter, 1 digit and be at least 7 characters long.")
    private String password;

    public CreateUserDto(String firstname, String lastname,Address address, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }
}
