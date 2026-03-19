package com.sdet.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Allure;

public class ScreenshotUtil {

    // For failure (used in Hooks)
    public static byte[] captureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // For manual checkpoint screenshots
    public static void attachScreenshot(WebDriver driver, String name) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        Allure.getLifecycle().addAttachment(
                name,
                "image/png",
                "png",
                screenshot
        );
    }
}