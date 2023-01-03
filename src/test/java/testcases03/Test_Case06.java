package testcases03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;

public class Test_Case06 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        //    accept Alert(I am an alert box!) and print alert on console
        WebElement alert = driver.findElement(By.xpath("//*[@onclick='alertbox()']"));
        alert.click();
        System.out.println(driver.switchTo().alert().getText());//alert uzerindeki yaziyi konsola alabiliriz
        driver.switchTo().alert().accept(); //cikan alert'i kabul ettik

        //    click "Alert with OK & Cancel" and click 'click the button to display a Confirm box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();

        //    cancel Alert  (Press a Button !)
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();

        //    and then sendKeys 'Hanzel ile baglan hayata' (Please enter your name)
        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("Hanzel");
        Thread.sleep(2000);

        driver.switchTo().alert().accept();

        //    finally print on console this message "Hello Hanzel How are you today"
        System.out.println(driver.findElement(By.xpath("//*[@id='demo1']")).getText());

        //    aseertion these message
        Assert.assertNotEquals("Hello HanzeL How are you today",driver.findElement(By.xpath("//*[@id='demo1']")).getText());

    }


}
