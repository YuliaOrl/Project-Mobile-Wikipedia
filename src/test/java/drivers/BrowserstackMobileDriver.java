package drivers;

import com.codeborne.selenide.WebDriverProvider;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    static BrowserConfig config =
            ConfigFactory.create(
                    BrowserConfig.class,
                    System.getProperties()
            );

    @SneakyThrows
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.user", config.getBrowserstackUser());
        mutableCapabilities.setCapability("browserstack.key", config.getBrowserstackKey());
        mutableCapabilities.setCapability("app", config.getAppUrl());
        mutableCapabilities.setCapability("device", config.getDeviceName());
        mutableCapabilities.setCapability("os_version", config.getOsVersion());
        mutableCapabilities.setCapability("project", config.getProjectName());
        mutableCapabilities.setCapability("build", config.getBuildName());
        mutableCapabilities.setCapability("name", config.getName());
        return new RemoteWebDriver(new URL(config.getBrowserstackUrl()), mutableCapabilities);
    }
}