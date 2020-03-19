package ru.cucumber.habr.steps;

import cucumber.api.java.en.Then;
import ru.cucumber.habr.pages.HubPage;

import static org.junit.Assert.assertEquals;

public class HubPageStepdefs {

    private HubPage hubPage;

    public HubPageStepdefs() {
        hubPage = new HubPage();
    }

    @Then("I check open \"(.*)\" page")
    public void iCheckOpenPage(String company) {
        assertEquals("title not found",company,
                hubPage.title.getText());
    }

}
