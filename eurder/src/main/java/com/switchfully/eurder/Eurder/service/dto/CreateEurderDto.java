package com.switchfully.eurder.Eurder.service.dto;

import com.switchfully.eurder.itemGroup.service.dto.CreateItemGroupDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;
@Getter
public class CreateEurderDto {
    @NotNull(message = "Please provide a list of ItemGroupDto who is not null.")
    @Valid
    private List<CreateItemGroupDto> listOfItemGroup;

    public CreateEurderDto(List<CreateItemGroupDto> listOfItemGroup) {
        this.listOfItemGroup = listOfItemGroup;
    }

    public CreateEurderDto() {
    }

    @Override
    public String toString() {
        return "CreateEurderDto{" +
                "listOfItemGroup=" + listOfItemGroup +
                '}';
    }
}
