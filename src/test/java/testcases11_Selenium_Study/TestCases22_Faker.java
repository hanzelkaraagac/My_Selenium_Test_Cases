package testcases11_Selenium_Study;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCases22_Faker extends TestBase {
    //Faker Kutuphanesi HOMEWORK
    //Faker class’i testlerimizi yaparken ihtiyac duydugumuz isim, soyisim, adres vb bilgiler icin fake
    //degerler uretmemize imkan tanir.
    //Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.
    //"https://facebook.com"  Adresine gidin
    //“create new account”  butonuna basin
    //“firstName” giris kutusuna bir isim yazin
    //“surname” giris kutusuna bir soyisim yazin
    //“email” giris kutusuna bir email yazin
    //“email” onay kutusuna emaili tekrar yazin
    //Bir sifre girin
    //Tarih icin gun secin
    //Tarih icin ay secin
    //Tarih icin yil secin
    //Cinsiyeti secin
    //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    //Sayfayi kapatin

    @Test
    public void fakerHomework() {
        //Faker class’i testlerimizi yaparken ihtiyac duydugumuz isim, soyisim, adres vb bilgiler icin fake
        //degerler uretmemize imkan tanir.
        //Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.
        Faker faker = new Faker();
        String name=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email=faker.internet().emailAddress();
        String password=faker.internet().password();
        int day=faker.number().numberBetween(1,31);
        String day_= String.valueOf(day);

        int month=faker.number().numberBetween(1,12);

        int year=faker.number().numberBetween(1905,2023);
        String year_= String.valueOf(year);

        int randomIndex= faker.number().numberBetween(1,3);

        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        //“create new account”  butonuna basin
        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();
        //“firstName” giris kutusuna bir isim yazin
        driver.findElement(By.name("firstname")).sendKeys(name);
        //setValueByJS(driver.findElement(By.name("firstname")),name);
        //“surname” giris kutusuna bir soyisim yazin
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        //“email” giris kutusuna bir email yazin
        driver.findElement(By.name("reg_email__")).sendKeys(email);
        //“email” onay kutusuna emaili tekrar yazin
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(email);
        //Bir sifre girin
        driver.findElement(By.name("reg_passwd__")).sendKeys(password);

        //Tarih icin gun secin
        driver.findElement(By.name("birthday_day")).sendKeys(day_);
        //Tarih icin ay secin
        // driver.findElement(By.name("birthday_month")).sendKeys(month_);
        WebElement moonth=driver.findElement(By.name("birthday_month"));
        Select slc= new Select(moonth);
        slc.selectByIndex(month);

        //Tarih icin yil secin
        driver.findElement(By.name("birthday_year")).sendKeys(year_);


        //Cinsiyeti secin

//        WebElement myGender=driver.findElement(By.xpath("(//*[@class='_8esa']"+")["+randomIndex+"]"));
//        myGender.click();
//        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
//        Assert.assertTrue(myGender.isSelected());
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertTrue(driver.findElement(By.xpath("(//*[@class='_8esa'])[1]")).isSelected(),"kadin secilmis");
//        softAssert.assertTrue(driver.findElement(By.xpath("(//*[@class='_8esa'])[2]")).isSelected(),"erkek secilmis");
//        softAssert.assertTrue(driver.findElement(By.xpath("(//*[@class='_8esa'])[3]")).isSelected(),"ozel secilmis");
//        softAssert.assertAll();

        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //Cinsiyeti secin
        WebElement man =driver.findElement(By.xpath("//input[@value='2']"));
        man.click();
        WebElement woman =driver.findElement(By.xpath("//input[@value='1']"));
        WebElement other =driver.findElement(By.xpath("//input[@value='-1']"));

        assertTrue(man.isSelected());
        assertFalse(woman.isSelected());
        assertFalse(other.isSelected());
        //Sayfayi kapatin
        //driver.close();
    }
}