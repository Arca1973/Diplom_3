package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.BurgerConstructorPage;
import pages.LoginPage;
import pages.RegestrationPage;
import pages.ForgotPasswordPage;


public class MenuNavigationTests extends BaseTest {
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
    }

    @Test
    @DisplayName("Проверяем что содержимое окна с ингридиентами прокручивается до пункта с соусами после нажатия элемента Соусы")
    @Description("Нажимаем элемент Соусы, проверяем что в окне виден список Соусы")

    public void SaucessMenuNavigationTest () {
        burgerConstructorPage.clickSaucesLink();
        Assert.assertTrue(burgerConstructorPage.isH2SaucessDisplayed());
    }

    @Test
    @DisplayName("Проверяем что содержимое окна с ингридиентами прокручивается до пункта с начинками после нажатия элемента Начинки")
    @Description("Нажимаем элемент Начинки, проверяем что в окне виден список Начинки")

    public void ToppingsMenuNavigationTest () {
        burgerConstructorPage.clickToppingsLink();
        Assert.assertTrue(burgerConstructorPage.isH2ToppingsLinkDisplayed());
    }

    @Test
    @DisplayName("Проверяем что содержимое окна с ингридиентами прокручивается до пункта с булками после нажатия элемента Булки")
    @Description("Нажимаем элемент Булки, проверяем что в окне виден список Булки")

    public void BunsMenuNavigationTest () {
        burgerConstructorPage.clickBunsLink();
        Assert.assertTrue(burgerConstructorPage.isH2BunsDisplayed());
    }
}