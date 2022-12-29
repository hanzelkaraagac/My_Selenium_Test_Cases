package testcases05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Test_Case01_Dropdown {
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        WebElement option = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(option);
        select.selectByIndex(1);
        String sectigimOptionIndex = select.getFirstSelectedOption().getText();
        System.out.println("sectigim Option Index = " + sectigimOptionIndex);

        Thread.sleep(3000);

        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        select.selectByValue("2");
        String sectigimOptionValue =  select.getFirstSelectedOption().getText();
        System.out.println("sectigim Option Value = " + sectigimOptionValue);

        Thread.sleep(3000);

        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        select.selectByVisibleText("Option 1");
        String sectigimOptionText = select.getFirstSelectedOption().getText();
        System.out.println("sectigim Option Text = " + sectigimOptionText);

        Thread.sleep(3000);

        // Tüm option'ları yazdırın
        List<WebElement> tumOptionlar = select.getOptions();
        int sayac=1;
        for (WebElement w:tumOptionlar) {
            System.out.println(sayac + ". OPTION " + w.getText());
            sayac++;
        }

        //lambda ile
//        List<WebElement> allOptions = select.getOptions();
//        allOptions.forEach(t -> System.out.println("Option Isımleri : " + t.getText()));

        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        int expected =3;
        int actual = tumOptionlar.size();
        Assert.assertEquals(expected,actual);
    }
}
