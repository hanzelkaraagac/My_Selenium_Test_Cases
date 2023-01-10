package testcases09_cookie;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

/*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */

public class TestCases01_Cookie extends TestBase {
    @Test
    public void cookiesTest() {
        //Techproeducation adresine gidiniz
        driver.get("https://techproeducation.com");

        waitFor(5);

        //Sayfadaki cookie lerin sayısını yazdırınız
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Cookilerin Sayisi : " + cookies.size());

        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        for (Cookie w : cookies) {
            System.out.println(w.getName()+" : " + w.getValue());
        }

//        //lambda ile
//        cookies.stream().forEach(t-> System.out.println(t.getName()+" "+ t.getValue()));

        //Yeni bir cookie ekleyiniz
        Cookie myCookie = new Cookie("myCookie","123456789");
        driver.manage().addCookie(myCookie);

        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        Set<Cookie> cookies2 = driver.manage().getCookies();
        System.out.println("Cookilerin Sayisi : " + cookies2.size());
        for (Cookie c:cookies2) {
            System.out.println(c.getName() + " : " + c.getValue());
        }

        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookie(myCookie);

        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();
        Set<Cookie> cookies3 = driver.manage().getCookies();
        System.out.println(cookies3.size());
    }
}
