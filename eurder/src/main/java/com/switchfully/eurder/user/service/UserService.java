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
        return createUser(createUserDto, Role.CUSTOMER);
    }

    // ctrl alt m (for method and intelliJ saw the duplication)
    public UserDto createAdminUser(CreateUserDto createUserDto) {
        return createUser(createUserDto, Role.ADMIN);
    }

    private UserDto createUser(CreateUserDto createUserDto, Role customer) {
        if (userRepository.emailExist(createUserDto.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }
        User user = userMapper.fromDto(createUserDto, customer);
        userRepository.saveUser(user);
        return userMapper.toDto(user);
    }
}
