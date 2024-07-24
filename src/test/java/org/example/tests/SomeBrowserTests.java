package org.example.tests;

import org.example.pages.*;
import org.example.utils.WebDriverProvider;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс SomeBrowserTests содержит тесты для страниц DroppablePage, ProgressBarPage и ButtonsPage.
 * <p>
 * Каждый тест открывает соответствующую страницу, выполняет действия на странице и проверяет результаты.
 */
public class SomeBrowserTests {

    /** Экземпляр WebDriver для управления браузером */
    WebDriver driver;
    DroppablePage droppablePage;
    ProgressBarPage progressBarPage;
    ButtonsPage buttonsPage;

    /**
     * Метод setupDriver инициализирует драйвер перед каждым тестом.
     */
    @BeforeEach
    void setupDriver() {
        driver = WebDriverProvider.getDriver();
    }

    /**
     * Тест для страницы DroppablePage.
     * <p>
     * Открывает страницу, выполняет действие перетаскивания элемента и проверяет текст элемента после перетаскивания.
     */
    @Test
    void testDroppablePage() {
        droppablePage = new DroppablePage(driver);
        droppablePage.open();
        droppablePage.dragAndDrop();
        assertThat(droppablePage.getDroppableElementText()).isEqualTo("Dropped!");
    }

    /**
     * Тест для страницы ProgressBarPage.
     * <p>
     * Открывает страницу, проверяет текст кнопки "Start/Stop", нажимает кнопку, ожидает
     * достижения прогресс-баром значения 50 и проверяет значение прогресс-бара.
     * <p>
     * <b>Тест иногда падает из-за производительности Selenium или приложения!!!</b>
     */
    @Test
    void testProgressBarPage() {
        progressBarPage = new ProgressBarPage(driver);
        progressBarPage.open();
        assertThat(progressBarPage.getStartStopButtonText()).isEqualTo("Start");
        progressBarPage.clickStartStopButton();
        assertThat(progressBarPage.getStartStopButtonText()).isEqualTo("Stop");
        progressBarPage.waitForProgressBarToReach(50);
        progressBarPage.clickStartStopButton();
        assertThat(progressBarPage.getStartStopButtonText()).isEqualTo("Start");
        assertThat(progressBarPage.getProgressBarValue()).isIn(List.of("50", "51", "52", "53", "54"));
    }

    /**
     * Тест для страницы ButtonsPage.
     * <p>
     * Открывает страницу, выполняет двойной клик, правый клик и левый клик, проверяет наличие всех сообщений
     * и проверяет текст каждого сообщения.
     */
    @Test
    void testButtonsPage() {
        buttonsPage = new ButtonsPage(driver);
        buttonsPage.open();
        buttonsPage.doubleClickButton();
        buttonsPage.rightClickButton();
        buttonsPage.leftClickButton();
        List<String> expectedMessages = List.of(
                "You have done a double click",
                "You have done a right click",
                "You have done a dynamic click");
        buttonsPage.waitForAllMessagesToBePresent(expectedMessages);
        assertThat(buttonsPage.getDoubleClickMessage()).isEqualTo("You have done a double click");
        assertThat(buttonsPage.getRightClickMessage()).isEqualTo("You have done a right click");
        assertThat(buttonsPage.getLeftClickMessage()).isEqualTo("You have done a dynamic click");
    }

    /**
     * Метод tearDown закрывает драйвер после каждого теста.
     */
    @AfterEach
    void tearDown() {
        WebDriverProvider.closeDriver();
    }

}
