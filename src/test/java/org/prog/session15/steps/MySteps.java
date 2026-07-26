package org.prog.session15.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class MySteps {

    WebDriver driver;

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
}
