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
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCases09 {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://demo.automationtesting.in/Alerts.html");
    }
    @After
    public void tearDown() {
        driver.close();
    }
    @Test
    public void iframeTest() throws InterruptedException {
        driver.findElement(By.xpath("(//button[@onclick='alertbox()'])")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//*[text()='Alert with OK & Cancel ']")).click();
        driver.findElement(By.xpath("(//button[@onclick='confirmbox()'])")).click();
        driver.switchTo().alert().dismiss();
        driver.findElement(By.xpath("(//*[text()='Alert with Textbox '])")).click();
        driver.findElement(By.xpath("(//button[@onclick='promptbox()'])")).click();
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();
        String actualText = driver.findElement(By.id("demo1")).getText();
        Assert.assertTrue("text aynı değil", actualText.contains("TechProEducation"));
    }
}
