package com.asurus.stepdefinitions;

import com.asurus.pages.HomePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobject.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static org.example.stepdefinitions.BaseSteps.PAGES_STORAGE;
import static org.example.stepdefinitions.BaseSteps.webDriver;

public class LoginSteps {

    @Given("Home Page {string}")
    public HomePage open() {
        Selenide.open("/");
        return null;
    }

    @When("Result Incorrect Input {string}")
    public String getResultTextForIncorrectInput() {

        SelenideElement searchResult = $(By.xpath("//div[@tabindex = 0]/div[@class='a-row']")).shouldBe(Condition.visible);

        return searchResult.getText();
    }

    @When("User enters username as {string} and password as {string} on {string}")
    public void userEntersUsernameAsAndPasswordAsOn(String login, String pass, String pageName) {
        ((LoginPage) PAGES_STORAGE.get(pageName)).fillIncorrectData(login, pass);
    }

    @Then("User gets error message {string} on {string}")
    public void userGetsErrorMessage(String errorMessage, String pageName) {
        Assert.assertEquals(((LoginPage) PAGES_STORAGE.get(pageName)).clickSighInButtonAndReceiveErrorMessage(), errorMessage,
        "");
    }
}
