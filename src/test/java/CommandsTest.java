import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

import static java.lang.Thread.sleep;

public class CommandsTest {
    @Test
    public void checkInputField() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        submitButton.click();
        Thread.sleep(3000);
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        inputField.click();
        System.out.println("Is enabled " + inputField.isEnabled());
        WebElement textMessage = driver.findElement(By.id("message"));
        System.out.println("Is displayed " +textMessage.isDisplayed());
        String disableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).getText();
        System.out.println("Equals " + disableButton.equals("Disable"));
        inputField.sendKeys("Bootcamp");
        inputField.clear();
        driver.quit();


    }
    @Test
    public void getCoordinate() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        int boxA = driver.findElement(By.id("column-a")).getLocation().getY();
        int boxB = driver.findElement(By.id("column-b")).getLocation().getY();
        System.out.print(Integer.toString(boxA).equals(Integer.toString(boxB)));
    }
}
