package com.switchfully.eurder.Eurder.api;

import com.switchfully.eurder.Eurder.service.dto.CreateEurderDto;
import com.switchfully.eurder.Eurder.service.dto.EurderDto;
import com.switchfully.eurder.itemGroup.service.dto.CreateItemGroupDto;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.Base64;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@Transactional
class EurderControllerTest {
    @LocalServerPort
    private int port;

    private final CreateItemGroupDto CREATE_ITEM_GROUP_DTO = new CreateItemGroupDto("06739518-3972-48ef-997a-2af5c7ca57bd", 10);

    private final CreateEurderDto CREATE_EURDER_DTO = new CreateEurderDto(List.of(CREATE_ITEM_GROUP_DTO));
    private final EurderDto EURDER_DTO = new EurderDto(UUID.randomUUID(), 100.5);
    String username = "customer@email.com";
    String password = "password";
    String base64Credentials = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

    @Test
    void givenAnOrderWithValidItemGroup_whenCreateOrder_thenTheNewlyCreatedOrderIsReturned() {
        EurderDto orderDto =
                RestAssured
                        .given()
                        .body(CREATE_EURDER_DTO)
                        .headers("Authorization",
                                "Basic " + base64Credentials,
                                "Content-Type",
                                ContentType.JSON,
                                "Accept",
                                ContentType.JSON)
                        .port(port)
                        .post("/orders")
                        .then()
                        .log().ifValidationFails(LogDetail.BODY)
                        .assertThat()
                        .statusCode(HttpStatus.CREATED.value())
                        .extract()
                        .as(EurderDto.class);

        Assertions.assertThat(orderDto)
                .usingRecursiveComparison()
                .ignoringFieldsMatchingRegexes(".*Id", ".*ID", ".*id")
                .isEqualTo(EURDER_DTO);
    }

    @Test
    void givenAnOrderWithInvalidItemGroup_whenCreateOrder_thenThrowError() {
        CreateItemGroupDto createItemGroupDto = new CreateItemGroupDto("0e8cd5a3-749c-4f09-8aec-aee8edc503a4", 100);
        CreateEurderDto createEurderDto = new CreateEurderDto(List.of(createItemGroupDto));

        RestAssured
                .given()
                .body(createEurderDto)
                .headers("Authorization",
                        "Basic " + base64Credentials,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .port(port)
                .post("/orders")
                .then()
                .log().ifValidationFails(LogDetail.BODY)
                .assertThat()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

}