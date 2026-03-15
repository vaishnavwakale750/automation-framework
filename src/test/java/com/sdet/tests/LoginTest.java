package com.sdet.tests;

import com.sdet.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLoginPageTitle() {

        LoginPage loginPage = new LoginPage(driver);

        String title = loginPage.getPageTitle();

        System.out.println("Page Title: " + title);

        Assert.assertTrue(title.contains("Swag"));
    }
}