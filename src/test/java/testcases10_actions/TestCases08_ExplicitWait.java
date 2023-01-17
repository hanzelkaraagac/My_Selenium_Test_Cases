package testcases10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class TestCases08_ExplicitWait extends TestBase {

    /*
                                    - Explicit Wait -
        Selenium’da Explicit Wait, Web Sürücüsüne belirli koşulları (Expected Condition) veya
    “ElementNotVisibleException” exception’ı atmadan önce aşılan maksimum süreyi beklemesini söylemek için kullanılır.
    Akıllı bir bekleme türüdür ancak yalnızca belirli öğeler(elementler) için uygulanabilir.
    Dinamik olarak yüklenen web elementleri beklerken implicit wait’ten daha iyi seçenekler sunar.
        Explicit Wait kullandığımızda, “ExpectedConditions” tanımlamalıyız veya Fluent Wait kullanarak durumu ne
    sıklıkla kontrol etmek istediğimizi yapılandırmalıyız.
Syntax:
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(element locator));
     */
    //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
    //Start button'nuna basalım
    //Hello World! yazısının çıktığını doğrulayalım


    @Test
    public void visibilityTest() {
        //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Start button'nuna basalım
        driver.findElement(By.xpath("//*[text()='Start']")).click();

        //Hello World! yazısının çıktığını doğrulayalım
//     //Start button'una bastiktan sonra loading yazisi kaybolana kadar bekle.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));//kac saniyede bulursa gecer. 20 saniye beklemez. oncesinde bulursa gecer.
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loading']")));
        driver.findElement(By.xpath("//*[@id='loading']")).isDisplayed();

//      //Start button'una bastiktan sonra Hello World! yazisi gorunene kadar bekledik.
//      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Hello World!']")));
//      driver.findElement(By.xpath("//*[text()='Hello World!']")).isDisplayed();
    }
}
