package driver;

import config.PropertiesLoader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class AppiumDriverFactory {
//    private static AndroidDriver driver;
//
//    public static AndroidDriver getDriver() {
//        if (driver == null) {
//            initDriver();
//        }
//        return driver;
//    }
//
//    private static void initDriver() {
//        DesiredCapabilities caps = new DesiredCapabilities();
//
//        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertiesLoader.getProperty("platform.name"));        // Android
//        caps.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesLoader.getProperty("device.name"));            // emulator-5554
//        caps.setCapability(MobileCapabilityType.UDID, PropertiesLoader.getProperty("device.udid"));                   // emulator-5554
//        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, PropertiesLoader.getProperty("automation.name"));    // UiAutomator2
//        caps.setCapability(MobileCapabilityType.APP, PropertiesLoader.getProperty("app.path"));                       // path to .apk
//        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
//        caps.setCapability("appPackage", PropertiesLoader.getProperty("app.package"));
//        caps.setCapability("appActivity", PropertiesLoader.getProperty("app.activity"));
//
//        try {
//            driver = new AndroidDriver(new URL(PropertiesLoader.getProperty("appium.server")), caps);
//            log.info("AndroidDriver initialized successfully.");
//        } catch (MalformedURLException e) {
//            log.error("Failed to initialize AndroidDriver. Check Appium server URL.", e);
//            throw new RuntimeException("Appium server URL is invalid!", e);
//        }
//    }
//
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//            log.info("AndroidDriver stopped and set to null.");
//        }
//    }
}
