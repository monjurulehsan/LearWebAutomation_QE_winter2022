package amazon;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonHomePage {

    static WebDriver driver;
    String browserName = "chrome";
    String url = "https://www.amazon.com/";
    static String actualText;


    @BeforeTest
    public void setUpAutomation() {
        System.out.println("*************** Automation Started *****************");
    }

    @AfterTest
    public void tearDownAutomation() {
        System.out.println("*************** Automation End *****************");
    }


    @BeforeTest
    public void setUp() {
        if (this.browserName == "chrome") {
            setUpChromeBrowser();

        }

        //  navigate to amazon.com
        driver.get(this.url);
        driver.manage().window().maximize();
    }


    public static void setUpChromeBrowser() {
        String chromeDriverPath = "../LearWebAutomation_QE_winter2022/BrowserDriver/Windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
    }


    @Test
    public static void testSearchBoxOnChrome() throws InterruptedException {
        //   setUp("chrome","https://www.amazon.com/");

        //   enter keyword in searchBox field
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iPhone 14");

        //  click on search button
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();


        // Verify searched product
        String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]")).getText();
        actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]")).getText();
        System.out.println("Actual Text : " + actualText);
        String expectedText = "\"iPhone 14\"";
        System.out.println("Expected Text : " + expectedText);

        if (actualText.equals(expectedText)) {
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Fail");
        }

        String actualProductName = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).getText();
        String expectedProductName = "Apple iPhone 13 Pro Max, 128GB, Sierra Blue - Unlocked (Renewed)";
        if (actualProductName.equals(expectedProductName)) {
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Fail");
        }


        driver.findElement(By.tagName("id Value"));


        Thread.sleep(10000);
        driver.close();


    }


    /**
     * This test method will verify successful signIn using valid credential
     * <p>
     * //         * @throws InterruptedException
     * //
     */
    @Test
    public static void testSignIn() throws InterruptedException {
        //   setUp("chrome","https://www.amazon.com/");
        // Click on Hello SignIn
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).click();
        // Enter email/ phoneNumber
        driver.findElement(By.id("ap_email")).sendKeys("monjurulehsan@gmail.com");

        // Click continue button
        driver.findElement(By.cssSelector("#continue")).click();
        // Enter password
        driver.findElement(By.name("password")).sendKeys("hello12345");
        // Click SignIn Button
        driver.findElement(By.className("a-button-input")).click();

        // Verify successful login
        String expectedText = "Hello, Fahim";
        String actualText = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).getText();
        System.out.println("Actual Text : " + actualText);

        Assert.assertEquals(actualText, expectedText, "SignIn not successful");
        Thread.sleep(5000);

    }

    /**
     * This test method will verify unsuccessful signIn using Invalid credential and verify Error message
     *
     * @throws InterruptedException
     */
    @Test
    public static void testSignInUsingInvalidCredential() throws InterruptedException {
        //   setUp("chrome","https://www.amazon.com/");
        // Click on Hello SignIn
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).click();
        // Enter email/ phoneNumber
        driver.findElement(By.id("ap_email")).sendKeys("mh.shahib@gmail.com");

        // Click continue button
        driver.findElement(By.cssSelector("#continue")).click();
        // Enter password
        driver.findElement(By.name("password")).sendKeys("Test12345");
        // Click SignIn Button
        driver.findElement(By.className("a-button-input")).click();

        // Verify successful login
        String expectedText = "There was a problem";
        String actualText = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4")).getText();
        System.out.println("Actual Text : " + actualText);

        Assert.assertEquals(actualText, expectedText, "SignIn is successful and Error message not showing ");

        String expectedTitle = "Amazon Sign-In";
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title : " + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle, "Page Title not match");


        Thread.sleep(5000);
        driver.close();

    }

}






