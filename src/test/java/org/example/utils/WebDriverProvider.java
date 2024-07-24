package org.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

/**
 * Класс WebDriverProvider предоставляет методы для инициализации и управления экземпляром WebDriver.
 * <p>
 * Этот класс используется для создания и предоставления экземпляра WebDriver для выполнения автоматизированных тестов.
 * Он обеспечивает настройку WebDriver и регистрацию слушателя событий для логирования.
 */
@Slf4j
public class WebDriverProvider {

    /**
     * Экземпляр WebDriver, который используется в тестах.
     * Это поле инициализируется при первом вызове метода {@link #getDriver()}.
     */
    private static WebDriver driver;

    /**
     * Приватный конструктор для предотвращения создания экземпляров этого класса.
     */
    private WebDriverProvider() {
    }

    /**
     * Метод для получения экземпляра WebDriver.
     * <p>
     * Если экземпляр WebDriver еще не создан, он инициализируется с помощью настроек Chrome и
     * декоратора событий для логирования действий WebDriver.
     *
     * @return экземпляр WebDriver
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            log.info("Slf4j Logging: WebDriver initialization");
            // Создаем объект ChromeOptions для настройки ChromeDriver
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            // Создаем экземпляр ChromeDriver с заданными параметрами
            WebDriver originalDriver = new ChromeDriver(options);

            // Создаем и регистрируем слушателя событий WebDriver
            WebDriverListener listener = new WebDriverEventListenerImpl();
            driver = new EventFiringDecorator<>(listener).decorate(originalDriver);
        }
        log.info("Slf4j Logging: Returning WebDriver instance");
        return driver;
    }

    /**
     * Метод для закрытия экземпляра WebDriver и освобождения ресурсов.
     * <p>
     * Этот метод завершает работу браузера и очищает ссылку на экземпляр WebDriver.
     */
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
