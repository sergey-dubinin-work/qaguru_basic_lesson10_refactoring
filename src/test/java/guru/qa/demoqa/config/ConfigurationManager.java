package guru.qa.demoqa.config;

import guru.qa.demoqa.config.selenoidConfig.SelenoidConfiguration;
import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

    public static SelenoidConfiguration getSelenoidConfig(){
        return ConfigCache.getOrCreate(SelenoidConfiguration.class);
    }

}
