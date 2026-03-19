package com.sdet.hooks;

import com.sdet.core.DriverFactory;
import com.sdet.config.ConfigManager;
import com.sdet.utils.ScreenshotUtil;
import io.cucumber.java.*;
import org.openqa.selenium.*;

public class Hooks {

    @Before
    public void beforeScenario() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigManager.getProperty("baseUrl"));
    }

//    @AfterStep
//    public void takeScreenshot(Scenario scenario) {
//        WebDriver driver = DriverFactory.getDriver();
//
//        if (driver != null) {
//            byte[] screenshot = ((TakesScreenshot) driver)
//                    .getScreenshotAs(OutputType.BYTES);
//
//            scenario.attach(screenshot, "image/png", "Step Screenshot");
//        }
//    }

    @After
    public void afterScenario(Scenario scenario) {

        WebDriver driver = DriverFactory.getDriver();

        if (scenario.isFailed() && driver != null) {
            try {
                byte[] screenshot = ScreenshotUtil.captureScreenshot(driver);

                scenario.attach(screenshot, "image/png", "Failure Screenshot");

            } catch (Exception e) {
                System.out.println("Screenshot failed: " + e.getMessage());
            }
        }

        if (driver != null) {
            DriverFactory.quitDriver();
        }
    }
}