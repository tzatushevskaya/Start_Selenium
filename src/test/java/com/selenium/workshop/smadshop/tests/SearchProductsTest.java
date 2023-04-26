package com.selenium.workshop.smadshop.tests;

import com.selenium.workshop.smadshop.dto.ProductDto;
import com.selenium.workshop.smadshop.steps.*;
import com.selenium.workshop.smadshop.utils.PropertyReader;
import org.junit.Before;
import org.junit.Test;

public class SearchProductsTest extends BaseTest{

    private BaseSteps baseSteps;
    private SearchSteps searchSteps;
    private CatalogSteps catalogSteps;
    private ProductDetailsSteps productDetailsSteps;
    private CheckDetailsSteps checkDetailsSteps;

    /**
     * 1. Navigate to smadshop main page
     * 2. Check smadshop page loaded
     * 3. Search a product
     * 4. Check the list of items contains the search term
     * 5. Save the product data
     * 6. Open the product
     * 7. Check the data is the same as on search page
     */


    @Before
    public void setupSteps(){
        baseSteps = new BaseSteps(getDriver());
        searchSteps = new SearchSteps(getDriver()) ;
        catalogSteps = new CatalogSteps(getDriver());
        productDetailsSteps = new ProductDetailsSteps(getDriver());
        checkDetailsSteps = new CheckDetailsSteps();
    }

    @Test
    public void searchProductsTest(){

        final String searchTerm = PropertyReader.getConfigProperty("product");

        baseSteps.checkMainPageLoaded();
        searchSteps.searchItem(searchTerm);
        catalogSteps.checkResultListIsPresent();
        catalogSteps.checkTermIsPresentInResults(searchTerm);

        final int productIndex = catalogSteps.getRandomProductIndex();
        final ProductDto catalogProduct = catalogSteps.getProductDetails(productIndex);
        catalogSteps.openProduct(productIndex);

        productDetailsSteps.checkProductPageLoaded();
        final ProductDto detailedProduct = productDetailsSteps.getProductDetails();

        checkDetailsSteps.checkProductMatch(catalogProduct, detailedProduct);
    }
}
