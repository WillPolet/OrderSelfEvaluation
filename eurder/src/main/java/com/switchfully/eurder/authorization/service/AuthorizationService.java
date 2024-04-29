package com.switchfully.eurder.authorization.service;

import com.switchfully.eurder.exception.AccessForbiddenException;
import com.switchfully.eurder.exception.NotFoundException;
import com.switchfully.eurder.exception.PasswordNotMatchException;
import com.switchfully.eurder.user.domain.*;
import com.switchfully.eurder.user.domain.attributes.EmailPassword;
import com.switchfully.eurder.user.domain.attributes.Role;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class AuthorizationService {
    CustomerRepository customerRepository;

    AdminRepository adminRepository;

    public AuthorizationService(CustomerRepository customerRepository, AdminRepository adminRepository) {
        this.customerRepository = customerRepository;
        this.adminRepository = adminRepository;
    }

    public void hasRole(Role role, String authorization){
        EmailPassword emailPassword = getEmailPassword(authorization);
        User user = getUserByEmailPassword(emailPassword);

        if (!user.passwordMatch(emailPassword.getPassword())) {
            throw new PasswordNotMatchException("Email/password in authorization header doesn't match");
        }

        if (user instanceof Customer && role == Role.ADMIN){
            throw new AccessForbiddenException("Authenticated user have no access to this feature");
        }
        if (user instanceof Admin && role == Role.CUSTOMER){
            throw new AccessForbiddenException("Authenticated user have no access to this feature");
        }
    }

    private EmailPassword getEmailPassword(String authorization) {
        String decodedEmailAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String email = decodedEmailAndPassword.substring(0, decodedEmailAndPassword.indexOf(":"));
        String password = decodedEmailAndPassword.substring(decodedEmailAndPassword.indexOf(":") + 1);
        return new EmailPassword(email, password);
    }

    private User getUserByEmailPassword(EmailPassword emailPassword) {
        if (customerRepository.findByEmail(emailPassword.getEmail()).isPresent()) {
            return customerRepository.findByEmail(emailPassword.getEmail()).get();
        } else if (adminRepository.findByEmail(emailPassword.getEmail()).isPresent()) {
            return adminRepository.findByEmail(emailPassword.getEmail()).get();
        } else {
            throw new NotFoundException("Email in authorization header not found");
        }
    }


}
