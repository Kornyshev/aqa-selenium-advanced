package org.example.pages.conditions;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Класс ProgressBarValueCondition представляет собой условие ожидания для прогресс-бара,
 * которое используется для проверки, достиг ли прогресс-бар определенного значения.
 * <p>
 * Этот класс имплементирует интерфейс ExpectedCondition из библиотеки Selenium.
 * Интерфейс ExpectedCondition используется для создания пользовательских условий ожидания.
 * Такие условия позволяют WebDriver ждать до тех пор, пока условие не будет выполнено или не истечет таймаут.
 * <p>
 * Класс ProgressBarValueCondition будет применяться в тестах, где необходимо дождаться,
 * пока прогресс-бар достигнет определенного значения, прежде чем продолжить выполнение теста.
 */
@Slf4j
public class ProgressBarValueCondition implements ExpectedCondition<Boolean> {

    /** Элемент прогресс-бара */
    private final WebElement progressBar;

    /** Целевое значение прогресс-бара */
    private final int targetValue;

    /**
     * Конструктор ProgressBarValueCondition.
     *
     * @param progressBar элемент прогресс-бара, значение которого будет проверяться
     * @param targetValue целевое значение прогресс-бара, которое должно быть достигнуто или превышено
     */
    public ProgressBarValueCondition(WebElement progressBar, int targetValue) {
        this.progressBar = progressBar;
        this.targetValue = targetValue;
    }

    /**
     * Метод apply используется для проверки текущего значения атрибута aria-valuenow элемента прогресс-бара.
     * Он возвращает true, если текущее значение прогресс-бара больше или равно целевому значению, и false в противном случае.
     *
     * @param driver веб-драйвер, управляющий браузером
     * @return true, если текущее значение прогресс-бара больше или равно целевому значению, false в противном случае
     */
    @Override
    public Boolean apply(WebDriver driver) {
        log.info("Slf4j Logging: Checking the value of the progress bar's aria-valuenow attribute");
        String value = progressBar.getAttribute("aria-valuenow");
        if (value != null) {
            try {
                int currentValue = Integer.parseInt(value);
                log.info("Slf4j Logging: Current progress bar value is {}, target value is {}", currentValue, targetValue);
                return currentValue >= targetValue;
            } catch (NumberFormatException e) {
                log.info("Slf4j Logging: Failed to parse progress bar value: {}", value);
            }
        } else {
            log.info("Slf4j Logging: aria-valuenow attribute is null");
        }
        return false;
    }
}
