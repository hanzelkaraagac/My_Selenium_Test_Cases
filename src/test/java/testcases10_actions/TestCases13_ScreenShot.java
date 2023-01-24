package testcases10_actions;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCases13_ScreenShot extends TestBase {

    String tarih;
    @Test
    public void screnShotTest() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        String amazonSayfasi = driver.getWindowHandle();
        //Tüm sayfanın resmini alalım
        tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));

        //FileUtils ==> okuyama yazma ve kopyalama islemlerinde bize yardimci oluyor
        /*
        FILEUTILS CLASS'I, FILE NESNELERI ILE BIRLIKTE KULLANABILECEGIMIZ METHODLAR ICERIR.
        BU METHODLARI KULLANARAK DOSYALARDA OKUMA,YAZMA VE KOPYALAMA ISLEMLERINI COK DAHA KOLAY YAPABILIRIZ.
        */


        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        waitFor(3);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        tarih = new SimpleDateFormat ("hh_mm_ss_ddMMYYYY").format(new Date());
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa2"+tarih+".jpeg"));

        //Tekrar amazon sayfasına dönüp iphone aratalım
        driver.switchTo().window(amazonSayfasi);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //Arama sonucunun resmini alalım
        WebElement sonuc = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        FileUtils.copyFile(sonuc.getScreenshotAs(OutputType.FILE),new File("target/WebElementScreenShot/WEScreenShot"+tarih+".jpeg"));
        //sonuc elementini locate edip webelmente assine edin
        //FileUtils.copyFile(WE.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));

    }
}
