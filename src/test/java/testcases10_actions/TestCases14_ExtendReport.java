package testcases10_actions;

import com.aventstack.extentreports.ExtentTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;
import java.time.Duration;
public class TestCases14_ExtendReport extends TestBase {
    @Test
    public void invisibleTest() {
        extentTest=extentReports.createTest("Extent Tests","Test Raporu");
        //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");
        extentTest.info("Url'e gidildi");

        //Start button'nuna basalım
        driver.findElement(By.xpath("//*[text()='Start']")).click();
        extentTest.info("Start buttonuna basıldı");

        //Hello World! yazısının çıktığını doğrulayalım
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Loading... ']")));
        extentTest.info("Hello World yazısı doğrulandı");

        //Start buttonuna bastıktan sonra Loading webelementi kaybolana kadar bekledik
        assert driver.findElement(By.xpath("//*[text()='Hello World!']")).isDisplayed();
        extentTest.pass("WE beklendi");
    }
}