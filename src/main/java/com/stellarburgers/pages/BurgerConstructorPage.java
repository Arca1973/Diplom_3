package com.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BurgerConstructorPage {
    public BurgerConstructorPage(WebDriver driver) {
                this.driver = driver;
    }
    private final WebDriver driver;
    // Локаторы
    private final By singInButton = By.xpath("//button[text()='Войти в аккаунт']"); //кнопка «Войти в аккаунт» на главной,
    private final By accountLink = By.xpath("//*[contains(text(), 'Личный Кабинет')]"); //ссылка «Личный кабинет» на главной,

    public final By bunsTabLocator = By.xpath("//span[text()='Булки']");
    public final By saucesTabLocator = By.xpath("//span[text()='Соусы']");
    public final By fillingsTabLocator =By.xpath("//span[text()='Начинки']");



    @Step("Нажимаем кнопку Войти в аккаунт")
    public void clickSingInButton() {
        driver.findElement(singInButton).click();
    }
    @Step("Нажимаем Личный Кабинет")
    public void clickAccountLink() {
        driver.findElement(accountLink).click();
    }

    @Step("Нажимаем Булки")
    public void clickBunsLink() {
        WebElement element = driver.findElement(bunsTabLocator);
        element.click();
    }
    @Step("Нажимаем Соусы")
    public void clickSaucesLink() {
        WebElement element = driver.findElement(saucesTabLocator);
                   element.click();
    }
    @Step("Нажимаем Начинки")
    public void clickFillingsLink() {
        WebElement element = driver.findElement(fillingsTabLocator);
        element.click();
    }

    @Step("Ожидаем загрузки страницы link")
    public void waitForPageLoad(String link){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(link));
    }

    @Step("проверки активности раздела")
    public boolean isSectionActive(String sectionName) {
        By activeSection = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and contains(@class, 'tab_tab_type_current__2BEPc')]//span[text()='" + sectionName + "']");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(activeSection));
            return element != null && element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    }


