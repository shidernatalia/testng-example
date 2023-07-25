package PageObjectTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BootstrapProgressBarPage;

public class ProgressBarTest extends BaseTest {
    BootstrapProgressBarPage bootstrapProgressBarPage = new BootstrapProgressBarPage();
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void testProgressBarPercentage(){
        homePage.clickBootstrapProgressBarPage()
                .clickStartDwonloadButton();

        softAssert.assertEquals(bootstrapProgressBarPage.getCompletedMessage(),
                "Download completed!",
                "\nMessage is not - Download complete!\n");
        softAssert.assertEquals(bootstrapProgressBarPage.getProgressBarPercentage(),
                "100%",
                "\nPercentage is not - 100%\n");
        softAssert.assertAll();
    }
}
