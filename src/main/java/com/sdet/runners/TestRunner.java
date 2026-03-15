package com.sdet.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.sdet.stepdefinitions",
        plugin = {"pretty"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}