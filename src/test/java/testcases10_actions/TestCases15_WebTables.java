package testcases10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;


//https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
//Demo Table altındaki tablodaki otel bilgilerini yazdırınız
//Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
//Bütün Height bilgilerini yazdırınız
//Otel uzunluklarının hepsini toplayınız
//Bir method ile satır ve sutun bilgilerini çağıralım

public class TestCases15_WebTables extends TestBase {

    @Test
    public void name() {
        //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        //Demo Table altındaki tablodaki otel bilgilerini yazdırınız
        List<WebElement> otelBilgileri = driver.findElements(By.xpath("//*[@class='tsc_table_s13']//tbody//tr"));
        otelBilgileri.forEach(t-> System.out.println(t.getText()));
        //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
        int row = 1;
        for (WebElement w:otelBilgileri) {
            if(w.getText().contains("601m")){
                System.out.println("Tablodaki "+row+" .satırdaki otel bilgileri : "+w.getText());
            }
            row++;
        }
        //Bütün Height bilgilerini yazdırınız
        List<WebElement> heightBilgileri = driver.findElements(By.xpath("//*[@class='tsc_table_s13']//tbody//tr//td[3]"));
        heightBilgileri.forEach(t-> System.out.println(t.getText()));
        //Otel uzunluklarının hepsini toplayınız
        List<String> list = new ArrayList<>();
        for (WebElement q:heightBilgileri) {
            list.add(q.getText());
        }
        for (int i = 0; i < list.size(); i++) {
            list.set(i,list.get(i).replace("m",""));
        }
        list.forEach(System.out::println);
        int toplam = 0;
        for (String s:list) {
            toplam+=Integer.parseInt(s);
        }
        System.out.println("Otellerin toplam uzunluğu = "+toplam);
        //Bir method ile satır ve sutun bilgilerini çağıralım
        tabloSatirSutun(3,4);
    }
    private void tabloSatirSutun(int satir, int sutun) {
        System.out.println(satir + " . satir " + sutun + " . sutun bilgisi : " +
                driver.findElement(By.xpath("//*[@class='tsc_table_s13']//tbody//tr[" + satir + "]//td[" + sutun + "]")).getText());

    }
}