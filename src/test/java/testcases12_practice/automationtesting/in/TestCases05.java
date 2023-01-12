package testcases12_practice.automationtesting.in;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCases05 extends TestBase {
    @Test
    public void test01() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("https://practice.automationtesting.in/");
        //3) Click on Shop Menu
        driver.findElement(By.linkText("Shop")).click();
        driver.navigate().refresh();
        driver.findElement(By.linkText("Shop")).click();
        //4) Now click on Home menu button
        driver.findElement(By.linkText("Home")).click();
        //5) Test whether the Home page has Three Arrivals only
        driver.findElement(By.xpath("//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']")).isDisplayed();
        //6) The Home page must contains only three Arrivals
        WebElement threeArrivals = driver.findElement(By.xpath("//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']"));
        Assert.assertTrue(threeArrivals.isDisplayed());

        //7) Now click the image in the Arrivals
        driver.findElement(By.xpath("(//*[@class='woocommerce-LoopProduct-link'])[3]")).click();

        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']")).click();
        waitFor(3);
        driver.findElement(By.xpath("//*[@class='button wc-forward']")).click();
        String yeniSayfaUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://practice.automationtesting.in/basket/", yeniSayfaUrl);

        //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
        driver.navigate().back();
        waitFor(1);
        driver.navigate().back();
        waitFor(1);
        driver.navigate().back();
        driver.findElement(By.xpath("(//*[@class='woocommerce-LoopProduct-link'])[3]")).click();

        driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']")).click();
        waitFor(3);
        driver.findElement(By.xpath("//*[@class='button wc-forward']")).click();

        //10) Now clock on Reviews tab for the book you clicked on.
        driver.navigate().back();
        waitFor(1);
        driver.findElement(By.xpath("//*[@class='reviews_tab']")).click();

        //11) There should be a Reviews regarding that book the user clicked on
    }
}