package testcases03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Test_Case05_Dropdown extends TestBase {

    @Test
    public void test01() {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        //Dropdown menuyu yazdıralım
        List<WebElement> dropdown = driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        //Select select = new Select(dropdown);
        dropdown.forEach(t-> System.out.println(t.getText()));
        //Dropdown menuden baby secelim
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby"
                ,Keys.TAB,"Milk",Keys.ENTER);

//        WebElement dropdown2 = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
//        Select select = new Select(dropdown2);
//        for (WebElement w:select.getOptions()) {
//            System.out.println(w.getText());
//        }


        //arama bölümünden milk aratalım
    }
}
