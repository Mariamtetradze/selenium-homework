import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AutoComplete {
    WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void autoCompleteSuggestions() throws InterruptedException  {
        driver.get(" https://www.google.com/");
        driver.manage().window().maximize();
        WebElement searchBar = driver.findElement(By.className("gLFyf"));
        searchBar.sendKeys("Automation");
        Thread.sleep(2000);
        List<WebElement> elementList = driver.findElements(By.xpath("//ul//li[@class=\"sbct\"]"));
        System.out.print(elementList.size());
        WebElement lastElement = elementList.get(elementList.size() - 1);
        lastElement.click();
    }
    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
}
