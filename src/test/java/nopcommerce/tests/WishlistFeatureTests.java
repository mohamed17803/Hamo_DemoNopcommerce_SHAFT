package nopcommerce.tests;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.example.WishlistFeature;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Wishlist Management")
@Story("Verify Wishlist Functionality")

public class WishlistFeatureTests {

    private SHAFT.GUI.WebDriver driver;
    private JSONFileManager testData;

    @BeforeMethod
    @Description("Navigate To URL")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @BeforeClass
    @Description("Setting JSON File")
    public void BeforeClass() {
        testData = new JSONFileManager("src/test/resources/nopcommerce.TestData/WishlistTestData.json");
    }

    @Test(description = "Validate Wishlist Success Message and Background Color")
    public void wishlistValidations() {
        new WishlistFeature(driver).urlNavigate().ClickandValidateSuccess(testData.getTestData("BackgroundColor"));
    }

    @Test(description = "Validate that the product added to wishList succesfully ")
    public void validateWishList(){
        new WishlistFeature(driver).urlNavigate().validateAddToWishList();
    }

    @AfterMethod
    @Description("Close the Browser after test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
