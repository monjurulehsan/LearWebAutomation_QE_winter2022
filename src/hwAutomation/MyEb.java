package hwAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static hwAutomation.NewArrival.driver;

public class MyEb {

    /**
     * Test Case: ebay Home page functionality should work properly;
     */
    @BeforeTest
    public static void SetUp() throws InterruptedException {
        String driverPath = "../LearWebAutomation_QE_winter2022/BrowserDriver/Windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

//        To open browse
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    /**
     * Scenario 1: ebay home page, "My eby" drop down menu should work properly
     */

    @Test
    public static void MyEbyDropDown() throws InterruptedException {
        //Shop by category clickable.
        driver.findElement(By.xpath("//*[@id=\"gh-eb-My\"]/div/a[1]")).click();

        // Verify work properly.
        String expectedText = "Please verify yourself to continue";
        Thread.sleep(2000);
        String actualText = driver.findElement(By.xpath("//*[@id=\"areaTitle\"]/h1")).getText();
        System.out.println("Actual Text : " + actualText);
        System.out.println("Expected Text :" + expectedText);

        Thread.sleep(5000);
        Assert.assertEquals(actualText, expectedText, " doesn't work");
        Thread.sleep(3000);
        driver.close();

    }



}
