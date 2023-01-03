package testcases03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Test_Case08 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeSayisi = driver.findElements(By.xpath("//iframe"));
        System.out.println("ifram sayisi : " + iframeSayisi.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement frame = driver.findElement(By.xpath("//*[@wmode='transparent']"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
        Thread.sleep(3000);
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.navigate().refresh();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement iframe = driver.findElement(By.xpath("//*[@id='a077aa5e']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']"));
    }
}
