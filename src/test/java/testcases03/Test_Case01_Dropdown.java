package testcases03;

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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Test_Case01_Dropdown {

    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Books" secenegini secin
    // arama cubuguna "Java" aratın
    // arama sonuclarinin Java icerdigini test edin

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
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Books" secenegini secin

        //Dropdown 3 adimda handle edilir.
        //1.adim Locate edilmeli
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        //2.adim Select objesi olusturulmali
        Select select = new Select(ddm);
        //3.adim herhangi bir option'u secmeliyiz
        select.selectByVisibleText("Books");
//      select.selectByValue("search-alias=stripbooks-intl-ship");//value degerini handle ettik
//      select.selectByIndex(5);//index ile aldik


        // arama cubuguna "Java" aratın
        WebElement aramaCubugu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaCubugu.sendKeys("Java" + Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String aramaSonucYazisi = aramaSonucElementi.getText();
        Assert.assertTrue(aramaSonucYazisi.contains("Java"));
    }


}
