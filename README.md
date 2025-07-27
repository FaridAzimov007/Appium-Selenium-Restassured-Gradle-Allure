# 📱 Mobile Test Automation Framework

This project is a clean and scalable mobile test automation framework for Android applications using Java 21, Appium (UiAutomator2), JUnit 5, Gradle, RestAssured/DTO+Lombok approach for API testing and Allure Reporting.

## 🚀 Features

- ✅ Page Object Model — separation of locators and actions
- ✅ Fluent Step Chaining — readable and maintainable test flows
- ✅ Reusable Action Layer — common mobile actions: click, type, swipe, getText
- ✅ Allure Reporting — integrated with @Step, @Description, @DisplayName
- ✅ Tag-Based Execution — run tests by tags like @Tag("Smoke")
- ✅ Session Isolation — new driver instance for each test

## 🧪 Sample Test Flow
``` public void purchaseProductAndValidateCartAndCheckout() {
        new LoginPageSteps()
                .loginWithValidCredentials("user-login", "user-password")
                .addProductToCartAndGoToCart()
                .validateProductDataAndGoToCheckout()
                .fillCheckoutInfoAndGoToOverview()
                .verifyProductDataProceedCheckoutComplete()
                .verifySuccessfulCheckoutMessage();
    }
   ```
## 🚀 How to execute
To execute only Mobile UI Smoke tests, run:
```bash
./gradlew clean Smoke
```
To execute only Rest Api tests, run:
```bash
./gradlew clean RestApi
```

## 📊 Allure Report
After executing the tests, you can generate and open an Allure report:

```bash
./gradlew allureReport
./gradlew allureServe
```
## Setup Guide
---
### 1. Install Java (21 or compatible)
- Verify installation:
```bash
java -version
```

### 2. Install Node.js (required for Appium)
- Download Node.js
- Verify installation:
```bash
node -v
npm -v
```

### 3. Install Appium CLI
```npm install -g appium```

### 4. Install Appium Inspector (optional but useful)
- Download Appium Inspector - https://github.com/appium/appium-inspector/releases

### 5. Install Appium drivers
```appium driver install uiautomator2```

## Android Setup
### 6. Install Android Studio
- Download Android Studio
- Add ANDROID_HOME to your environment variables:
```
export ANDROID_HOME=$HOME/Library/Android/sdk
export PATH=$ANDROID_HOME/emulator:$ANDROID_HOME/platform-tools:$PATH
```

### 7. Create an Android Virtual Device (AVD)
- Use Android Studio > Device Manager
- Make sure emulator launches successfully:
```
emulator -list-avds
emulator -avd <your_avd_name>
```

## 8. How to run appium  server and configure Inspector
### 9. Start Appium Server
In terminal:
```appium```

### 10. Download your .apk file
Place it in your project or downloads folder.

### 11. Configure Appium Inspector and start session
```JSON Representation:
{
  "platformName": "Android",
  "appium:automationName": "UiAutomator2",
  "appium:app": "/Users/faridazimov/Desktop/PortnovSchool/apk/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk",
  "appium:newCommandTimeout": 150,
  "appium:deviceName": "emulator-5554",
  "appium:appWaitActivity": "com.swaglabsmobileapp.*"
}
```

### 12. Start Android Emulator (if not already running)



