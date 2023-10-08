package com.schambeck.cleanarch.entrypoint.rest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class NotificationRestEntryPointIT {
    @LocalServerPort
    int port;
    
    @BeforeEach
    void setup() {
        RestAssured.port = port;
    }
    
    @Test
    void givenId_whenExists_thenCorrect() {
        get("/notifications/{id}", "29f893c4-67bf-4d77-afa1-681587a67ada")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("id", equalTo("29f893c4-67bf-4d77-afa1-681587a67ada"));
    }
    
    @Test
    void givenId_whenDoesnotExist_thenWrong() {
        get("/notifications/{id}", "6765594d-b2cc-4f70-964b-bef00ad2a854")
                .then()
                .log().all()
                .statusCode(404);
    }
}
