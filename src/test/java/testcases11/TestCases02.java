package testcases11;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCases02 {
    public static void main (String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com ");
        //    2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //    3. Login alanine  “username” yazdirin
        driver.findElement(By.xpath("//input[@name='user_login']")).sendKeys("username");
        //    4. Password alanine “password” yazdirin
        driver.findElement(By.cssSelector("#user_password")).sendKeys("password");
        //    5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        driver.navigate().back();
        //    6. Online Banking menusunden Pay Bills sayfasina gidin

        driver.findElement(By.cssSelector("#online-banking")).click();

        driver.findElement(By.cssSelector("#pay_bills_link")).click();
        //    7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.cssSelector("#sp_amount")).sendKeys("10000");
        //    8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.cssSelector("#sp_date")).sendKeys("2020-09-10");
        //    9. Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("#pay_saved_payees")).click();
        //    10. “The payment was successfully submitted.” mesajinin ciktigini kontrol edin
        String successText = driver.findElement(By.cssSelector("#alert_content")).getText();

        if (successText.equals("The payment was successfully submitted.")) {
            System.out.println("Test PASS");
        } else {
            System.out.println("Test FAIL");
        }

    }
}