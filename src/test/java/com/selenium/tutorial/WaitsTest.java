package com.selenium.tutorial;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitsTest {

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
    public void testImplicitWait(){
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.name("q"));
        element.click();
    }

    @Test
    public void testExplicitWait(){
        driver.get("https://www.google.com");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        List<WebElement> elements = wait.until(ExpectedConditions.
                visibilityOfAllElementsLocatedBy(By.name("q")));
    }

    @Test
    public void testFluentWait(){
        driver.get("https://www.google.com");
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(driver -> {
            return driver.findElement(By.name("q"));
        });
    }
}
