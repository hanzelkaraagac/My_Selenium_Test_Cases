package testcases03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Test_Case09_Dropdown extends TestBase {

    @Test
    public void dropdownTest() {
        // https://testcenter.techproeducation.com/index.php?page=dropdown sitesine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        WebElement selectOption = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(selectOption);
        select.selectByIndex(1);
        String ekranaYazdirOption1  = select.getFirstSelectedOption().getText();
        System.out.println("sectigim Option Index : " + ekranaYazdirOption1);

        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        select.selectByValue("2");
        String ekranaYazdirOption2 = select.getFirstSelectedOption().getText();
        System.out.println("sectigim Option Value : " + ekranaYazdirOption2);

        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        select.selectByVisibleText("Option 2");
        String ekranaYazdirOption3 = select.getFirstSelectedOption().getText();
        System.out.println("sectigim Option VisibleText : " + ekranaYazdirOption3);

        // Tüm option'ları yazdırın
        List<WebElement> hepsiniEkranaYazdir = select.getOptions();
        int sayac = 1;
        for (WebElement w: hepsiniEkranaYazdir) {
            System.out.println(sayac + " " + w.getText());
            sayac++;
        }

        System.out.println("***************************");

        // Yil 1996'yi secelim.
        WebElement yil = driver.findElement(By.id("year"));
        Select select2 = new Select(yil);
        select2.selectByValue("1996");

        // Ay September secelim.
        WebElement ay = driver.findElement(By.id("month"));
        Select select3 = new Select(ay);
        select3.selectByVisibleText("September");


        // gun 14'u secelim.
        WebElement gun = driver.findElement(By.id("day"));
        Select select4 = new Select(gun);
        select4.selectByIndex(13);

        // State selection kismindaki listeyi ekrana yazdirin.
        WebElement stateSelectionAll = driver.findElement(By.id("state"));
        Select select5 = new Select(stateSelectionAll);
        List<WebElement> stateSelectionAll2 = select5.getOptions();

        for (WebElement state : stateSelectionAll2) {
            System.out.println(state.getText());
        }

        //Which programming languages do you know? kismindan Java ve JavaScript'i secelim.

        //large button'a click yapin.


    }
}
