package testcases11_Selenium_Study;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.List;

public class TestCases10 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //      --------------ÖDEV---------------------
        //        Bir class olusturun: IframeOdev
        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        //sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframeSize = driver.findElements(By.xpath("//iframe"));
        System.out.println(iframeSize.size());
        //Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String sayfaBaslik = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(sayfaBaslik.contains("Editor"));
        //Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        String icYazi = driver.findElement(By.xpath("//p[.='Your content goes here.']")).getText();
        System.out.println(icYazi);
        driver.findElement(By.xpath("//p[.='Your content goes here.']")).clear();
        //Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        driver.findElement(By.xpath("//p")).sendKeys("iframein icindeyim");
        String yeniYazi = driver.findElement(By.xpath("//p")).getText();
        Assert.assertEquals(yeniYazi, "iframein icindeyim");
        //Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().parentFrame();
        String actualYazi = driver.findElement(By.xpath("//a[.='Elemental Selenium']")).getText();
        Assert.assertTrue(actualYazi.contains("Elemental Selenium"));
    }
}

