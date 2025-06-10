package guru.qa.demoqa.helpers;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

public enum Browser {

    CHROME{
        @Override
        public void setupBrowserManager() {
            WebDriverManager.chromedriver().setup();
        }

        @Override
        public void setupBrowserOptions() {
            ChromeOptions options = new ChromeOptions();
            options.setCapability("selenoid:options", selenoidOptions());
            Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        }
    },

    FIREFOX{
        @Override
        public void setupBrowserManager() {
            WebDriverManager.firefoxdriver().setup();
        }

        @Override
        public void setupBrowserOptions() {
            FirefoxOptions options = new FirefoxOptions();
            options.setCapability("selenoid:options", selenoidOptions());
            Configuration.browserCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        }
    };

    public String getBrowserName(){
        return this.toString().toLowerCase();
    };

    public abstract void setupBrowserManager();

    public abstract void setupBrowserOptions();

    private static Map<String, Object> selenoidOptions(){
        return Map.of(
                "enableVNC", true,
                "enableVideo", true
        );
    }

}
