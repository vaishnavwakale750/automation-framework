package com.sdet.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserAPI {

    public static Response getUser(int id) {
        return given()
                .when()
                .get("/users/" + id)
                .then()
                .extract()
                .response();
    }
}