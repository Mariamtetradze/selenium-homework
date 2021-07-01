import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class JSexecutor {
    WebDriver driver;

   /* @BeforeMethod
    public void beforeTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    } */
    @Test
    public void hoverItem(){
        HtmlUnitDriver driver = new HtmlUnitDriver(true);
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html ");
        driver.manage().window().maximize();
        WebElement practiseMagicItem = driver.findElement(By.xpath("//div[@id=\"container\"]//ul//li[contains(text(), \" Practice magic\")]"));
        Actions action = new Actions(driver);
        action.moveToElement(practiseMagicItem).perform();
        WebElement deleteButton = driver.findElement(By.xpath("//div[@id=\"container\"]//ul//li[contains(text(), \" Practice magic\")]//span//i"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", deleteButton);
        driver.quit();
    }

    @Test
    public void scrollAndValidate(){
        HtmlUnitDriver driver = new HtmlUnitDriver(true);
        driver.get("http://webdriveruniversity.com/Scrolling/index.html ");
        driver.manage().window().maximize();
        JavascriptExecutor js= (JavascriptExecutor)driver;
        WebElement box = driver.findElement(By.id("zone2-entries"));
        js.executeScript("arguments[0].scrollIntoView();",box);
        String text = js.executeScript("return document.getElementById('zone2-entries').innerHTML").toString();
        System.out.println("Visible text is "+text );
        driver.quit();
}

}
