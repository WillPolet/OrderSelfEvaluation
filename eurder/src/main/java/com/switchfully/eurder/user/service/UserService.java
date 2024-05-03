package com.switchfully.eurder.user.service;

import com.switchfully.eurder.exception.CustomerNotFoundException;
import com.switchfully.eurder.user.domain.AdminRepository;
import com.switchfully.eurder.user.domain.Customer;
import com.switchfully.eurder.user.domain.CustomerRepository;
import com.switchfully.eurder.user.domain.attributes.Role;
import com.switchfully.eurder.user.service.dto.CreateCustomerDto;
import com.switchfully.eurder.user.service.dto.CustomerDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public List<CustomerDto> getAllCustomers() {
        return customerMapper.toDto(customerRepository.findAll());
    }

    public CustomerDto getCustomerById(UUID id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer with id : " + id + " could not be found."));
        return customerMapper.toDto(customer);
    }
}
