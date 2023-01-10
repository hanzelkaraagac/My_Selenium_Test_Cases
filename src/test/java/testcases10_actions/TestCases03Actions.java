package testcases10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class TestCases03Actions extends TestBase {
    @Test
    public void actionsTest() {
//        -http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");

//        -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        Actions actions = new Actions(driver);
        WebElement fleet = driver.findElement(By.xpath("(//*[@class='css-76zvg2 r-homxoj'])[4]"));
        actions.moveToElement(fleet).perform();
        fleet.click();

        //-Sayfa başlığının Fleet içerdiğini test edelim
        String baslik = driver.findElement(By.xpath("(//*[.='Fleet'])[3]")).getText();
        Assert.assertTrue(baslik.contains("Fleet"));

    }
}
