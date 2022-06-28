package hwAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewArrival {
    static WebDriver driver;
    static String actualText;

    /**
     * Test Case: Target Home page functionality should work properly;
     */
    @BeforeTest
    public static void SetUp() {
        String driverPath = "../LearWebAutomation_QE_winter2022/BrowserDriver/Windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

//        To open browse
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
    }

    /**
     * Scenario 1:  In ebay home page, "Shop by category" drop down menu should work properly
     */

    @Test
    public static void typeAble(){

        driver.findElement(By.xpath("//*[@id=\"gh-shop-a\"]")).click();
    }

    /**
     * Scenario 2 : In ebay home page, "Motors" button should work properly
     */

    @Test
    public static void clickable() {

        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a")).click();


    }



}
