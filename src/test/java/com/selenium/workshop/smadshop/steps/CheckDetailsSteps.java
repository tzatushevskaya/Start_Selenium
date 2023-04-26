package com.selenium.workshop.smadshop.steps;

import com.selenium.workshop.smadshop.dto.ProductDto;

import static org.junit.Assert.assertEquals;

public class CheckDetailsSteps {

    public void checkProductMatch(ProductDto catalogProduct, ProductDto detailedProduct) {
        assertEquals("catalog product data is not equal to product data from details page",
                catalogProduct, detailedProduct);
    }
}
