package org.prog.session15;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.session12.pages.AlloPage;
import org.prog.session14.pages.GooglePage;
import org.prog.session15.steps.AlloWebSteps;
import org.prog.session15.steps.DBSteps;
import org.prog.session15.steps.WebSteps;
import org.prog.session15.util.DBConnectionFactory;
import org.prog.session15.util.WebDriverFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.DriverManager;
import java.sql.SQLException;

//TODO: previous HW in cucumber

@CucumberOptions(
        features = {"src/test/resources/features/homework-15"},
        glue = "org.prog.session15.steps",
        plugin = {
                "pretty",
                "html:target/report.html",
                "json:target/Cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
//        ,tags = "@regression and not @skip"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    private WebDriver driver;
    private AlloPage alloPage;

    @SneakyThrows
    @BeforeSuite
    public void beforeSuite() {
        driver = WebDriverFactory.getDriver();
        alloPage = new AlloPage(driver);
        AlloWebSteps.alloPage = alloPage;
        AlloWebSteps.connection = DBConnectionFactory.getConnection();
    }

    @AfterSuite
    public void afterSuite1() {
        driver.quit();
    }

    @AfterSuite
    public void afterSuite2() throws SQLException {
        AlloWebSteps.connection.close();
    }
}
