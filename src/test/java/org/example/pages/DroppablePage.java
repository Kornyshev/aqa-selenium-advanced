package org.example.pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Класс DroppablePage представляет страницу для выполнения действий Drag and Drop (перетаскивание).
 * <p>
 * Этот класс содержит методы для открытия страницы, выполнения действий перетаскивания
 * и получения текста элемента после перетаскивания.
 */
@Slf4j
public class DroppablePage extends BasePage {

    /** Экземпляр WebDriverWait для явных ожиданий */
    private final WebDriverWait wait;

    /** URL страницы для выполнения действий Drag and Drop */
    public String URL = "https://demoqa.com/droppable";

    /** Элемент, который нужно перетаскивать */
    @FindBy(css = "div#draggable")
    private WebElement elementForDragAndDrop;

    /** Контейнер, куда нужно перетащить элемент */
    @FindBy(css = "div.drop-box")
    private WebElement droppableContainer;

    /**
     * Конструктор DroppablePage инициализирует элементы страницы и экземпляр WebDriverWait.
     *
     * @param driver экземпляр WebDriver для взаимодействия с браузером
     */
    public DroppablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    /**
     * Открывает страницу для выполнения действий Drag and Drop.
     */
    @Step("open the Droppable page")
    public void open() {
        log.info("Slf4j Logging: Opening the Droppable page");
        driver.get(this.URL);
    }

    /**
     * Выполняет действие перетаскивания элемента в контейнер.
     */
    @Step("execute Drag&Drop action")
    public void dragAndDrop() {
        log.info("Slf4j Logging: Waiting for the draggable element to be visible");
        wait.until(ExpectedConditions.visibilityOf(elementForDragAndDrop));
        log.info("Slf4j Logging: Waiting for the droppable container to be visible");
        wait.until(ExpectedConditions.visibilityOf(droppableContainer));
        log.info("Slf4j Logging: Performing drag and drop action");
        Actions actions = new Actions(driver);
        actions.dragAndDrop(elementForDragAndDrop, droppableContainer).perform();
    }

    /**
     * Получает текст из контейнера после выполнения действия перетаскивания.
     *
     * @return текст из контейнера после выполнения действия перетаскивания
     */
    @Step("get droppable element text")
    public String getDroppableElementText() {
        log.info("Slf4j Logging: Waiting for the droppable container to be visible");
        WebElement element = wait.until(ExpectedConditions.visibilityOf(droppableContainer));
        String text = element.getText();
        log.info("Slf4j Logging: Retrieved text from the droppable container: {}", text);
        return text;
    }
}
