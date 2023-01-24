package testcases10_actions;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class TestCases16_ReadExcel extends TestBase {
    /*
     <!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
     <!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
     1- Öncelikli olarak dependency leri pom.xml'e yüklüyoruz
     2- Dosya yolumuzu string bir değişkene atıyoruz
     3- Ve bu dosyayı sistemde akışa alıyoruz
     */
    @Test
    public void name() throws IOException {
        String dosyaYolu = "/Users/macbookair/Desktop/data.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //Bilgisayarınızdaki data isimli excel dosyasından kullanıcı bilgilerini alıp
        String email = workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString();
        System.out.println("Email : "+email);
        String password = workbook.getSheet("Sayfa1").getRow(2).getCell(1).toString();
        System.out.println("Şifre : "+password);

        //https://www.bluerentalcars.com/ adresine gidip
        driver.get("https://www.bluerentalcars.com/");

        //Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
        driver.findElement(By.xpath("//*[@class='btn btn-primary btn-sm']")).click();
        WebElement emailAddress = driver.findElement(By.xpath("//*[@id='formBasicEmail']"));
        emailAddress.sendKeys(email, Keys.TAB,password,Keys.ENTER);

        //Login olduğumuzu doğrulayalım
        WebElement login = driver.findElement(By.xpath("//*[@id='dropdown-basic-button']"));
        assert login.getText().equals("Erol Evren");
    }
}
