package DemoTestNG;

import org.testng.annotations.*;

@Test(groups = "smoke")
public class ConfigurationAnnotations_2_ListBox {

    public void test3_BootstrapListBox(){
        System.out.println("     (5) Test Method 1: Bootstrap List Box");
    }
    public void test4_JQuerypListBox(){
        System.out.println("     (5) Test Method 2: JQuery List Box");
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
    @BeforeTest
    public void beforeTest(){
        System.out.println("  (2) Before Each Test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("  (2) After Each Test");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println(" (1) Before Suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println(" (1) After Suite");
    }
    @BeforeGroups(groups = {"regression", "smoke"})
    public void beforeGroups(){
        System.out.println("Execute Before Group");
    }
    @AfterGroups(groups = {"regression", "smoke"})
    public void afterGroups(){
        System.out.println("Execute After Group");
    }
}
