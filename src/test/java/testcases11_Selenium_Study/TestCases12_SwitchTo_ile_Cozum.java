package testcases11_Selenium_Study;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;
public class TestCases12_SwitchTo_ile_Cozum extends TestBase {
    @Test
    public void windowsTest() {
          /*
        -------ÖDEV----------
        https://testcenter.techproeducation.com/index.php?page=multiple-windows
        Title in ‘Windows’ oldugunu test edin
        Click here a tiklayin
        Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
                 */
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String targetTitle="Windows";
        switchToWindow(targetTitle);
        // Click here a tiklayin
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
        String targetTitle2="New Window";
        switchToWindow(targetTitle2);
    }
}


