package org.prog.session17.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;
import java.util.Random;

public class MySteps {

    private static ThreadLocal<String> pageName = new ThreadLocal<>();

    @Given("I have something {string}")
    public void given(String value) {
        System.out.println("Executing step: I have something " + value);
    }

    @When("I do something {int} times")
    public void when(int i) {
        System.out.println("Executing step: I do something " + i + " times");
    }

    @Then("I click {}")
    public void then(GooglePageElements element) {
//        driver.findElement(element.getLocator()).click();
    }

    @Given("data table stuff")
    public void dataTableStuff(DataTable dataTable) {
        Map<String, String> userData = dataTable.asMap();
        for (Map.Entry<String, String> entry : userData.entrySet()) {
            System.out.println("Add to BD: " + entry.getKey() + ": " + entry.getValue());
        }
    }

    //IMAGINE: we use web driver
    @Given("Fail {int} in {int} for {string}")
    public void failIn(int value1, int value2, String webPage) throws InterruptedException {
        Random random = new Random();
        int i = random.nextInt(value2);
        int executionTime = random.nextInt(10000);
        pageName.set(webPage);
        Thread.sleep(executionTime);
        System.out.println(">>>>>> Page name " + pageName.get());
        Assert.assertTrue(value1 < i, "Failing " + value1 + " should be > " + i);
    }
}
