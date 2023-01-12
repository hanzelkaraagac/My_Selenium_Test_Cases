package testcases11_Selenium_Study;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class TestCases08 {
    /*
1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
3-Option3 ü seçin.
4-Option3 ün seçili olduğunu doğrulayın.
*/
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }
    @After
    public void tearDown() throws Exception {
        driver.close();
    }
    @Test
    public void DropDownMenu() {
        WebElement Dropdown_Example=driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        Assert.assertTrue(Dropdown_Example.isDisplayed());
        Select opt=new Select(Dropdown_Example);
        opt.selectByValue("option3");
        Assert.assertTrue(Dropdown_Example.getAttribute("value").equalsIgnoreCase("option3"));
    }
}
