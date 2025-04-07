package tests;

import API.UserApiMethod;
import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.BurgerConstructorPage;
import pages.RegestrationPage;
import pages.RestorePasswordPage;
import pages.LoginPage;


public class LoginTest extends BaseTest {

    private String name;
    private String email;
    private String password;

    // Переменные для хранения экземпляров классов страниц
    private BurgerConstructorPage burgerConstructorPage;
    private LoginPage loginPage;
    private RestorePasswordPage restorePasswordPage;
    private RegestrationPage registrationPage;

    @Before
    public void setUp() {
        super.setUp();

        // Инициализация экземпляров классов страниц
        burgerConstructorPage = new BurgerConstructorPage(driver);
        loginPage = new LoginPage(driver);
        restorePasswordPage = new RestorePasswordPage(driver);
        registrationPage= new RegestrationPage(driver);

        // Генерация уникальных имени, электронной почты и пароля
        name = "ИВАН" + (int) (Math.random() * 1000000);
        email = name + "@yandex.ru";
        password = "1234" + (int) (Math.random() * 1000000);


        new UserApiMethod().createUser(email, password, name);

    }

    @Test
    public void Test() {
        burgerConstructorPage.clickSingInButton();
        loginPage.inputEmailField(email);
        loginPage.inputPasswordField(password);
        loginPage.clickEnterButton();
        waitForPageLoad(BIURGER_CONSTRUCTOR_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), BIURGER_CONSTRUCTOR_PAGE_URL); //проверяем переход на страницу "Личный кабинет"

    }
}