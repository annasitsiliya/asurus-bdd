package com.asurus.stepdefinitions;

import com.asurus.pages.SearchResultsPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;


public class SearchResultSteps {

    private static final String NO_RESULTS = "No results for %s.";

    @Then("User sees no results message for {string}")
    public void userSeesNoResultsMessage(String searchTerm) {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        String actualResult = searchResultsPage.getResultTextForIncorrectInput();
        String expectedResult = String.format(NO_RESULTS, searchTerm);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Then("User sees result summary string with {string}")
    public void userSeesSearchResultSummary(String searchTerm) {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        String actualResult = searchResultsPage.getResultTextForCorrectInput();
        String expectedResult = String.format("\"%s\"", searchTerm);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Then("Search result items contain {string}")
    public void searchItemsContainSearchTerm(String searchTerm) {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        List<String> allItemsText = searchResultsPage.getTextForAllResults();
        boolean result = allItemsText.stream().anyMatch(text -> text.toLowerCase().contains(searchTerm));
        Assert.assertTrue(result);
    }
}
