package com.switchfully.eurder.user.api;

import com.switchfully.eurder.authorization.service.AuthorizationService;
import com.switchfully.eurder.user.domain.attributes.Role;
import com.switchfully.eurder.user.service.UserService;
import com.switchfully.eurder.user.service.dto.CreateCustomerDto;
import com.switchfully.eurder.user.service.dto.CustomerDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    private final AuthorizationService authorizationService;

    public UserController(UserService userService, AuthorizationService authorizationService) {
        this.userService = userService;
        this.authorizationService = authorizationService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public CustomerDto createUser(@RequestBody @Valid CreateCustomerDto createUserDto){return userService.createCustomerUser(createUserDto);}

    @GetMapping()
    public List<CustomerDto> getAllUsers(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        authorizationService.hasRole(Role.ADMIN, authorization);
        return userService.getAllCustomers();
    }

    @GetMapping(path = "/{id}")
    public CustomerDto getUserById(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization, @PathVariable UUID id){
        authorizationService.hasRole(Role.ADMIN, authorization);
        return userService.getCustomerById(id);
    }
}
