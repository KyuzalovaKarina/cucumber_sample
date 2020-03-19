package ru.cucumber.habr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage{


    @FindBy(xpath = "//a[contains(@href,'target_type=hubs')]")
    public WebElement tabHub;

    @FindBy(id = "search-form-btn")
    public WebElement btnFind;

    @FindBy(id = "search-form-field")
    public WebElement inputFind;

    public WebElement getCompany(String company) {
       return driver.findElement(By.xpath("//a[contains(@href,'company/" + company + "')]"));
    }

    public void openUrl(String url) {
        driver.get(url);
    }

}
