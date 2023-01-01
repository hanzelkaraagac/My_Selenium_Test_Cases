package testcases04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.util.Set;

public class Test_Case02 extends TestBase {
    @Test
    public void windowHandleTest() throws InterruptedException {
//         url'ye git: http://demo.guru99.com/popup.php
        String url = "http://demo.guru99.com/popup.php";
        driver.navigate().to(url);
        Thread.sleep(5000);
        driver.manage().deleteAllCookies();

//        yeni pencereden acar
//        driver= new ChromeDriver();
//        String URL= "http://demo.guru99.com/popup.php";
//        driver.navigate().to(URL);
//        driver.manage().deleteAllCookies();

        Thread.sleep(3000);
//       ilk pencereyi al
        String firstWindow = driver.getWindowHandle();
//       "Click Here" butonuna tıklayın
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
        //        driver.findElement(By.cssSelector("a[target='_blank']")).click();
        //driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);
//       setteki tüm pencereyi al
        Set<String> windows=driver.getWindowHandles();
        System.out.println(windows);
//       diğer pencereye geç
//       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
//       Gönder düğmesine tıklayarak
//       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
//       Tekrar ilk pencereye geç
//       İlk pencerede olduğunu doğrula
    }
}
