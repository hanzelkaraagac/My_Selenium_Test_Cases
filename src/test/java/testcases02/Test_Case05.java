package testcases02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Test_Case05 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız
        WebElement addButton = driver.findElement(By.xpath("//*[text()='Add Element']"));
        for (int i = 0; i < 100; i++) {
            addButton.click();
        }

        // 100 defa basıldığını test ediniz
        //1.YOL
        List<WebElement> deleteButton = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        Assert.assertEquals(100,deleteButton.size());
        //Ekranda gormesini istiyorsak eger
        System.out.println(deleteButton.size());

//        //2.YOL
//        WebElement addButton2 = driver.findElement(By.xpath("//*[text()='Add Element']"));
//        int b;
//        for (b = 0; b < 100; b++) {
//            addButton2.click();
//        }
//        System.out.println(b);

        // 90 defa delete butonuna basınız
        for (int i = 0; i <90; i++) {
            driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();
        }
        // 90 defa basıldığını doğrulayınız
        //1.YOL
        List<WebElement> deleteButtonList = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        int kalanDeleteButton = deleteButton.size()-90;
        Assert.assertEquals(kalanDeleteButton,deleteButtonList.size());

//        //2.yol
//        List<WebElement> deleteButtonList2 =driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
//        int counter=0;
//        for(WebElement w:deleteButtonList2){
//            counter++;
//        }
//        System.out.println(counter);
//        if(counter==10){
//            System.out.println("Delete button 90 kere yazildi");
//        }else System.out.println("Delete button eksik yazildi");

        // Sayfayı kapatınız
        driver.close();
    }
}
