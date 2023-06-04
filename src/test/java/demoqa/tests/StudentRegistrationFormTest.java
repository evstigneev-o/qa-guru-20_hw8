package demoqa.tests;

import org.junit.jupiter.api.Test;

import java.io.File;

public class StudentRegistrationFormTest extends BaseTest {
    File studentImage = new File("src/test/resources/penny.jpeg");
    String firstName = "Test";
    String lastName = "Testov";
    String email = "test@testov.com";
    String gender = "Male";
    String dayOfBirth = "17";
    String monthOfBirth = "July";
    String yearOfBirth = "1995";
    String mobile = "8005553535";
    String subjects = "Computer Science";
    String hobby = "Sports";
    String currentAddress = "Moscow, 16 Pushkina street";
    String state = "NCR";
    String city = "Delhi";

    @Test
    public void checkStudentRegistrationForm() {
        studentRegistrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(mobile)
                .setBirthDay(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobby)
                .uploadPicture(studentImage)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();
        studentRegistrationPage
                .checkConfirmationFormVisible()
                .checkData("Student Name", String.format("%s %s", firstName, lastName))
                .checkData("Student Email", email)
                .checkData("Gender", gender)
                .checkData("Mobile", mobile)
                .checkData("Date of Birth", String.format("%s %s,%s", dayOfBirth, monthOfBirth, yearOfBirth))
                .checkData("Subjects", subjects)
                .checkData("Hobbies", hobby)
                .checkData("Picture", studentImage.getName())
                .checkData("Address", currentAddress)
                .checkData("State and City", String.format("%s %s", state, city));

    }

}
