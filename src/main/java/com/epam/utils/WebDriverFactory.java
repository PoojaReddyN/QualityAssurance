package com.epam.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    private static WebDriver driver=null;

    private WebDriverFactory() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            FirefoxOptions firefoxOptions =new FirefoxOptions();
            firefoxOptions.addArguments("--open-maximized");
            //firefoxOptions.addArguments("--headless");
            driver=new FirefoxDriver(firefoxOptions);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

}
