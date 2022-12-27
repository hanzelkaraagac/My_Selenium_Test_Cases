package testcases02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Case01 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //-"sahibinden.com" adresine gidelim
        driver.get("https://sahibinden.com");
        Thread.sleep(3000);
        //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String sayfaTitle = driver.getTitle();
        String sayfaUrl = driver.getCurrentUrl();
        System.out.println("sayfaTitle = " + sayfaTitle);
        System.out.println("sayfaUrl = " + sayfaUrl);

        //-title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(sayfaTitle.contains("Oto") && sayfaUrl.contains("Oto"));

        //-Ardindan "trendyol.com" adresine gidelim
        driver.get("https://trendyol.com");

        //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String trendyolTitle = driver.getTitle();
        Assert.assertTrue(trendyolTitle.contains("Sitesi"));
        System.out.println(trendyolTitle);

        //-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();

        //-sayfayi yenileyelim
        driver.navigate().refresh();

        //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();
        driver.close();
    }
}
