package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    protected static WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
       // driver.quit();
    }




    //    MULTIPLE WINDOW
//    1 parametre alir: Gecis yapmak istedigim sayfanin Title
//    ORNEK:
//    driver.get("https://the-internet.herokuapp.com/windows");
//    switchToWindow("New Window");
//    switchToWindow("The Internet");
    public static void switchToWindow (String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;//CIK. break'den daha guzlu. method'un disina cikip devam ediyor (return)
            }
        }
        driver.switchTo().window(origin); //eger oyle bir sayfa yok ise tekrar ayni sayfada kal dedik. (sayfadaki title'i bulamazsa)
    }



    //windowNumber sıfır (0)'dan başlıyor.
    //index numarasini parametre olarak alir.
    //ve o indexli pencereye gecis yapar
    public static void switchToWindow(int windowNumber){ //ayni isim farkli parametre (switchToWindow) Overloading
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }


    /*   HARD WAIT:
    @param : second
*/
    public static void waitFor (int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
