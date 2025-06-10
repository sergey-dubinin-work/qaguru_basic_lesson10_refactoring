package guru.qa.demoqa.helpers;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

import static guru.qa.demoqa.config.ConfigurationManager.getWebDriverConfig;
import static guru.qa.demoqa.config.ConfigurationManager.getSelenoidConfig;

public class DriverSettings {

    public static void configure(){

        Configuration.browser = getWebDriverConfig().webBrowser();

        if (getSelenoidConfig().selenoidUrl() != null){
            Configuration.remote = String.format(
                    "%s:%s/wd/hub",
                    getSelenoidConfig().selenoidUrl(),
                    getSelenoidConfig().selenoidPort()
            );
        } else {
            Browsers.valueOf(Configuration.browser.toUpperCase()).webDriverManager.setup();
        }

        ChromeOptions options = new ChromeOptions();

        options.setCapability("selenoid:options", new HashMap<String, Object>() {
                    {
                        put("enableVNC", true);
                        put("enableVideo", true);
                    }
                }
        );

        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options); // todo: add browsersSupport

    }

}
