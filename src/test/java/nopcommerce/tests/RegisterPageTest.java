package nopcommerce.tests;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import org.example.RegisterPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Annotations
@Epic("User Management ")
@Feature("RegisterPage")

public class RegisterPageTest {
    private SHAFT.GUI.WebDriver driver;
     private JSONFileManager testData ;
@BeforeClass
@Description("Setting JSON File")
public void beforeClass() {
    testData = new JSONFileManager("src/test/resources/nopcommerce.TestData/RegisterPageTestData.json");

}
@Test(description = "Validate that the User registration is successfully done ")
public void  ValidateRegistration(){
 new RegisterPage(driver).urlNavigate().ClickOnRegisterButton().ClickOnMaleOption().FillRegisterPageData(testData.getTestData("firstName"),
         testData.getTestData("lastName"), testData.getTestData("email"),testData.getTestData("companyName"),
         testData.getTestData("password"),testData.getTestData("confirmPassword"))
         .DateOfBirthSelection(testData.getTestData("Day"),
                 testData.getTestData("Month"),
                 testData.getTestData("Year")).ClickOnButtonOfRegister().ValidateRegistration(testData.getTestData("alertText"),
                 testData.getTestData("color"));

}
    @BeforeMethod
    @Description("Navigating to Url")
    public void setup() {
driver= new SHAFT.GUI.WebDriver() ;

    }
    @AfterMethod
    @Description("Close the browser after the Test")
    public void  tearDown() {
        driver.browser().closeCurrentWindow();
    }
}

