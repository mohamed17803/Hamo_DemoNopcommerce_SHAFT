package nopcommerce.tests;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.example.SearchFeature;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Search Functionality")
@Story("Efficient Product Search")

public class SearchFeatureTests {

    private SHAFT.GUI.WebDriver driver;
    private JSONFileManager testData;

    @BeforeMethod
    @Description("Navigate To URL")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @BeforeClass
    @Description("Setting JSON File")
    public void beforeClass() {
        testData = new JSONFileManager("src/test/resources/nopcommerce.TestData/SearchFeatureTestData.json");
    }

    @Test(description = "Validate when the user searches by Product Name or sku the correct result will be shown")
    public void searchByProductName() {
        new SearchFeature(driver).urlNavigate()
                .searchWithProductName(testData.getTestData("productName"))
                .clickOnSearchButton()
                .validateSearchWithProductName(testData.getTestData("expectedUrl"), testData.getTestData("searchWord"))
                .searchWithSku(testData.getTestData("sku")).clickOnSearchButton()
                .validateSearchWithSku(testData.getTestData("sku"));
    }




    @Test(description = "Validate when the user searches for a book by product name")
    public void searchBookByProductName() {
        new SearchFeature(driver).urlNavigate()
                .searchWithProductName(testData.getTestData("SecondsearchWord"))
                .clickOnSearchButton()
                .validateSearchWithProductName(testData.getTestData("expectedUrl"),
  testData.getTestData("SecondsearchWord")).searchWithSku(testData.getTestData("Secondsku"))
                .clickOnSearchButton().validateSearchWithSku(testData.getTestData("Secondsku"));

    }


 @Test(description = "Validate accuracy of Nike product search results by product name and SKU")
    public void searchNikeByProductName() {
        new SearchFeature(driver).urlNavigate()
                .searchWithProductName(testData.getTestData("ThirdsearchWord"))
                .clickOnSearchButton()
                .validateSearchWithProductName(testData.getTestData("expectedUrl"),
   testData.getTestData("ThirdsearchWord")).searchWithSku(testData.getTestData("Thirdsku"))
                .clickOnSearchButton()
                .validateSearchWithSku(testData.getTestData("Thirdsku"));
    }



    @AfterMethod
    @Description("Close the Browser after test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}