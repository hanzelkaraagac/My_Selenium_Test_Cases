package testcases01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Test_Case_13_Verify_Product_Quantity_in_Cart extends TestBase {
    @Test
    public void test01() throws AWTException {
        // Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // Verify that home page is visible successfully
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.SPACE).perform();
        waitFor(3);

        // Click 'View Product' for any product on home page // Ana sayfadaki herhangi bir ürün için 'Ürünü Görüntüle'yi tıklayın
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();



        // Verify product detail is opened // Ürün detayının açıldığını doğrulayın
        String actual = driver.getCurrentUrl();
        String expected = "https://automationexercise.com/product_details/1";
        Assert.assertTrue(actual.contains(expected));

        // Increase quantity to 4 // Miktarı 4'e çıkar
        WebElement miktar = driver.findElement(By.xpath("//*[@id='quantity']"));
        miktar.clear();
        miktar.sendKeys("4");

        // Click 'Add to cart' button
        driver.findElement(By.xpath("//*[@type='button']")).click();

        // Click 'View Cart' button
        driver.findElement(By.xpath("(//*[@class='text-center'])[2]")).click();

        // Verify that product is displayed in cart page with exact quantity //Ürünün sepet sayfasında tam miktarla görüntülendiğini doğrulayın
        driver.findElement(By.xpath("//*[text()='4']")).isDisplayed();
    }
}
