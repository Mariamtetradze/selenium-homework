import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest {
    WebDriver driver;
   /* @BeforeMethod
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    } */
    @Test
    public void fileUpload() {
        HtmlUnitDriver driver = new HtmlUnitDriver(true);
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        File file = new File("src/Images/illimg.jpeg");
        WebElement uploadFileButton = driver.findElement(By.id("file-upload"));
        uploadFileButton.sendKeys(file.getAbsolutePath());
        WebElement submitButton = driver.findElement(By.id("file-submit"));
        submitButton.click();
        try {
            uploadFileButton.sendKeys(file.getAbsolutePath());
        } catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException ");
        }
        driver.quit();
    }


}
