package org.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.interactions.Sequence;

import java.lang.reflect.Method;
import java.util.Collection;

/**
 * Класс WebDriverEventListenerImpl реализует интерфейс WebDriverListener для логирования событий WebDriver.
 * <p>
 * Этот класс используется для отслеживания и логирования всех вызовов WebDriver и действий с элементами.
 * <p>
 * Где будет применяться этот класс:
 * <p>
 * Отладка и Анализ:
 * <p>
 * Логирование всех значимых событий, таких как навигация по URL, поиск элементов, клики и выполнение действий, помогает отслеживать и понимать поведение тестов.
 * Полезен при анализе проблем, возникающих во время выполнения тестов.
 * <p>
 * Интеграция в тестовый фреймворк:
 * <p>
 * Этот класс может быть зарегистрирован в качестве слушателя событий WebDriver в вашем тестовом фреймворке, что позволит автоматически логировать все действия, выполняемые WebDriver.
 * <p>
 * Интерфейс в сигнатуре класса: WebDriverListener
 * <p>
 * Интерфейс WebDriverListener позволяет перехватывать и обрабатывать события, связанные с WebDriver, и предоставляет методы, которые можно переопределить для логирования или других действий перед и после выполнения методов WebDriver.
 * Реализация этого интерфейса помогает получать подробные логи всех взаимодействий с браузером, что улучшает возможность диагностики и анализа тестов.
 */
@Slf4j
public class WebDriverEventListenerImpl implements WebDriverListener {

    /**
     * Логирует вызов любого метода WebDriver до его выполнения.
     *
     * @param driver экземпляр WebDriver
     * @param method вызываемый метод
     * @param args   аргументы метода
     */
    @Override
    public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args) {
        log.info("WebDriverListener Logging: Before any WebDriver call: {}", method.getName());
    }

    /**
     * Логирует вызов любого метода WebDriver после его выполнения.
     *
     * @param driver  экземпляр WebDriver
     * @param method  вызываемый метод
     * @param args    аргументы метода
     * @param result  результат вызова метода
     */
    @Override
    public void afterAnyWebDriverCall(WebDriver driver, Method method, Object[] args, Object result) {
        log.info("WebDriverListener Logging: After any WebDriver call: {}", method.getName());
    }

    /**
     * Логирует перед навигацией по URL.
     *
     * @param driver экземпляр WebDriver
     * @param url    URL, на который осуществляется навигация
     */
    @Override
    public void beforeGet(WebDriver driver, String url) {
        log.info("WebDriverListener Logging: Before navigating to: {}", url);
    }

    /**
     * Логирует после навигации по URL.
     *
     * @param driver экземпляр WebDriver
     * @param url    URL, на который была осуществлена навигация
     */
    @Override
    public void afterGet(WebDriver driver, String url) {
        log.info("WebDriverListener Logging: After navigating to: {}", url);
    }

    /**
     * Логирует перед поиском элемента.
     *
     * @param driver  экземпляр WebDriver
     * @param locator локатор элемента
     */
    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        log.info("WebDriverListener Logging: Before finding element: {}", locator);
    }

    /**
     * Логирует после поиска элемента.
     *
     * @param driver  экземпляр WebDriver
     * @param locator локатор элемента
     * @param result  найденный элемент
     */
    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        log.info("WebDriverListener Logging: After finding element: {}", locator);
    }

    /**
     * Логирует перед закрытием браузера.
     *
     * @param driver экземпляр WebDriver
     */
    @Override
    public void beforeClose(WebDriver driver) {
        log.info("WebDriverListener Logging: Before closing the browser");
    }

    /**
     * Логирует после закрытия браузера.
     *
     * @param driver экземпляр WebDriver
     */
    @Override
    public void afterClose(WebDriver driver) {
        log.info("WebDriverListener Logging: After closing the browser");
    }

    /**
     * Логирует перед выходом из браузера.
     *
     * @param driver экземпляр WebDriver
     */
    @Override
    public void beforeQuit(WebDriver driver) {
        log.info("WebDriverListener Logging: Before quitting the browser");
    }

    /**
     * Логирует после выхода из браузера.
     *
     * @param driver экземпляр WebDriver
     */
    @Override
    public void afterQuit(WebDriver driver) {
        log.info("WebDriverListener Logging: After quitting the browser");
    }

    /**
     * Логирует перед выполнением действий.
     *
     * @param driver  экземпляр WebDriver
     * @param actions действия
     */
    @Override
    public void beforePerform(WebDriver driver, Collection<Sequence> actions) {
        log.info("WebDriverListener Logging: Before performing actions");
    }

    /**
     * Логирует после выполнения действий.
     *
     * @param driver  экземпляр WebDriver
     * @param actions действия
     */
    @Override
    public void afterPerform(WebDriver driver, Collection<Sequence> actions) {
        log.info("WebDriverListener Logging: After performing actions");
    }

    /**
     * Логирует перед кликом на элемент.
     *
     * @param element элемент
     */
    @Override
    public void beforeClick(WebElement element) {
        log.info("WebDriverListener Logging: Before clicking on element: {}", element);
    }

    /**
     * Логирует после клика на элемент.
     *
     * @param element элемент
     */
    @Override
    public void afterClick(WebElement element) {
        log.info("WebDriverListener Logging: After clicking on element: {}", element);
    }

    /**
     * Логирует перед получением имени тега элемента.
     *
     * @param element элемент
     */
    @Override
    public void beforeGetTagName(WebElement element) {
        log.info("WebDriverListener Logging: Before getting tag name of element: {}", element);
    }

    /**
     * Логирует после получения имени тега элемента.
     *
     * @param element элемент
     * @param result  результат получения имени тега
     */
    @Override
    public void afterGetTagName(WebElement element, String result) {
        log.info("WebDriverListener Logging: After getting tag name of element: {}, result: {}", element, result);
    }

    /**
     * Логирует перед получением атрибута элемента.
     *
     * @param element элемент
     * @param name    имя атрибута
     */
    @Override
    public void beforeGetAttribute(WebElement element, String name) {
        log.info("WebDriverListener Logging: Before getting attribute: {} of element: {}", name, element);
    }

    /**
     * Логирует после получения атрибута элемента.
     *
     * @param element элемент
     * @param name    имя атрибута
     * @param result  результат получения атрибута
     */
    @Override
    public void afterGetAttribute(WebElement element, String name, String result) {
        log.info("WebDriverListener Logging: After getting attribute: {} of element: {}, result: {}", name, element, result);
    }

}
