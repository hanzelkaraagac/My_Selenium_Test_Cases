package testcases06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class TestCases07 extends TestBase {
    @Test
    public void test01() {
        // https://amazon.com adresine gidiniz
        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        // Change country/region butonuna basiniz
        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        // Go to website butonuna tiklayiniz
        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz


            // https://amazon.com adresine gidiniz
            driver.get("https://amazon.com");
            String sayfa1Handle = driver.getWindowHandle();


            // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mouse'u bu menunun ustune getirelim
            WebElement dilMenu = driver.findElement(By.xpath("//div[text()='EN']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(dilMenu).perform();
            waitFor(3);


            // Change country/region butonuna basiniz
            driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();


            // United States dropdown'undan 'Turkey (Türkiye)' seciniz
            WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
            Select select = new Select(ddm);
            //select.selectByIndex(19);
            select.selectByVisibleText("Turkey (Türkiye)");
            waitFor(3);


            //Drop down opsiyon listesi 'Go to website' butonuna basmamıza engel oldugu icin
            //herhangi bir yere clic yapıp drop down opsiyon listesinin toparlanmasını sagladık
            driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();
            waitFor(3);

            // Go to website butonuna tiklayiniz
            driver.findElement(By.xpath("//span[@id='icp-save-button']")).click();


            // acilan yeni sayfadanin Title'ini yazdirin ve 'Elektronik' icerdigini test ediniz

            Set<String> windowHandleSeti = driver.getWindowHandles();

            System.out.println(sayfa1Handle);
            System.out.println(windowHandleSeti);

            String sayfa2Handle = "";

            for (String each : windowHandleSeti) {

                if (!each.equals(sayfa1Handle)) {

                    sayfa2Handle = each;

                }

            }

            driver.switchTo().window(sayfa2Handle);

            String ikinciSayfaTitle = driver.getTitle();
            System.out.println(ikinciSayfaTitle);

            Assert.assertTrue(ikinciSayfaTitle.contains("Elektronik"));
        }
    }
