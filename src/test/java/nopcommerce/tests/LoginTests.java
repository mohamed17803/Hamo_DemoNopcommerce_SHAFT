package nopcommerce.tests;


import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.example.LoginPage;
import org.testng.annotations.*;

@Epic("Login Functionality")
@Story("Login with valid and invalid credentials")

public class LoginTests {
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
        testData = new JSONFileManager("src/test/resources/nopcommerce.TestData/LoginPageTestData.json");
    }

    @Test(description = "Validating that user could login with valid email and password")
    public void ValidateLogin() {

        new LoginPage(driver).urlNavigate().ClickOnLoginTabButton().FillLoginData(testData.getTestData("UserName")
                ,testData.getTestData("Password")).ClickOnButtonOfLogin().Loginvalidation(testData.getTestData("expectedUrl"));    }

    @Test(description = "Validate user could not login with invalid email and password")
     public void ValidateNotLogin() {
        new LoginPage(driver).urlNavigate().ClickOnLoginTabButton().FillLoginData(testData.getTestData("WrongUsername"), "WrongPassword")
                .ClickOnButtonOfLogin().Validatewronglogin(testData.getTestData("expectedErrorMessage")
                        ,testData.getTestData("colorOfErrorMessage"));

    }

    @AfterMethod
    @Description("Close the Browser after test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
