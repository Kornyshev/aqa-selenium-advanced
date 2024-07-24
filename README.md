### Site for practice: https://demoqa.com/

## О проекте
Этот проект представляет собой автоматизированный набор тестов для веб-приложения. Он использует Selenium WebDriver для взаимодействия с веб-страницами и JUnit 5 для выполнения тестов. В проекте также используются инструменты для отчетности и логирования, такие как Allure и SLF4J.

## Структура проекта

Проект имеет следующую структуру:

- src/main/java
  - org.example.pages - содержит классы страниц веб-приложения, представляющие собой различные страницы, с которыми взаимодействует тест.
  - org.example.utils - утилитарные классы, такие как WebDriverProvider для управления экземпляром WebDriver и WebDriverEventListenerImpl для логирования событий WebDriver.
- src/test/java
  - org.example.tests - содержит тестовые классы, которые используют страницы и утилитарные классы для выполнения тестов.
  
Классы и страницы
- BasePage: Абстрактный класс, который предоставляет базовую функциональность для всех страниц, включая инициализацию WebDriver.
- ButtonsPage: Класс, представляющий страницу с кнопками. Включает методы для открытия страницы, выполнения действий с кнопками (двойной клик, правый клик, левый клик) и получения текстов сообщений, связанных с этими действиями.
- DroppablePage: Класс, представляющий страницу с элементом для перетаскивания. Включает методы для открытия страницы, выполнения действия перетаскивания и получения текста из контейнера, в который был перетащен элемент.
- ProgressBarPage: Класс, представляющий страницу с прогресс-баром. Включает методы для открытия страницы, клика по кнопке "Старт/Стоп", получения текста кнопки и значения прогресс-бара, а также ожидания, пока прогресс-бар не достигнет заданного значения.

Слушатели и адаптеры
- WebDriverEventListenerImpl: Класс, реализующий интерфейс WebDriverListener. Предназначен для логирования событий WebDriver, таких как навигация, поиск элементов, клики и другие действия. Логирование помогает отслеживать действия и отладить тесты.
- WebDriverProvider: Класс-утилита для управления экземпляром WebDriver. Реализует Singleton-паттерн для предоставления единственного экземпляра WebDriver с настроенными опциями. Также включает метод для закрытия WebDriver.

## Зависимости
Проект использует следующие зависимости:

- JUnit 5 (junit-jupiter.version: 5.10.3) - фреймворк для написания и выполнения тестов.
- Maven Compiler Plugin (maven.compiler.source: 17, maven.compiler.target: 17) - плагин Maven для компиляции исходного кода Java.
- Maven Surefire Plugin (maven-surefire-plugin.version: 3.0.0-M4) - плагин Maven для выполнения тестов.
- Allure Maven (allure-maven.version: 2.10.0) - плагин для интеграции с Allure для генерации отчетов о тестах.
- Allure JUnit5 (allure-junit5.version: 2.20.0) - интеграция Allure с JUnit 5 для создания отчетов.
- AspectJ (aspectj.version: 1.9.9.1) - библиотека для аспектно-ориентированного программирования.
- SLF4J (slf4j-api.version: 2.0.12) - API для логирования.
- Lombok (lombok.version: 1.18.34) - библиотека для генерации шаблонного кода.
- Logback Classic (logback-classic.version: 1.5.6) - реализация SLF4J для логирования.
- AssertJ (assertj-core.version: 3.26.3) - библиотека для утверждений в тестах.
- Selenium Java (selenium-java.version: 4.22.0) - библиотека для автоматизации браузеров с использованием WebDriver.

## Как запустить проект
- Настройте Maven: Убедитесь, что Maven установлен и настроен на вашем компьютере.
- Сборка проекта: Выполните команду `mvn clean install` для сборки проекта и скачивания всех зависимостей.
- Запуск тестов: Выполните команду `mvn test site` для запуска тестов. Результаты тестов будут доступны в отчетах Allure и логах.

## Заключение
Этот проект демонстрирует применение Selenium WebDriver для автоматизированного тестирования веб-приложений с использованием современных инструментов и библиотек для улучшения качества и удобства тестирования.