package testcases03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Test_Case02_Dropdown_Options {

    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
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



        // dropdown'dan "Baby" secenegini secin

        //1.adim Locate edilmeli
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        //2.adim Select objesi olusturulmali
        Select select = new Select(ddm);
        //3.adim herhangi bir option'u secmeliyiz
        select.selectByVisibleText("Baby");



        // sectiginiz option'i yazdirin
        String sectigimOption = select.getFirstSelectedOption().getText();//Webelement dondurur ve bizim en son sectigimiz option'u getirir.
        System.out.println("sectigimOption = " + sectigimOption);



        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> tumOptionlar = select.getOptions(); //tum option'lari getiriyor

        int actualOptionSayisi = tumOptionlar.size();
        int expectedOptionSayisi = 28;

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

    }
}
