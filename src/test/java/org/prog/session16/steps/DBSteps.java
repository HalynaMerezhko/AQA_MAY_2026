package org.prog.session16.steps;

import io.cucumber.java.en.Given;
import org.prog.session13.dto.PersonDto;
import org.prog.session13.dto.ResultsDto;
import org.prog.session16.DataHolder;

import java.sql.*;

public class DBSteps {
    public static Connection connection;

    @Given("I store {string} in DB")
    public void storePeopleInDB(String alias) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
                        "VALUES (? , ? , ? , ? , ?)");

        ResultsDto dto = (ResultsDto) DataHolder.data.get(alias);

        for (PersonDto personDto : dto.getResults()) {
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

    @Given("I pick one random person from DB as {string}")
    public void pickOneRandomPersonFromDB(String alias) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Persons ORDER BY RAND() LIMIT 1");
        if (resultSet.next()) {
            String randomUser = resultSet.getString("FirstName") + " " + resultSet.getString("LastName");
            DataHolder.data.put(alias, randomUser);
        }
    }
}
