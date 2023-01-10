package testcases07_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCases02_Iframe extends TestBase {
    @Test
    public void iframeTest() {
        // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");


        // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
        WebElement baslik=driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(baslik.isEnabled());
        System.out.println("BASLIK: " + baslik.getText());



        // TextBox'a 'Merhaba Dunya' yazin.

        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);


        WebElement textBox = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));

        textBox.clear();
        waitFor(3);
        textBox.sendKeys("Merhaba Dunya");


        // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin

        driver.switchTo().parentFrame();

        WebElement elementalSelenium=driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSelenium.isDisplayed());

        System.out.println("ELEMENTAL SELENİUM YAZISI: " + elementalSelenium.getText());

    }
}
