package org.example;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class WishlistFeature {
    SHAFT.GUI.WebDriver driver;

    public WishlistFeature(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public WishlistFeature urlNavigate() {
        driver.element().browser().navigateToURL("https://demo.nopcommerce.com/");
        return this;
    }

    // Locators
    private By HTCwishlistbutton = By.xpath("//div[@data-productid=\"18\"]//button[@title=\"Add to wishlist\"]");
    private By Succesmessage = By.id("bar-notification");
    private By wishlistButton = By.className("wishlist-label");
    private By qtyValue = By.className("qty-input");

    @SneakyThrows
    @Step("Validate Wishlist Success Message and Background Color for HTC One M8 Android L 5.0 Lollipop")
    public WishlistFeature ClickandValidateSuccess(String BackgoroundColor) {
        driver.element().click(HTCwishlistbutton);
        driver.verifyThat().element(Succesmessage).isVisible();
        driver.verifyThat().element(Succesmessage).cssProperty("background-color").isEqualTo(BackgoroundColor);

        return this;
    }


    public WishlistFeature validateAddToWishList(){
        driver.element().click(HTCwishlistbutton);
        driver.element().waitToBeInvisible(Succesmessage);
        driver.element().click(wishlistButton);
        String quantityValue = driver.element().getText(qtyValue);
        int qty = Integer.parseInt(quantityValue);
        Assert.assertTrue(qty>0,"Quantity is not greater than zero ");
        return this;
    }
}


