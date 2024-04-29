//package com.switchfully.eurder.user.service;
//
//import com.switchfully.eurder.user.domain.Customer;
//import com.switchfully.eurder.user.domain.attributes.Role;
//import com.switchfully.eurder.user.service.dto.CreateUserDto;
//import com.switchfully.eurder.user.service.dto.UserDto;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class UserMapper {
//    public UserDto toDto(Customer customer) {
//        return new UserDto(
//        customer.getId(),
//        customer.getFirstname(),
//        customer.getLastname(),
//        customer.getAddress(),
//        customer.getEmail()
//    }
//
//    public List<UserDto> toDto(List<Customer> customers) {
//        return customers.stream().map(this::toDto).collect(Collectors.toList());
//    }
//    public Customer fromDto(CreateUserDto createUserDto, Role role) { //Could check there if the email is already in use && if I need to create an admin.
//        return new Customer(
//        createUserDto.getFirstname(),
//        createUserDto.getLastname(),
//        createUserDto.getAddress(),
//        createUserDto.getEmail(), createUserDto.getPassword(), role);
//    }
//}
