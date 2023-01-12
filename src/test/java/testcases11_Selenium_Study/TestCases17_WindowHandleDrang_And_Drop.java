package testcases11_Selenium_Study;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCases17_WindowHandleDrang_And_Drop extends TestBase {
    /*
  #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
 #Fill in capitals by country
*/
  /*
   #url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
  #Ülkeye göre başkentleri doldurun
 */

    @Test
    public void capitalsTest() {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        //Kaynak Elementler:
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement stokholm = driver.findElement(By.id("box2"));
        WebElement washington = driver.findElement(By.id("box3"));
        WebElement kopenhag = driver.findElement(By.id("box4"));
        WebElement seul = driver.findElement(By.id("box5"));
        WebElement roma = driver.findElement(By.id("box6"));
        WebElement madrid = driver.findElement(By.id("box7"));

        //Hedef Elementler:
        WebElement norvec = driver.findElement(By.id("box101"));
        WebElement isvec = driver.findElement(By.id("box102"));
        WebElement ABD = driver.findElement(By.id("box103"));
        WebElement danimarka = driver.findElement(By.id("box104"));
        WebElement guneyKore = driver.findElement(By.id("box105"));
        WebElement italya = driver.findElement(By.id("box106"));
        WebElement ispanya = driver.findElement(By.id("box107"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(oslo, norvec).perform();
        waitFor(3);
        actions.dragAndDrop(stokholm, isvec).perform();
        waitFor(3);
        actions.dragAndDrop(washington, ABD).perform();
        waitFor(3);
        actions.dragAndDrop(kopenhag, danimarka).perform();
        waitFor(3);
        actions.dragAndDrop(seul, guneyKore).perform();
        waitFor(3);
        actions.dragAndDrop(roma, italya).perform();
        waitFor(3);
        actions.dragAndDrop(madrid, ispanya).perform();
        waitFor(3);
    }
}
