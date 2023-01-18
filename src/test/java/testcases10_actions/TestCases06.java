package testcases10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCases06 extends TestBase {
    @Test
    public void test01() {
        /*
     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
     -Sari oldugunu test ediniz.
     */

//      -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

        WebElement iframe = driver.findElement(By.xpath("//*[@class='demo-frame']"));
        driver.switchTo().frame(0);

//      -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        WebElement yesilTus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement mavitus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
        Actions actions = new Actions(driver);

        actions.dragAndDropBy(yesilTus,-175,0).perform();//Genellikle slider'lar icin bu method kullanilir.
        actions.dragAndDropBy(mavitus,-80,0).release().build().perform();
        actions.dragAndDropBy(yesilTus,300,0).release().build().perform();


//      -Sari oldugunu test ediniz.
        WebElement sari = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 254, 0);']"));
        Assert.assertTrue(sari.isDisplayed());
        //asagidaki gibi de kullanilabilir
//        assert sari.isDisplayed();




    }
}
