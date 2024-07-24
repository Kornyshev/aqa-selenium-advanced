package org.example.pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

/**
 * Класс ButtonsPage представляет страницу с кнопками для взаимодействия в веб-приложении.
 * <p>
 * Этот класс содержит методы для выполнения различных действий с кнопками на странице,
 * таких как двойной клик, клик правой кнопкой мыши и левый клик.
 * <p>
 * Методы используют явные ожидания для обеспечения правильного выполнения действий и получения сообщений.
 */
@Slf4j
public class ButtonsPage extends BasePage {

    /** Экземпляр WebDriverWait для явных ожиданий */
    private final WebDriverWait wait;

    /** URL страницы с кнопками */
    public String URL = "https://demoqa.com/buttons";

    /** Кнопка для двойного клика */
    @FindBy(css = "button#doubleClickBtn")
    private WebElement doubleClickButton;

    /** Кнопка для клика правой кнопкой мыши */
    @FindBy(css = "button#rightClickBtn")
    private WebElement rightClickButton;

    /** Кнопка для левого клика */
    @FindBy(xpath = "//button[text()= 'Click Me']")
    private WebElement leftClickButton;

    /** Текстовый лейбл для сообщения после двойного клика */
    @FindBy(css = "p#doubleClickMessage")
    private WebElement doubleClickTextLabel;

    /** Текстовый лейбл для сообщения после клика правой кнопкой мыши */
    @FindBy(css = "p#rightClickMessage")
    private WebElement rightClickTextLabel;

    /** Текстовый лейбл для сообщения после левого клика */
    @FindBy(css = "p#dynamicClickMessage")
    private WebElement leftClickTextLabel;

    /**
     * Конструктор ButtonsPage инициализирует элементы страницы и экземпляр WebDriverWait.
     *
     * @param driver экземпляр WebDriver для взаимодействия с браузером
     */
    public ButtonsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    /**
     * Открывает страницу с кнопками.
     */
    @Step("Open the Buttons page")
    public void open() {
        log.info("Slf4j Logging: Opening the Buttons page");
        driver.get(this.URL);
    }

    /**
     * Выполняет двойной клик по кнопке для двойного клика.
     */
    @Step("Double-click the double-click button")
    public void doubleClickButton() {
        log.info("Slf4j Logging: Waiting for the double-click button to be clickable");
        wait.until(ExpectedConditions.elementToBeClickable(doubleClickButton));
        log.info("Slf4j Logging: Performing double-click on the double-click button");
        new Actions(driver).doubleClick(doubleClickButton).perform();
    }

    /**
     * Выполняет клик правой кнопкой мыши по кнопке для клика правой кнопкой мыши.
     */
    @Step("Right-click the right-click button")
    public void rightClickButton() {
        log.info("Slf4j Logging: Waiting for the right-click button to be clickable");
        wait.until(ExpectedConditions.elementToBeClickable(rightClickButton));
        log.info("Slf4j Logging: Performing right-click on the right-click button");
        new Actions(driver).contextClick(rightClickButton).perform();
    }

    /**
     * Выполняет левый клик по кнопке "Click Me".
     */
    @Step("Left-click the click-me button")
    public void leftClickButton() {
        log.info("Slf4j Logging: Waiting for the click-me button to be clickable");
        wait.until(ExpectedConditions.elementToBeClickable(leftClickButton)).click();
        log.info("Slf4j Logging: Performing left-click on the click-me button");
    }

    /**
     * Получает текст сообщения после двойного клика.
     *
     * @return текст сообщения после двойного клика
     */
    @Step("Get the double-click message")
    public String getDoubleClickMessage() {
        log.info("Slf4j Logging: Waiting for the double-click message to be visible");
        String text = wait.until(ExpectedConditions.visibilityOf(doubleClickTextLabel)).getText();
        log.info("Slf4j Logging: Retrieved double-click message: {}", text);
        return text;
    }

    /**
     * Получает текст сообщения после клика правой кнопкой мыши.
     *
     * @return текст сообщения после клика правой кнопкой мыши
     */
    @Step("Get the right-click message")
    public String getRightClickMessage() {
        log.info("Slf4j Logging: Waiting for the right-click message to be visible");
        String text = wait.until(ExpectedConditions.visibilityOf(rightClickTextLabel)).getText();
        log.info("Slf4j Logging: Retrieved right-click message: {}", text);
        return text;
    }

    /**
     * Получает текст сообщения после левого клика.
     *
     * @return текст сообщения после левого клика
     */
    @Step("Get the dynamic click message")
    public String getLeftClickMessage() {
        log.info("Slf4j Logging: Waiting for the dynamic click message to be visible");
        String text = wait.until(ExpectedConditions.visibilityOf(leftClickTextLabel)).getText();
        log.info("Slf4j Logging: Retrieved dynamic click message: {}", text);
        return text;
    }

    /**
     * Ожидает, пока все указанные сообщения не будут присутствовать на странице.
     *
     * @param expectedMessages список ожидаемых сообщений
     */
    @Step("Wait for all messages to be present")
    public void waitForAllMessagesToBePresent(List<String> expectedMessages) {
        log.info("Slf4j Logging: Waiting for all messages to be present: {}", expectedMessages);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .until(driver -> {
                    for (String expectedMessage : expectedMessages) {
                        if (!isMessagePresent(expectedMessage)) {
                            log.info("Slf4j Logging: Message not found: {}", expectedMessage);
                            return false;
                        }
                    }
                    log.info("Slf4j Logging: All expected messages are present");
                    return true;
                });
    }

    /**
     * Проверяет, присутствует ли указанное сообщение на странице.
     *
     * @param message сообщение для проверки
     * @return true, если сообщение присутствует, иначе false
     */
    private boolean isMessagePresent(String message) {
        return List.of(
                doubleClickTextLabel.getText(),
                rightClickTextLabel.getText(),
                leftClickTextLabel.getText()
        ).contains(message);
    }
}
