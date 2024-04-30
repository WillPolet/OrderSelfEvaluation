package com.switchfully.eurder.Eurder.service;

import com.switchfully.eurder.Eurder.domain.Eurder;
import com.switchfully.eurder.Eurder.service.dto.EurderDto;
import org.springframework.stereotype.Component;

@Component
public class EurderMapper {
    public EurderDto toDto(Eurder eurder, double totalPrice) {
        return new EurderDto(
                eurder.getEurderId(),
                totalPrice
        );
    }
}
