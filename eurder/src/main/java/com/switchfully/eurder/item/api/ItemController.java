//package com.switchfully.eurder.item.api;
//
//import com.switchfully.eurder.authorization.service.AuthorizationService;
//import com.switchfully.eurder.item.service.ItemService;
//import com.switchfully.eurder.item.service.dto.CreateItemDto;
//import com.switchfully.eurder.item.service.dto.ItemDto;
//import com.switchfully.eurder.user.domain.attributes.Role;
//import jakarta.validation.Valid;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/items")
//public class ItemController {
//    private final ItemService itemService;
//
//    private final AuthorizationService authorizationService;
//
//    public ItemController(ItemService itemService, AuthorizationService authorizationService) {
//        this.itemService = itemService;
//        this.authorizationService = authorizationService;
//    }
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping
//    public ItemDto createItem(@RequestBody @Valid CreateItemDto createItemDto, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
//        authorizationService.hasRole(Role.ADMIN, authorization);
//        return itemService.createItem(createItemDto);
//    }
//
//    @GetMapping
//    public List<ItemDto> getAllItems(){
//        return itemService.getAllItems();
//    }
//}
