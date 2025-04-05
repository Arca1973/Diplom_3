package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BurgerConstructorPage {

    public BurgerConstructorPage(WebDriver driver) {
        this.driver = driver;
    }
    private final WebDriver driver;
    // Локатор
    private final By singInButton = By.xpath("//button[text()='Войти в аккаунт']"); //кнопка «Войти в аккаунт» на главной,
    private final By accountLink = By.xpath("//a[contains(@class, 'AppHeader_header__linkText__3q_va ml-2') and contains(text(), 'Личный Кабинет')]"); //ссылка «Личный кабинет» на главной,
    private final By bunsLink = By.xpath("//span[contains(text(), 'Булки')]");//ссылка Булки
    private final By saucesLink = By.xpath("//span[contains(text(), 'Соусы')]");//ссылка Соусы
    private final By toppingsLink = By.xpath("//span[contains(text(), 'Начинки')]");//ссылка Начинки


    public void clickSingInButton() {
        driver.findElement(singInButton).click();
    }

    public void clickAccountLink() {
        driver.findElement(accountLink).click();
    }

    public void clickBunsLink() {
        driver.findElement(bunsLink).click();
    }

    public void clickSaucesLink() {
        driver.findElement(saucesLink).click();
    }

    public void clickToppingsLink() {
        driver.findElement(toppingsLink).click();
    }
}
