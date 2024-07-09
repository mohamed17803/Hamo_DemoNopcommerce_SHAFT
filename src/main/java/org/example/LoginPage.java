package org.example;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage {
    private final SHAFT.GUI.WebDriver driver;

    // Constructor to initialize the driver
    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Method for navigating to the URL
    public LoginPage urlNavigate() {
        String pageURL = "https://demo.nopcommerce.com/"; // Navigating to the home page URL
        driver.browser().navigateToURL(pageURL);
        return this;
    }

    // Locators
    private final By LoginTabButton = By.xpath("//div[@class=\"header-links-wrapper\"]//a[@href=\"/login?returnUrl=%2F\"]");
    private final By EmailTextBox = By.xpath("//div[@class=\"inputs\"]/input[@id=\"Email\"]");
    private final By PasswordTextBox = By.xpath("//div[@class=\"inputs\"]/input[@id=\"Password\"]");
    private final By ButtonOfLogin = By.xpath("//div[@class=\"buttons\"]/button[@class=\"button-1 login-button\"]");
    private final By Myaccounttab = By.className("ico-account");
    private final By ErrorMessage =  By.xpath("//div[contains(text(),'Login was unsuccessful')]");


    // Actions
    public LoginPage ClickOnLoginTabButton() {
        driver.element().click(LoginTabButton);
        return this;
    }

    public LoginPage FillLoginData(String username, String password) {
        driver.element().type(EmailTextBox, username);
        driver.element().type(PasswordTextBox, password);
        return this;
    }

    public LoginPage ClickOnButtonOfLogin() {
        driver.element().click(ButtonOfLogin);
        return this;
    }

    @Step("Validate that the Login process is correctly done")
    public void Loginvalidation(String expectedUrl) {
        driver.verifyThat().element(Myaccounttab).isVisible().perform();
        driver.verifyThat().browser().url().isEqualTo(expectedUrl).perform(); // Verify the URL
    }
    @Step("Validate that the User cannot Login with a wrong data  ")
    public  void  Validatewronglogin(String expectedErrorMessage, String colorOfErrorMessage) {
        driver.verifyThat().element(ErrorMessage).text().isEqualTo(expectedErrorMessage).perform();


    }

}
