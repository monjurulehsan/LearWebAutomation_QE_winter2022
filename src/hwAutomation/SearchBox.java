package hwAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchBox {

    static WebDriver driver;
    static String actualText;

    /**
     * Test Case: ebay search box functionality should work properly;
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
     * Scenario 1: ebay Search box should be type able with valid product name
     */

    @Test
    public static void typeAble() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("mask");

        Thread.sleep(3000);
        // Verify successful login
        String expectedText = "mask";
        Thread.sleep(3000);
        String actualText = driver.findElement(By.className("//*[@id=\"gh-ac\"]")).getText();
        System.out.println("Actual Text : " + actualText);
        Assert.assertEquals(actualText, expectedText, "We can't find.");
        Thread.sleep(2000);
        driver.close();

    }

    /**
     * Scenario 2 :  ebay Search button should be clickable
     */

    @Test
    public static void clickable() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("Mask");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
// Verify successful login
        String expectedText = "Related:";
        String actualText = driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/span[1]")).getText();
        System.out.println("Actual Text : " + actualText);
        Thread.sleep(3000);
        Assert.assertEquals(actualText, expectedText, "We can't find.");
        Thread.sleep(2000);
        driver.close();

    }

}
