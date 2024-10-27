package Desktop;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.options.WindowsOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class NotpadTest {

    WebDriver driver;

    @BeforeClass
    public void setUp()  {
        WindowsOptions options = new WindowsOptions();
        options.setCapability("app", "notepad.exe");
        options.setCapability("automationName", "WinAppDriver");

        try {
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testOpenNotepadAndTypeMessage() {
        WebElement textArea = driver.findElement(By.name("Text editor"));
        String message = "Hello!! This is an automated notepad document, written using WinAppDriver. Iam Pooja Nuthula, a java automation tester.";
        textArea.sendKeys(message);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
