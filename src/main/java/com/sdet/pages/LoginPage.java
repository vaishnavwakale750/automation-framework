package com.sdet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMsg = By.cssSelector("[data-test='error']");
    private WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ IMPORTANT for synchronization
    }

    // Actions

    public void enterUsername(String user) {
        WebElement userField = driver.findElement(username);
        userField.clear();
        userField.sendKeys(user);
    }

    public void enterPassword(String pass) {
        WebElement passField = driver.findElement(password);
        passField.clear();
        passField.sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    // ✅ THIS IS YOUR REQUIRED METHOD
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    // Utility methods

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }
}