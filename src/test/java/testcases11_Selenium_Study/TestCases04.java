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

public class TestCases04 {
    /*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void Test01() throws InterruptedException {
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
        driver.findElement(By.xpath("//a[normalize-space()='Phones & PDAs']")).click();
        getName();
        clickAllElements();
        driver.findElement(By.xpath("//div[@id='cart']")).click();
        getNameOfCart();
        compareTwoList();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    public void clickAllElements() throws InterruptedException {
        List<WebElement>addToCart=driver.findElements(By.xpath("(//button[@type='button'])"));
        for (int i = 8; i <=15 ; i+=3) {
            addToCart.get(i).click();
            Thread.sleep(2000);
        }
        List<String> myList = new ArrayList<String>(Arrays.asList(driver.findElement(By.id("cart-total")).getText().split(" ")));
        Assert.assertTrue("Sepette 3 ürün yok", myList.get(0).equalsIgnoreCase("3"));
    }
    public List<String> getName()  {
        //~ get the brandName of phones
        List<WebElement> brandName = driver.findElements(By.xpath("//h4"));
        List<String> brandList =new ArrayList<>();
        for (int i = 0; i <brandName.size() ; i++) {
            brandList.add(i,brandName.get(i).getText());
        }
        return brandList;
    }
    public List<String> getNameOfCart(){
        // ~ get the names of list from the cart
        List<WebElement>listOfCart=driver.findElements(By.xpath("//td[@class='text-left']"));
        List<String>CartList =new ArrayList<>();
        for (int i = 0; i <listOfCart.size() ; i++) {
            CartList.add(i,listOfCart.get(i).getText());
        }
        return CartList;
    }
    public void compareTwoList()  {
        getName().containsAll(getNameOfCart());
        getName().add("Test");
        System.out.println(getName());
        System.out.println(getNameOfCart());
    }
}