package testcases01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Case04_Logout_User {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/macbookair/Documents/selenium libraries/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // Verify that home page is visible successfully
        WebElement urlGorunumu = driver.findElement(By.xpath("(//*[@href=\"/\"])[1]"));
        if (urlGorunumu.isDisplayed()) {
            System.out.println("Text PASSED");
        }else System.out.println("Text FAILED");

        // Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@ class='fa fa-lock']")).click();

        // Verify 'Login to your account' is visible
        WebElement loginGorunumu = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        if (loginGorunumu.isDisplayed()) {
            System.out.println("Text PASSED");
        } else System.out.println("Text FAILED");

        // Enter correct email address and password
        driver.findElement(By.xpath("(//*[@name='email'])[1]")).sendKeys("emaiil1940@gmail.com");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("ASD123b");
        Thread.sleep(1500);

        // Click 'login' button
        driver.findElement(By.xpath("//*[text()='Login']")).click();

        // Verify that 'Logged in as username' is visible
        WebElement usernameKontrol = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        if (usernameKontrol.isDisplayed()) {
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");

        // Click 'Logout' button
        driver.findElement(By.xpath("//*[text()=' Logout']")).click();

        // Verify that user is navigated to login page
        WebElement navigatedVerify = driver.findElement(By.xpath("//*[text()=' Signup / Login']"));
        if (navigatedVerify.isDisplayed()) {
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");

        driver.close();

    }
}
