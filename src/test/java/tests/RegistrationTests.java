package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BurgerConstructorPage;
import pages.RegestrationPage;
import pages.RestorePasswordPage;
import pages.UserAccountPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class RegistrationTests extends BaseTest {

    private String name;
    private String email;
    private String password;
    private String wrong_password;
    // Переменные для хранения экземпляров классов страниц
    private BurgerConstructorPage burgerConstructorPage;
    private UserAccountPage userAccountPage;
    private RestorePasswordPage restorePasswordPage;
    private RegestrationPage registrationPage;

    @Before
    public void setUp() {
        super.setUp();

        // Инициализация экземпляров классов страниц
        burgerConstructorPage = new BurgerConstructorPage(driver);
        userAccountPage = new UserAccountPage(driver);
        restorePasswordPage = new RestorePasswordPage(driver);
        registrationPage= new RegestrationPage(driver);

        // Генерация уникальных имени, электронной почты и пароля
        name = "ИВАН" + (int) (Math.random() * 1000000);
        email = name + "@yandex.ru";
        password = "1234" + (int) (Math.random() * 1000000);
        wrong_password ="12345";
    }
    @Test
    public void UnSuccessfulUserRegistrationWithWrongPasswordTest() {

        burgerConstructorPage.clickSingInButton();
        userAccountPage.clickRegistrationLink();
        registrationPage.inputNameField(name);
        registrationPage.inputEmailField(email);
        registrationPage.inputPasswordField(wrong_password);
        registrationPage.clickRegistrationButton();
        Assert.assertTrue("Неверный пароль", registrationPage.isWrongPasswordMessageDisplayed());

    }

    @Test
    public void SuccessfulUserRegistrationTest() {

        burgerConstructorPage.clickSingInButton();
        userAccountPage.clickRegistrationLink();
        registrationPage.inputNameField(name);
        registrationPage.inputEmailField(email);
        registrationPage.inputPasswordField(password);
        registrationPage.clickRegistrationButton();
        waitForPageLoad(USER_ACCOUNT_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), USER_ACCOUNT_PAGE_URL); //проверяем переход на страницу "Личный кабинет"

    }
}