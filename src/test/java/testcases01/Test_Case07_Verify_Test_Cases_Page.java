package testcases01;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Case07_Verify_Test_Cases_Page {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        // Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());

        // Click on 'Test Cases' button
        driver.findElement(By.xpath("(//*[text()=' Test Cases'])[1]")).click();

            Thread.sleep(3000);
        // Verify user is navigated to test cases page successfully
        WebElement testCaseVerify = driver.findElement(By.xpath("//*[text()='Test Cases']"));
        Assert.assertTrue(testCaseVerify.isDisplayed());

    }


}
