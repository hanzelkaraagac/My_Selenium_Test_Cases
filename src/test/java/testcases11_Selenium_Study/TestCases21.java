package testcases11_Selenium_Study;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

// Yeni Class olusturun ActionsClassHomeWork
public class TestCases21 extends TestBase {
    @Test
    public void keyboardBaseActionsTest() {     // Keyboard Base Actions
        Actions actions = new Actions(driver);
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        // 2- Hover over Me First" kutusunun ustune gelin
        WebElement homfButton = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(homfButton).perform();
        // Link 1" e tiklayin
        driver.findElement(By.xpath("//*[text()='Link 1']")).click();
        // Popup mesajini yazdirin
        System.out.println("Popup mesaji = " + driver.switchTo().alert().getText());
        // Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        // “Click and hold" kutusuna basili tutun
        WebElement cahBox = driver.findElement(By.id("click-box"));
        actions.clickAndHold(cahBox).perform();
        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Click and hold button mesaji = " + cahBox.getText());
        // 8- “Double click me" butonunu cift tiklayin (Cift tiklandigini kontrol et)
        WebElement dcmButton = driver.findElement(By.id("double-click"));
        String beforeDcmButton = dcmButton.getAttribute("class");
        actions.doubleClick(dcmButton).perform();
        String afterDcmButton = dcmButton.getAttribute("class");
        System.out.println("\nbeforeDcmClick = " + beforeDcmButton);
        System.out.println("afterDcmClick = " + afterDcmButton);
        Assert.assertNotEquals(beforeDcmButton,afterDcmButton);
    }
}
