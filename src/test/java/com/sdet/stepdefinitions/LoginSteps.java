package com.sdet.stepdefinitions;

import com.sdet.core.DriverFactory;
import com.sdet.utils.ScreenshotUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    WebDriver driver;
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
}