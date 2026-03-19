package com.sdet.api;

import io.restassured.RestAssured;

public class BaseAPI {

    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
}