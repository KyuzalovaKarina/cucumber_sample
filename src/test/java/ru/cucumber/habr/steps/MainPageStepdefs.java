package ru.cucumber.habr.steps;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class MainPageStepdefs {

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger(MainPageStepdefs.class);

    public MainPageStepdefs(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("start");
    }

    public void openPage(String url) {
        driver.get(url);
        logger.info("open page" + url);
    }

    public void iOpenHubPage() {
        driver.findElement(By.xpath("//a[contains(@href,'target_type=hubs')]")).click();
        logger.info("select hubs tab");
    }

    public void iFindPost(String request) {
        driver.findElement(By.id("search-form-btn")).click();
        driver.findElement(By.id("search-form-field")).sendKeys(request, Keys.ENTER);
        logger.info("find string " +  request);
    }

    public void iCheckExistCompany(String company) {
        assertTrue(company + "not exist",driver
                .findElement(By.xpath("//a[contains(@href,'" + company + "')]"))
                .isDisplayed());
    }

    public void iClickCompany(String company) {
        driver.findElement(By.xpath("//a[contains(@href,'company/" + company + "')]")).click();
        logger.info("select company");
    }


    @Test
    public void test() {
        String company = "otus";
        openPage("https://habr.com/ru/");
        iFindPost(company);
        iOpenHubPage();
        iCheckExistCompany(company);
        iClickCompany(company);
        driver.quit();
    }
}
