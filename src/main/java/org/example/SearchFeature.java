package org.example;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchFeature {

    // Initializing the driver
    private final SHAFT.GUI.WebDriver driver;

    public SearchFeature(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to the URL
    public SearchFeature urlNavigate() {
        String pageURL = "https://demo.nopcommerce.com/";
        driver.browser().navigateToURL(pageURL);
        return this;
    }

    // Locators
    private final By searchBar = By.id("small-searchterms");
    private final By searchButton = By.xpath("//div[@class=\"search-box store-search-box\"]//button[@type=\"submit\"]");
    private final By searchResult = By.xpath("//div[@class=\"search-results\"]"); // Locator for the search results container.
    private final By searchItem = By.xpath("//div[@class=\"item-box\"]//div[@class=\"picture\"]"); // Locator for search items.
    private final By skuValue = By.xpath("//div[@class=\"sku\"]//span[@class=\"value\"]"); // Locator for the SKU value of a product.

    // Actions

    // Method to type a product name into the search bar
    public SearchFeature searchWithProductName(String productName) {
        driver.element().type(searchBar, productName);
        return this;
    }

    // Method to validate the search results using product name
    public SearchFeature validateSearchWithProductName(String expectedUrl, String searchWord) {
        driver.verifyThat().browser().url().contains(expectedUrl); // Verify that the URL contains the expected URL part.
        List<WebElement> searchResults = driver.getDriver().findElements(searchResult); // Get all search results.
        int sizeOfSearchResult = searchResults.size();
        System.out.println("the number of itemsResult is : " + sizeOfSearchResult);
        for (WebElement result : searchResults) {
            String resultText = result.getText().toLowerCase();
            // Here we do assertions and validations
             Assert.assertTrue(resultText.contains(searchWord.toLowerCase()));
        }
        return this;
    }

    // Method to type a SKU into the search text box
    public SearchFeature searchWithSku(String sku) {
        driver.element().type(searchBar, sku);
        return this;
    }
    // Method to click the search button
    public SearchFeature clickOnSearchButton() {
        driver.element().click(searchButton);
        return this;
    }


    @Step(" Validate the search results using it's SKU ")
    public SearchFeature validateSearchWithSku(String sku) {
        driver.element().click(searchItem); // Click on the first search item.
        String skuOfProduct = driver.element().getText(skuValue); // Get the SKU value of the clicked product.
        // Here we do assertions and validations
         Assert.assertTrue(skuOfProduct.contains(sku));
        return this;
    }


}
