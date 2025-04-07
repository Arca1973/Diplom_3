package base;

import org.junit.After;
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
    protected final String REGISTRATION_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    protected final String RESTORE_PASSWORD_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    protected final String BIURGER_CONSTRUCTOR_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    protected WebDriver driver;

    protected void waitForPageLoad(String link){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(link));
    }

    @Before
    public void setUp() {
        // По умолчанию используем Chrome, но можно передать параметр через Maven
        String browser = System.getProperty("browser", "firefox");
        driver = WebDriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");// URL тестового сервиса
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

