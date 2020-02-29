package ru.cucumber.habr.steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ru.cucumber.habr.pages.MainPage;

import static org.junit.Assert.assertTrue;

public class MainPageStepdefs {

    private static final Logger logger = LogManager.getLogger(MainPageStepdefs.class);

    @Autowired
    private MainPage mainPage;

    @Value("${url}")
    private String url;

    @Given("I open main page")
    public void openPage() {
        mainPage.openUrl(url);
        logger.info("open page" + url);
    }

    @When("^I open hub tab$")
    public void iOpenHubPage() {
        mainPage.tabHub.click();
        logger.info("select hubs tab");
    }

    @When("I find post \"(.*)\"")
    public void iFindPost(String request) {
        mainPage.btnFind.click();
        mainPage.inputFind.sendKeys(request, Keys.ENTER);
        logger.info("find string " +  request);
    }

    @And("I check exist \"(.*)\" company")
    public void iCheckExistCompany(String company) {
        assertTrue(company + "not exist",mainPage.getCompany(company)
                .isDisplayed());
    }

    @Then("I click \"(.*)\" company")
    public void iClickCompany(String company) {
        mainPage.getCompany(company).click();
        logger.info("select company");
    }


//    @Test
//    public void test() {
//        String company = "otus";
//        openPage("https://habr.com/ru/");
//        iFindPost(company);
//        iOpenHubPage();
//        iCheckExistCompany(company);
//        iClickCompany(company);
//        driver.quit();
//    }

}
