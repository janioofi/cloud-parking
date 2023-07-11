package com.jan1ooo.cloudparking.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerIT extends AbstractContainerBase {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest(){
        System.out.println(randomPort);
        RestAssured.port = randomPort;
    }

    @Test
    void whenFindAllCheckResult() {
        RestAssured.given()
                .when()
                .get("/api/parking")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .body()
                .prettyPrint();
    }

//    @Test
//    void whenCreateThenCheckIsCreated() {
//        RestAssured.given()
//                .when()
//                .post("/api/parking")
//                .then()
//                .statusCode(201)
//                .extract()
//                .response()
//                .body()
//                .prettyPrint();
//    }

    @Test
    void exit() {
    }
}