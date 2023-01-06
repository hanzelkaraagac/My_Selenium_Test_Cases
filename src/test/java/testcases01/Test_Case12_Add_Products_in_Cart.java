package testcases01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class Test_Case12_Add_Products_in_Cart extends TestBase {
    @Test
    public void test01() {
        // Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

        // Verify that home page is visible successfully // Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        // Click 'Products' button
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();

        //Cikan reklami onlemek icin
        driver.navigate().refresh();
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();

        //altta cikan reklamdan kurturlmak icin
        driver.findElement(By.xpath("//*[@id='search_product']")).sendKeys("", Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB);

        // Hover over first product and click 'Add to cart' //İlk ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();

        // Click 'Continue Shopping' button //'Alışverişe Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

        // Hover over second product and click 'Add to cart' //Fareyle ikinci ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]")).click();

        // Click 'View Cart' button // 'Sepeti Görüntüle' düğmesini tıklayın
        driver.findElement(By.linkText("View Cart")).click();

        // Verify both products are added to Cart //Her iki ürünün de Sepete eklendiğini doğrulayın
        driver.findElement(By.xpath("//*[text()='Blue Top']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Men Tshirt']")).isDisplayed();



        // Verify their prices, quantity and total price //Fiyatlarını, miktarlarını ve toplam fiyatlarını doğrulayın
        //Birinci urunlerin gorunurlugu
        driver.findElement(By.xpath("//*[text()='Rs. 500']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='1']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Rs. 500']")).isDisplayed();

        //ikinci urunlerin gorunurlugu
        driver.findElement(By.xpath("//*[text()='Rs. 400']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='1']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Rs. 400']")).isDisplayed();
    }
}
