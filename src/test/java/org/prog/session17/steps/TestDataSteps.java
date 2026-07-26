package org.prog.session17.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.prog.session13.dto.NameDto;
import org.prog.session13.dto.PersonDto;
import org.prog.session13.dto.ResultsDto;
import org.prog.session17.DataHolder;

import java.util.ArrayList;
import java.util.Map;

public class TestDataSteps {

    @Given("A person with data {string}")
    public void createPerson(String alias, DataTable dataTable) {
        ResultsDto dto = new ResultsDto();
        dto.setResults(new ArrayList<>());

        PersonDto personDto = new PersonDto();
        NameDto  nameDto = new NameDto();

        Map<String, String> userData = dataTable.asMap();
        nameDto.setFirst(userData.get("first"));
        nameDto.setLast(userData.get("last"));
        nameDto.setTitle(userData.get("title"));
        personDto.setGender(userData.get("gender"));
        personDto.setNat(userData.get("nat"));
        personDto.setName(nameDto);
        dto.getResults().add(personDto);
        DataHolder.data.put(alias, dto);
    }

}
