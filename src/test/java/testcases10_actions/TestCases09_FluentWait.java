package testcases10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.TestBase;

import java.time.Duration;

public class TestCases09_FluentWait extends TestBase {

      /*
                                - Fluent Wait -
        Selenium’da Fluent Wait, web sürücüsünün bir koşulu beklemesi için maksimum süreyi ve “ElementNotVisibleException”
    exception’ını atmadan önce koşulu kontrol etmek istediğimiz sıklığı tanımlamak için kullanılır.
    Nesne bulunana veya zaman aşımı gerçekleşene kadar düzenli aralıklarla web elementini kontrol eder.
        Bir elemanın farklı zaman aralıklarında yüklendiği bir senaryo düşünelim.
    Öğe 10 saniye, 20 saniye veya daha uzun bir süre içinde yüklenebilir.
    Bu durumda 20 saniyelik Explicit Wait tanımlarsak bir exception atmadan önce belirtilen süreye kadar bekleyecektir.
    Bu tür senaryolarda, Fluent Wait öğeyi bulana kadar veya son zamanlayıcı bitene kadar farklı frekansta bulmaya
    çalışacağından, kullanımı ideal olacaktır.
    Syntax:
                 Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);//Eğer element bulunmazsa NoSuchElementException hatasını yok sayar.
     */
    //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sayfasına gidelim
    //Click me, to open an ... butonuna basalım
    //Çıkan alert'i kapatalım


    @Test
    public void fluentWaitTest() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sayfasına gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //Click me, to open an ... butonuna basalım
        WebElement waitButton = driver.findElement(By.xpath("//button[@id='alert']"));
        waitButton.click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))//Max bekleme suresi
                .pollingEvery(Duration.ofSeconds(2));//hangi siklikla beklemesi gerektigini belirleriz.
        wait.until(ExpectedConditions.alertIsPresent());//Alert cikana kadar bekle
        //Çıkan alert'i kapatalım
        driver.switchTo().alert().accept();
    }
}
