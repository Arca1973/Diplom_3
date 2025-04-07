package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.BurgerConstructorPage;
import pages.RegestrationPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;


public class RegistrationTests extends BaseTest {
    private String name;
    private String email;
    private String password;
    private String wrong_password;
    // Переменные для хранения экземпляров классов страниц
    private BurgerConstructorPage burgerConstructorPage;
    private LoginPage loginPage;
    private ForgotPasswordPage restorePasswordPage;
    private RegestrationPage registrationPage;

    @Before
    public void setUp() {
        super.setUp();
        // Инициализация экземпляров классов страниц
        burgerConstructorPage = new BurgerConstructorPage(driver);
        loginPage = new LoginPage(driver);
        restorePasswordPage = new ForgotPasswordPage(driver);
        registrationPage= new RegestrationPage(driver);
        // Генерация уникальных имени, электронной почты и пароля
        name = "ИВАН" + (int) (Math.random() * 1000000);
        email = name + "@yandex.ru";
        password = "1234" + (int) (Math.random() * 1000000);
        wrong_password ="12345";
    }
    @Test
    @DisplayName("Проверяем возможность регистрации нового пользователя с паролем короче 6 символов")
    @Description("Нажимаем кнопку Войти в аккаунт, Нажимаем кнопку Регистрация, запоняем поля формы регистраци name и email - валидными значениями, password - 12345, нажимаем кнопку Регистрация, проверяем что появляется сообщение Неверный пароль")
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
    @DisplayName("Проверяем возможность регистрации нового пользователя при вооде валидных данных")
    @Description("Нажимаем кнопку Войти в аккаунт, Нажимаем кнопку Регистрация, запоняем поля формы регистраци name, email и password - валидными значениями,  нажимаем кнопку Регистрация, проверяем что после успешной регистрации происходит переход на страницу конструктора бургеров")

    public void SuccessfulUserRegistrationTest() {
        burgerConstructorPage.clickSingInButton();
        loginPage.clickRegistrationLink();
        registrationPage.inputNameField(name);
        registrationPage.inputEmailField(email);
        registrationPage.inputPasswordField(password);
        registrationPage.clickRegistrationButton();
        waitForPageLoad(LOGIN_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL); //проверяем переход на страницу авторизации
    }
}