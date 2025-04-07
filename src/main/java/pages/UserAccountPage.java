package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserAccountPage {

    public UserAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    private final WebDriver driver;
    // Локатор
    private final By constructorLink = By.xpath("//a[contains(@class, 'AppHeader_header_link_3D_hX') and contains(text(), 'Конструктор')]"); //кнопка «Конструктор» в личном кабинете,
    private final By singInButton = By.xpath("//div[@class='button_button_33qZ0 button_button_type_primary_107bx button_button_size_medium_3zxIa']//button[text()='Войти']"); //кнопка «Войти» в личном кабинете,
    private static final By registrationLink = By.xpath("//*[contains(text(), 'Зарегистрироваться')]");//ссылка «Зарегистрироваться» в личном кабинете
    private final By restorePasswordLink = By.xpath("//a[contains(@class, 'Auth_link_1f0l') and contains(text(), 'Восстановить пароль')]"); //ссылка «Восстановить пароль» в личном кабинете
    private final By inputEmailField = By.xpath("//input[@class='text input_textfield text_type_main-default' and @type='text']"); // поле ввода Email
    private final By inputPasswordField = By.xpath("//input[@class='text input_textfield text_type_main-default' and @type='password']")  // поле ввода Password
            ; // поле ввода Password


    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }

    public void clickSingInButton() {
        driver.findElement(singInButton).click();
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