package com.asurus.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private static final String AMAZON_URL = "https://www.amazon.com/";

    public HomePage open() {
        Selenide.open(AMAZON_URL);
        return this;
    }

    public SearchResultsPage inputTextAndClickSearchButton(String searchText) {
        SelenideElement searchInputField = $(By.cssSelector(".nav-search-field input")).shouldBe(Condition.visible);
        searchInputField.sendKeys(searchText);
        SelenideElement searchButton = $(By.xpath("//input[@id=\"nav-search-submit-button\"]")).shouldBe(Condition.visible);
        searchButton.click();
        return new SearchResultsPage();
    }

}
