package hwAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static hwAutomation.NewArrival.driver;

public class EbayBrandOutlet {



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
     * Scenario 1:  In ebay home page, "Brand Outlet" button should clickable
     */



    @Test
    public static void BrandOutlet() throws InterruptedException {
        //Brand Outlet clickable.
        driver.findElement(By.xpath("//*[@id=\"gh-p-4\"]/a")).click();

        // Verify work properly.
        String expectedText = "The Brand Outlet";
        Thread.sleep(2000);
        String actualText = driver.findElement(By.className("b-pageheader__text")).getText();
        System.out.println("Actual Text : " + actualText);
        System.out.println("Expected Text :" + expectedText);

        Thread.sleep(5000);
        Assert.assertEquals(actualText, expectedText, " doesn't work");
        Thread.sleep(3000);
        driver.close();

    }

    /**
     * Scenario 2 : Brand Outlet Elements clothing menu should work properly.
     */
    @Test
    public static void clothing() throws InterruptedException {
        //Brand Outlet clickable.
        driver.findElement(By.xpath("//*[@id=\"gh-p-4\"]/a")).click();

        // Verify work properly.
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#s0-17-12-0-1\\[0\\]-0-0-0-27\\[0\\]-0-toggle-button > span")).click();
        String expectedText = "Champion - Up to 50% off";
        Thread.sleep(2000);
        String actualText = driver.findElement(By.xpath("//*[@id=\"s0-17-12-0-1[0]-0-0-0-27[0]-0\"]/ul/li[1]/a")).getText();
        System.out.println("Actual Text : " + actualText);
        System.out.println("Expected Text :" + expectedText);

        Thread.sleep(5000);
        Assert.assertEquals(actualText, expectedText, " doesn't work");
        Thread.sleep(3000);
        driver.close();

    }
}
