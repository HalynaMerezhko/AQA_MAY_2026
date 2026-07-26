package org.prog.session15.steps;

import io.cucumber.java.en.When;
import org.prog.session14.pages.GooglePage;

public class WebSteps {

    public static GooglePage googlePage;

    @When("I load google page")
    public void loadGooglePage() {
        googlePage.loadPage();
    }

    @When("I accept cookies if present")
    public void acceptCookiesIfPresent() {
        googlePage.acceptCookiesIfPresent(true);
    }

    @When("I set search input to random persons name")
    public void setSearchInputToRandomPersonsName() throws InterruptedException {
        googlePage.setSearchValue(DBSteps.randomUser);
        Thread.sleep(10000);
    }
}
