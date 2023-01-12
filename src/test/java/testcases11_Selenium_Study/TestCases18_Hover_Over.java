package testcases11_Selenium_Study;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCases18_Hover_Over extends TestBase {
    //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2. "Hover over Me First" kutusunun ustune gelin
    //3. "Link 1" e tiklayin
    //4. Popup mesajini yazdirin
    //5. Popup'i tamam diyerek kapatin
    //6. "Click and hold" kutusuna basili tutun
    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    //8. "Double click me" butonunu cift tiklayin
    //9. "Double click me" butonunun renk değiştridiğini doğrulayın


    @Test
    public void actionsTest() {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        WebElement hoverFirst = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));

        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverFirst).perform();
        waitFor(2);

        //3. "Link 1" e tiklayin
        driver.findElement(By.linkText("Link 1")).click();


        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHoldButton = driver.findElement(By.xpath("//p[text()='Click and Hold!']"));
        actions.clickAndHold(clickAndHoldButton).perform();


        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.id("click-box")).getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickMeButton = driver.findElement(By.id("double-click"));
        String firstColor = doubleClickMeButton.getCssValue("background-color");

        actions.doubleClick(doubleClickMeButton).perform();

        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        String lastColor = doubleClickMeButton.getCssValue("background-color");
        System.out.println("firstColor = " + firstColor);
        System.out.println("lastColor = " + lastColor);
        Assert.assertNotEquals(firstColor, lastColor);
    }
}



