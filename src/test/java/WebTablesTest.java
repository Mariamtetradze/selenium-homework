import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTest {
    WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void printPrice() {
        driver.get("http://techcanvass.com/Examples/webtable.html");
        driver.manage().window().maximize();
        WebElement lastTd = driver.findElement(By.xpath("//table/tbody/tr[4]/td[3]"));
        String hondaPrice = lastTd.getText();
        System.out.print(hondaPrice);
    }
    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
}
