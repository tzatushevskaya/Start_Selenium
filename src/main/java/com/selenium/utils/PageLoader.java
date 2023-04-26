package com.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageLoader {

    private static final int DRIVER_WAIT_TIME = 10;
    private final WebDriver driver;

    public PageLoader(WebDriver driver) {
        this.driver = driver;
    }

    public void isElementPresent(By locator) {
        try {
            getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (WebDriverException e) {
            throw new WebDriverException("Element is not present: " + e.getMessage());
        }
    }

    private WebDriverWait getWait() {
        return new WebDriverWait(this.driver, Duration.ofSeconds(DRIVER_WAIT_TIME));
    }
}
