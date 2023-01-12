package testcases13Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TestCases02_FileDownload extends TestBase {
    @Test
    public void fileDownloadTest() {
        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //2. some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();

        //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)

        //1.YOL
//        String dosyaYolu = "/Users/macbookair/Downloads";
//        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //2.YOL
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "/macbookair/Downloads";
        String dosyaYolu2 = farkliKisim + ortakKisim;


    }
}
