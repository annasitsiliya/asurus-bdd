package com.asurus.stepdefinitions;

import com.asurus.pages.HomePage;
import io.cucumber.java.en.Given;


public class HomePageSteps {

    @Given("User is on Amazon home page")
    public HomePage openHomePage() {
        HomePage homePage = new HomePage();
        homePage.open();
        return homePage;
    }

    @Given("User searches for {string}")
    public HomePage doSearch(String searchTerm) {
        HomePage homePage = new HomePage();
        homePage.inputTextAndClickSearchButton(searchTerm);
        return homePage;
    }
}
