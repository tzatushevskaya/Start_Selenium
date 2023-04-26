package com.selenium.workshop.smadshop.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    public static final int timeout = 10;

    private static WebDriverWait wait;

    public static void waitUntilPresent(WebDriver driver, By locator) {
        wait = getWait(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    private static WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

}
