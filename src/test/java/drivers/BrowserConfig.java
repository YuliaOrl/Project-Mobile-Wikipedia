package drivers;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties",
})

public interface BrowserConfig extends Config {
    @Key("browserstack.user")
    String getBrowserstackUser();

    @Key("browserstack.key")
    String getBrowserstackKey();

    @Key("browserstack.url")
    String getBrowserstackUrl();

    @Key("app")
    String getAppUrl();

    @Key("device")
    String getDeviceName();

    @Key("os_version")
    String getOsVersion();

    @Key("project")
    String getProjectName();

    @Key("build")
    String getBuildName();

    @Key("name")
    String getName();

    @Key("platformName")
    String getPlatformName();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();
}

