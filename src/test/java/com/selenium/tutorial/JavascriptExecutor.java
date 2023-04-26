package com.selenium.tutorial;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavascriptExecutor {

    private static final String SCRIPT = "arguments[0].scrollIntoView();";

    @Test
    public void checkJS() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/large");

        WebElement table = driver.findElement(By.id("large-table"));

        JavascriptExecutor.waitForPageToLoad(driver);

        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(SCRIPT, table);

        driver.quit();

    }

    public static void waitForPageToLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        ExpectedCondition<Boolean> jsLoad = d -> ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return document.readyState").toString()
                .equals("complete");
        wait.until(jsLoad);
    }
}
