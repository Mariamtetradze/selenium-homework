import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Set;

public class CookieTest {
    WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void cookiesTest() {
        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("test123");
        driver.findElement(By.name("password")).sendKeys("test1234");
        driver.findElement(By.name("submit")).click();
        Set<Cookie> cookies = driver.manage().getCookies();
        for(Cookie cookie:cookies) {
            System.out.println(cookie.getName() +" " +cookie.getValue() + " " +cookie.getExpiry());
             driver.manage().deleteCookieNamed("Selenium");
        }

}
    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
}
