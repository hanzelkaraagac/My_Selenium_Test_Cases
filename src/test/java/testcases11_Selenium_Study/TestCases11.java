package testcases11_Selenium_Study;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCases11 extends TestBase {
    @Test
    public void iFrameTest(){
        //Bir class olusturun: IframeOdev
        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        //sayfadaki toplam iframe sayısını bulunuz.
        int iFrameSayisi = driver.findElements(By.tagName("iframe")).size();
        System.out.println("The total number of AAAYY iFrame : " + iFrameSayisi);

        //Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String header = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(header.contains("Editor"));
        //Paragrafdaki yaziyi silelim
        driver.switchTo().frame("mce_0_ifr");
        WebElement box = driver.findElement(By.xpath("//p"));
        box.clear();
        //Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        box.sendKeys("IFRAME'IN ICINDEYIM");

        //Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().parentFrame();
        String textName = driver.findElement(By.xpath("//div[@style='text-align: center;']")).getText();
        Assert.assertTrue(textName.contains("Elemental Selenium"));
    }
}

