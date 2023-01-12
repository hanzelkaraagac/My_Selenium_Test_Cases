package testcases11_Selenium_Study;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class TestCases19 extends TestBase {

    @Test
    public void test01() {

        //Test01 :  1- amazon gidin
        driver.get("https://www.amazon.com.tr");
        driver.findElement(By.id("sp-cc-accept")).click();//cerezler

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement searchDropDown = driver.findElement(By.id("searchDropdownBox"));
        Select option = new Select(searchDropDown);
        List<WebElement> searchList = option.getOptions();
        searchList.stream().forEach(t-> System.out.println(t.getText()));

        //dropdown menude 40 eleman olduğunu doğrulayın
        Assert.assertTrue(searchList.size()>20);

        //Test02
        //dropdown menuden elektronik bölümü seçin
        option.selectByVisibleText("Elektronik");

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucSayisi.getText().contains("iphone"));

        //ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("//div[@class='sg-col-inner']//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']")).click();

        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String iphoneTitle = driver.getTitle();
        String iphonePrice = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']")).getText();
        driver.findElement(By.id("add-to-cart-button")).click();


        //Test03
        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com.tr");

        //dropdown’dan bebek bölümüne secin
        WebElement searchDropDown1 = driver.findElement(By.id("searchDropdownBox"));
        Select option1 = new Select(searchDropDown1);
        option1.selectByVisibleText("Bebek");

        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puset", Keys.ENTER);

        //sonuç yazsının puset içerdiğini test edin
        WebElement sonucSayisi1 = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucSayisi1.getText().contains("puset"));

        //5-üçüncü ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[3]")).click();

        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
        String pusetTitle = driver.getTitle();
        String pusetPrice = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']")).getText();
        driver.findElement(By.id("add-to-cart-button")).click();

        driver.findElement(By.xpath("//span[@class='a-button-inner']//a[@data-csa-c-content-id='sw-gtc_CONTENT']")).click();//sepete git

        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        //urun basligi dogrulamasi
        driver.findElement(By.xpath("(//*[@class='a-truncate-cut'])[1]")).click();//sepetteki pusete tikla
        List<String> allWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindow.get(2));
        Assert.assertEquals(pusetTitle, driver.getTitle());

        //fiyat dogrulamasi
        String sepettekiPusetFiyat = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']")).getText();
        Assert.assertEquals(pusetPrice,sepettekiPusetFiyat);

        driver.switchTo().window(allWindow.get(1));
        driver.findElement(By.xpath("(//*[@class='a-truncate-cut'])[2]")).click();

        List<String> allWindow1 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindow1.get(3));
        Assert.assertEquals(iphoneTitle,driver.getTitle());

        String sepettekiIphoneFiyat = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']")).getText();
        Assert.assertEquals(iphonePrice,sepettekiIphoneFiyat);

    }
}


