package testcases04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Test_Case04 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//    https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

//    ILK SAYFANIN ID'SINI ALALIM
        String windowHandle1 = driver.getWindowHandle();

//    Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
      String actual = driver.findElement(By.xpath("//h3")).getText();
       String expected = "Opening a new window";
       Assert.assertEquals(expected,actual);

//    Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
        String title = driver.getTitle();
        Assert.assertEquals("The Internet",title);

//    Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
//    BU NOKTADA 2 PENCERE ACIK VE IKINCISINE GECIS YAPMAK ISTIYORUM
//    BUNUN ICIN driver.getWindowHandles() ILE TUM PENCERELERIN IDLERINI ALALIM

        Thread.sleep(3000);
        Set<String> tumPencereler = driver.getWindowHandles();
        for (String w: tumPencereler) {
            if (!w.equals(windowHandle1)){
                driver.switchTo().window(w);
                break;
            }
        }

//    BU NOKTADA DRIVER 2. PENCEREDE
//    Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.
        String windowHandle2 = driver.getWindowHandle();
        String title2 = driver.getTitle();
        Assert.assertEquals("New Window",title2);

//    Sayfadaki textin "New Window" olduğunu doğrulayın.
        String textVerify= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window",textVerify);

        Thread.sleep(1500);


//    Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu  doğrulayın.
        driver.switchTo().window(windowHandle1);
        String title3 = driver.getTitle();
        Assert.assertEquals("The Internet",title3);

        Thread.sleep(1500);
//    2. windowa tekrar gecelim
        driver.switchTo().window(windowHandle2);

        Thread.sleep(1500);
//    1. windowa tekrar gecelim
        driver.switchTo().window(windowHandle1);
    }


}
