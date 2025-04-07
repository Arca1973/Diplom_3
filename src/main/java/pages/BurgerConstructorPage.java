package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BurgerConstructorPage {

    public BurgerConstructorPage(WebDriver driver) {
        this.driver = driver;
    }
    private final WebDriver driver;
    // Локаторы
    private final By singInButton = By.xpath("//button[text()='Войти в аккаунт']"); //кнопка «Войти в аккаунт» на главной,
    private final By accountLink = By.xpath("//*[contains(text(), 'Личный Кабинет')]"); //ссылка «Личный кабинет» на главной,
    private final By bunsLink = By.xpath("//span[contains(text(), 'Булки')]");//ссылка Булки
    private final By saucesLink = By.xpath("//span[contains(text(), 'Соусы')]");//ссылка Соусы
    private final By toppingsLink = By.xpath("//span[contains(text(), 'Начинки')]");//ссылка Начинки

    private final By h2BunsLink = By.xpath(" //h2[contains(text(),'Булки')]");//заголовок Булки
    private final By h2SaucessLink = By.xpath("//h2[contains(text(), 'Соусы')]");//заголовок Соусы
    private final By h2ToppingsLink = By.xpath("//h2[contains(text(), 'Начинки')]");//заголовок Начинки


    public void clickSingInButton() {
        driver.findElement(singInButton).click();
    }

    public void clickAccountLink() {
        driver.findElement(accountLink).click();
    }

    public void clickBunsLink() {
        WebElement element = driver.findElement(bunsLink);
        String noselectAttribute = element.getAttribute("noselect");
        if (noselectAttribute != null) {
            element.click();
        }
    }

    public void clickSaucesLink() {
        WebElement element = driver.findElement(saucesLink);
        String noselectAttribute = element.getAttribute("noselect");
        if (noselectAttribute != null) {
            element.click();
        }
    }

    public void clickToppingsLink() {
        WebElement element = driver.findElement(toppingsLink);
        String noselectAttribute = element.getAttribute("noselect");
        if (noselectAttribute != null) {
            element.click();
        }
    }

    public boolean isH2BunsDisplayed() {
        WebElement element = driver.findElement(h2BunsLink);
               return element.isDisplayed();
    }

    public boolean isH2SaucessDisplayed() {
        WebElement element = driver.findElement(h2SaucessLink);
        return element.isDisplayed();
    }

    public boolean isH2ToppingsLinkDisplayed() {
        WebElement element = driver.findElement(h2ToppingsLink);
        return element.isDisplayed();
    }
}
