package com.switchfully.eurder.item.api;

import com.switchfully.eurder.item.service.dto.CreateItemDto;
import com.switchfully.eurder.item.service.dto.ItemDto;
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
import org.assertj.core.api.Assertions;


import java.util.Base64;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@Transactional
class ItemControllerTest {
    @LocalServerPort
    private int port;
    private final CreateItemDto CREATE_ITEM_DTO = new CreateItemDto("item", "description", 5.0, 10);
    private final ItemDto ITEM_DTO = new ItemDto(UUID.randomUUID(), "item", "description", 5.0, 10);
    String username = "email@email.com";
    String password = "test";
    String base64Credentials = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

    private final ItemDto CUSTOMER_IN_DB = new ItemDto(UUID.fromString("06739518-3972-48ef-997a-2af5c7ca57bd"),"produit1", "test", 10.05, 10);
    @Test
    void givenAnItemToCreate_whenCreateItem_thenTheNewlyCreatedItemIsReturned() {
        ItemDto itemDto =
                RestAssured
                        .given()
                        .body(CREATE_ITEM_DTO)
                        .headers("Authorization",
                                "Basic " + base64Credentials,
                                "Content-Type",
                                ContentType.JSON,
                                "Accept",
                                ContentType.JSON)
                        .port(port)
                        .post("/items")
                        .then()
                        .log().ifValidationFails(LogDetail.BODY)
                        .assertThat()
                        .statusCode(HttpStatus.CREATED.value())
                        .extract()
                        .as(ItemDto.class);

        Assertions.assertThat(itemDto)
                .usingRecursiveComparison()
                .ignoringFieldsMatchingRegexes(".*Id", ".*ID", ".*id")
                .isEqualTo(ITEM_DTO);
    }

    @Test
    void givenAlreadyExistItemIntoDataBase_whenGetAllItems_thenReturnAListOfAllItems() {
        List<ItemDto> itemDtos =
                RestAssured
                        .given()
                        .headers("Authorization",
                                "Basic " + base64Credentials,
                                "Content-Type",
                                ContentType.JSON,
                                "Accept",
                                ContentType.JSON)
                        .port(port)
                        .get("/items")
                        .then()
                        .log().ifValidationFails(LogDetail.BODY)
                        .assertThat()
                        .statusCode(HttpStatus.OK.value())
                        .extract()
                        .jsonPath()
                        .getList(".", ItemDto.class);
//        Assertions.assertThat(itemDtos)
//                .usingRecursiveComparison()
//                .ignoringFieldsMatchingRegexes(".*Id", ".*ID", ".*id")
//                .isEqualTo(List.of(CUSTOMER_IN_DB));
        Assertions.assertThat(itemDtos).usingElementComparatorIgnoringFields("id").contains(CUSTOMER_IN_DB);
    }

}