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

import java.time.Duration;
import java.util.List;

public class Test_Case09_Search_Product {
    static  WebDriver driver;
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
    public void test01() {
        // Verify that home page is visible successfully
        WebElement homepage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homepage.isDisplayed());

        // Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        //Cikan reklami onlemek icin sayfayi yeniledik ve tekrar click dedik
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        // Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductsGorunumu = driver.findElement(By.xpath("//*[text()='All Products']"));
        Assert.assertTrue(allProductsGorunumu.isDisplayed());

        // Enter product name in search input and click search button
        WebElement searchButton = driver.findElement(By.xpath("//*[@id='search_product']"));
        searchButton.sendKeys("Men Tshirt", Keys.TAB,Keys.ENTER);

        // Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchVerify = driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(searchVerify.isDisplayed());

        //Asagida cikan reklami ortadan kaldirmak icin kullandik
        WebElement searchVerify3 = driver.findElement(By.xpath("//*[@id='search_product']"));
        searchVerify3.sendKeys("",Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);

        WebElement searchVerify2 = driver.findElement(By.xpath("(//*[text()='View Product'])[1]"));
        Assert.assertTrue(searchVerify2.isDisplayed());

        // Verify all the products related to search are visible
        driver.navigate().back();

        //1.YOL
//        WebElement allWantedItems  = driver.findElement(By.xpath("(//*[@class='productinfo text-center']/p) [2]"));
//        Assert.assertTrue(allWantedItems.isDisplayed());

        //2.YOL
//        List<WebElement> allWantedItems  = driver.findElements(By.xpath("(//*[@class='productinfo text-center']/p) [2]"));
//        for (WebElement w: allWantedItems) {
//            Assert.assertTrue(w.isDisplayed());
//        }

        //3.YOL
        List<WebElement> allWantedItems  = driver.findElements(By.
                xpath("(//*[@class='productinfo text-center']/p) [2]"));

        allWantedItems.stream().forEach(WebElement::isDisplayed);

    }
}




