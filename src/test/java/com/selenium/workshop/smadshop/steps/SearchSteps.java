package com.selenium.workshop.smadshop.steps;

import com.selenium.workshop.smadshop.page.MainPage;
import org.openqa.selenium.WebDriver;

public class SearchSteps {

    private final MainPage mainPage;

    public SearchSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    public void searchItem(String searchTerm) {
        mainPage.search(searchTerm);
    }
}
