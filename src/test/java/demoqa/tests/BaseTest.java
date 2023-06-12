package demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import demoqa.pages.StudentRegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    Faker faker = new Faker();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
    }
}
