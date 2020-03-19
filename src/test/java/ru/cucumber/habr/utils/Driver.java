package ru.cucumber.habr.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    public static WebDriver setDriver(DriverEnum driverType) {
        switch (driverType) {
            case FIREFOX: {
                return getFirefoxDriver();
            }
            default: {
                return getChromeDriver();
            }
        }
    }

    public static WebDriver getChromeDriver() {
        if (driver == null) {
            //WebDriverManager.chromedriver().setup();
            //System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
            try {
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                driver = //new ChromeDriver();
                        new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), capability);
            } catch (Exception e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getFirefoxDriver() {
        if (driver == null) {
            //System.setProperty("webdriver.gecko.driver","C:\\Tools\\geckodriver.exe");
            WebDriverManager.firefoxdriver().setup();
            DesiredCapabilities capability = DesiredCapabilities.firefox();
            try {
                //driver = new FirefoxDriver();
                 driver =  new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), capability);
            } catch (Exception e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
