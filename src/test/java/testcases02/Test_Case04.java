package testcases02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Case04 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculate under Micro Apps
        driver.findElement(By.xpath("//*[text()='Calculator']")).click();

        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("30", Keys.TAB,Keys.TAB,"30",Keys.ENTER);

        // Type any number in the second input
//      driver.findElement(By.id("number2")).sendKeys("14");

        // Click on Calculate
//      driver.findElement(By.id("calculate")).click();
        // Print the result
        WebElement sonuc = driver.findElement(By.xpath("//*[@id='answer']"));
        System.out.println("sonuc : " + sonuc.getText());

        // close driver
        driver.close();

    }
}
