package hwAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static hwAutomation.NewArrival.driver;

public class EbayDeals {
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
     * Scenario 1:  In ebay home page, "Daily Deals" button should clickable
     */



    @Test
    public static void DailyDeals() throws InterruptedException {
        //Daily Deals clickable.
        driver.findElement(By.xpath("//*[@id=\"gh-p-1\"]/a")).click();

        // Verify work properly.
        String expectedText = "Deals";
        Thread.sleep(2000);
        String actualText = driver.findElement(By.xpath("//*[@id=\"refit-spf-container\"]/div[1]/h1/a")).getText();
        System.out.println("Actual Text : " + actualText);
        System.out.println("Expected Text :" + expectedText);

        Thread.sleep(5000);
        Assert.assertEquals(actualText, expectedText, " doesn't work");
        Thread.sleep(3000);
        driver.close();

    }

    /**
     * Scenario 2 : Daily Deals Elements Featured menu should work properly.
     */
    @Test
    public static void Featured() throws InterruptedException {
        //Featured clickable.
        driver.findElement(By.xpath("//*[@id=\"gh-p-1\"]/a")).click();

        // Verify work properly.
        String expectedText = "Sizzling Savings are Here";
        Thread.sleep(2000);
        String actualText = driver.findElement(By.xpath("//*[@id=\"sizzling-savings-are-here\"]/span")).getText();
        System.out.println("Actual Text : " + actualText);
        System.out.println("Expected Text :" + expectedText);

        Thread.sleep(5000);
        Assert.assertEquals(actualText, expectedText, " doesn't work");
        Thread.sleep(3000);
        driver.close();

    }

}
