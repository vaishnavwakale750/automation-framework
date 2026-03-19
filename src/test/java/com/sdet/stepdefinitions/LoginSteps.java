package com.sdet.stepdefinitions;

import com.sdet.core.DriverFactory;
import com.sdet.pages.LoginPage;
import com.sdet.utils.ScreenshotUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    private WebDriver driver = DriverFactory.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Step("Open application URL")
    @Given("user is on login page")
    public void user_is_on_login_page() {

        driver = DriverFactory.getDriver();

        if (driver == null) {
            driver = DriverFactory.initDriver();
        }

        // ✅ IMPORTANT checkpoint
        ScreenshotUtil.attachScreenshot(driver, "Login Page");
    }

    @Step("Verify page title contains: {expectedTitle}")
    @Then("page title should contain {string}")
    public void page_title_should_contain(String expectedTitle) {

        String actualTitle = driver.getTitle();

        try {
            Assert.assertTrue(actualTitle.contains(expectedTitle));
        } catch (AssertionError e) {

            ScreenshotUtil.attachScreenshot(driver, "Failure - Title Mismatch");

            throw e; // VERY IMPORTANT
        }
        // ✅ IMPORTANT checkpoint
        ScreenshotUtil.attachScreenshot(driver, "After Login Page");
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        loginPage.login("standard_user", "secret_sauce");

        ScreenshotUtil.attachScreenshot(driver, "After Valid Login");
    }

    @When("user enters invalid credentials")
    public void user_enters_invalid_credentials() {
        loginPage.login("invalid_user", "wrong_password");
        ScreenshotUtil.attachScreenshot(driver, "After Invalid Login");
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue(loginPage.isErrorDisplayed());
        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Username and password do not match")
        );
        ScreenshotUtil.attachScreenshot(driver, "Error Message Displayed");
    }

}