package fey.test;

import java.net.*;
import java.time.Duration;
import java.util.*;

import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.*;
import io.appium.java_client.android.options.UiAutomator2Options;


import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.CustomField;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import org.testng.annotations.Test;



public class TestGoogleSearch {

   ReportiumClient reportiumClient;
   UiAutomator2Options uiAutomator2Options;

    @Test
    public void testGoogleSearch() throws Exception {
        System.out.println("starting testGoogleSearch");

        // UiAutomator2Options for Appium 2.0
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setDeviceName("R5CWA2726XK");
        uiAutomator2Options.setAutomationName("UiAutomator2");

        // perfecto capabilities
        Map<String, Object> perfectoOptions = new HashMap<>();
        perfectoOptions.put("securityToken", "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3NTQzOTMyNTQsImp0aSI6ImNjZDgxMjQyLTI3YzctNDYxNS05Mzk2LTM1NzExZDhiY2YwYyIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiYzNhZDkxZTgtZTRhYS00YTU5LThiMzItZTIxNmM2MDYyODA0IiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiI0ZjMwYmMyOS05MmFjLTQ0ZDItOWIyYy0yZDdiZjljY2Y5ZDQiLCJzZXNzaW9uX3N0YXRlIjoiZGNkMjZhYzktZWYwYy00NzEwLTk0OTItMGZiZTk2YjVhYWI3Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiJkY2QyNmFjOS1lZjBjLTQ3MTAtOTQ5Mi0wZmJlOTZiNWFhYjcifQ.tGIQck0sJxJPFuTw5d91DgBnc7zJaXTjs4sERlLHjCg");
        perfectoOptions.put("automationVersion", "1.70.1");
        perfectoOptions.put("javascriptEnabled", true);
        perfectoOptions.put("openDeviceTimeout", 5.0);
        perfectoOptions.put("scriptName", "Fey Google Search");
        perfectoOptions.put("screenshotOnError", true);
        perfectoOptions.put("takesScreenshot", true);
        perfectoOptions.put("browserName", "chrome");
        uiAutomator2Options.setCapability("perfecto:options", perfectoOptions);

        //Start the appium driver
        AndroidDriver driver = new AndroidDriver(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub"),
                uiAutomator2Options);
        System.out.println("driver started");
        System.out.println("Driver used: " + driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));

        // Reporting client. For more details, see http://developers.perfectomobile.com/display/PD/Reporting
        PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                .withProject(new Project("Fey new onboarding project", "1.0"))
                .withJob(new Job("Fey Onboarding job", 45))
                .withCustomFields(new CustomField("programmer", "Mike Fey"))
                .withCustomFields(new CustomField("author", "mike.fey@perforce.com"))
                .withContextTags("Appiumv2.0")
                .withWebDriver(driver)
                .build();
        ReportiumClient reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);

    // Add test steps here
        System.out.println("these are the test steps");
        reportiumClient.testStart("Report perforce search test", new TestContext("Appium_v2.0", "Android Web"));

        reportiumClient.stepStart("start step: launch perforce web");
        System.out.println("launching perforce.com");
        driver.get("https://www.google.com");
        // reportiumClient.stepEnd("end step: launched perfecto web");


        reportiumClient.stepStart("start step: search for perforce");
        System.out.println("doing a search");
     //  WebElement button = driver.findElement(By.id("com.android.chrome:id/negative_button"));
     // if (driver.findElement(By.id("com.android.chrome:id/negative_button")).isDisplayed()) {
      //    driver.findElement(By.id("com.android.chrome:id/negative_button")).click();
      // }
        System.out.println("typing search string");

       // reportiumClient.stepEnd("end step: launch google step");


// Print available contexts
        Set<String> contexts = driver.getContextHandles();
        for (String context : contexts) {
            System.out.println("Context: " + context);
        }

        // Switch to web context
        for (String context : contexts) {
            if (context.contains("WEBVIEW") || context.contains("CHROMIUM")) {
                driver.context(context);
                break;
            }
        }
        //WebElement searchGlass = driver.findElement(By.xpath("//*[@id='search-button']"));
       // searchGlass.click();

        System.out.println("using try-catch to click button if displayed");
        try {
            WebElement button = driver.findElement(By.id("com.android.chrome:id/negative_button"));

            if (button.isDisplayed()) {
                button.click();
                System.out.println("Button was displayed and clicked");
            } else {
                System.out.println("Button is not displayed.");
            }
        } catch (Exception e) {
            System.out.println("Button not found or other error: " + e.getMessage());
           // System.out.println("moving on to next steps");
        }

        // searchGlass.sendKeys("perforce");



        reportiumClient.testStop(TestResultFactory.createSuccess());

        System.out.println("finished test, quit driver");
        driver.quit();
    }

}
