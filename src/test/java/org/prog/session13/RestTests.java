package org.prog.session13;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

//TODO: Add location to request, assert city name and street name not not for all persons;
// https://randomuser.me/documentation

public class RestTests {

    @Test
    public void restTest1() {
        RestAssured.given()
                .baseUri("https://randomuser.me/")
                .basePath("/api")
                .queryParam("noinfo")
                .queryParam("inc", "gender,name,nat,location")
                .queryParam("results", 10)
                .get()
                .then()
                .statusCode(200)
                .body("results.gender", Matchers.hasItem("female"))
                .body("results.name.title", Matchers.hasItem("Ms"))
                .body("results.location.street.name", Matchers.everyItem(Matchers.notNullValue()))
                .body("results.location.city", Matchers.everyItem(Matchers.notNullValue()));
    }
}