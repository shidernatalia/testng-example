package DemoTestNG;

import org.testng.annotations.*;

public class ConfigurationAnnotations_1_DatePickers {
    @Test(groups = "smoke")
    public void test1_BootstrapDatePicker(){
        System.out.println("     (5) Test Method 1: Bootstrap Date Picker");
    }
    @Test(groups = {"regression", "e2e"})
    public void test2_JQuerypDatePicker(){
        System.out.println("     (5) Test Method 2: JQuery Date Picker");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("    (4) Execute before each method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("    (4) Execute after each method");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("   (3) Execute before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("   (3) Execute after class");
    }
}
