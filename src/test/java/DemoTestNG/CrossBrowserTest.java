package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/*
* https://automation.lambdatest.com/build
* https://www.lambdatest.com/support/docs/java-with-selenium-running-java-automation-scripts-on-lambdatest-selenium-grid/
* */
public class CrossBrowserTest {
    public RemoteWebDriver driver;
    private String username = "shidernatalia";
    private String accessKey = "NQp9uDV6TOtCnV3u3F0WfgM0hYrcKO2gt3Ib0iCB0CyPfQYeBr";
    private String hub = "@hub.lambdatest.com/wd/hub";
    boolean status = false;
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

    @Parameters({"Browser", "Version", "Platform"})
    @BeforeMethod
    public void setUp(String browser, String version, String platform) {
        desiredCapabilities.setCapability("browserName", browser);
        desiredCapabilities.setCapability("version", version);
        desiredCapabilities.setCapability("platform", platform);
        desiredCapabilities.setCapability("build", "2.1");
        desiredCapabilities.setCapability("name", "Cross Browser Testing");

        desiredCapabilities.setCapability("network", true);
        desiredCapabilities.setCapability("console", true);
        desiredCapabilities.setCapability("visual", true);

        try{
            driver  = new RemoteWebDriver(
                    new URL("https://" + username + ":" + accessKey + hub), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }finally {
            tearDown();
        }
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    private void tearDown() {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit(); //really important statement for preventing your test execution from a timeout.
        }
    }
    @Test
    public void testDropDwon(){
        driver.findElement(By.linkText("Select Dropdown List")).click();
        WebElement findDropDown = driver.findElement(By.id("select-demo"));
        Select dayDropDown = new Select(findDropDown);
        dayDropDown.deselectByVisibleText("Saturday");
    }
    @Test
    public void testDragDrop(){
        driver.findElement(By.linkText("Drag and Drop")).click();
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target);
    }
}
