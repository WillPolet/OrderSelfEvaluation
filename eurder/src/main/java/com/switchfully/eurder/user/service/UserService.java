package com.switchfully.eurder.user.service;

import com.switchfully.eurder.user.domain.User;
import com.switchfully.eurder.user.domain.UserRepository;
import com.switchfully.eurder.user.domain.attributes.Role;
import com.switchfully.eurder.user.service.dto.CreateUserDto;
import com.switchfully.eurder.user.service.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public UserDto createCustomerUser(CreateUserDto createUserDto) {
        if (userRepository.emailExist(createUserDto.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }
        User user = userMapper.fromDto(createUserDto, Role.CUSTOMER);
        userRepository.saveUser(user);
        return userMapper.toDto(user);
    }

    public UserDto createAdminUser(CreateUserDto createUserDto) {
        if (userRepository.emailExist(createUserDto.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }
        User user = userMapper.fromDto(createUserDto, Role.ADMIN);
        userRepository.saveUser(user);
        return userMapper.toDto(user);
    }
}
