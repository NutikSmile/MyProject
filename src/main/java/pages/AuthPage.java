package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.SQLOutput;

public class AuthPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AuthPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, 5);
    }

    private By locatorTabRegistration = new By.ByXPath("//div[@id= 'authModal']//a[contains(text(),' Регистрация:')]");
    private By locatorButtonRegistration = new By.ByXPath("//div[@id= 'authModal']//button[text()='Зарегистрироваться']");
    private By locatorInputEmail = new By.ById("RegistrationForm_email");
    private By locatorInputPassword = new By.ById("RegistrationForm_password");
    private By locatorInputPasswordRepeat = new By.ById("RegistrationForm_cPassword");
    private By locatorCheckBoxTerms = new By.ByXPath("//div[input[@id ='RegistrationForm_personal_data']]");
    private By locatorTextRegistrationStatus = new By.ByXPath("//div[contains(@class, 'registration_status')]");

    /**
     * Нажимает на вкладку "Регистрация" в окне
     */
    public AuthPage clickTabRegistration(){
        driver.findElement(locatorTabRegistration).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorButtonRegistration));
        return this;
    }

    /**
     * Заполняет поле email указанным значением
     * @param email
     */
     public AuthPage setEmail(String email){
        driver.findElement(locatorInputEmail).sendKeys(email);
        return  this;
     }

    /**
     * Заполняет поле "Пароль" указанным значением
     * @param password
     */
    public AuthPage setPassword(String password){
        driver.findElement(locatorInputPassword).sendKeys(password);
        return this;
    }

    /**
     * Заполняет поле "Повторить пароль" указанным значением
     * @param passwordRepeat
     */
    public AuthPage setPasswordRepeat(String passwordRepeat){
        driver.findElement(locatorInputPasswordRepeat).sendKeys(passwordRepeat);
        return this;
    }

    /**
     * Нажимает на чекбокс-согласие с Пользовательским соглашением
     */
    public AuthPage clickCheckBoxTerms(){
        driver.findElement(locatorCheckBoxTerms).click();
        return this;
    }

    /**
     * Нажимает на кнопку "Зарегистрироваться"
     */
    public AuthPage clickButtonRegistration(){
        driver.findElement(locatorButtonRegistration).click();
        return this;
    }

    public AuthPage assertTextAboutEmailForConfirmationRegistration(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorTextRegistrationStatus));
        String status = driver.findElement(locatorTextRegistrationStatus).getText();
        Assert.assertEquals(status, "На адрес "+email+" отправлено сообщение с инструкцией по активации аккаунта. Письмо должно прийти в течение 3 минут. Если письмо не дошло - проверьте папку \"Спам\".");
        return this;
    }
}
