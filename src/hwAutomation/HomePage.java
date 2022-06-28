package hwAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePage {

    static WebDriver driver;
    static String actualText;

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
     * Scenario 1: ebay home page, "Shop by category" drop down menu should work properly
     */

    @Test
    public static void ShopByCategory() throws InterruptedException {
        //Shop by category clickable.
        driver.findElement(By.xpath("//*[@id=\"gh-shop-a\"]")).click();

        // Verify work properly.
        String expectedText = "Shop by category";
        Thread.sleep(2000);
        String actualText = driver.findElement(By.id("gh-shop-a")).getText();
        System.out.println("Actual Text : " + actualText);
        System.out.println("Expected Text :" + expectedText);

        Thread.sleep(5000);
        Assert.assertEquals(actualText, expectedText, " doesn't work");
        Thread.sleep(3000);
        driver.close();

    }

    /**
     * Scenario 2 : In ebay home page, "Motors" button should work properly
     */

    @Test
    public static void Motors() throws InterruptedException {
//      Motors Button clickable.
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a")).click();

// Verify work properly.
        String expectedText = "eBay Motors";
        Thread.sleep(2000);
        String actualText = driver.findElement(By.xpath("/html/body/div[6]/div[2]/section/div[1]/div[2]/h1")).getText();
        System.out.println("Actual Text : " + actualText);
        System.out.println("Expected Text :" + expectedText);

        Thread.sleep(5000);
        Assert.assertEquals(actualText, expectedText, " doesn't work");
        Thread.sleep(3000);
        driver.close();
    }

    /**
     * Scenario 3: In ebay home page, "Electronics" button should work properly
     */

    @Test
    public static void Electronics() throws InterruptedException {
//     Electronics Button clickable.
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[4]/a")).click();

        // Verify work properly.
        String expectedText = "Electronics";
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
     * Scenario 4: In ebay home page, "Collectibles & Art" button should work properly
     */

    @Test
    public static void CollectiblesAndArt() throws InterruptedException {
        //    Collectibles & Art Button clickable.
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[5]/a")).click();

        // Verify work properly.
        String expectedText = "Collectibles & Art";
        Thread.sleep(2000);
        String actualText = driver.findElement(By.className("title-banner__title")).getText();
        System.out.println("Actual Text : " + actualText);
        System.out.println("Expected Text :" + expectedText);

        Thread.sleep(5000);
        Assert.assertEquals(actualText, expectedText, " doesn't work");
        Thread.sleep(3000);
        driver.close();

    }

    /**
     * Scenario 5: In ebay home page, "Toys" button should work properly
     */

    @Test
    public static void Toys() throws InterruptedException {
        //Toys button clickable.
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[8]/a")).click();

        // Verify work properly.
        String expectedText = "Toys & Hobbies";
        Thread.sleep(2000);
        String actualText = driver.findElement(By.className("title-banner__title")).getText();
        System.out.println("Actual Text : " + actualText);
        System.out.println("Expected Text :" + expectedText);

        Thread.sleep(5000);
        Assert.assertEquals(actualText, expectedText, " doesn't work");
        Thread.sleep(3000);
        driver.close();

    }

    /**
     * Scenario 5: In ebay home page, "Home & Garden" button should work properly
     */

    @Test
    public static void HomeGarden() throws InterruptedException {
        //Home & Garden button clickable.
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[6]/a")).click();

        // Verify work properly.
        String expectedText = "Home & Garden";
        Thread.sleep(2000);
        String actualText = driver.findElement(By.className("title-banner__title")).getText();
        System.out.println("Actual Text : " + actualText);
        System.out.println("Expected Text :" + expectedText);

        Thread.sleep(5000);
        Assert.assertEquals(actualText, expectedText, " doesn't work");
        Thread.sleep(3000);
        driver.close();

    }
    /**
     * Scenario 6: In ebay home page, "Clothing & Accessories" button should work properly
     */

    @Test
    public static void ClothingAndAccessories() throws InterruptedException {
        //Clothing & Accessories button clickable.
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[7]/a")).click();

        // Verify work properly.
        String expectedText = "Clothing, Shoes & Accessories";
        Thread.sleep(2000);
        String actualText = driver.findElement(By.className("b-pageheader__text")).getText();
        System.out.println("Actual Text : " + actualText);
        System.out.println("Expected Text :" + expectedText);

        Thread.sleep(5000);
        Assert.assertEquals(actualText, expectedText, " doesn't work");
        Thread.sleep(3000);
        driver.close();

    }
}
