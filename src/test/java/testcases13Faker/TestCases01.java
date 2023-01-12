package testcases13Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class TestCases01 extends TestBase {
    @Test
    public void fakerTest() {
        // 'https://www.facebook.com' sayfasina gidiniz
        driver.get("https://www.facebook.com");

        // yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // isim kutusunu locate ediniz
        WebElement isimKutusu = driver.findElement(By.xpath("//*[@name='firstname']"));

        // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun
        Faker faker = new Faker();

        String email = faker.internet().emailAddress();

        Actions actions = new Actions(driver);

        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(email)
                .sendKeys(Keys.TAB).sendKeys(email)
                .sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("14").sendKeys(Keys.TAB)
                .sendKeys("Sep").sendKeys(Keys.TAB)
                .sendKeys("1996")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ENTER).perform();



    }
}
