package testcases10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCases02 extends TestBase {
    @Test
    public void test01() {
        //google sayfasina gidelim
        driver.get("https://google.com");

        //Buyuk kucuk harf olucak sekilde "HeLlO" yazdiralim
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys(Keys.SHIFT,"H",Keys.SHIFT,"e",Keys.SHIFT,"l",Keys.SHIFT,"l",Keys.SHIFT,"O",Keys.SHIFT);
    }
}
