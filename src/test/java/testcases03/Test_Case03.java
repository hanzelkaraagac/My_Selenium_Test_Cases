package testcases03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Test_Case03 {

    /*
    - ebay sayfasına gidiniz
    - electronics bölümüne tıklayınız
    - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
    - Her sayfanın sayfa başlığını yazdıralım
    - sayfayı kapatalım
    */

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
        // - sayfayı kapatalım
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        // - ebay sayfasına gidiniz
        driver.get("https://www.ebay.com/");

        // - electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

        // - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        for (int i = 0; i < 24; i++) {
            List<WebElement> urunler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            urunler.get(i).click();
            Thread.sleep(2000);
            // - Her sayfanın sayfa başlığını yazdıralım
            System.out.println(i+". başlık : "+driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
        }
    }



}
