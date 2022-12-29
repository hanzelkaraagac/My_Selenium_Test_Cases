package testcases04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Case01 {
    // https://amazon.com sayfasina gidelim.
    //sayfanin gorundugunu dogrulayalim.

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://amazon.com sayfasina gidelim.
        driver.get("https://amazon.com");
    }

    @AfterClass
    public static void afterClass() {
        // driver.close();
    }

    @Test
    public void test01() {
        //sayfanin gorundugunu dogrulayalim.
        WebElement homePage = driver.findElement(By.xpath("(//body)[1]"));
        Assert.assertTrue(homePage.isDisplayed());

        //searcbox'daki "all"dan "Video Games"'a tiklayalim ve "gta 5" i aratalim.
        //cikan ilk resme tiklayalim.
        //tekrar anasayfaya donelim.



    }
}
