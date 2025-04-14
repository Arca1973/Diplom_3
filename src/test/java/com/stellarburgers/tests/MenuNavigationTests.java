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
    Boolean sectionActive;

    @Before
    public void setUp() {
        super.setUp();
        // Инициализация экземпляров классов страниц
        burgerConstructorPage = new BurgerConstructorPage(driver);
    }
    @Test
    @DisplayName("Проверяем что в окне с ингредиентами становиться активным раздел  с булками после нажатия элемента Булки")
    @Description("Нажимаем элемент Булки, проверяем что раздел булки активен")
    public void BunsMenuNavigationTest () {

        burgerConstructorPage.clickSaucesLink();
        burgerConstructorPage.clickBunsLink();
        sectionActive = burgerConstructorPage.isSectionActive("Булки");
        Assert.assertTrue(sectionActive);
    }
    @Test
    @DisplayName("Проверяем что в окне с ингредиентами  становиться активным раздел  с соусами после нажатия элемента Соусы")
    @Description("Нажимаем элемент Соусы, проверяем что раздел Соусы активен")

    public void SaucesMenuNavigationTest() {
        burgerConstructorPage.clickSaucesLink();
        sectionActive = burgerConstructorPage.isSectionActive("Соусы");
        Assert.assertTrue(sectionActive);
    }

    @Test
    @DisplayName("Проверяем что в окне с ингредиентами  становиться активным раздел  с начинками после нажатия элемента Начинки")
    @Description("Нажимаем элемент Начинки, проверяем что раздел Начинки активен")

    public void FillingsMenuNavigationTest() {
        burgerConstructorPage.clickFillingsLink();
        sectionActive = burgerConstructorPage.isSectionActive("Начинки");
        Assert.assertTrue(sectionActive);
    }
}