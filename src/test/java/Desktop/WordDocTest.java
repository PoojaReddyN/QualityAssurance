package Desktop;

import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.KeyEvent;

public class WordDocTest {

    @Test
    public void openWordAndTypeAndSave() {
        String wordPath = "C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE";

        {
            try {
                Runtime.getRuntime().exec(wordPath);
                Robot robot = new Robot();
                robot.delay(3000);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_N);
                robot.keyRelease(KeyEvent.VK_N);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.delay(1000);

                String message = "Hello!! This is an automated Word document created using WinAppDriver. Iam Pooja Nuthula, a java automation tester.";
                for (char c : message.toCharArray()) {
                    robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
                    robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
                    robot.delay(100);
                }

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_S);
                robot.keyRelease(KeyEvent.VK_S);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.delay(1000);

                String fileName = "AutomationDoc.docx";
                for (char c : fileName.toCharArray()) {
                    robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
                    robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
                    robot.delay(100);
                }

                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                robot.delay(1000);
                robot.keyPress(KeyEvent.VK_ALT);
                robot.keyPress(KeyEvent.VK_F4);
                robot.keyRelease(KeyEvent.VK_F4);
                robot.keyRelease(KeyEvent.VK_ALT);

            } catch (AWTException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
