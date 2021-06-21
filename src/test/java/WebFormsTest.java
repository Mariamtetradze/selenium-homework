import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class WebFormsTest {
    @Test
    public void radioButton(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html ");
        driver.manage().window().maximize();
        Select language = new Select(driver.findElement(By.id("dropdowm-menu-1")));
        language.selectByIndex(2);
        WebElement selectedValue = driver.findElement(By.xpath("//option[@value =\"python\"]"));
        Assert.assertTrue(selectedValue.isSelected());
        List<WebElement> AllCheckboxes =  driver.findElements(By.xpath("//input[@type='checkbox']"));
        int size = AllCheckboxes.size();
        for(int i = 0; i<size; i++) {
            if(!AllCheckboxes.get(i).isSelected()) {
                AllCheckboxes.get(i).click();
            }
        }
        WebElement yellowRadio = driver.findElement(By.xpath("//form/input[3]"));
        yellowRadio.click();
        WebElement fruitOptions = driver.findElement(By.id("fruit-selects"));
        fruitOptions.click();
        WebElement disabledElement = driver.findElement(By.xpath("//option[@value=\"orange\"]"));
        Assert.assertFalse(disabledElement.isEnabled());
        driver.quit();
    }
}
