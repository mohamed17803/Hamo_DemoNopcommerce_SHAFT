package org.example;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
// initialize the driver
public class RegisterPage {
    private final SHAFT.GUI.WebDriver driver;

    public RegisterPage(SHAFT.GUI.WebDriver driver) {

        this.driver = driver;
    }
// Url Navigation :
    public  RegisterPage urlNavigate() {
        String pageURL = "https://demo.nopcommerce.com/";
        driver.browser().navigateToURL(pageURL);
        return this;
    }


    // Locators :
 private   By  RegisterButton = By.xpath("//a[@class=\"ico-register\"]") ;
 private   By  MaleOption  = By.id("gender-male")   ;
 private   By  FirstNameTextBox = By.id("FirstName") ;
 private   By  LastNameTextBox = By.id("LastName") ;
 private   By  DayOfBirth  =  By.name("DateOfBirthDay") ;
 private   By  MonthOfBirth  =  By.name("DateOfBirthMonth") ;
 private   By  YearOfBirth  =  By.name("DateOfBirthYear") ;
 private   By  EmailTextBox  =  By.xpath("//div[@class=\"inputs\"]/input[@id=\"Email\"]");
 private   By  CompanyName  = By.id("Company") ;
 private   By PasswordTextBox = By.xpath("//div[@class=\"inputs\"]/input[@id=\"Password\"]");
 private   By ConfirmPasswordTextBox = By.xpath("//div[@class=\"inputs\"]/input[@id=\"ConfirmPassword\"]") ;
 private   By ButtonOfRegister = By.xpath("//div[@class=\"buttons\"]/button[@id=\"register-button\"]") ;
 private   By StatusAlert    = By.className("result");



 // Actions :


    // A method to navigate to the Registration Page
 public RegisterPage ClickOnRegisterButton() {
     driver.element().click(RegisterButton);
     return this;
 }
 public  RegisterPage ClickOnMaleOption() {

     driver.element().click(MaleOption);
     return this;
 }

    public RegisterPage FillRegisterPageData(String FirstName , String LastName, String Email ,String companyName, String Password , String ConfirmPassword) {

        driver.element().type(FirstNameTextBox, FirstName);
        driver.element().type( LastNameTextBox  , LastName);
        driver.element().type(EmailTextBox, Email);
        driver.element().type(CompanyName,companyName );
        driver.element().type(PasswordTextBox, Password);
        driver.element().type(ConfirmPasswordTextBox, ConfirmPassword);

        return this ;
    }

public  RegisterPage DateOfBirthSelection (String Day , String Month , String Year ) {

     driver.element().select(DayOfBirth, Day);
     driver.element().select(MonthOfBirth, Month);
     driver.element().select(YearOfBirth, Year);
          return this ;


}

    public RegisterPage ClickOnButtonOfRegister() {
        driver.element().click(ButtonOfRegister) ;
        return this ;
    }

    @Step("Validate that the User registration is successfully done ")
    public void ValidateRegistration (String alertText , String color) {
        driver.verifyThat().element(StatusAlert).text().isEqualTo(alertText);
        driver.verifyThat().element(StatusAlert).cssProperty("color").isEqualTo(color).perform();
    }


}
