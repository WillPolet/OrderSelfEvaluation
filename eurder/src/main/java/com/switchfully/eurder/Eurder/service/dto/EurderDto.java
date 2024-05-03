package com.switchfully.eurder.Eurder.service.dto;

import lombok.Getter;

import java.util.UUID;
@Getter
public class EurderDto {
    private UUID eurderId;
    private double totalPriceOfEurder;

    public EurderDto(UUID eurderId, double totalPriceOfEurder) {
        this.eurderId = eurderId;
        this.totalPriceOfEurder = totalPriceOfEurder;
    }

    public EurderDto() {
    }
}
