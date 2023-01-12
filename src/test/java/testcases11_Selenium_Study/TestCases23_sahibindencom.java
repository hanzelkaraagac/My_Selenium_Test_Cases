package testcases11_Selenium_Study;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCases23_sahibindencom extends TestBase {

@Test
public void test01() {
        //sahibinden.coma gidin
        driver.get("https://www.sahibinden.com");
        //anasayfada oldugunuzu
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.sahibinden.com/";
        Assert.assertEquals(expectedUrl, actualUrl);
        if (driver.findElement(By.xpath("//*[@id='onetrust-reject-all-handler']")).isDisplayed()) {
        driver.findElement(By.xpath("//*[@id='onetrust-reject-all-handler']")).click();
        }
        //detayli arama tiklayin
        driver.findElement(By.xpath("//a[contains(text(),'Detaylı Arama')]")).click();
        //detayli arama sayfasina geldiginizi dogrulatin
        String actualdetayliTitle = driver.getCurrentUrl();
        String expecteddetayliTitle = "https://www.sahibinden.com/arama/detayli";
        Assert.assertEquals(expecteddetayliTitle, actualdetayliTitle);
        //emlak-konut-satilik seceneklerini secip
        driver.findElement(By.xpath("(//span[text()='Emlak'])[1]")).click();
        waitFor(1);
        driver.findElement(By.xpath("//span[text()='Konut']")).click();
        waitFor(1);
        driver.findElement(By.xpath("//span[text()='Satılık']")).click();
        waitFor(1);
        driver.findElement(By.xpath("//span[text()='Daire']")).click();
        //altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
        detayliArama("Yalova", "Armutlu", "Bayır Mh.");
        detayli_Arama_fiyat("100000","700000","TL");
        scrollDownActions();
        scrollDownActions();
        detayli_Arama_cephe("Kuzey"," Batı");
        WebElement aramayap = driver.findElement(By.xpath("(//button[normalize-space()='Arama Yap'])[1]"));
        doubleClick(aramayap);
        //aramayap.click();
        //cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin
        String sonuc = driver.findElement(By.xpath("//div[@class='result-text']")).getText();
        System.out.println(sonuc);
        }
public void detayliArama(String il, String ilce, String mah) {
        WebElement Adres1 = driver.findElement(By.xpath("(//*[@class='faceted-select'])[1]"));
        Adres1.click();
        WebElement ilyaz = driver.findElement(By.xpath("//input[@placeholder='İl']"));
        ilyaz.sendKeys(il);
        waitFor(2);
        driver.findElement(By.xpath("//a[contains(text(),'" + il + "')]")).click();
        WebElement Adres2 = driver.findElement(By.xpath("(//*[@class='faceted-select'])[2]"));
        Adres2.click();
        waitFor(2);
        WebElement semtyaz = driver.findElement(By.xpath("//input[@placeholder='İlçe']"));
        semtyaz.sendKeys(ilce);
        driver.findElement(By.xpath("//a[contains(text(),'" + ilce + "')]")).click();
        driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();
        WebElement Adres3 = driver.findElement(By.xpath("(//*[@class='faceted-select'])[3]"));
        Adres3.click();
        WebElement mahlyaz = driver.findElement(By.xpath("//input[@placeholder='Semt / Mahalle']"));
        mahlyaz.sendKeys(mah);
        driver.findElement(By.xpath("//a[normalize-space()='" + mah + "']")).click();
        waitFor(2);
        driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();
        }
public void detayli_Arama_fiyat(String min,String max,String parabirimi){
        WebElement minFiyat=driver.findElement(By.xpath("//input[@placeholder='Min TL']"));
        minFiyat.click();
        minFiyat.sendKeys(min);
        WebElement maxFiyat=driver.findElement(By.xpath("//input[@placeholder='Max TL']"));
        maxFiyat.click();
        maxFiyat.sendKeys(max);
        WebElement parabrimi=driver.findElement(By.xpath("//select[@name='price_currency']"));
        parabrimi.click();
        parabrimi.sendKeys(parabirimi);
        }
public void detayli_Arama_cephe(String...cephe) {
        Actions actions=new Actions(driver);
        WebElement ddm = driver.findElement(By.xpath("//a[normalize-space()='Cephe']"));
        actions.moveToElement(ddm).perform();
        doubleClick(ddm);
        for (String w : cephe) {
        if (w == cephe[0]) {
        driver.findElement(By.xpath("//*[contains(text(),'"+cephe[0]+"')]")).click();
        } else if (w == cephe[1]) {
        driver.findElement(By.xpath("//*[contains(text(),'" +cephe[1]+"')]")).click();
        } else if (w == cephe[2]) {
        driver.findElement(By.xpath("//*[contains(text(),'" +cephe[2]+"')]")).click();
        } else if (w == cephe[3]) {
        driver.findElement(By.xpath("//*[contains(text(),'" +cephe[3]+"')]")).click();
        }else break;
        }
}
}
