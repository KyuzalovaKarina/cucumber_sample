package ru.cucumber.habr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.cucumber.habr.utils.Driver;
import ru.cucumber.habr.utils.DriverEnum;

public class BasePage {

    protected WebDriver driver;

    public BasePage(){
        String driverName = System.getProperty("driver").toUpperCase();
        driver = Driver.setDriver(DriverEnum.valueOf(driverName));
        PageFactory.initElements(driver,this);
    }
}
