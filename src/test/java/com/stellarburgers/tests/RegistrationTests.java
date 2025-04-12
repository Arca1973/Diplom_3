package com.stellarburgers.tests;

import com.stellarburgers.TestDataGenerator;
import com.stellarburgers.api.UserApiMethod;
import com.stellarburgers.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.stellarburgers.pages.BurgerConstructorPage;
import com.stellarburgers.pages.RegistrationPage;
import com.stellarburgers.pages.LoginPage;


public class RegistrationTests extends BaseTest {
    private String name;
    private String email;
    private String password;
    private String wrong_password;
    // Переменные для хранения экземпляров классов страниц
    private BurgerConstructorPage burgerConstructorPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

    @Before
    public void setUp() {
        super.setUp();
        // Инициализация экземпляров классов страниц
        burgerConstructorPage = new BurgerConstructorPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage= new RegistrationPage(driver);
        // Генерация уникальных имени, электронной почты и пароля
        name = TestDataGenerator.generateRandomName();
        email = TestDataGenerator.generateRandomEmail();
        password = TestDataGenerator.generateRandomPassword();
        wrong_password ="12345";
    }
    @Test
    @DisplayName("Проверяем возможность регистрации нового пользователя с паролем короче 6 символов")
    @Description("Нажимаем кнопку Войти в аккаунт, Нажимаем кнопку Регистрация, заполняем поля формы регистраци name и email - валидными значениями, password - 12345, нажимаем кнопку Регистрация, проверяем что появляется сообщение Неверный пароль")
    public void UnSuccessfulUserRegistrationWithWrongPasswordTest() {
        burgerConstructorPage.clickSingInButton();
        loginPage.clickRegistrationLink();
        registrationPage.inputNameField(name);
        registrationPage.inputEmailField(email);
        registrationPage.inputPasswordField(wrong_password);
        registrationPage.clickRegistrationButton();
        Assert.assertTrue("Неверный пароль", registrationPage.isWrongPasswordMessageDisplayed());
    }

    @Test
    @DisplayName("Проверяем возможность регистрации нового пользователя при вводе валидных данных")
    @Description("Нажимаем кнопку Войти в аккаунт, Нажимаем кнопку Регистрация, заполняем поля формы регистраци name, email и password - валидными значениями,  нажимаем кнопку Регистрация, проверяем что после успешной регистрации происходит переход на страницу конструктора бургеров")

    public void SuccessfulUserRegistrationTest() {
        burgerConstructorPage.clickSingInButton();
        loginPage.clickRegistrationLink();
        registrationPage.inputNameField(name);
        registrationPage.inputEmailField(email);
        registrationPage.inputPasswordField(password);
        registrationPage.clickRegistrationButton();
        registrationPage.waitForPageLoad(LOGIN_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL); //проверяем переход на страницу авторизации

    }
    @After
    public void afterEach() {
        new UserApiMethod().killUser(email, password, name);
    }

}