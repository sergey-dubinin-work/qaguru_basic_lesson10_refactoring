package guru.qa.demoqa;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.demoqa.helpers.AllureAttachments;
import guru.qa.demoqa.helpers.DriverSettings;
import guru.qa.demoqa.helpers.DriverUtils;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BrowserTest {

    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DriverSettings.configure();
    }


    @AfterEach
    void tearDown() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();

        closeWebDriver();

        AllureAttachments.addVideo(sessionId);
    }

}
