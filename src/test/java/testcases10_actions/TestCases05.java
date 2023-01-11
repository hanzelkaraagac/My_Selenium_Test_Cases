package testcases10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCases05 extends TestBase {
    @Test
    public void test01() {

//    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

//    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement cizim = driver.findElement(By.xpath("//*[@class='signature-pad--body']"));
        Actions actions = new Actions(driver);

        actions.clickAndHold(cizim).moveByOffset(35,20)
                .moveByOffset(50,10)
                .moveByOffset(-10,-50)
                .moveByOffset(-50,-10)
                .release().perform();







//    - Son olarak sayfayı temizleyiniz

    }
}
