package testcases03;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Case04 {

     /*
       https://www.google.com/ adresine gidin
       cookies uyarisini kabul ederek kapatin
       Sayfa basliginin “Google” ifadesi icerdigini test edin
       Arama cubuguna “Nutella” yazip aratin
       Bulunan sonuc sayisini yazdirin
       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       Sayfayi kapatin
     */
     WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/Users/macbookair/Documents/selenium libraries/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() {
        //https://www.google.com/ adresine gidin
        driver.get("https://google.com");
        //cookies uyarisini kabul ederek kapatin

        //Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

        //Bulunan sonuc sayisini yazdirin
        String [] sonucSayisi = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        String sonuc = sonucSayisi[1];
        System.out.println("Sonuc Sayısı = " +sonuc);

        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        sonuc=sonuc.replaceAll("\\D",""); // ReplaceAll methodu ile \\D'i kullanarak bütün noktalama işaretlerini hiçlikle değiştir
        int istenenSayi = 10000000;
        Assert.assertTrue(Integer.parseInt(sonuc)>istenenSayi);

    }
}
