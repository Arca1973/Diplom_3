package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final WebDriver driver;
    // Локатор
    private final By constructorLink = By.xpath("//a[contains(@class, 'AppHeader_header_link_3D_hX') and contains(text(), 'Конструктор')]"); //кнопка «Конструктор» на странице Авторизация
    private final By enterLink = By.xpath("//*[contains(text(), 'Войти')]"); //кнопка «Войти» на странице Авторизация,
    private static final By registrationLink = By.xpath("//*[contains(text(), 'Зарегистрироваться')]");//ссылка «Зарегистрироваться» на странице Авторизация
    private final By restorePasswordLink = By.xpath("//a[contains(@class, 'Auth_link_1f0l') and contains(text(), 'Восстановить пароль')]"); //ссылка «Восстановить пароль» в личном кабинете
    private final By inputEmailField = By.xpath("//label[text()='Email']/following-sibling::input"); // поле ввода Email на странице Авторизация
    private final By inputPasswordField = By.xpath("//label[text()='Пароль']/following-sibling::input"); // поле ввода Password на странице странице Авторизация // поле ввода Password


    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }

    public void clickEnterButton() {
        driver.findElement(enterLink).click();
    }

    public void clickRegistrationLink() {
        driver.findElement(registrationLink).click();
    }

    public void clickRestorePasswordLink() {
        driver.findElement(restorePasswordLink).click();
    }

    public void  inputEmailField(String emailValue) {
        driver.findElement(inputEmailField).sendKeys(emailValue);
    }

    public void inputPasswordField(String passwordValue) {
        driver.findElement(inputPasswordField).sendKeys(passwordValue);
    }
}