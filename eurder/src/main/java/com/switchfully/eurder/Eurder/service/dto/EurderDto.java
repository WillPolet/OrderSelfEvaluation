package com.switchfully.eurder.Eurder.service.dto;

import java.util.UUID;

public class EurderDto {
    private UUID eurderId;
    private double totalPriceOfEurder;

    public EurderDto(UUID eurderId, double totalPriceOfEurder) {
        this.eurderId = eurderId;
        this.totalPriceOfEurder = totalPriceOfEurder;
    }
}
