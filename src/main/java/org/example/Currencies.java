package org.example;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Currencies {

 // initialize the driver
 private final SHAFT.GUI.WebDriver driver ;
 public Currencies(SHAFT.GUI.WebDriver driver){
  this.driver = driver ;
 }


 // Method for navigating to the URL

 public Currencies urlNavigate() {
  String pageURL = "https://demo.nopcommerce.com/"; // Navigating to the home page URL
  driver.browser().navigateToURL(pageURL);
  return this;
 }

 // Locators
  private  By CurrencyList =  By.id("customerCurrency");
  private  By  Firstproduct   =  By.xpath("//div[@data-productid=\"1\"]//span[@class=\"price actual-price\"]");
  private  By  Secondproduct   = By.xpath("//div[@data-productid=\"18\"]//span[@class=\"price actual-price\"]");
  private  By  Thirdproduct   = By.xpath("//div[@data-productid=\"43\"]//span[@class=\"price actual-price\"]");
  private  By  FourthProduct = By.xpath("//div[@data-productid=\"4\"]//span[@class=\"price actual-price\"]");

  //Actions
  @Step("Open currencies list and select {currency}")
 public  Currencies Openccurrencieslist(String Currency){
  driver.element().select(CurrencyList, Currency);
  return this ;

 }
 @Step("Validate that the currency symbol appears in all product prices")
 public Currencies validateCurrencySymbol(String currenysymbol) {
  String[] xPaths = {
          "//div[@data-productid=\"1\"]//span[@class=\"price actual-price\"]",
          "//div[@data-productid=\"4\"]//span[@class=\"price actual-price\"]",
          "//div[@data-productid=\"18\"]//span[@class=\"price actual-price\"]",
          "//div[@data-productid=\"43\"]//span[@class=\"price actual-price\"]"
  };
  for (int i = 0; i < xPaths.length; i++) {
   String getText = driver.element().getText(By.xpath(xPaths[i]));
   Assert.assertTrue(getText.contains(currenysymbol), " The Currency symbol was successfully found in element " + (i + 1));
  }
  return this;
 }





}
