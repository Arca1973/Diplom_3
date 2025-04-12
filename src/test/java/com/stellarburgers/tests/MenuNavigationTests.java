package com.stellarburgers.tests;

import com.stellarburgers.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.stellarburgers.pages.BurgerConstructorPage;


public class MenuNavigationTests extends BaseTest {
    // Переменные для хранения экземпляров классов страниц
    private BurgerConstructorPage burgerConstructorPage;

    @Before
    public void setUp() {
        super.setUp();
        // Инициализация экземпляров классов страниц
        burgerConstructorPage = new BurgerConstructorPage(driver);
    }

    @Test
    @DisplayName("Проверяем что в окне с ингредиентами  становиться активным раздел  с соусами после нажатия элемента Соусы")
    @Description("Нажимаем элемент Соусы, проверяем что раздел Соусы активен")

    public void SaucesMenuNavigationTest() {
        burgerConstructorPage.clickSaucesLink();
        Assert.assertTrue(burgerConstructorPage.isSectionActive("Соусы"));
    }

    @Test
    @DisplayName("Проверяем что в окне с ингредиентами  становиться активным раздел  с начинками после нажатия элемента Начинки")
    @Description("Нажимаем элемент Начинки, проверяем что раздел Начинки активен")

    public void FillingsMenuNavigationTest() {
        burgerConstructorPage.clickFillingsLink();
        Assert.assertTrue(burgerConstructorPage.isSectionActive("Начинки"));
    }

    @Test
    @DisplayName("Проверяем что в окне с ингредиентами становиться активным раздел  с булками после нажатия элемента Булки")
    @Description("Нажимаем элемент Булки, проверяем что раздел будки активен")
    public void BunsMenuNavigationTest () {

        burgerConstructorPage.clickSaucesLink();
        burgerConstructorPage.clickBunsLink();
        Assert.assertTrue(burgerConstructorPage.isSectionActive("Булки"));
    }
}