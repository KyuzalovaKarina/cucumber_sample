package ru.cucumber.habr.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.test.context.ContextConfiguration;
import ru.cucumber.habr.config.Config;
import ru.cucumber.habr.utils.Driver;

@ContextConfiguration(classes = Config.class)
public class BasePageStepdefs {

    @Before
    public void before() {
        System.out.println("before");
    }

    @After
    public void after(){
        System.out.println("after hooks");
        Driver.closeDriver();
    }
}
