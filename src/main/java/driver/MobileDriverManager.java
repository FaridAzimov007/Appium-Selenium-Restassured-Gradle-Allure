package driver;

import config.PropertiesLoader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class MobileDriverManager {
    private static final ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    public static AndroidDriver getDriver() {
        if (driver.get() == null) {
            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertiesLoader.getProperty("platform.name"));
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesLoader.getProperty("device.name"));
            caps.setCapability(MobileCapabilityType.UDID, PropertiesLoader.getProperty("device.udid"));
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, PropertiesLoader.getProperty("automation.name"));
            caps.setCapability(MobileCapabilityType.APP, PropertiesLoader.getProperty("app.path"));
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
            caps.setCapability("appPackage", PropertiesLoader.getProperty("app.package"));
            caps.setCapability("appActivity", PropertiesLoader.getProperty("app.activity"));

            try {
                AndroidDriver androidDriver = new AndroidDriver(new URL(PropertiesLoader.getProperty("appium.server")), caps);
                driver.set(androidDriver);
                log.info("AndroidDriver initialized successfully.");
            } catch (MalformedURLException e) {
                log.error("Invalid Appium server URL", e);
                throw new RuntimeException("Appium server URL is invalid!", e);
            }
        }

        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            log.info("AndroidDriver quit and removed from ThreadLocal.");
        }
    }
}
