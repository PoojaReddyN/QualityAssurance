package com.epam.Pages;

import com.epam.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AtlassionHomePage {

    private WebDriver driver;

    @FindBy(xpath = "//button[@name='sign-in']")
    WebElement signInButton;

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameField;

    @FindBy(xpath = "//button[@id='login-submit']")
    WebElement loginButton;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//img[@class='css-imugma']")
    WebElement profileIcon;

    @FindBy(xpath = "//span[@class='css-uokyes'][text()='Account settings']")
    WebElement accountSettings;

    @FindBy(xpath = "//p[@class='css-rjsthw']")
    WebElement emailId;

    public AtlassionHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void clickSignInButton() {
        WaitHelper.waitForElementToBeVisible(driver, signInButton, 10);
        signInButton.click();
    }

    private void enterUsername(String username) {
        WaitHelper.waitForElementToBeVisible(driver, usernameField, 10);
        usernameField.sendKeys(username);
    }

    private void enterPassword(String password) {
        WaitHelper.waitForElementToBeVisible(driver, passwordField, 10);
        passwordField.sendKeys(password);
    }

    private void clickLoginButton() {
        loginButton.click();
    }

    public void login(String username, String password) {
        clickSignInButton();
        enterUsername(username);
        clickLoginButton();
        enterPassword(password);
        clickLoginButton();
    }

    public void clickProfileIcon() {
        WaitHelper.waitForElementToBeVisible(driver, profileIcon, 10);
        profileIcon.click();
    }

    public String getEmailId() {
        return emailId.getText();
    }

    public AtlassianProfilePage navigateToAtlassianProfilePage() {
        accountSettings.click();
        return new AtlassianProfilePage(driver);
    }
}
