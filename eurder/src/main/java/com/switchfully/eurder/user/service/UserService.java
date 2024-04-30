package com.switchfully.eurder.user.service;

import com.switchfully.eurder.user.domain.AdminRepository;
import com.switchfully.eurder.user.domain.Customer;
import com.switchfully.eurder.user.domain.CustomerRepository;
import com.switchfully.eurder.user.domain.attributes.Role;
import com.switchfully.eurder.user.service.dto.CreateCustomerDto;
import com.switchfully.eurder.user.service.dto.CustomerDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    private CustomerRepository customerRepository;
    private AdminRepository adminRepository;

    private CustomerMapper customerMapper;

    public UserService(CustomerRepository customerRepository, AdminRepository adminRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.adminRepository = adminRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto createCustomerUser(CreateCustomerDto createCustomerDto) {
        if(verifyIfEmailAlreadyExist(createCustomerDto.getEmail())){
            throw new IllegalArgumentException("Email already in use, please provide another.");
        }
        Customer customer = customerMapper.fromDto(createCustomerDto);
        customerRepository.save(customer);
        return customerMapper.toDto(customer);
    }

    private boolean verifyIfEmailAlreadyExist(String email) {
        return customerRepository.findByEmail(email).isPresent() || adminRepository.findByEmail(email).isPresent();
    }

    // ctrl alt m (for method and intelliJ saw the duplication)
//    public UserDto createAdminUser(CreateCustomerDto createCustomerDto) {
//        return createUser(createCustomerDto, Role.ADMIN);
//    }
//
//    private UserDto createUser(CreateCustomerDto createCustomerDto, Role customer) {
//        if (userRepository.emailExist(createCustomerDto.getEmail())) {
//            throw new IllegalArgumentException("Email already in use");
//        }
//        Customer user = userMapper.fromDto(createCustomerDto, customer);
//        userRepository.saveUser(user);
//        return userMapper.toDto(user);
//    }
}
