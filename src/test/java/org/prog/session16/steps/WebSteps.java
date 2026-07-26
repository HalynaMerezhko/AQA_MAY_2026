package org.prog.session16.steps;

import io.cucumber.java.en.When;
import org.prog.session14.pages.GooglePage;
import org.prog.session16.DataHolder;

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

    @When("I set search input to {string} name")
    public void setSearchInputToRandomPersonsName(String alias) throws InterruptedException {
        googlePage.setSearchValue((String) DataHolder.data.get(alias));
        Thread.sleep(10000);
    }
}
