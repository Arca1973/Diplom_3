package tests;

import API.UserApiMethod;
import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;

public class PersonalAccountNavigationTest extends BaseTest {

    private String name;
    private String email;
    private String password;

    // Переменные для хранения экземпляров классов страниц
    private BurgerConstructorPage burgerConstructorPage;
    private LoginPage loginPage;
    private RestorePasswordPage restorePasswordPage;
    private RegestrationPage registrationPage;
    private PersonalAccountPage personalAccountPage;

    @Before
    public void setUp() {
        super.setUp();

        // Инициализация экземпляров классов страниц
        burgerConstructorPage = new BurgerConstructorPage(driver);
        loginPage = new LoginPage(driver);
        restorePasswordPage = new RestorePasswordPage(driver);
        registrationPage= new RegestrationPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);

                // Генерация уникальных имени, электронной почты и пароля
        name = "ИВАН" + (int) (Math.random() * 1000000);
        email = name + "@yandex.ru";
        password = "1234" + (int) (Math.random() * 1000000);


        new UserApiMethod().createUser(email, password, name); // Создаем пользователя
        burgerConstructorPage.clickSingInButton(); //Переход на страницу авторизации
        loginPage.inputEmailField(email);//вводим email для авторизации
        loginPage.inputPasswordField(password);//вводим пароль для авторизации
        loginPage.clickEnterButton();//нажимаем Войти для авторизации
        waitForPageLoad(BIURGER_CONSTRUCTOR_PAGE_URL); //ожидамем возврат на старницу конструкотора
            }

    @Test
    public void ClickPersonalAccountTest() {
        burgerConstructorPage.clickAccountLink();
        waitForPageLoad(USER_ACCOUNT_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), USER_ACCOUNT_PAGE_URL); //проверяем переход на страницу "Личный кабинет"
    }

    @Test
    public void ClickConstructorTest() {
        burgerConstructorPage.clickAccountLink();
        waitForPageLoad(USER_ACCOUNT_PAGE_URL);
        personalAccountPage.clickConstructorLink();
        waitForPageLoad(BIURGER_CONSTRUCTOR_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), BIURGER_CONSTRUCTOR_PAGE_URL); //проверяем переход на страницу "КОНСТРУКТОР"
    }

    @Test
    public void ClickLogoTest() {
        burgerConstructorPage.clickAccountLink();
        waitForPageLoad(USER_ACCOUNT_PAGE_URL);
        personalAccountPage.clickStellarBurgersLogo();
        waitForPageLoad(BIURGER_CONSTRUCTOR_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), BIURGER_CONSTRUCTOR_PAGE_URL); //проверяем переход на страницу "КОНСТРУКТОР"
    }

    @Test
    public void ClickExitTest() {
        burgerConstructorPage.clickAccountLink();
        waitForPageLoad(USER_ACCOUNT_PAGE_URL);
        personalAccountPage.clickExitButton();
        waitForPageLoad(LOGIN_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL); //проверяем переход на страницу "Личный кабинет"
    }
}