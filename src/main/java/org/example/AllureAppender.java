package org.example;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import io.qameta.allure.Allure;

/**
 * Класс AllureAppender представляет собой кастомный appender для логирования,
 * который интегрирует логи с отчетами Allure.
 * <p>
 * Этот класс наследует AppenderBase из библиотеки Logback и переопределяет метод append,
 * чтобы добавлять сообщения логов в отчеты Allure.
 * <p>
 * AllureAppender используется для автоматического добавления логов в отчеты Allure,
 * что помогает в анализе и отладке тестов.
 */
public class AllureAppender extends AppenderBase<ILoggingEvent> {

    /**
     * Метод append добавляет сообщение лога в отчет Allure.
     *
     * @param eventObject объект логирования, содержащий информацию о событии логирования
     */
    @Override
    protected void append(ILoggingEvent eventObject) {
        String logMessage = eventObject.getFormattedMessage();
        Allure.attachment(logMessage.substring(0, logMessage.indexOf(":")), logMessage);
    }
}
