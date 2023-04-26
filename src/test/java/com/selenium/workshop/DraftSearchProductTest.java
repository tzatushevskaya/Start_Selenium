package com.selenium.workshop;

import com.selenium.workshop.smadshop.component.CatalogProduct;
import com.selenium.workshop.smadshop.component.DetailedProduct;
import com.selenium.workshop.smadshop.component.Product;
import com.selenium.workshop.smadshop.page.CatalogPage;
import com.selenium.workshop.smadshop.page.MainPage;
import com.selenium.workshop.smadshop.page.ProductPage;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class DraftSearchProductTest {

    private MainPage mainPage;
    private CatalogPage catalogPage;
    private ProductPage productPage;

    /**
     * 1. Navigate to smadshop main page
     * 2. Check smadshop page loaded
     * 3. Search a product
     * 4. Check the list of items contains the search term
     * 5. Save the product data
     * 6. Open the product
     * 7. Check the data is the same as on search page
     */

    @Test
    public void searchProductTest(){

        final String searchTerm = "пылесос";

        assertTrue("the main page is not loaded", mainPage.isPageLoaded());

        mainPage.search(searchTerm);

        List<CatalogProduct> productList = catalogPage.getProductList();

        assertTrue("the product list is empty", productList.size() > 0);

        for (Product product : productList) {
            assertTrue("the product name doesn't contain " + searchTerm, product.getName().contains(searchTerm));
        }

        CatalogProduct firstProduct = productList.get(0);
        String firstProductName = firstProduct.getName();
        int firstProductPrice = firstProduct.getPrice();
        catalogPage.openItem(0);

        assertTrue("the product page is not loaded", productPage.isPageLoaded());

        DetailedProduct actualProduct = productPage.getProduct();
        String firstDetailedProductName = actualProduct.getName();
        int firstDetailedProductPrice = actualProduct.getPrice();





        assertTrue("the product name is different", firstDetailedProductName.equals(firstProductName));
        assertTrue("the product price is different", firstDetailedProductPrice==firstProductPrice);

    }
}
