package org.prog.session11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

//TODO: navigate to allo.ua
//TODO: find Sarch button
//TODO: search for iphone/android/whatever

public class WebTest {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }


    @Test
    public void alloTest() throws Exception {
        driver.get("https://allo.ua/");
        List<WebElement> searchPanels = driver.findElements(By.id("search-form__input"));

        if (searchPanels.size() != 1) {
            throw new Exception("Search penal is not found");
        }
        WebElement searchPanel = searchPanels.getFirst();
        searchPanel.click();
        searchPanel.sendKeys("Iphone");
        searchPanel.sendKeys(Keys.ENTER);
    }
}


















