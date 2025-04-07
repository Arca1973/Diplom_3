package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.BurgerConstructorPage;
import pages.LoginPage;
import pages.RegestrationPage;
import pages.RestorePasswordPage;


public class MenuNavigationTests extends BaseTest {


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

    }

    @Test
    public void SaucessMenuNavigationTest () {


        burgerConstructorPage.clickSaucesLink();
        Assert.assertTrue(burgerConstructorPage.isH2SaucessDisplayed());
    }

    @Test
    public void ToppingsMenuNavigationTest () {

        burgerConstructorPage.clickToppingsLink();
        Assert.assertTrue(burgerConstructorPage.isH2ToppingsLinkDisplayed());
    }

    @Test
    public void BunsMenuNavigationTest () {

        burgerConstructorPage.clickBunsLink();
        Assert.assertTrue(burgerConstructorPage.isH2BunsDisplayed());
    }



}