package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, 5);
    }

    private By locatorButtonSignIn = new By.ByXPath("//div[@class= 'top']//a[text()='Войти']");
    private By locatorLinkActiveCity = new By.ByXPath("//div[@class='top']//a[contains(@class, 'city-name active')]");

    public void open(){
        driver.get("https://msk.kassir.ru");
    }

    /**
     * Наживает на кнопку "Войти" в шапке
     */
    public void clickButtonSignIn(){
        driver.findElement(locatorButtonSignIn).click();
    }

    /**
     * Нажимает на ссылку с выбранным городом в шапке
     */
    public void clickLinkActiveCity(){
        driver.findElement(locatorLinkActiveCity).click();
    }

    /**
     * Проверяет, что выбранный город, отображаемый в шапке, равен указанному значению
     * @param city
     */
    public void assertCityInHeader(String city){
    String actualCity = driver.findElement(locatorLinkActiveCity).getText();
        Assert.assertEquals(actualCity, city);
    }

    /**
     * Проверяет, что текущий url совпадает с ожидаемым
     * @param url
     */
    public void assertCurrentUrl(String url){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, url);
    }
}
