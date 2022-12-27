package testcases02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Case03 {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        //fill the firstname
        WebElement firstName = driver.findElement(By.xpath("(//*[@type='text'])[1]"));
                     //Key.SPACE ==> secmemize yariyor               //erkek olsaydi Keys.TAB,Keys.SPACE derseniz male'yi secer
        firstName.sendKeys("Hanzel", Keys.TAB,"Karaagac",Keys.TAB,Keys.ARROW_RIGHT,Keys.TAB,
                Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.TAB,"12/12/2022",Keys.TAB,Keys.TAB,
                Keys.SPACE,Keys.TAB,Keys.TAB,Keys.TAB,Keys.SPACE,Keys.TAB,"Africa",Keys.TAB,Keys.LEFT_SHIFT,
                Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.SPACE,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);

        //Tek bir locate'de hepsini tamamladik :)

        //fill the lastname
        //check the gender
        //check the experience
        //fill the date
        //choose your profession -> Automation Tester
        //choose your tool -> Selenium Webdriver
        //choose your continent -> Antartica
        //choose your command  -> Browser Commands
        //click submit button

    }
}
