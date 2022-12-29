package testcases05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Cases02_CheckBox {
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
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");

        // checkbox elementlerini locate edin
        WebElement checkbox1 = driver.findElement(By.id("vfb-6-0"));
        WebElement checkbox2 = driver.findElement(By.id("vfb-6-1"));
        WebElement checkbox3 = driver.findElement(By.id("vfb-6-2"));

        // checkbox1 ve checkbox3  secili degil ise secin
        if (!checkbox1.isSelected() && !checkbox3.isSelected()){
            checkbox1.click();
            Thread.sleep(1500);
            checkbox3.click();
        }

        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(checkbox1.isSelected() && checkbox3.isSelected());

        // checkbox2 elementinin secili olmadıgını test edin
        Assert.assertTrue(!checkbox2.isSelected());
//      Assert.assertFalse(checkbox2.isSelected());
    }



}
