package org.prog.session17.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import org.prog.session13.dto.ResultsDto;
import org.prog.session17.DataHolder;

public class RestSteps {

    @Given("I request {int} random people from random user service as {string}")
    public void requestUsers(int amount, String alias) {
        ResultsDto dto = RestAssured.given()
                .baseUri("https://randomuser.me/")
                .basePath("/api")
                .queryParam("noinfo")
                .queryParam("results", amount)
                .queryParam("inc", "gender,name,nat")
                .get()
                .as(ResultsDto.class);

        DataHolder.data.put(alias, dto);
    }
}
