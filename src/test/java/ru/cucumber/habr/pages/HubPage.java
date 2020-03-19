package ru.cucumber.habr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.cucumber.habr.utils.Driver;
import ru.cucumber.habr.utils.DriverEnum;

public class HubPage extends BasePage {


    @FindBy(className = "page-header__info-title")
    public WebElement title;
}
