
package testcases01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Case01 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","/Users/macbookair/Documents/selenium libraries/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

        // Verify that home page is visible successfully
        WebElement urlGorunumu = driver.findElement(By.xpath("(//*[@href=\"/\"])[1]"));
        if (urlGorunumu.isDisplayed()) {
            System.out.println("Text PASSED");
        }else System.out.println("Text FAILED");

        // Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@ class='fa fa-lock']")).click();

        // Verify 'New User Signup!' is visible
        WebElement newUSGorunumu = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        if (newUSGorunumu.isDisplayed()){
            System.out.println("Text PASSED");
        }else System.out.println("Text FAILED");


        // Enter name and email address
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("hanzel");
        Thread.sleep(1500);
        WebElement email= driver.findElement(By.xpath("(//*[@type='email'])[2]"));
        email.sendKeys("emaiil19401@gmail.com");
        Thread.sleep(1500);

        // Click 'Signup' button
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();

        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAI = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        if(enterAI.isDisplayed()){
            System.out.println("Text PASSED");
        }else System.out.println("Text FAILED");

        // Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("ASD123b");
        WebElement gun = driver.findElement(By.xpath("//*[@id='days']"));
        gun.findElement(By.xpath("//*[@value= '14']")).click();

        Thread.sleep(3000);

        WebElement ay = driver.findElement(By.xpath("//*[@id='months']"));
        ay.findElement(By.xpath("//*[text()='September']")).click();
        Thread.sleep(3000);

        WebElement yil = driver.findElement(By.xpath("//*[@id='years']"));
        yil.findElement(By.xpath("//*[text()='1996']")).click();


        // Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@name='newsletter']")).click();

        //Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id='optin']")).click();

        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("Cubuk");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("Kraker");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("Free");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("Turkiye Cumhuriye Adana ile Seyhan ilcesi");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("Evin ustu mahallesi evin ustu sokak no:ev/2");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='country']"));
        driver.findElement(By.xpath("//*[text()='New Zealand']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("Osmanlı beylerbeyligi");
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Istanbul");
        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("01180");
        driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys("+909451649467");

        Thread.sleep(1500);

        //Click 'Create Account button'
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();

        // Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountC = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        if (accountC.isDisplayed()) {
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");

        //Click 'Continue' button
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

//====> //Cikan reklama close dedik ==> calismayabilir !!!!!!!1
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='dismiss-button']")).click();

        //Verify that 'Logged in as username' is visible
        WebElement usernameKontrol = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        if (usernameKontrol.isDisplayed()) {
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");

        //Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();

        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDelete = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        if (accountDelete.isDisplayed()) {
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");

        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        driver.close();

       // newUSGorunumu.sendKeys("asdadasdsa", Keys.ENTER);






    }
}

