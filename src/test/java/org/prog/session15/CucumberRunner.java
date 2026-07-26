package org.prog.session15;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.session14.pages.GooglePage;
import org.prog.session15.steps.DBSteps;
import org.prog.session15.steps.WebSteps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.DriverManager;
import java.sql.SQLException;

//TODO: previous HW in cucumber

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "org.prog.session15.steps",
        plugin = {
                "pretty",
                "html:target/report.html"
        }
//        ,tags = "@regression and not @skip"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    private WebDriver driver;

    @SneakyThrows
    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
        WebSteps.googlePage = new GooglePage(driver);
        DBSteps.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "root", "password");
    }

    @AfterSuite
    public void afterSuite1() {
        driver.quit();
    }

    @AfterSuite
    public void afterSuite2() throws SQLException {
        DBSteps.connection.close();
    }
}
