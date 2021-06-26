import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class Exceptions {
    WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void datePicker() {
        driver.get("https://jqueryui.com/datepicker/ ");
        driver.manage().window().maximize();
        WebElement frame = driver.findElement(By.xpath("//div[@id=\"content\"]/iframe"));
        new WebDriverWait(driver,3).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        try {
            driver.switchTo().frame(frame);
        } catch (WebDriverException e) {
            System.out.print("exceptional");
        }
        WebElement dateButton = driver.findElement(By.id("datepicker"));
        dateButton.click();
        WebElement prevButton = driver.findElement(By.className("ui-datepicker-prev"));
        prevButton.click();
        List<WebElement> dates = driver.findElements(By.xpath("//div[@id=\"ui-datepicker-div\"]/table//td"));
        int total = dates.size();
        for(int i =0; i < total; i++) {
            String date=dates.get(i).getText();
            if(date.equals("31")) {
                dates.get(i).click();
                break;
            }
        }

    }
    @Test
    public void alertException() {
        driver.get(" https://demoqa.com/alerts ");
        driver.manage().window().maximize();
        WebElement clickButton = driver.findElement(By.id("timerAlertButton"));
        clickButton.click();
        new WebDriverWait(driver,10).until(ExpectedConditions.alertIsPresent());
            try {
                driver.switchTo().alert().accept();
            } catch (NoAlertPresentException e) {
                System.out.println("exceptional case");
            }
        catch (NoSuchSessionException e) {
        System.out.println("couldn't locate");
    }
    }
    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
    }



