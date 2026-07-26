package org.prog.session15.steps;

import io.cucumber.java.en.Given;
import org.prog.session13.dto.PersonDto;

import java.sql.*;

public class DBSteps {
    public static Connection connection;

    public static String randomUser;

    @Given("I store those people in DB")
    public void storePeopleInDB() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
                        "VALUES (? , ? , ? , ? , ?)");

        for (PersonDto personDto : RestSteps.resultsDto.getResults()) {
            try {
                preparedStatement.setString(1, personDto.getName().getFirst());
                preparedStatement.setString(2, personDto.getName().getLast());
                preparedStatement.setString(3, personDto.getGender());
                preparedStatement.setString(4, personDto.getName().getTitle());
                preparedStatement.setString(5, personDto.getNat());
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("Failes to insert persons " + personDto);
            }
        }
    }

    @Given("I pick one random person from DB")
    public void pickOneRandomPersonFromDB() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Persons ORDER BY RAND() LIMIT 1");
        while (resultSet.next()) {
            randomUser = resultSet.getString("FirstName") + " " + resultSet.getString("LastName");
        }
    }
}
