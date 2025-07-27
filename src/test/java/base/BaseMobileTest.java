package base;

import driver.AppiumDriverFactory;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import driver.MobileDriverManager;

public class BaseMobileTest {
    @BeforeEach
    public void setUp() {
        MobileDriverManager.getDriver(); // Создание происходит внутри
    }

    @AfterEach
    public void tearDown() {
        MobileDriverManager.quitDriver();
    }
}
