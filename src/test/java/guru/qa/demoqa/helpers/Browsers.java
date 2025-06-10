package guru.qa.demoqa.helpers;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public enum Browsers {

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
