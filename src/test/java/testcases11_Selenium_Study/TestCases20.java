package testcases11_Selenium_Study;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

// Bir Class olusturalim KeyboardActions2
public class TestCases20 extends TestBase {

    @Test
    public void KeyboardActions2Test() {
        Actions actions = new Actions(driver);
        // https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        waitForPageToLoad(30);                // Waiting for page to load...
        // video’yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // videoyu izlemek icin Play tusuna basin
        driver.switchTo().frame(0);
        WebElement video = driver.findElement(By.xpath("//*[@id='player']//div"));
        String beforeClassValue = ((WebElement) video).getAttribute("class");
        video.click();
        // videoyu calistirdiginizi test edin
        waitFor(5);
        String afterClassValue = video.getAttribute("class");
        System.out.println("beforeClassText = " + beforeClassValue);
        System.out.println("afterClassText = " + afterClassValue);
        Assert.assertNotEquals(beforeClassValue,afterClassValue);
    }
}

