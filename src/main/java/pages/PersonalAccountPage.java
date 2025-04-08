package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;
    // Локатор
    private final By constructorLink = By.xpath("//p[contains(text(),'Конструктор')]"); //ссылка «Конструктор» в Личном кабинете
    private final By exitButton = By.xpath("//button[contains(text(),'Выход')]"); //кнопка «Выход» в Личном кабинете
    private final By stellarBurgersLogo= By.xpath("//div[@class='AppHeader_header__logo__2D0X2']//a//*[name()='svg']"); //Логотип Stellar Burgers

    @Step("Нажимаем Конструктор")
    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }

    @Step("Нажимаем Выход")
    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    @Step("Нажимаем на Логотип")
    public void clickStellarBurgersLogo() {
        driver.findElement(stellarBurgersLogo).click();
    }

}