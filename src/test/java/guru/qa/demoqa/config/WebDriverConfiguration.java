package guru.qa.demoqa.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:webdriver.properties"
})
public interface WebDriverConfiguration extends Config {

    @DefaultValue("chrome")
    @Key("web.browser")
    String webBrowser();

}