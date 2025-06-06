package guru.qa.demoqa.config.driverConfig;

import org.aeonbits.owner.Config;

@Config.Sources({ "classpath:config/driver.properties" })
public interface DriverConfiguration extends Config {
    @Key("remote.web.user")
    String remoteWebUser();

    @Key("remote.web.password")
    String remoteWebPassword();
}