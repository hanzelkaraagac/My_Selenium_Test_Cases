package testcases06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class TestCases05_WindowHandle extends TestBase {
    @Test
    public void windowHandleTest() {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String sayfa1Handle=driver.getWindowHandle();


        // 2- url'in 'amazon' icerdigini test edelim
        String amazonUrl=driver.getCurrentUrl();
        Assert.assertTrue(amazonUrl.contains("amazon"));


        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String sayfa2Handle=driver.getWindowHandle();



        // 4- title'in 'Best Buy' icerdigini test edelim
        String bestBuyTitle=driver.getTitle();
        Assert.assertTrue(bestBuyTitle.contains("Best Buy"));


        // 5- ilk sayfaya(amazon) donup sayfada Java aratalım
        driver.switchTo().window(sayfa1Handle);
        WebElement amazonAramaMot=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        amazonAramaMot.sendKeys("Java" + Keys.ENTER);



        // 6- arama sonuclarının 'Java' icerdigini test edelim
        WebElement aramaSonucu=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String aramaSonucuStr=aramaSonucu.getText();
        Assert.assertTrue(aramaSonucuStr.contains("Java"));



        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(sayfa2Handle);


        // 8- logonun gorundugunu test edelim
        WebElement logo=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

    }
}
