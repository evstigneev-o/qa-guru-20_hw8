package demoqa.tests;

import com.codeborne.selenide.Configuration;
import demoqa.pages.StudentRegistrationPage;
import demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
    }
}
