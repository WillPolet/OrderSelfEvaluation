package com.switchfully.eurder.user.service;

import com.switchfully.eurder.user.domain.Customer;
import com.switchfully.eurder.user.service.dto.CreateCustomerDto;
import com.switchfully.eurder.user.service.dto.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public CustomerDto toDto(Customer customer) {
        return new CustomerDto(
        customer.getId(),
        customer.getFirstname(),
        customer.getLastname(),
        customer.getAddress(),
        customer.getEmail(),
        customer.getPhoneNumber()
        );
    }

    public List<CustomerDto> toDto(List<Customer> customers) {
        return customers.stream().map(this::toDto).collect(Collectors.toList());
    }
    public Customer fromDto(CreateCustomerDto createUserDto) {
        return new Customer(
        createUserDto.getFirstname(),
        createUserDto.getLastname(),
        createUserDto.getAddress(),
        createUserDto.getEmail(),
        createUserDto.getPassword(),
        createUserDto.getPhoneNumber()
        );
    }
}
