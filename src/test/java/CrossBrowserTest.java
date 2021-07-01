import com.gargoylesoftware.htmlunit.BrowserVersion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Parameters;

public class CrossBrowserTest {
    WebDriver driver;
    @Parameters("browser")
    public void setup(String browser) throws Exception {

        if(browser.equalsIgnoreCase("chrome")){
            driver = new HtmlUnitDriver(BrowserVersion.CHROME);
        }

        else if(browser.equalsIgnoreCase("Edge")){
            WebDriverManager.edgedriver().setup();
            driver = new HtmlUnitDriver(BrowserVersion.EDGE);
        }
        else{
            throw new Exception("Incorrect browser");
       }

    }
}
