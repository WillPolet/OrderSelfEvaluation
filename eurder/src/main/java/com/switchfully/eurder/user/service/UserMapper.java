package com.switchfully.eurder.user.service;

import com.switchfully.eurder.user.domain.User;
import com.switchfully.eurder.user.domain.attributes.Role;
import com.switchfully.eurder.user.service.dto.CreateUserDto;
import com.switchfully.eurder.user.service.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        return new UserDto(
        user.getId(),
        user.getFirstname(),
        user.getLastname(),
        user.getAddress(),
        user.getEmail(),
        user.getRole());
    }

    public List<UserDto> toDto(List<User> users) {
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }
    public User fromDto(CreateUserDto createUserDto, Role role) { //Could check there if the email is already in use && if I need to create an admin.
        return new User(
        createUserDto.getFirstname(),
        createUserDto.getLastname(),
        createUserDto.getAddress(),
        createUserDto.getEmail(), createUserDto.getPassword(), role);
    }
}
