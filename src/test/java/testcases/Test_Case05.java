package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Case05 {

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

        // Verify 'New User Signup!' is visible
        WebElement newUSGorunumu = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        if (newUSGorunumu.isDisplayed()){
            System.out.println("Text PASSED");
        }else System.out.println("Text FAILED");

        // Enter name and already registered email address
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("hanzel");
        Thread.sleep(1500);
        WebElement email= driver.findElement(By.xpath("(//*[@type='email'])[2]"));
        email.sendKeys("emaiil1940@gmail.com");
        Thread.sleep(1500);

        // Click 'Signup' button
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();

        // Verify error 'Email Address already exist!' is visible
        WebElement verifyError = driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
        if (verifyError.isDisplayed()) {
            System.out.println("Text PASSED");
        }else System.out.println("Text FAILED");

        driver.close();
    }
}
