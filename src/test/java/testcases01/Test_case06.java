package testcases01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_case06 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver,chrome.driver","/Users/macbookair/Documents/selenium libraries/drivers/chromedriver");
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

        // Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();

        // Verify 'GET IN TOUCH' is visible
        WebElement getITVerify = driver.findElement(By.xpath("//*[text()='Get In Touch']"));
        if (getITVerify.isDisplayed()) {
            System.out.println("Text PASSED");
        }else System.out.println("Text FAILED");

        // Enter name, email, subject and message
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Hanzel");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("emaiil1940@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@name='subject']")).sendKeys("BASLIK");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='message']")).sendKeys("Bu bir deneme mesajidir");

        // Upload file

        // Click 'Submit' button
        driver.findElement(By.xpath("//*[@name='submit']")).click();

        Thread.sleep(3000);

        // Click OK button ==> Cikan alert kismini onaylar.
        driver.switchTo().alert().accept();

        Thread.sleep(3000);

        // Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement verifyMessage = driver.findElement(By.xpath("(//*[text()='Success! Your details have been submitted successfully.'])[1]"));
        if (verifyMessage.isDisplayed()) {
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");

        // Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("(//*[text()=' Home'])[2]")).click();

        WebElement homeGorunumu = driver.findElement(By.xpath("(//*[@href=\"/\"])[1]"));
        if (homeGorunumu.isDisplayed()) {
            System.out.println("Text PASSED");
        }else System.out.println("Text FAILED");

        driver.close();
    }

}


