package org.prog.session15.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import org.prog.session13.dto.ResultsDto;

public class RestSteps {

    public static ResultsDto resultsDto;

    @Given("I request {int} random people from random user service")
    public void requestUsers(int amount) {
        resultsDto = RestAssured.given()
                .baseUri("https://randomuser.me/")
                .basePath("/api")
                .queryParam("noinfo")
                .queryParam("results", amount)
                .queryParam("inc", "gender,name,nat")
                .get()
                .as(ResultsDto.class);
    }
}
