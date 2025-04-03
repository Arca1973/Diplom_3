package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {
    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;

    // Локатор
    private final By enterLink = By.xpath("//a[contains(@class, 'Auth_link_1f0l') and contains(text(), 'Войти')]"); //ссылка «Войти» на странице Востановление пароля
    private final By restoreButton = By.xpath("//button[contains(@class, 'button button_33q20 button_type_primary_107Bx button_button_size_medium_3xIAa') and contains(text(), 'Восстановить')]"); //кнопка «Восстановить» на странице Востановление пароля
    private final By inputEmailField = By.xpath("//input[@class='text input_textfield text_type_main-default' and @type='text']"); // поле ввода Email на странице Востановление пароля


    public void clickEnterLink() {
        driver.findElement(enterLink).click();
    }

    public void clickRestoreButton() {
        driver.findElement(restoreButton).click();
    }

    public void inputEmailField(String emailValue) {
        driver.findElement(inputEmailField).sendKeys(emailValue);
    }

}