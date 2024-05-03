package com.switchfully.eurder.Eurder.api;

import com.switchfully.eurder.Eurder.service.EurderMapper;
import com.switchfully.eurder.Eurder.service.EurderService;
import com.switchfully.eurder.Eurder.service.dto.CreateEurderDto;
import com.switchfully.eurder.Eurder.service.dto.EurderDto;
import com.switchfully.eurder.authorization.service.AuthorizationService;
import com.switchfully.eurder.user.domain.User;
import com.switchfully.eurder.user.domain.attributes.Role;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class EurderController {
    public final EurderService eurderService;
    public final AuthorizationService authorizationService;

    public EurderController(EurderService eurderService, AuthorizationService authorizationService) {
        this.eurderService = eurderService;
        this.authorizationService = authorizationService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EurderDto createEurder(@RequestBody @Valid CreateEurderDto createEurderDto, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        authorizationService.hasRole(Role.CUSTOMER, authorization);
        User connectedUser = authorizationService.returnUserConnected(authorization);
        return eurderService.createEurder(createEurderDto, connectedUser);
    }
}
