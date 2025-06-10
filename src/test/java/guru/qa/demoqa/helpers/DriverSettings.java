package guru.qa.demoqa.helpers;

import com.codeborne.selenide.Configuration;

import static guru.qa.demoqa.config.ConfigurationManager.getWebDriverConfig;
import static guru.qa.demoqa.config.ConfigurationManager.getSelenoidConfig;

public class DriverSettings {

    public static void configure(){

        Browser browser =  Browser.valueOf(getWebDriverConfig().webBrowser().toUpperCase());

        Configuration.browser = browser.getBrowserName();

        if (getSelenoidConfig().selenoidUrl() != null){
            Configuration.remote = String.format(
                    "%s:%s/wd/hub",
                    getSelenoidConfig().selenoidUrl(),
                    getSelenoidConfig().selenoidPort()
            );
        } else {
           browser.setupBrowserManager();
        }

        browser.setupBrowserOptions();

    }

}
