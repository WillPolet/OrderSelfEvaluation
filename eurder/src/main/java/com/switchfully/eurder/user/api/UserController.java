//package com.switchfully.eurder.user.api;
//
//import com.switchfully.eurder.authorization.service.AuthorizationService;
//import com.switchfully.eurder.user.domain.attributes.Role;
//import com.switchfully.eurder.user.service.UserService;
//import com.switchfully.eurder.user.service.dto.CreateUserDto;
//import com.switchfully.eurder.user.service.dto.UserDto;
//import jakarta.validation.Valid;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//    private final UserService userService;
//
//    private final AuthorizationService authorizationService;
//
//    public UserController(UserService userService, AuthorizationService authorizationService) {
//        this.userService = userService;
//        this.authorizationService = authorizationService;
//    }
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping()
//    public UserDto createUser(@RequestBody @Valid CreateUserDto createUserDto){return userService.createCustomerUser(createUserDto);}
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/admin")
//    public UserDto createAdmin(@RequestBody @Valid CreateUserDto createUserDto, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
//        authorizationService.hasRole(Role.ADMIN,authorization);
//        return userService.createAdminUser(createUserDto);}
//}
