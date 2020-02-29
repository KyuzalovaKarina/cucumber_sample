package ru.cucumber.habr.steps;

import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import ru.cucumber.habr.pages.HubPage;

import static org.junit.Assert.assertEquals;

public class HubPageStepdefs {

    @Autowired
    private HubPage hubPage;



    @Then("I check open \"(.*)\" page")
    public void iCheckOpenPage(String company) {
        assertEquals("title not found",company,
                hubPage.title.getText());
    }

}
