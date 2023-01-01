package testcases04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Test_Case05 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> toplamIframe = driver.findElements(By.tagName("iframe"));
        System.out.println(toplamIframe.size());

        //Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String actual = driver.findElement(By.xpath("//h3")).getText();
        String expected = "Editor";
        Assert.assertTrue(actual.contains(expected));


        Thread.sleep(3000);
        //Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        WebElement textbox = driver.findElement(By.xpath("//*[text()='Your content goes here.']"));
        textbox.clear();

        Thread.sleep(3000);

        //Sonrasinda paragrafa “iframe'in icindeyim” yazisini yazdıralım
        textbox.sendKeys("iframe'in icindeyim");

        //Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
//      driver.switchTo().parentFrame(); //bir oncekine donmek istersek bunu kullaniriz
        String actual2 = driver.findElement(By.xpath("Elemental Selenium")).getText();
        String expected2 = "Elemental Selenium";
        Assert.assertEquals(expected2,actual2);

        Thread.sleep(3000);


    }
}
