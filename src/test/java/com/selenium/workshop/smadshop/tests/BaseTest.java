package com.selenium.workshop.smadshop.tests;

import com.selenium.workshop.smadshop.driver.CustomWebDriverManager;
import com.selenium.workshop.smadshop.utils.PropertyReader;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    private static WebDriver driver;
    private final static String URL = PropertyReader.getConfigProperty("url");

    @BeforeClass
    public static void setUp(){
        System.out.println("Setting the webdriver");
        driver = CustomWebDriverManager.getDriver();
        driver.get(URL);
    }


    @AfterClass
    public static void tearDown(){
        System.out.println("Closing the webdriver");
        CustomWebDriverManager.quitDriver();
    }


    public static WebDriver getDriver() {
        return driver;
    }
}
