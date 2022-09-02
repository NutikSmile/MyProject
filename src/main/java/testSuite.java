import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.AuthPage;
import pages.CitiesPage;
import pages.HomePage;

import java.util.Random;

public class testSuite extends webDriverSettings{

    @Test
    public void testRegistrationSuccess(){
        Random random = new Random();
        int n = random.nextInt(1000);
        String email = "anich"+n+"@yandex.ru";
        String password = n+"Anich";

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.clickButtonSignIn();

        AuthPage authPage = PageFactory.initElements(driver, AuthPage.class);
        authPage.clickTabRegistration()
                .setEmail(email)
                .setPassword(password)
                .setPasswordRepeat(password)
                .clickCheckBoxTerms()
                .clickButtonRegistration()
                .assertTextAboutEmailForConfirmationRegistration(email);
    }

    @Test
    public void testChangeTown(){

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.clickLinkActiveCity();

        CitiesPage citiesPage = PageFactory.initElements(driver, CitiesPage.class);
        citiesPage.clickLinkCityInList("Казань");
        homePage.assertCityInHeader("Казань");
        homePage.assertCurrentUrl("https://kzn.kassir.ru/");
    }
}
