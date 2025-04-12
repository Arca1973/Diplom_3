package com.stellarburgers.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    static String yandex_driver_path = "/usr/local/bin/yandexdriver";
    @Step("Выбираем броузер")
    public static WebDriver createDriver(String browser) {
        if ("yandex".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.chrome.driver", yandex_driver_path);
            ChromeOptions options = new ChromeOptions();
            return new ChromeDriver(options);
        } else {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }
}