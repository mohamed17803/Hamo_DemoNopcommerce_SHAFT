package org.example;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomeSliders {

  private   SHAFT.GUI.WebDriver driver ;

    public HomeSliders (SHAFT.GUI.WebDriver driver) {
        this.driver = driver ;
    }

    // Method of urL navigation

    public  HomeSliders uRlnavigate(){

        driver.browser().navigateToURL("https://demo.nopcommerce.com/");
        return this ;
    }


    // Locators

   private  By FirstSlider = By.xpath("(//div[@class=\"nivoSlider\"]//a[@class=\"nivo-imageLink\"])[1]") ;
   private  By SecondSlider = By.xpath("(//div[@class=\"nivoSlider\"]//a[@class=\"nivo-imageLink\"])[2]");


   //Actions
    public HomeSliders validateIphoneSlider(String expectedIphoneUrl){
        //driver.element().waitToBeReady(iphoneSLider);
        driver.waitUntil(ExpectedConditions.elementToBeSelected(FirstSlider));
        driver.element().click(FirstSlider);
        String currentUrl= driver.browser().getCurrentURL();
        Assert.assertEquals(currentUrl,expectedIphoneUrl,"The url after click on slider doesn't match the expected URL");
        return this;
    }
    public HomeSliders validateGalaxySLider(String expectedGalaxyUrl){
        driver.waitUntil(ExpectedConditions.elementToBeClickable(SecondSlider));
        driver.element().click(SecondSlider);
        String currentUrl = driver.browser().getCurrentURL();
        Assert.assertEquals(currentUrl,expectedGalaxyUrl,"doesn't match ");
        return this;
    }
}