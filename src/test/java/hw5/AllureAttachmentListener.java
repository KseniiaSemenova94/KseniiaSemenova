package hw5;

import hw5.base.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;

@Listeners(AllureAttachmentListener.class)
public class AllureAttachmentListener extends TestListenerAdapter {

        @Attachment(value = "Attachment: {0}", type = "image/png")
        public byte[] makeScreenshot(String name) {
            byte[] array = {1};
            try {
                return ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BYTES);
            } catch (WebDriverException e) {
                e.printStackTrace();
            }
            return array;
        }

        @Override
        public void onTestFailure(ITestResult tr) {
            makeScreenshot("failed");
        }
    }

