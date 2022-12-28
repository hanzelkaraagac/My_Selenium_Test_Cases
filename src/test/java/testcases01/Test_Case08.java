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

public class Test_Case08 {
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        // Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // Verify that home page is visible successfully
        WebElement urlGorunumu = driver.findElement(By.xpath("(//*[@href=\"/\"])[1]"));
        Assert.assertTrue(urlGorunumu.isDisplayed());

        // Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        //Cikan reklami onlemek icin sayfayi yeniledik ve tekrar click dedik
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        // Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductsGorunumu = driver.findElement(By.xpath("//*[text()='All Products']"));
        Assert.assertTrue(allProductsGorunumu.isDisplayed());

        // The products list is visible
        WebElement urunListGorunumu = driver.findElement(By.xpath("(//*[text()='Blue Top'])[1]"));
        Assert.assertTrue(urunListGorunumu.isDisplayed());

        //Alt tarafta cikan reklamdan kurtulmak icin bu methodu kullandim.
        Thread.sleep(3000);
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.click();
        aramaKutusu.sendKeys("",Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);

        Thread.sleep(3000);

        // Click on 'View Product' of first product
        driver.findElement(By.xpath("//*[@href='/product_details/1']")).click();

        // User is landed to product detail page
        String sayfaUrl = driver.getCurrentUrl();
        Assert.assertTrue(sayfaUrl.contains("product_detail")); // url deki sayfa kismi

        WebElement detailPageGorunumu = driver.findElement(By.xpath("//*[text()='Blue Top']"));
        Assert.assertTrue(detailPageGorunumu.isDisplayed());



        // Verify that detail detail is visible: Product Name, Category, Price, Availability, Condition, Brand
        WebElement productNameGorunumu = driver.findElement(By.xpath("//*[text()='Blue Top']"));
        Assert.assertTrue(productNameGorunumu.isDisplayed());

        WebElement categoryGorunumu = driver.findElement(By.xpath("//*[text()='Category']"));
        Assert.assertTrue(categoryGorunumu.isDisplayed());

        WebElement priceGorunumu = driver.findElement(By.xpath("//*[text()='Rs. 500']"));
        Assert.assertTrue(categoryGorunumu.isDisplayed());

        WebElement availabilityGorunumu = driver.findElement(By.xpath("//*[text()='Availability:']"));
        Assert.assertTrue(categoryGorunumu.isDisplayed());

        WebElement conditionGorunumu = driver.findElement(By.xpath("//*[text()='Condition:']"));
        Assert.assertTrue(categoryGorunumu.isDisplayed());

        WebElement brandGorunumu = driver.findElement(By.xpath("//*[text()='Brand:']"));
        Assert.assertTrue(categoryGorunumu.isDisplayed());

    }
}
