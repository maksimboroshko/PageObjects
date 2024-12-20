package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;

import java.util.Map;

public class TestBase {
    RegistrationPage registrationPage;

    @BeforeAll
    static void beforeAll() {
        // Настройки конфигурации браузера из параметров Jenkins
        Configuration.browser = System.getProperty("browserName"); // Браузер (например, chrome)
        Configuration.browserVersion = System.getProperty("browserVersion"); // Версия браузера
        Configuration.browserSize = System.getProperty("browserSize"); // Разрешение экрана
        Configuration.remote = System.getProperty("remoteUrl"); // URL удалённого браузера с логином и паролем
        // Другие настройки
        Configuration.pageLoadStrategy = "normal";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 6000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        // Логирование для Allure
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    public void preparation() {
        registrationPage = new RegistrationPage();
        registrationPage.openPage().removeBanners();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
