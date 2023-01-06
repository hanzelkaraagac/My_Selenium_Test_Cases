package testcases01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Test_Case10_Verify_Subscription_in_Home_Page {
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }

    @Test
    public void test01() throws AWTException, InterruptedException {
        // Verify that home page is visible successfully
        WebElement homepage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homepage.isDisplayed());

        // Scroll down to footer ==> Altbilgiye doğru aşağı kaydır
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();//Sayfanin en sonuna inmesini sagladi

        // Verify text 'SUBSCRIPTION'
        WebElement subscription = driver.findElement(By.xpath("//h2[normalize-space()='Subscription']"));
        Assert.assertTrue(subscription.isDisplayed());

        // Enter email address in input and click arrow button == > Girişte e-posta adresini girin ve ok düğmesine tıklayın
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("ads1940@gmail.com");
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();

        // Verify success message 'You have been successfully subscribed!' is visible ==> Başarı mesajını doğrulayın 'Başarıyla abone oldunuz!' görünür
        WebElement successMessage = driver.findElement(By.xpath("//*[@id='success-subscribe']"));
        Assert.assertTrue(successMessage.isDisplayed());
    }



}
