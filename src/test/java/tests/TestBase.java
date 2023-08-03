package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import drivers.BrowserstackDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        switch (System.getProperty("deviceHost")) {
            case "android", "ios" -> Configuration.browser = BrowserstackDriver.class.getName();
            case "emulator" -> Configuration.browser = LocalMobileDriver.class.getName();
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void afterEach() {
//        String sessionId = sessionId().toString();
        Attach.pageSource();
        closeWebDriver();
//        Attach.addVideo(sessionId);
    }
}