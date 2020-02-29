package ru.cucumber.habr.config;

import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.*;
import org.springframework.test.annotation.DirtiesContext;
import ru.cucumber.habr.utils.Driver;

@Configuration
@ComponentScan("ru.cucumber.habr")
@PropertySource("classpath:config/hub.properties")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class Config {

    @Bean(value = "chrome")
    public WebDriver getDriver() {
        return Driver.getChromeDriver();
    }

    @Bean(value = "firefox")
    public WebDriver getOtherDriver() {
        return Driver.getFirefoxDriver();
    }
}
