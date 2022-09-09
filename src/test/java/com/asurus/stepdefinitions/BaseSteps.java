package com.asurus.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.factory.WebDriverFactory;
import org.example.pageobject.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class BaseSteps {
    public static final Map<String, BasePage> PAGES_STORAGE = new HashMap<>();

    public static WebDriver webDriver;

//    class VerifySearchFieldTest extends BaseWebDriverTest {
//        public static final String INCORRECT_INPUT = "890770hhbhb767879zdrjh444:::";
//        public static final String PRESENT = "ipad";
//        public static final String TEXT = "iPad";

    @Before
    public void initWebDriver() {
        webDriver = new WebDriverFactory().getWebDriver();
    }

    @After
    public void afterScenario() {
        webDriver.close();
        webDriver.quit();

        PAGES_STORAGE.clear();
    }
}
