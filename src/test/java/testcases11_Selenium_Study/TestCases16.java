package testcases11_Selenium_Study;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TestCases16 extends TestBase {

        //Go to https://www.amazon.com.tr/
        //Search iPhone13 512
        //Check that the results are listed
        //Click iPhone13 at the top of the list
        //Log the following values for each size .Size information .Price .Color .Stock status
        //Isim - Renk - Stok - Boyut - Fiyat

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");

        driver.findElement(By.id("sp-cc-accept")).click();

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone13 512", Keys.ENTER);

        WebElement resultVisiable = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(resultVisiable.isDisplayed());

        driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[4]")).click();

        driver.findElement(By.xpath("(//input[@name='2'])[1]")).click();
        driver.findElement(By.xpath("(//input[@name='2'])[2]")).click();

        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click();

        String name = driver.findElement(By.xpath("//li[@class='a-spacing-mini']")).getText();
        System.out.println(name);

        List<WebElement> items = driver.findElements(By.xpath("//li[@class='sc-product-variation']//span[@class='a-size-small']"));
        System.out.println("Color: "+items.get(1).getText());
        String price = driver.findElement(By.xpath("//div[@class='sc-item-price-block']")).getText();
        System.out.println("Fiyat: "+price);
        System.out.println("Stock: "+items.get(0).getText());
    }

}


