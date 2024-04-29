package com.switchfully.eurder.user.service;

import com.switchfully.eurder.user.domain.Customer;
import com.switchfully.eurder.user.domain.UserRepository;
import com.switchfully.eurder.user.domain.attributes.Role;
import com.switchfully.eurder.user.service.dto.CreateCustomerDto;
import com.switchfully.eurder.user.service.dto.UserDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public UserDto createCustomerUser(CreateCustomerDto createCustomerDto) {
        return createUser(createCustomerDto, Role.CUSTOMER);
    }

    // ctrl alt m (for method and intelliJ saw the duplication)
    public UserDto createAdminUser(CreateCustomerDto createCustomerDto) {
        return createUser(createCustomerDto, Role.ADMIN);
    }

    private UserDto createUser(CreateCustomerDto createCustomerDto, Role customer) {
        if (userRepository.emailExist(createCustomerDto.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }
        Customer user = userMapper.fromDto(createCustomerDto, customer);
        userRepository.saveUser(user);
        return userMapper.toDto(user);
    }
}
