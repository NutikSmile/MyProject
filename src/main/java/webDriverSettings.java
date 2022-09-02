import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class webDriverSettings {
    public ChromeDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void start(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
    }

    @AfterTest
    public void end(){
        driver.close();
    }
}
