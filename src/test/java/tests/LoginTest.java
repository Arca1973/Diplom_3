package tests;

import API.UserApiMethod;
import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.BurgerConstructorPage;
import pages.RegestrationPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    private String name;
    private String email;
    private String password;
    private String accessToken;
    // Переменные для хранения экземпляров классов страниц
    private BurgerConstructorPage burgerConstructorPage;
    private LoginPage loginPage;
    private ForgotPasswordPage forgotPasswordPage;
    private RegestrationPage registrationPage;

    @Before
    public void setUp() {
        super.setUp();
        // Инициализация экземпляров классов страниц
        burgerConstructorPage = new BurgerConstructorPage(driver);
        loginPage = new LoginPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        registrationPage= new RegestrationPage(driver);
        // Генерация уникальных имени, электронной почты и пароля
        name = "ИВАН" + (int) (Math.random() * 1000000);
        email = name + "@yandex.ru";
        password = "1234" + (int) (Math.random() * 1000000);

        accessToken = new UserApiMethod().createUser(email, password, name); //Создаем пользователя
    }

    @Test
    @DisplayName("Проверяем переход на страницу авторизации с главной страницы после нажатия кнопки Войти в аккаунт")
    @Description("Создаем нового клиента, нажимаем кнопку Войти в аккаунт, запоняем поля формы авторизации email и  password, нажимаем кнопку Войти, проверяем что после успешной авторизации происходит переход на страницу конструктора бургеров")
    public void MainPageLoginButtonTest() {
        burgerConstructorPage.clickSingInButton();
        loginPage.fillLoginForm(email,password);
        waitForPageLoad(BURGER_CONSTRUCTOR_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), BURGER_CONSTRUCTOR_PAGE_URL); //проверяем переход на страницу "Конструктор бургеров"
    }

    @Test
    @DisplayName("Проверяем переход на страницу авторизации с главной страницы после нажатия кнопки Личный Кабинет")
    @Description("Создаем нового клиента, нажимаем кнопку Личный Кабинет, запоняем поля формы авторизации email и  password, нажимаем кнопку Войти, проверяем что после успешной авторизации происходит переход на страницу конструктора бургеров")
    public void UserAccountLoginButtonTest() {
        burgerConstructorPage.clickAccountLink();
        loginPage.fillLoginForm(email,password);
        waitForPageLoad(BURGER_CONSTRUCTOR_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), BURGER_CONSTRUCTOR_PAGE_URL); //проверяем переход на страницу "Конструктор бургеров"
    }

    @Test
    @DisplayName("Проверяем переход на страницу авторизации с страницы регистрации после нажатия кнопки Войти")
    @Description("Создаем нового клиента, нажимаем кнопку Войти, запоняем поля формы авторизации email и  password, нажимаем кнопку Войти, проверяем что после успешной авторизации происходит переход на страницу конструктора бургеров")
    public void RegistrationFormLoginButtonTest() {
        registrationPage.clickEnterLink();
        loginPage.fillLoginForm(email,password);
        waitForPageLoad(BURGER_CONSTRUCTOR_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), BURGER_CONSTRUCTOR_PAGE_URL); //проверяем переход на страницу "Конструктор бургеров"
    }

    @Test
    @DisplayName("Проверяем переход на страницу авторизации с страницы восстановления пароля после нажатия кнопки Войти")
    @Description("Создаем нового клиента, нажимаем кнопку Войти, запоняем поля формы авторизации email и  password, нажимаем кнопку Войти, проверяем что после успешной авторизации происходит переход на страницу конструктора бургеров")
    public void  ForgotPasswordFormLoginButtonTest() {
        forgotPasswordPage.clickEnterLink();
        loginPage.fillLoginForm(email,password);
        waitForPageLoad(BURGER_CONSTRUCTOR_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), BURGER_CONSTRUCTOR_PAGE_URL); //проверяем переход на страницу "Конструктор бургеров"
    }

//  @After
//   public void tearDown() {
//        new UserApiMethod().deleteUser(accessToken);
 // }
}
