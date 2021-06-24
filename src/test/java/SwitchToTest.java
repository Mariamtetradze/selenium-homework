import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class SwitchToTest {
    WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void switchTo() {
        driver.get(" http://the-internet.herokuapp.com/iframe ");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        WebElement textField = driver.findElement(By.id("tinymce"));
        textField.clear();
        textField.sendKeys("Here Goes");
        driver.switchTo().parentFrame();
        WebElement alignCenterButton = driver.findElement(By.xpath("//button[@title='Align center']"));
        alignCenterButton.click();
    }

    @Test
    public void acceptAlert(){
        driver.get(" https://demoqa.com/alerts");
        driver.manage().window().maximize();
        WebElement clickMeButton = driver.findElement(By.id("alertButton"));
        clickMeButton.click();
        driver.switchTo().alert().accept();
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }

}