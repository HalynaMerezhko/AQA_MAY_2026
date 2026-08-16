package org.prog.session12;

import groovy.util.MapEntry;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.prog.session12.pages.AlloPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.Random;

//TODO: on allo ua page - for first 3 goods print and assert not null goods price and goods code
//TODO: Hint: use Actions to see code

public class WebTest {

    private WebDriver driver;
    private AlloPage alloPage;
    private Connection connection;

    private Random random = new Random();

    @BeforeSuite
    public void beforeSuite() throws SQLException {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        alloPage = new AlloPage(driver);
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db",
                "root", "password");
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }

    @Test
    public void alloTest() throws Exception {
        alloPage.loadPage();
        alloPage.search("Iphone");
        int cardsCount = 3;
        List<WebElement> productCards = alloPage.getProductCards(cardsCount);
        Map<String, String> productInfo = alloPage.getProductInfo(productCards, cardsCount);

        PreparedStatement statement = connection.prepareStatement("INSERT INTO phones (Model, Price) VALUES(? , ?)");
        for (Map.Entry<String, String> record: productInfo.entrySet()){
            try{
                statement.setString(1, record.getKey());
                statement.setString(2, record.getValue());
                statement.execute();
            } catch (SQLException e) {
                System.out.println("Failes to insert phone " + record.getKey());
            }
        }
    }
}


















