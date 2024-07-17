package nopcommerce.tests;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.example.FollowUs;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Social Media Links Validation")
@Story("Validate the social media links on the homepage")
public class FollowUsTests {

    private SHAFT.GUI.WebDriver driver;
    private JSONFileManager testData;

    @BeforeClass
    @Description("Setting JSON File")
    public void BeforeClass() {
        testData = new JSONFileManager("src/test/resources/nopcommerce.TestData/FollowUsTestData.json");
    }

    @BeforeMethod
    @Description("Navigate To URL")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test(description = "Validate that the user is navigated to the Facebook page of the website correctly")
    public void FacebookValidation() {

        new FollowUs(driver).urlNavigate()
                .clickAndValidateFacebookUrl(testData.getTestData("expectedFacebookUrl"));
    }
    @Test(description = "Validate that the user is navigated to the Twitter page of the website correctly")
    public  void  TwitterValidation(){
        new FollowUs(driver).urlNavigate().clickandvalidateTwitter(testData.getTestData("expectedTwitterUrl"));

    }

    @Test(description = "Validate that the user is navigated to the RSSlink page of the website correctly")
    public  void RsslinkValidation(){

        new FollowUs(driver).urlNavigate().clickandValidateRSSlink(testData.getTestData("expectedRssUrl"));
    }
    @Test(description ="Validate that the user is navigated to the Youtube page of the website correctly" )
    public void  YoutubeValidation(){
        new FollowUs(driver).urlNavigate().YoutubeclickandValidation(testData.getTestData("expectedYoutubeUrl"));
    }

    @AfterMethod
    @Description("Close the Browser after test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
