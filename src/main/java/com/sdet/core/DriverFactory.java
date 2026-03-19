package com.sdet.core;

import com.sdet.config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver() {

        String browser = ConfigManager.getProperty("browser");

        switch (browser.toLowerCase()) {

            case "chrome":
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                driver.set(new FirefoxDriver());
                break;

            case "edge":
                driver.set(new EdgeDriver());
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        WebDriver wd = driver.get();
        wd.manage().window().maximize();

        return wd;
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        WebDriver wd = driver.get();

        if (wd != null) {
            wd.quit();
            driver.remove();   // 🔥 VERY IMPORTANT
        }
    }
}