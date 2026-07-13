package org.prog.session12;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

//TODO: on allo ua page - for first 3 goods print and assert not null goods price and goods code
//TODO: Hint: use Actions to see code

public class WebTest {

    private WebDriver driver;

    private Random random = new Random();

    @BeforeSuite
    public void beforeSuite() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
        WebElement productCard =
                wait.until(ExpectedConditions.elementToBeClickable(By.className("product-card")));

        List<WebElement> productCards = driver.findElements(By.className("product-card"));
        Assert.assertNotNull(productCards);
        Assert.assertTrue(productCards.size() > 3);


        for (int i = 0; i < 3; i++) {
            Actions actions = new Actions(driver);
            actions.moveToElement(productCards.get(i)).perform();

            List<WebElement> skuWebElements = productCards.get(i).findElements(By.className("product-sku__value"));
            Assert.assertNotNull(skuWebElements);

            List<WebElement> priceWebElements = productCards.get(i).findElements(By.className("sum"));
            Assert.assertNotNull(priceWebElements);

            System.out.println(skuWebElements.getFirst().getText() + " - " + priceWebElements.getLast().getText());
        }
    }
}


















