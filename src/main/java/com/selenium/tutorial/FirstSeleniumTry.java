package com.selenium.tutorial;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTry {

    public static void main(String[] args) throws InterruptedException {

        // establish the path to driver executable
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // open link
        driver.get("https://www.google.com/");
//        Thread.sleep(5000);
        driver.navigate().to("https://www.amazon.com/");
//        Thread.sleep(5000);

        // get info from driver
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        driver.quit();

    }
}
