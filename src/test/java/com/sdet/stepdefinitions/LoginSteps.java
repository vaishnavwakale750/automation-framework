package com.sdet.stepdefinitions;

import com.sdet.pages.LoginPage;
import com.sdet.tests.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;

    @Given("user is on login page")
    public void user_is_on_login_page() {

        loginPage = new LoginPage(driver);
    }

    @Then("page title should contain {string}")
    public void page_title_should_contain(String expectedTitle) {

        String title = loginPage.getPageTitle();

        Assert.assertTrue(title.contains(expectedTitle));
    }
}