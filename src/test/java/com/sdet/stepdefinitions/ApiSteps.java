package com.sdet.stepdefinitions;

import com.sdet.api.BaseAPI;
import com.sdet.api.UserAPI;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static org.testng.Assert.*;

public class ApiSteps {

    Response response;

    @Given("API is ready")
    public void api_is_ready() {
        BaseAPI.setup();
    }

    @When("I get user with id {int}")
    public void i_get_user(int id) {
        response = UserAPI.getUser(id);
    }

    @Then("response status should be {int}")
    public void validate_status(int status) {

        System.out.println("Response Body:");
        response.prettyPrint();   // 🔥 VERY IMPORTANT

        assertEquals(response.getStatusCode(), status);
    }
}