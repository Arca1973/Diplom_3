package com.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;
    // Локатор
    private final By enterLink = By.xpath("//*[contains(text(), 'Войти')]"); //ссылка «Войти» на странице Регистрация
    private final By registrationButton = By.xpath("//button[contains(text(), 'Зарегистрироваться')]"); //кнопка «Зарегистрироваться» на странице Регистрация
    private final By inputNameField = By.xpath("//input[@class='text input__textfield text_type_main-default' and @type='text' and @name='name']"); // поле ввода Name на странице Регистрация
    private final By inputEmailField = By.xpath("//label[text()='Email']/following-sibling::input"); // поле ввода Email на странице Регистрация
    private final By inputPasswordField = By.xpath("//label[text()='Пароль']/following-sibling::input"); // поле ввода Password на странице Регистрация
    private final By wrongPasswordMessage = By.xpath("//p[text()='Некорректный пароль']"); //сообщение 'Некорректный пароль'

    @Step("Нажимаем Войти")
    public void clickEnterLink() {
        driver.findElement(enterLink).click();
    }

    @Step("Нажимаем Зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Вводим name")
    public void inputNameField(String nameValue) {
        driver.findElement(inputNameField).sendKeys(nameValue);
    }

    @Step("Вводим email")
    public void inputEmailField(String emailValue) {
        driver.findElement(inputEmailField).sendKeys(emailValue);
    }

    @Step("Вводим password")
    public void inputPasswordField(String PasswordValue) {
        driver.findElement(inputPasswordField).sendKeys(PasswordValue);
    }

    @Step("Проверяем что появилось сообщение Некорректный пароль")
    public boolean isWrongPasswordMessageDisplayed() {
        return driver.findElement(wrongPasswordMessage).isDisplayed();
    }

    @Step("Ожидаем загрузки страницы link")
    public void waitForPageLoad(String link){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(link));
    }

}