package ru.cucumber.habr.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import ru.cucumber.habr.utils.Driver;

public class BasePageStepdefs {

    @Before
    public void before() {
        System.out.println("before");
        System.setProperty("driver","chrome");
    }

    @After
    public void after(){
        System.out.println("after hooks");
        Driver.closeDriver();
    }
}
