package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CitiesPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, 5);
    }

    /**
     * Нажимает на название города  в списке
     * @param city
     */
    public void clickLinkCityInList(String city){
        By locatorLinkCityInList = new By.ByXPath("//div[@id='cityModal']//li/a[contains(text(), '"+city+"')]");
        driver.findElement(locatorLinkCityInList).click();
    }
}
