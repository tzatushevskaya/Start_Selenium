package com.selenium.workshop.smadshop.component;

import org.openqa.selenium.WebElement;

import static com.selenium.workshop.smadshop.utils.RegexParser.parseInteger;

public abstract class Product {

    protected abstract WebElement getNameEl();

    protected abstract WebElement getPriceEl();

    public String getName() {
        return  getNameEl().getText();
    }

    public int getPrice() {
        return parseInteger(getPriceEl().getText());
    }

}
