package guru.qa.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.demoqa.config.driverConfig.DriverConfig;
import guru.qa.demoqa.helpers.AllureAttachments;
import guru.qa.demoqa.helpers.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

    @BeforeAll
    static void setup() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.setCapability("selenoid:options", new HashMap<String, Object>() {
                    {
                        put("enableVNC", true);
                        put("enableVideo", true);
                    }
                }
        );

        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

        Configuration.browser = System.getProperty("web.browser", "chrome");

//        Configuration.remote = String.format(
//                "%s:%s/wd/hub",
//                getSelenoidConfig().selenoidUrl(),
//                getSelenoidConfig().selenoidPort()
//        );

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
