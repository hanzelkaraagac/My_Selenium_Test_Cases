package testcases04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Test_Case03 extends TestBase {

    @Test
    public void test01() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

//      Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
        String actual = driver.findElement(By.xpath("//p[1]")).getText();
        String expected = "An iframe with a thin black border:";
        Assert.assertEquals(actual,expected);

//      Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);
        String actual2 = driver.findElement(By.xpath("//h1")).getText();
        String expected2 = "Applications lists";
        Assert.assertTrue(actual2.contains(expected2));

//      Son olarak footer daki ‘Povered By’ yazisini varligini test edelim

        driver.switchTo().defaultContent();//ana sayfaya donmemizi saglar.

        String actual3 = driver.findElement(By.xpath("//*[text()='Povered By']")).getText();
        String expected3 = "Povered By";
        Assert.assertTrue(actual3.contains(expected3));


    }
}
