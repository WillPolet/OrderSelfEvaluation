package com.switchfully.eurder.user.service.dto;

import com.switchfully.eurder.user.domain.attributes.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class CreateCustomerDto {
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
    @NotEmpty(message = "Please provide a phone number for user.")
    @Pattern(regexp = "^\\+?\\d{10,14}$", message = "Phone number must be between 10 and 14 digits long.")
    private String phoneNumber;

    public CreateCustomerDto(String firstname, String lastname, Address address, String email, String password, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phoneNumber=phoneNumber;
    }
}
