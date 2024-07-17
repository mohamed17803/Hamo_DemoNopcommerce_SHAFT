package nopcommerce.tests;

import org.example.HomeSliders;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;

import org.testng.annotations.*;

@Epic("Home Page Sliders Validation")
@Story("Validate sliders on different devices")
public class HomeSlidersTest  {

    private SHAFT.GUI.WebDriver driver ;
    private JSONFileManager testData;

    @BeforeClass
    public void beforeClass() {
        testData = new JSONFileManager("src/test/resources/nopcommerce.TestData/HomeSlidersTestData.json");
    }

    @Test(description = "Validate iPhone slider URL")
    @Description("Verify that the iPhone slider URL matches the expected URL")
    public void validateIphoneSlider() {
        new HomeSliders( driver).uRlnavigate()
                .validateIphoneSlider(testData.getTestData("expectedIphoneUrl"));
    }

    @Test(description = "Validate Galaxy slider URL")
    @Description("Verify that the Galaxy slider URL matches the expected URL")
    public void validateGalaxySlider() {
        new HomeSliders(driver).uRlnavigate().validateGalaxySLider(testData.getTestData("expectedGalaxyUrl"));

    }

}
