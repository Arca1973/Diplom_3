package com.stellarburgers.tests;

import com.stellarburgers.TestDataGenerator;
import com.stellarburgers.api.UserApiMethod;
import com.stellarburgers.base.BaseTest;
import com.stellarburgers.pages.BurgerConstructorPage;
import com.stellarburgers.pages.LoginPage;
import com.stellarburgers.pages.PersonalAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonalAccountNavigationTest extends BaseTest {
    private String name;
    private String email;
    private String password;
    private String accessToken;
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
        name = TestDataGenerator.generateRandomName();
        email = TestDataGenerator.generateRandomEmail();
        password = TestDataGenerator.generateRandomPassword();

        new UserApiMethod().createUser(email, password, name); // Создаем пользователя
        burgerConstructorPage.clickSingInButton(); //Переход на страницу авторизации
        loginPage.fillLoginForm(email,password);
        loginPage.waitForPageLoad(BURGER_CONSTRUCTOR_PAGE_URL); //ожидамем возврат на старницу конструкотора
            }

    @Test
    @DisplayName("Проверяем переход на страницу Личный кабинет с главной страницы после нажатия кнопки Личный кабинет")
    @Description("нажимаем кнопку Личный кабинет, проверяем что происходит переход на страницу Личный кабинет")

    public void ClickPersonalAccountTest() {
        burgerConstructorPage.clickAccountLink();
        burgerConstructorPage.waitForPageLoad(USER_ACCOUNT_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), USER_ACCOUNT_PAGE_URL); //проверяем переход на страницу "Личный кабинет"
    }

    @Test
    @DisplayName("Проверяем переход на страницу Конструктор из Личного кабинета после нажатия кнопки Конструктор")
    @Description("нажимаем кнопку Конструктор, проверяем что происходит переход на страницу Конструктор")
    public void ClickConstructorTest() {
        burgerConstructorPage.clickAccountLink();
        burgerConstructorPage.waitForPageLoad(USER_ACCOUNT_PAGE_URL);
        personalAccountPage.clickConstructorLink();
        personalAccountPage.waitForPageLoad(BURGER_CONSTRUCTOR_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), BURGER_CONSTRUCTOR_PAGE_URL); //проверяем переход на страницу "КОНСТРУКТОР"
    }

    @Test
    @DisplayName("Проверяем переход на страницу Конструктор из Личного кабинета  после нажатия логотипа Stellar Burgers")
    @Description("нажимаем логотип Stellar Burgers, проверяем что происходит переход на страницу Конструктор")
    public void ClickLogoTest() {
        burgerConstructorPage.clickAccountLink();
        burgerConstructorPage.waitForPageLoad(USER_ACCOUNT_PAGE_URL);
        personalAccountPage.clickStellarBurgersLogo();
        personalAccountPage.waitForPageLoad(BURGER_CONSTRUCTOR_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), BURGER_CONSTRUCTOR_PAGE_URL); //проверяем переход на страницу "КОНСТРУКТОР"
    }

    @Test
    @DisplayName("Проверяем переход на страницу Авторизации из Личного кабинета после нажатия кнопки Выйти")
    @Description("нажимаем кнопку Выйти, проверяем что происходит переход на страницу Авторизации")

    public void ClickExitTest() {
        burgerConstructorPage.clickAccountLink();
        burgerConstructorPage.waitForPageLoad(USER_ACCOUNT_PAGE_URL);
        personalAccountPage.clickExitButton();
        personalAccountPage.waitForPageLoad(LOGIN_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL); //проверяем переход на страницу "Личный кабинет"
    }
    @After
    public void afterEach() {
        new UserApiMethod().deleteUser(accessToken);
    }
}