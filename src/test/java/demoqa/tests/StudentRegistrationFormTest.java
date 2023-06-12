package demoqa.tests;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDateTime;

import static demoqa.utils.RandomGenerator.*;

public class StudentRegistrationFormTest extends BaseTest {
    File studentImage = new File("src/test/resources/penny.jpeg");
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = getRandomGender();
    String dayOfBirth = String.format("%02d",faker.number().numberBetween(1,30));
    String monthOfBirth = getRandomMonth();
    String yearOfBirth = String.valueOf(faker.number().numberBetween(1900, LocalDateTime.now().getYear()));
    String mobile = faker.phoneNumber().subscriberNumber(10);
    String subjects = getRandomSubject();
    String hobby = getRandomHobbies();
    String currentAddress = faker.address().fullAddress();
    String state = getRandomState();
    String city = getRandomCity(state);

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
