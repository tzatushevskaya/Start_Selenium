package com.selenium.tutorial;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JSExecutor {

    private static final String SCRIPT = "arguments[0].scrollIntoView();";
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.out.println("Setting web driver");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Closing the driver");
        driver.quit();
    }

    @Test
    public void checkJS() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/large");

        JSExecutor.waitForPageToLoad(driver);

        WebElement tab = driver.findElement(By.id("large-table"));
        ((JavascriptExecutor) driver).executeScript(SCRIPT, tab);

    }

    public static void waitForPageToLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        ExpectedCondition<Boolean> jsLoad = d -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").toString()
                .equals("complete");
        wait.until(jsLoad);
    }
}