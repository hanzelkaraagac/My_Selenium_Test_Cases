package Day01;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCases05_Faker {
    /* Given kullanici "https://editor.datatables.net/" sayfasina gider
    Then new butonuna basar
    And editor firstname kutusuna "<firstName>" bilgileri girer
    And editor lastname kutusuna "<lastName>" bilgileri girer
    And editor position kutusuna "<position>" bilgileri girer
    And editor office kutusuna "<office>" bilgileri girer
    And editor extension kutusuna "<extension>" bilgileri girer
    And editor startdate kutusuna "<startDate>" bilgileri girer
    And editor salary kutusuna "<salary>" bilgileri girer
    When Create tusuna basar
    Then Kullanıcının eklendiğini doğrular.
    And Eklediği kullanıcı kaydını siler
    Then Kullanıcinin silindiğini doğrular.
    */
    WebDriver driver;
    Faker faker=new Faker();
    String firstName="Can";
    String lastName=faker.name().lastName();
    String position=faker.job().position();
    String office=faker.job().position();
    String extension="EFE";
    String startDate="2022-12-24";
    String salary= String.valueOf(faker.number().numberBetween(Integer.MIN_VALUE,Integer.MAX_VALUE));
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void Test01() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        driver.findElement(By.xpath("//button[@class='dt-button buttons-create']")).click();
        driver.findElement(By.xpath("//input[@id='DTE_Field_first_name']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='DTE_Field_last_name']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='DTE_Field_position']")).sendKeys(position);
        driver.findElement(By.xpath("//input[@id='DTE_Field_office']")).sendKeys(office);
        driver.findElement(By.xpath("//input[@id='DTE_Field_extn']")).sendKeys(extension);
        driver.findElement(By.xpath("//input[@id='DTE_Field_start_date']")).sendKeys(startDate+ Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='DTE_Field_salary']")).sendKeys(salary);
        driver.findElement(By.xpath("//div[@data-dte-e='form_buttons']")).click();
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(firstName);
        WebElement search=driver.findElement(By.xpath("//td[2]"));
        String actual=search.getText();
        Assert.assertTrue("eklenmemiş", actual.contains(firstName));
        search.click();
        driver.findElement(By.xpath("//button[@class='dt-button buttons-selected buttons-remove']")).click();
        driver.findElement(By.xpath("//button[@class='btn']")).click();
        String noMatchingText=driver.findElement(By.xpath("//td[@valign='top']")).getText();
        Assert.assertTrue(noMatchingText.equalsIgnoreCase("No matching records found"));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}