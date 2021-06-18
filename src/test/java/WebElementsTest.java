import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebElementsTest {
    @Test
    public void firstTask() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();
        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
        for(int i=0; i < 3; i++) {
        addButton.click();
        }
        System.out.println(driver.findElements(By.cssSelector("div#elements>:last-child")));
        driver.quit();
       // WebElement relative = driver.findElement(By.xpath("//button[ends-with(@class, \"manually\")] and //button[text()='Delete']"));

}
    @Test
    public void secondTask() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        driver.manage().window().maximize();
        WebElement ipsumValue = driver.findElement(By.xpath("//table/tbody/tr/td[text()='Apeirian9']//preceding-sibling::td"));
        WebElement ipsumFollowing = driver.findElement(By.xpath("//table/tbody/tr/td[text()='Apeirian9']//following-sibling::td"));
        System.out.println(ipsumValue);
        System.out.println(ipsumFollowing);
        driver.quit();
    }


    }