import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionClassTest {
    @Test
    public void holdAndRelease() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/slider");
        driver.manage().window().maximize();
        WebElement sliderPoint = driver.findElement(By.cssSelector("input.range-slider--primary"));
        Actions action = new Actions(driver);
        action.clickAndHold(sliderPoint).moveByOffset(0,256).release().perform();
        int actualValue = Integer.parseInt(sliderPoint.getAttribute("value"));
        Assert.assertEquals(actualValue, 50);
        driver.quit();
    }

}
