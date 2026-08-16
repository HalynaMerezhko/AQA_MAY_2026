package org.prog.session15.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.prog.session12.pages.AlloPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AlloWebSteps {
    private List<WebElement> productCards;
    private Map<String, String> productInfo;
    public static Connection connection;
    public static AlloPage alloPage;

    @Given("I load Allo.ua page")
    public void loadPage(){
        alloPage.loadPage();
    }

    @Given("I search {string} products page")
    public void search(String searchText) throws Exception {
        alloPage.search(searchText);
    }

    @When("I get product cards, not less then {int}")
    public void getProductCards(int minCardsCount) {
        productCards = alloPage.getProductCards(minCardsCount);
    }

    @When("I get from product cards models and prices for {int} cards")
    public void getProductInfo(int cardsCount) {
        productInfo = alloPage.getProductInfo(productCards, cardsCount);
    }

    @Then("I insert models and prices into phones")
    public void insertProductInfoToPhones() throws SQLException {
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
