package BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    public String URL = "https://www.amazon.eg/";
    public static WebDriver driver;

    @BeforeSuite
    public void OpenBrowser() {
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }
    @AfterSuite
    public void CloseBrowser(){
        driver.quit();
    }
}
