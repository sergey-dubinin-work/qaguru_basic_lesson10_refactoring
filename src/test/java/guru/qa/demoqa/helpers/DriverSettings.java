package guru.qa.demoqa.helpers;

import com.codeborne.selenide.Configuration;

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
            Browsers.valueOf(Configuration.browser.toUpperCase()).setupBrowserManager();
        }

        Browsers.valueOf(Configuration.browser.toUpperCase()).setupBrowserOptions();

    }

}
