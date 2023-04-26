package com.selenium.workshop.smadshop.steps;

import com.selenium.workshop.smadshop.page.MainPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class BaseSteps {

    private final MainPage mainPage;

    public BaseSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    public void checkMainPageLoaded() {
        assertTrue("the main page is not loaded", mainPage.isPageLoaded());
    }
}
