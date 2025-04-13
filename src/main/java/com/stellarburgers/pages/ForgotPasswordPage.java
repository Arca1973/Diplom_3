package com.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    private final WebDriver driver;
    // Локатор
    private final By enterLink = By.xpath("//*[contains(text(), 'Войти')]"); //ссылка «Войти» на странице Восстановление пароля


    @Step("Нажимаем Войти")
    public void clickEnterLink() {
        driver.findElement(enterLink).click();
    }

}