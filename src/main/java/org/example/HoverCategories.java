package org.example;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HoverCategories {

    // Initialize the driver
    private final SHAFT.GUI.WebDriver driver;


    public HoverCategories(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to URL
    public HoverCategories urlNavigate() {
        String pageURL = "https://demo.nopcommerce.com/"; // Navigating to the home page URL
        driver.browser().navigateToURL(pageURL);
        return this;
    }

    // Locators
    private  By MainCategory = By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/electronics\"]");
    private  By SubCategory = By.xpath("//ul[@class=\"top-menu notmobile\"]//ul[@class=\"sublist first-level\"]//a[@href=\"/camera-photo\"]");
    private  By PageTitle = By.xpath("//div[@class=\"page-title\"]/h1");

    // Actions
    @Step("Validation of Hover and Click Functionality on Main and Sub Categories with Page Title Assertion  ")
    public void HoverFeatureValidation() throws InterruptedException {
        synchronized (driver) {
            driver.element().hover(MainCategory).click(SubCategory);
            driver.wait(7); // Wait for 7 seconds
            String pageTitleText = driver.element().getText(PageTitle);
            System.out.println("Page Title: " + pageTitleText);
            driver.assertThat().element(PageTitle).text().isEqualTo("Camera & photo").perform();
        }
    }
}