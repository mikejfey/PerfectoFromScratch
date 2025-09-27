package fey.test;


import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.*;
import org.testng.annotations.Test;

import java.net.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class TestWithXCUITestOptions {

    @Test
    public void testXCUITestOptions() throws Exception {

// Define the options for iOS
      // XCUITestOptions xcuiTestOptions = new XCUITestOptions(); //does not work.  use DesiredCapabilities instead
      // xcuiTestOptions.setCapability("deviceModel", "iPhone-14*"); // does not work
        DesiredCapabilities options = new DesiredCapabilities();
        options.setCapability("platformName", "iOS");
        options.setCapability("browserName", "Safari");

        //options.setApp("/path/to/your/app.app"); // Or use .ipa for real devices
        options.setCapability("appium:automationName", "XCUITest");
        System.out.println("setting deviceModel");

        //set perfecto capabilities
        Map<String, Object> perfectoOptions = new HashMap<>();
        perfectoOptions.put("securityToken", "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3NTQzOTMyNTQsImp0aSI6ImNjZDgxMjQyLTI3YzctNDYxNS05Mzk2LTM1NzExZDhiY2YwYyIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiYzNhZDkxZTgtZTRhYS00YTU5LThiMzItZTIxNmM2MDYyODA0IiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiI0ZjMwYmMyOS05MmFjLTQ0ZDItOWIyYy0yZDdiZjljY2Y5ZDQiLCJzZXNzaW9uX3N0YXRlIjoiZGNkMjZhYzktZWYwYy00NzEwLTk0OTItMGZiZTk2YjVhYWI3Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiJkY2QyNmFjOS1lZjBjLTQ3MTAtOTQ5Mi0wZmJlOTZiNWFhYjcifQ.tGIQck0sJxJPFuTw5d91DgBnc7zJaXTjs4sERlLHjCg");
        perfectoOptions.put("automationVersion", "1.70.1");
        perfectoOptions.put("deviceModel", "iPhone-14*");
        perfectoOptions.put("javascriptEnabled", true);
        perfectoOptions.put("openDeviceTimeout", 5.0);
        perfectoOptions.put("scriptName", "Fey Google XCUITest options");
        perfectoOptions.put("screenshotOnError", true);
        perfectoOptions.put("takesScreenshot", true);
        //perfectoOptions.put("browserName", "chrome");
        options.setCapability("perfecto:options", perfectoOptions);
        System.out.println("capabilities finished... try to start driver");
        // Start the Appium driver
        String perfectoURL = "https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub/";

        IOSDriver driver = new IOSDriver(new URL(perfectoURL), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));

        // Your test logic here
        System.out.println("App launched successfully!");

        // Quit the driver
        driver.quit();

    }
}
