package com.switchfully.eurder.itemGroup.api;

import com.switchfully.eurder.itemGroup.service.ItemGroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemGroups")
public class ItemGroupController {
    private ItemGroupService itemGroupService;

}

// create itemGroup only for customer "like add it to cart".
