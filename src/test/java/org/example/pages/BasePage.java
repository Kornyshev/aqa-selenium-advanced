package org.example.pages;

import org.openqa.selenium.WebDriver;

/**
 * Абстрактный класс BasePage служит базовым классом для всех страниц в приложении.
 * <p>
 * Этот класс предоставляет общий функционал, который будет использоваться всеми страницами,
 * такими как хранение и управление экземпляром WebDriver.
 * <p>
 * Наследование от BasePage позволяет избежать дублирования кода и облегчает поддержку и расширение проекта.
 */
public abstract class BasePage {

    /** Экземпляр WebDriver, управляющий браузером */
    protected WebDriver driver;

    /**
     * Конструктор BasePage инициализирует экземпляр WebDriver.
     *
     * @param driver экземпляр WebDriver, который будет использоваться страницами для взаимодействия с браузером
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

}
