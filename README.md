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


