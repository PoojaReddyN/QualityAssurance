package UI;

import com.epam.Pages.AtlassianProfilePage;
import com.epam.Pages.AtlassionHomePage;
import com.epam.Pages.GooglePage;
import com.epam.utils.ConfigLoader;
import com.epam.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AtlassianTest {

    String email = ConfigLoader.getProperty("email");
    String password = ConfigLoader.getProperty("password");
    String url = ConfigLoader.getProperty("BrowserUri");
    WebDriver driver;
    GooglePage googlePage;
    AtlassionHomePage atlassionHomePage;
    AtlassianProfilePage atlassianProfilePage;

    @BeforeClass
    public void setUp() {
        driver= WebDriverFactory.getDriver();
        driver.get(url);
    }

    @Test(priority = 1)
    public void loginToApplication() {
        googlePage = new GooglePage(driver);
        googlePage.enterSearchText("atlassian");
        atlassionHomePage=googlePage.navigateToAtlassianHomePage(driver);
        atlassionHomePage.login(email,password);
    }

    @Test(priority = 2)
    public void assertEmail(){
        atlassionHomePage.clickProfileIcon();
        Assert.assertTrue(atlassionHomePage.getEmailId().contains(email),"Email id is not matching");
    }

    @Test(priority = 3)
    public void createAvatar(){
        atlassianProfilePage = atlassionHomePage.navigateToAtlassianProfilePage();
        atlassianProfilePage.clickProfilePictureIcon();
        atlassianProfilePage.clickCreateAvatarButton();
        atlassianProfilePage.clickTealColor();
        atlassianProfilePage.enterInitials("NPR");
        atlassianProfilePage.clickUpdateButton();
    }

    @Test(priority = 4)
    public void logout(){
        atlassianProfilePage = atlassionHomePage.navigateToAtlassianProfilePage();
        atlassianProfilePage.clickOnLogoutButton();
    }

    @AfterClass
    public void tearDown() {
        WebDriverFactory.closeDriver();
    }

}
