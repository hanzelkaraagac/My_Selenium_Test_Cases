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

public class Test_Cases03_RadioButton {
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
    public void test01() {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");

        // radiobutton elementlerini locate edin
        WebElement option1 = driver.findElement(By.id("vfb-7-1"));
        WebElement option2 = driver.findElement(By.id("vfb-7-2"));
        WebElement option3 = driver.findElement(By.id("vfb-7-3"));

        // option2'yi secin
        option2.click();

        // option2 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(option2.isSelected());

        // option1 elementlerinin secili olmadıgını test edin
        Assert.assertTrue(!option1.isSelected());

        // option3 elementlerinin secili olmadıgını test edin
        Assert.assertTrue(!option3.isSelected());
    }
}
