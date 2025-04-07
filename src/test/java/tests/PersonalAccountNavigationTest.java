package tests;

import API.UserApiMethod;
import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
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
    private PersonalAccountPage personalAccountPage;

    @Before
    public void setUp() {
        super.setUp();
        // Инициализация экземпляров классов страниц
        burgerConstructorPage = new BurgerConstructorPage(driver);
        loginPage = new LoginPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
        // Генерация уникальных имени, электронной почты и пароля
        name = "ИВАН" + (int) (Math.random() * 1000000);
        email = name + "@yandex.ru";
        password = "1234" + (int) (Math.random() * 1000000);

        new UserApiMethod().createUser(email, password, name); // Создаем пользователя
        burgerConstructorPage.clickSingInButton(); //Переход на страницу авторизации
        loginPage.fillLoginForm(email,password);
        waitForPageLoad(BIURGER_CONSTRUCTOR_PAGE_URL); //ожидамем возврат на старницу конструкотора
            }

    @Test
    @DisplayName("Проверяем переход на страницу Личный кабинет с главной страницы после нажатия кнопки Личный кабинет")
    @Description("нажимаем кнопку Личный кабинет, проверяем что происходит переход на страницу Личный кабинет")

    public void ClickPersonalAccountTest() {
        burgerConstructorPage.clickAccountLink();
        waitForPageLoad(USER_ACCOUNT_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), USER_ACCOUNT_PAGE_URL); //проверяем переход на страницу "Личный кабинет"
    }

    @Test
    @DisplayName("Проверяем переход на страницу Конструктор из Личного кабинета после нажатия кнопки Конструктор")
    @Description("нажимаем кнопку Конструктор, проверяем что происходит переход на страницу Конструктор")
    public void ClickConstructorTest() {
        burgerConstructorPage.clickAccountLink();
        waitForPageLoad(USER_ACCOUNT_PAGE_URL);
        personalAccountPage.clickConstructorLink();
        waitForPageLoad(BIURGER_CONSTRUCTOR_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), BIURGER_CONSTRUCTOR_PAGE_URL); //проверяем переход на страницу "КОНСТРУКТОР"
    }

    @Test
    @DisplayName("Проверяем переход на страницу Конструктор из Личного кабинета  после нажатия логотипа Stellar Burgers")
    @Description("нажимаем логотип Stellar Burgers, проверяем что происходит переход на страницу Конструктор")
    public void ClickLogoTest() {
        burgerConstructorPage.clickAccountLink();
        waitForPageLoad(USER_ACCOUNT_PAGE_URL);
        personalAccountPage.clickStellarBurgersLogo();
        waitForPageLoad(BIURGER_CONSTRUCTOR_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), BIURGER_CONSTRUCTOR_PAGE_URL); //проверяем переход на страницу "КОНСТРУКТОР"
    }

    @Test
    @DisplayName("Проверяем переход на страницу Авторизации из Личного кабинета после нажатия кнопки Выйти")
    @Description("нажимаем кнопку Выйти, проверяем что происходит переход на страницу Авторизации")

    public void ClickExitTest() {
        burgerConstructorPage.clickAccountLink();
        waitForPageLoad(USER_ACCOUNT_PAGE_URL);
        personalAccountPage.clickExitButton();
        waitForPageLoad(LOGIN_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL); //проверяем переход на страницу "Личный кабинет"
    }
}