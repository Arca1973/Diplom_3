package base;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;
import java.time.Duration;

public class BaseTest {

    // Переменные с URL страниц
    protected final String USER_ACCOUNT_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    protected final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    protected final String BURGER_CONSTRUCTOR_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    protected static WebDriver driver;

    @Step("Ожидаем загрузки страницы link")
    protected void waitForPageLoad(String link){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(link));
    }

    @Before
    @Step("Выбираем броузер")
    public void setUp() {
        // По умолчанию используем Chrome, но можно передать параметр через Maven
        String browser = System.getProperty("browser", "yandex");
        driver = WebDriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");// URL тестового сервиса
    }

    @After
    @Step("Закрываем броузер")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

