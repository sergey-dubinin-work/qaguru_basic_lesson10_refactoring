package guru.qa.demoqa.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

    public static WebDriverConfiguration getWebDriverConfig(){
        return ConfigCache.getOrCreate(WebDriverConfiguration.class);
    }

    public static SelenoidConfiguration getSelenoidConfig(){
        return ConfigCache.getOrCreate(SelenoidConfiguration.class);
    }

}
