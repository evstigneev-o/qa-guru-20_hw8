package demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import demoqa.helpers.Attach;
import demoqa.pages.StudentRegistrationPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    Faker faker = new Faker();

    @BeforeAll
    static void setUp() {
      //  Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        //Configuration.remote = System.getProperty("selenoid");
        Configuration.baseUrl = System.getProperty("baseUrl");
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        //Configuration.headless = true;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }
}
