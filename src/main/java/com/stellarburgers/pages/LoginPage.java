package com.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final WebDriver driver;
    // Локаторы
    private final By enterLink = By.xpath("//*[contains(text(), 'Войти')]"); //кнопка «Войти» на странице Авторизация,
    private static final By registrationLink = By.xpath("//*[contains(text(), 'Зарегистрироваться')]");//ссылка «Зарегистрироваться» на странице Авторизация
    private final By inputEmailField = By.xpath("//label[text()='Email']/following-sibling::input"); // поле ввода Email на странице Авторизация
    private final By inputPasswordField = By.xpath("//label[text()='Пароль']/following-sibling::input"); // поле ввода Password на странице странице Авторизация // поле ввода Password




    @Step("Нажимаем Войти")
    public void clickEnterButton() {
        driver.findElement(enterLink).click();
    }
    @Step("Нажимаем Зарегистрироваться")
    public void clickRegistrationLink() {
        driver.findElement(registrationLink).click();
    }
    @Step("Вводим Email")
    public void  inputEmailField(String emailValue) {
        driver.findElement(inputEmailField).sendKeys(emailValue);
    }

    @Step("Вводим Password")
    public void inputPasswordField(String passwordValue) {
        driver.findElement(inputPasswordField).sendKeys(passwordValue);
    }

    @Step("Заполнение формы авторизации")
    public void fillLoginForm(String email, String password) {
        inputEmailField(email);
        inputPasswordField(password);
        clickEnterButton();
    }
    @Step("Ожидаем загрузки страницы link")
    public void waitForPageLoad(String link){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(link));
    }

}

