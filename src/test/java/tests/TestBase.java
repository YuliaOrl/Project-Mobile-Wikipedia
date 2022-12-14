package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBase {

    @BeforeAll
    public static void setup() {
        Configuration.browserSize = null;

        switch (System.getProperty("deviceHost")) {
            case ("browserstack"):
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
            case ("real"):
            case ("emulation"):
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            default:
                throw new RuntimeException("Environment is wrong");
        }
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = Selenide.sessionId().toString();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();

        if (System.getProperty("deviceHost").equals("browserstack")) {
            Attach.video(sessionId);
        }
    }
}