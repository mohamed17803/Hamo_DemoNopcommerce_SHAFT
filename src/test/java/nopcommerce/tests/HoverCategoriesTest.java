package nopcommerce.tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.example.HoverCategories;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Category Navigation Tests")
@Story("Hover and Click Category Validation")
public class HoverCategoriesTest {

    private SHAFT.GUI.WebDriver driver;

    @BeforeMethod
    @Description("Navigate To URL")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test(description = "Validation of Hover and Click Functionality on Main and Sub Categories with Page Title Assertion  ")
    public void checkTheWork() throws InterruptedException {
        new HoverCategories(driver).urlNavigate().HoverFeatureValidation();

    }

    @AfterMethod
    @Description("Close the Browser after test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
