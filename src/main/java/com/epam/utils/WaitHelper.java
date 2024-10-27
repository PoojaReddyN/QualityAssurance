package com.epam.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {

    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement element, long timeOutInSeconds) {
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
       // WebDriverWait myWait = new WebDriverWait(driver, timeOutInSeconds);
        return myWait.until(ExpectedConditions.visibilityOf(element));
    }

}
