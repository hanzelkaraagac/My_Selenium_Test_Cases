package testcases06;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Test_Case02 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        String window1Handle = driver.getWindowHandle();

        //youtube videosunu çalıştırınız
        WebElement iframe =driver.findElement(By.xpath("//*[@frameborder='0']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();

        //- üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();
        //- yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        //- iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //- arama sonucu olarak sadece sonuc sayısını yazdırınız
        String [] aramaSonuc = driver.findElement
                        (By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).
                getText().split(" ");
        System.out.println("Arama sonuc sayısı = "+aramaSonuc[2]);
        //- ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(window1Handle);
        System.out.println("İlk window url'i : "+driver.getCurrentUrl());
        //- ilk sekmeyi kapatalım
        driver.close();
        //- Sonra diğer sekmeyide kapatalım
        //TestBase'deki @After notasyonu çalışacak


    }
}
