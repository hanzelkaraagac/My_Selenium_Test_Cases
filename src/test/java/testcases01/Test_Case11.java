package testcases01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Test_Case11 extends TestBase {
    @Test
    public void test01() throws InterruptedException, AWTException {
        //Navigate to url 'http://automationexercise.com' ==> 'http:automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
        // Verify that home page is visible successfully ==> Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());

        // Click 'Cart' button ==> 'Cart' düğmesini tıklayın
        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[1]")).click();

        Thread.sleep(1500);

        // Scroll down to footer ==> Altbilgiye doğru aşağı kaydır
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);

        // Verify text 'SUBSCRIPTION'
        WebElement verifyText = driver.findElement(By.xpath("//h2"));
        Assert.assertTrue(verifyText.isDisplayed());


        // Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys("ads1940@gmail.com");
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();

        // Verify success message 'You have been successfully subscribed!' is visible
        WebElement messageVerify = driver.findElement(By.xpath("//div[@class='alert-success alert']"));
        Assert.assertTrue(messageVerify.isDisplayed());
    }
}
