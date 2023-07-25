package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @DataProvider
    public Object[][] ajaxData() {
        Object[][] data = new Object[2][2];

        data[0][0] = "Joe Doe";
        data[0][1] = "Tester Joe Doe";
        data[1][0] = "Jane Doe";
        data[1][1] = "Tester Jane Doe";

        return data;
    }

    @Test(dataProvider = "ajaxData")
    public void testAjaxForm(String name, String comment) {
        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
        driver.findElement(By.id("title")).sendKeys(name);
        driver.findElement(By.id("description")).sendKeys(comment);
        driver.findElement(By.id("btn-submit")).click();
    }

    @Test(dataProviderClass = DataProvidersInputForm.class, dataProvider = "input-form-data-provider")
    public void testInputForm(String name, String email, String password) {
        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("inputEmail4")).sendKeys(email);
        driver.findElement(By.id("inputPassword4")).sendKeys(password);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
