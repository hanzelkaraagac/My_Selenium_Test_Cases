package testcases11_Selenium_Study;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Set;
/*
       url'ye git: http://demo.guru99.com/popup.php
       ilk pencereyi al
       "Click Here" butonuna tıklayın
       setteki tüm pencereyi al
       diğer pencereye geç
       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
       Gönder düğmesine tıklayarak
       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
       Tekrar ilk pencereye geç
       İlk pencerede olduğunu doğrula
      */
public class TestCases14_WindowHandle {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("http://demo.guru99.com/popup.php");
        String ilkPencere=driver.getWindowHandle();
        System.out.println("ilk pencere : "+ilkPencere);
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> pencereler=driver.getWindowHandles();
        System.out.println(pencereler);
        String ikinciWindowhandle="";
        for (String each:pencereler) {
            if (!each.equals(ilkPencere)){
                ikinciWindowhandle=each;
            }
        }
        System.out.println("ikinci pencere"+ikinciWindowhandle);
        driver.switchTo().window(ikinciWindowhandle);
        Thread.sleep(2000);
        // Clicking on the submit button
        driver.findElement(By.xpath("(//input[@name='emailid'])")).sendKeys("somepne@gmail.com");
        driver.findElement(By.xpath("(//input[@name='btnLogin'])")).click();
        // verify title as expected
        //-->test edin diyorsa hard assertion, verify diyorsa soft assertion
        Assert.assertEquals("This access is valid only for 20 days.", driver.findElement(By.tagName("h3")).getText());
        //      switch to first window
        driver.switchTo().window(ilkPencere);
        Assert.assertTrue(driver.getCurrentUrl().contains("popup.php"));
    }
}


