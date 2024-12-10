package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.RegistrationPage;


public class TestBase {
    RegistrationPage registrationPage;
    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browser = "chrome"; // Укажите браузер
        Configuration.headless = true; // Headless режим для сервера Jenkins
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager"; // Можно также попробовать "normal"
        Configuration.timeout = 5000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    public void preparation() {
        registrationPage = new RegistrationPage();
        registrationPage.openPage().removeBanners();
    }

    @AfterEach
    void addAtachments (){
        Attach.screenshotAs("Last screenshot")
    }
}