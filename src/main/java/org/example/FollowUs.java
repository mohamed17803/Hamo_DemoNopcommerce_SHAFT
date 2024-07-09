package org.example;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class FollowUs {
    private final SHAFT.GUI.WebDriver driver;

    public FollowUs(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigate to the home page URL")
    public FollowUs urlNavigate() {
        driver.browser().navigateToURL("https://demo.nopcommerce.com/");
        return this;
    }

    // Locators
    private  By Facebook =By.className("facebook");
    private  By Twitter = By.className("twitter");
    private  By RSSlink = By.className("rss");
    private  By Youtube = By.className("youtube");

    // Actions
    @SneakyThrows
    public FollowUs clickAndValidateFacebookUrl(String expectedFaceBookUrl) {
        // Click on the Desired Icon
        driver.element().click(Facebook);

        // Wait for the new tab to open
        Thread.sleep(2000);

      // Retrieve handles of all open browser windows/tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getDriver().getWindowHandles());

        // Switch to the new tab
        driver.getDriver().switchTo().window(tabs.get(1));

        // Validate the URL in the new tab
        driver.verifyThat().browser().url().isEqualTo(expectedFaceBookUrl).perform();

        // Close the new tab
        driver.getDriver().close();

        // Switch back to the original tab
        driver.getDriver().switchTo().window(tabs.get(0));

        return this;
    }

    @SneakyThrows
    @Step("Click on Twitter (X) link icon and validate URL")
    public  FollowUs clickandvalidateTwitter(String expectedXurl){

        driver.element().click(Twitter);
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(driver.getDriver().getWindowHandles());
        driver.getDriver().switchTo().window(tabs.get(1));
        driver.verifyThat().browser().url().isEqualTo(expectedXurl).perform();
        driver.getDriver().close();
        driver.getDriver().switchTo().window(tabs.get(0));
        return this;

    }


    @SneakyThrows
    @Step( "Click on RSS link icon and validate URL")
    public FollowUs clickandValidateRSSlink(String expectedRSSurl) {
        driver.element().click(RSSlink);
        Thread.sleep(2000); // Adjust sleep time as necessary

        ArrayList<String> tabs = new ArrayList<>(driver.getDriver().getWindowHandles());

        // Ensure there's at least one window handle available
        if (tabs.size() > 1) {
            driver.getDriver().switchTo().window(tabs.get(1));
        } else {
            //  handle the case where only one window is available
            System.out.println("Only one window handle available. Performing validation in the current window.");
        }

        // Validate the URL in the current new tab
        driver.verifyThat().browser().url().isEqualTo(expectedRSSurl).perform();

        // Close the new tab  applicable
        if (tabs.size() > 1) {
            driver.getDriver().close();
            driver.getDriver().switchTo().window(tabs.get(0));
        }

        return this;
    }


    public  FollowUs YoutubeclickandValidation(String expectedYoutubeurl){

        driver.element().click(Youtube);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> tabs = new ArrayList<>(driver.getDriver().getWindowHandles());
        driver.getDriver().switchTo().window(tabs.get(1));
        driver.verifyThat().browser().url().isEqualTo(expectedYoutubeurl).perform();
        driver.getDriver().close();
        driver.getDriver().switchTo().window(tabs.get(0));
        return this;
    }


}
