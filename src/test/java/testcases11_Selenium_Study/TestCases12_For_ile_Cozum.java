package testcases11_Selenium_Study;


        import org.bouncycastle.math.ec.custom.sec.SecT113Field;
        import org.junit.Assert;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import utilities.TestBase;
        import java.util.Set;
public class TestCases12_For_ile_Cozum  extends TestBase {
    @Test
    public void windowTest() {
        https:
//testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get(" https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String window1 = driver.getWindowHandle();
        //Title in ‘Windows’ oldugunu test edin
        String baslik1 = driver.getTitle();
        System.out.println(baslik1);
        Assert.assertEquals("Windows", driver.getTitle());
        // Click here a tiklayin
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);
        for (String eachHandle : allWindowHandles) {
            if (!eachHandle.equals(window1)) {
                driver.switchTo().window(eachHandle);
                break;
            }
        }
        //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        String window2 = driver.getTitle();
        System.out.println(window2);
        Assert.assertEquals("New Window", driver.getTitle());
    }
}


