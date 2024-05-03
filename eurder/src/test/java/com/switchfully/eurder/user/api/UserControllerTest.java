package com.switchfully.eurder.user.api;

import com.switchfully.eurder.user.domain.Customer;
import com.switchfully.eurder.user.domain.attributes.Address;
import com.switchfully.eurder.user.service.dto.CreateCustomerDto;
import com.switchfully.eurder.user.service.dto.CustomerDto;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import jakarta.transaction.Transactional;
import net.bytebuddy.asm.Advice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.Base64;
import java.util.List;
import java.util.UUID;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@Transactional
class UserControllerTest {
    @LocalServerPort
    private int port;

    private final Address ADDRESS = new Address("Street", "1", "1000", "Brussels");
    private final CreateCustomerDto CREATE_CUSTOMER_DTO = new CreateCustomerDto("John", "Doe", ADDRESS, "john@doe.com", "M123456", "0488873638");
    private final CustomerDto CUSTOMER_DTO = new CustomerDto(UUID.randomUUID(), "John", "Doe", ADDRESS, "john@doe.com", "0488873638");
    private final Address ADDRESS_IN_DB = new Address("armand", "57", "1050", "bxl");
    private final CustomerDto CUSTOMER_IN_DB = new CustomerDto(UUID.fromString("9f280fbd-2036-4936-accf-79656593df39"),"firstName", "lastName", ADDRESS_IN_DB, "customer@email.com", "0488873638");

    String username = "email@email.com";
    String password = "test";
    String base64Credentials = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

    @Test
    void givenACustomerToCreate_whenCreateCustomer_thenTheNewlyCreatedCustomerIsReturned() {
        CustomerDto customerDto =
                RestAssured
                        .given()
                        .body(CREATE_CUSTOMER_DTO)
                        .headers(
                                "Content-Type",
                                ContentType.JSON,
                                "Accept",
                                ContentType.JSON)
                        .port(port)
                        .post("/users")
                        .then()
                        .log().ifValidationFails(LogDetail.BODY)
                        .assertThat()
                        .statusCode(HttpStatus.CREATED.value())
                        .extract()
                        .as(CustomerDto.class);


        Assertions.assertThat(customerDto)
                .usingRecursiveComparison()
                .ignoringFieldsMatchingRegexes(".*Id", ".*ID", ".*id")
                .isEqualTo(CUSTOMER_DTO);
    }

    @Test // Why here the test pass when first test launch because I should have a List of two customers.
    void givenAlreadyExistCustomerIntoDataBase_whenGetAllCustomers_thenReturnAListOfAllCustomers() {
        List<CustomerDto> customerDto =
                RestAssured
                        .given()
                        .headers(
                                "Authorization",
                                "Basic " + base64Credentials,
                                "Content-Type",
                                ContentType.JSON,
                                "Accept",
                                ContentType.JSON)
                        .port(port)
                        .get("/users")
                        .then()
                        .log().ifValidationFails(LogDetail.BODY)
                        .assertThat()
                        .statusCode(HttpStatus.OK.value())
                        .extract()
                        .body()
                        .jsonPath()
                        .getList(".", CustomerDto.class);
        Assertions.assertThat(customerDto)
                .usingRecursiveComparison()
                .ignoringFieldsMatchingRegexes(".*Id", ".*ID", ".*id")
                .isEqualTo(List.of(CUSTOMER_IN_DB));
    }

    @Test
    void givenAlreadyExistCustomerIntoDataBase_whenGetCustomerById_thenReturnTheCustomer() {
        CustomerDto customerDto =
                RestAssured
                        .given()
                        .headers(
                                "Authorization",
                                "Basic " + base64Credentials,
                                "Content-Type",
                                ContentType.JSON,
                                "Accept",
                                ContentType.JSON)
                        .port(port)
                        .get("/users/9f280fbd-2036-4936-accf-79656593df39")
                        .then()
                        .log().ifValidationFails(LogDetail.BODY)
                        .assertThat()
                        .statusCode(HttpStatus.OK.value())
                        .extract()
                        .as(CustomerDto.class);
        Assertions.assertThat(customerDto)
                .usingRecursiveComparison()
                .ignoringFieldsMatchingRegexes(".*Id", ".*ID", ".*id")
                .isEqualTo(CUSTOMER_IN_DB);
    }

}