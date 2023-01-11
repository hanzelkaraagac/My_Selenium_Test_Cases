package testcases06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class TestCases06_WindowHandles extends TestBase {
    @Test
    public void windowHandlesTest() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String sayfa1Handle=driver.getWindowHandle();



        // arama motoruna 'oppo' yazıp aratın
        WebElement aramaMotoru= driver.findElement(By.xpath("//input[@id='searchData']"));
        aramaMotoru.sendKeys("oppo" + Keys.ENTER);


        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]")).click();

        Set<String> windowHandleSeti=driver.getWindowHandles();



        String sayfa2Handle="";
        for (String each:windowHandleSeti) {

            if(!each.equals(sayfa1Handle)){

                sayfa2Handle=each;

            }



        }



        System.out.println(windowHandleSeti);

        System.out.println(sayfa1Handle);






        driver.switchTo().window(sayfa2Handle);

        // Basligin 'Oppo' icerdigini test edin.

        WebElement baslik=driver.findElement(By.xpath("//h1[@class='proName']"));
        String baslikStr=baslik.getText();
        Assert.assertTrue(baslikStr.contains("Oppo"));






        // ilk sayfaya donun ve Title'ını yazdırın

        driver.switchTo().window(sayfa1Handle);

        System.out.println("İLK SAYFA TİTLE : " + driver.getTitle());
    }
}
