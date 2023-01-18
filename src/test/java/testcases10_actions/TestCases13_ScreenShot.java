package testcases10_actions;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class TestCases13_ScreenShot extends TestBase {

    @Test
    public void screnShotTest() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Tüm sayfanın resmini alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa.jpeg"));
        //FileUtils ==> okuyama yazma ve kopyalama islemlerinde bize yardimci oluyor
        /*
        FILEUTILS CLASS'I, FILE NESNELERI ILE BIRLIKTE KULLANABILECEGIMIZ METHODLAR ICERIR.
        BU METHODLARI KULLANARAK DOSYALARDA OKUMA,YAZMA VE KOPYALAMA ISLEMLERINI COK DAHA KOLAY YAPABILIRIZ.
        */
        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        //Tekrar amazon sayfasına dönüp iphone aratalım
        //Arama sonucunun resmini alalım
    }
}
