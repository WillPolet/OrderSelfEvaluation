package com.switchfully.eurder.Eurder.service.dto;

import com.switchfully.eurder.itemGroup.service.dto.CreateItemGroupDto;
import lombok.Getter;

import java.util.List;
@Getter
public class CreateEurderDto {
    private List<CreateItemGroupDto> listOfItemGroup;
}
