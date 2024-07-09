package nopcommerce.tests;

import com.shaft.driver.SHAFT;

import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.example.Currencies;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Currency Selection and Validation")
@Story("Select currency and validate its appearance on product prices")

public class CurrenciesTest {
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
        testData = new JSONFileManager("src/test/resources/nopcommerce.TestData/CurrenciesTestData.json");
    }




    @Test(description = "Test if the driver selects the correct currency and validates the currency symbol in product prices")
    @Description("Test to choose the correct currency and validate that the currency symbol appears in all product prices.")
    public void Choosecurrencyvalidation(){
 new Currencies(driver).urlNavigate().Openccurrencieslist(testData.getTestData("Currency"))
         .validateCurrencySymbol(testData.getTestData("CurrencySymbol"));


    }


    @AfterMethod
    @Description("Close the Browser after test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
