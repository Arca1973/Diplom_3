package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegestrationPage {
    public RegestrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;

    // Локатор
    private final By enterLink = By.xpath("//a[contains(@class, 'Auth_link__1fOlj') and contains(text(), 'Войти')]"); //ссылка «Войти» на странице Регистрация
    private final By registrationButton = By.xpath("//button[contains(@class, 'button button_33q20 button_type_primary_107Bx button_button_size_medium__3zxIa') and contains(text(), 'Зарегистрироваться')]"); //кнопка «Зарегистрироваться» на странице Регистрация
    private final By inputNameField = By.xpath("//input[@class='text input__textfield text_type_main-default' and @type='text' and @name='name']"); // поле ввода Name на странице Регистрация
    private final By inputEmailField = By.xpath("//label[text()='Email']/following-sibling::input"); // поле ввода Email на странице Регистрация
    private final By inputPasswordField = By.xpath("//label[text()='Пароль']/following-sibling::input"); // поле ввода Password на странице Регистрация


    public void clickEnterLink() {
        driver.findElement(enterLink).click();
    }

    public void clickRegistrationButton () {
        driver.findElement(registrationButton).click();
    }

    public void inputNameField(String nameValue) {
        driver.findElement(inputEmailField).sendKeys(nameValue);
    }
    public void inputEmailField(String emailValue) {
        driver.findElement(inputEmailField).sendKeys(emailValue);
    }
    public void inputPasswordField(String PasswordValue) {
        driver.findElement(inputEmailField).sendKeys(PasswordValue);
    }