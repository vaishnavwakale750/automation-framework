package com.sdet.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.sdet.stepdefinitions", "com.sdet.hooks"},
        tags = "@smoke or @regression",
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)

@Listeners({AllureTestNg.class})
public class TestRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}