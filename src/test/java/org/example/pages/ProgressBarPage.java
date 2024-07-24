package org.example.pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.conditions.ProgressBarValueCondition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Класс ProgressBarPage представляет страницу с прогресс-баром для взаимодействия в веб-приложении.
 * <p>
 * Этот класс содержит методы для открытия страницы, нажатия кнопки "Start/Stop",
 * получения значений прогресс-бара и ожидания достижения определенного значения прогресс-бара.
 */
@Slf4j
public class ProgressBarPage extends BasePage {

    /** Экземпляр WebDriverWait для явных ожиданий */
    private final WebDriverWait wait;

    /** URL страницы с прогресс-баром */
    public String URL = "https://demoqa.com/progress-bar";

    /** Прогресс-бар элемент */
    @FindBy(css = "div#progressBar div")
    private WebElement progressBar;

    /** Кнопка "Start/Stop" */
    @FindBy(css = "button#startStopButton")
    private WebElement startStopButton;

    /**
     * Конструктор ProgressBarPage инициализирует элементы страницы и экземпляр WebDriverWait.
     *
     * @param driver экземпляр WebDriver для взаимодействия с браузером
     */
    public ProgressBarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    /**
     * Открывает страницу с прогресс-баром.
     */
    @Step("Open the Progress Bar page")
    public void open() {
        log.info("Slf4j Logging: Opening the Progress Bar page");
        driver.get(this.URL);
    }

    /**
     * Нажимает кнопку "Start/Stop".
     */
    @Step("Click the start/stop button")
    public void clickStartStopButton() {
        log.info("Slf4j Logging: Waiting for the start/stop button to be clickable");
        wait.until(ExpectedConditions.elementToBeClickable(startStopButton)).click();
        log.info("Slf4j Logging: Clicked the start/stop button");
    }

    /**
     * Получает текст с кнопки "Start/Stop".
     *
     * @return текст с кнопки "Start/Stop"
     */
    @Step("Get the text of the start/stop button")
    public String getStartStopButtonText() {
        log.info("Slf4j Logging: Waiting for the start/stop button to be visible");
        String text = wait.until(ExpectedConditions.visibilityOf(startStopButton)).getText();
        log.info("Slf4j Logging: Retrieved text from the start/stop button: {}", text);
        return text;
    }

    /**
     * Получает значение атрибута aria-valuenow из прогресс-бара.
     *
     * @return значение атрибута aria-valuenow из прогресс-бара
     */
    @Step("Get the value of the aria-valuenow attribute from the progress bar")
    public String getProgressBarValue() {
        log.info("Slf4j Logging: Waiting for the progress bar to be visible");
        String value = wait.until(ExpectedConditions.visibilityOf(progressBar)).getAttribute("aria-valuenow");
        log.info("Slf4j Logging: Retrieved value of aria-valuenow from the progress bar: {}", value);
        return value;
    }

    /**
     * Ожидает, пока прогресс-бар не достигнет указанного значения.
     *
     * @param targetValue целевое значение прогресс-бара
     */
    @Step("Wait for the progress bar to reach {targetValue}%")
    public void waitForProgressBarToReach(int targetValue) {
        log.info("Slf4j Logging: Waiting for the progress bar to reach {}%", targetValue);
        wait.until(new ProgressBarValueCondition(progressBar, targetValue));
        log.info("Slf4j Logging: Progress bar reached {}%", targetValue);
    }

}
