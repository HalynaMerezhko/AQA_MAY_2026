package org.prog.session12.pages;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;

public class AlloPage {

    private final WebDriver driver;

    public AlloPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://allo.ua/");
    }

    public void search(String searchText) throws Exception {
        List<WebElement> searchPanels = driver.findElements(By.id("search-form__input"));

        if (searchPanels.size() != 1) {
            throw new Exception("Search penal is not found");
        }
        WebElement searchPanel = searchPanels.get(0);
        searchPanel.click();
        searchPanel.sendKeys(searchText);
        searchPanel.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
        WebElement productCard =
                wait.until(ExpectedConditions.elementToBeClickable(By.className("product-card")));
    }

    public List<WebElement> getProductCards(int minCardsCount) {
        List<WebElement> productCards = driver.findElements(By.className("product-card"));
        Assert.assertNotNull(productCards);
        Assert.assertTrue(productCards.size() > minCardsCount);
        return productCards;
    }

    public Map<String, String> getProductInfo(List<WebElement> productCards, int cardsCount) {
        Map<String, String> productInfo = new HashMap<>();

        for (int i = 0; i < cardsCount; i++) {
            Actions actions = new Actions(driver);
            actions.moveToElement(productCards.get(i)).perform();

            List<WebElement> modelWebElements = productCards.get(i).findElements(By.className("product-card__title"));
            Assert.assertNotNull(modelWebElements);

            List<WebElement> priceWebElements = productCards.get(i).findElements(By.className("sum"));
            Assert.assertNotNull(priceWebElements);
            String model = modelWebElements.get(0).getText();
            String price = priceWebElements.get(0).getText();
            productInfo.put(model, price);
            System.out.println(model + " - " + price);
        }

        return productInfo;
    }
}
