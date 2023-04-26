package com.selenium.workshop.smadshop.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class EventListener extends AbstractWebDriverEventListener {

    private static final Logger log = LoggerFactory.getLogger(EventListener.class);

    public void beforeClickOn(WebElement element, WebDriver driver){
        log.info("Clicking on {}", getElement(element));
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keyToSend){
        System.out.println("Changing value " + Arrays.toString(keyToSend) + " for " + getElement(element));
    }

    private String getElement(WebElement element) {
        String text = element.getText();
        if (!text.isEmpty()) {
            return text;
        }
        if (!element.getAttribute("id").isEmpty()) {
            return element.getAttribute("id");
        }
        if (!element.getAttribute("class").isEmpty()) {
            return element.getAttribute("class");
        }
        return "";
    }

}
