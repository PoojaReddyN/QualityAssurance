package com.epam.Pages;

import com.epam.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AtlassianProfilePage {

    private WebDriver driver;

    @FindBy(xpath = "//button[@data-testid='profile-avatar-dropdown-trigger']")
    WebElement profilePictureIcon;

    @FindBy(xpath = "//span[text()='Create initials avatar']")
    WebElement createAvatarButton;

    @FindBy(xpath = "//button[@style = 'background-color: rgb(0, 163, 191);']")
    WebElement tealColor;

    @FindBy(xpath = "//input[@placeholder='Enter up to 4 initials']")
    WebElement initialsField;

    @FindBy(xpath = "//button[@data-testid='update-button']")
    WebElement updateButton;

    @FindBy(xpath = "//button[@data-testid='cancel-button']")
    WebElement cancelButton;

    @FindBy(xpath = "//span[text()='Log out']")
    WebElement logoutButton;

    public AtlassianProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProfilePictureIcon() {
        WaitHelper.waitForElementToBeVisible(driver, profilePictureIcon, 10);
        profilePictureIcon.click();
    }

    public void clickCreateAvatarButton() {
        WaitHelper.waitForElementToBeVisible(driver, createAvatarButton, 10);
        createAvatarButton.click();
    }

    public void clickTealColor() {
        WaitHelper.waitForElementToBeVisible(driver, tealColor, 10);
        tealColor.click();
    }

    public void enterInitials(String initials) {
        initialsField.sendKeys(initials);
    }

    public void clickUpdateButton() {
        updateButton.click();
    }

    public void clickOnLogoutButton() {
        logoutButton.click();
    }
}
