package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.ModalDialogComponent;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationPage {
    String pageHeader = "Student Registration Form";
    String successSubmitFormText = "Thanks for submitting the form";
    CalendarComponent calendarComponent = new CalendarComponent();
    ModalDialogComponent submittingForm = new ModalDialogComponent();
    SelenideElement
            practiceFormWrapper = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDayInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateDropDownMenu = $("#state"),
            cityDropDownMenu = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submitButton = $("#submit"),
            modalDialog = $(".modal-dialog"),
            modalDialogText = $("#example-modal-sizes-title-lg");

    public void closeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public StudentRegistrationPage openPage() {
        open("/automation-practice-form");
        practiceFormWrapper.shouldHave(text(pageHeader));
        closeBanners();
        return this;
    }

    public StudentRegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public StudentRegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public StudentRegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public StudentRegistrationPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public StudentRegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }


    public StudentRegistrationPage setBirthDay(String day, String month, String year) {
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public StudentRegistrationPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).press(Keys.ENTER);
        return this;
    }

    public StudentRegistrationPage setHobbies(String hobby) {
        hobbiesInput.$(byText(hobby)).click();
        return this;
    }

    public StudentRegistrationPage uploadPicture(File image) {
        uploadPictureInput.uploadFile(image);
        return this;
    }

    public StudentRegistrationPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public StudentRegistrationPage setState(String state) {
        stateDropDownMenu.click();
        stateCityWrapper.$(byText(state)).click();
        return this;
    }

    public StudentRegistrationPage setCity(String city) {
        cityDropDownMenu.click();
        stateCityWrapper.$(byText(city)).click();
        return this;
    }

    public StudentRegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public StudentRegistrationPage checkConfirmationFormVisible() {
        modalDialog.should(appear);
        modalDialogText.shouldHave(text(successSubmitFormText));
        return this;
    }

    public StudentRegistrationPage checkData(String key, String value) {
        submittingForm.matchKeyAndValue(key, value);
        return this;
    }
}
