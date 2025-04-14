package com.stellarburgers.base;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import com.stellarburgers.utils.WebDriverFactory;

import static com.stellarburgers.api.ApiConstants.BASE_URL;

public class BaseTest {

    // Переменные с URL страниц
    protected final String USER_ACCOUNT_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    protected final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    protected final String BURGER_CONSTRUCTOR_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    protected static WebDriver driver;


    @Before
    @Step("Выбираем броузер")
    public void setUp() {
        // По умолчанию используем Chrome, но можно передать параметр через Maven
        String browser = System.getProperty("browser", "yandex");
        driver = WebDriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.get(BASE_URL);// URL тестового сервиса
    }

    @After
    @Step("Закрываем броузер")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

