package hwAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EbayCart {

    static WebDriver driver;
    static String actualText;

    /**
     * Test Case: ebay cart functionality should work properly;
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
     * Scenario 1:  In ebay home page, "cart" button should work properly.
     */

    @Test
    public static void cartButtonClickable() throws InterruptedException {

// As a ebay user, cart button should be clickable.
        driver.findElement(By.className("gh-cart-icon")).click();
        Thread.sleep(4000);

        // Verify work properly
        String expectedText = "You don't have any items in your cart.";
        Thread.sleep(2000);
        String actualText = driver.findElement(By.cssSelector("#mainContent > div > div.left-section.app-wrapper-full-width > div.app-cart > div > div.font-title-3 > span > span > span")).getText();
        System.out.println("Actual Text : " + actualText);
        System.out.println("Expected Text :" + expectedText);

        Thread.sleep(5000);
        Assert.assertEquals(actualText, expectedText, "cart doesn't navigate to next page");
        Thread.sleep(3000);
        driver.close();
    }

    /**
     * Scenario 2 : ebay cart, signIn button should work properly
     */

    @Test
    public static void SignInButton() throws InterruptedException {

//        In ebay homepage, as a user cart button should be clickable
        driver.findElement(By.className("gh-cart-icon")).click();
        Thread.sleep(2000);

//       user should be able to click on signIn
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[1]/div/div[3]/a[1]")).click();
        Thread.sleep(5000);


        // Verify work properly
        String expectedText = "Please verify yourself to continue";
        String actualText = driver.findElement(By.xpath("//*[@id=\"areaTitle\"]/h1")).getText();
        System.out.println("Actual Text : " + actualText);

        Assert.assertEquals(actualText, expectedText, "We can't find your account.");
        Thread.sleep(2000);
        driver.close();
    }


}
