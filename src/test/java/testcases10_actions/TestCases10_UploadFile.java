package testcases10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCases10_UploadFile extends TestBase {

    //https://demo.guru99.com/test/upload/ adresine gidiniz
    //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
    // I accept terms of service bölümünü tikleyin
    // Submit File buttonuna basınız
    // "1 file has been successfully uploaded" görünür olduğunu test edin


    @Test
    public void uploadFileTest() {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");

        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
        String farkliKisim = System.getProperty("user.home");///Users/macbookair/Desktop
        String ortakYol = "/Desktop/logo.jpeg";
        String dosyaYolu = farkliKisim+ortakYol;

        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='uploadfile_0']"));
        dosyaSec.sendKeys(dosyaYolu);

        // I accept terms of service bölümünü tikleyin
        // Submit File buttonuna basınız
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='terms']"));
        checkBox.click();
        checkBox.sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER);

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        waitFor(3);
        driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();
    }
}
