package com.epam.Pages;

import com.epam.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

    private WebDriver driver;

    @FindBy(xpath = "//textarea[@class='gLFyf']")
    WebElement searchField;

    @FindBy(xpath = "//div[@class='byrV5b']")
    WebElement atlassianButton;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterSearchText(String text) {
        searchField.sendKeys(text);
        searchField.submit();
    }

    public AtlassionHomePage navigateToAtlassianHomePage(WebDriver driver){
        WaitHelper.waitForElementToBeVisible(driver,atlassianButton, 10);
        atlassianButton.click();
        return new AtlassionHomePage(driver);
    }


}
