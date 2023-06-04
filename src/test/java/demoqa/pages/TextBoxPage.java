package demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    SelenideElement
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputForm = $("#output"),
            outputName = outputForm.$("#name"),
            outputEmail = outputForm.$("#email"),
            outputCurrentAddress = outputForm.$("#currentAddress"),
            outputPermanentAddress = outputForm.$("#permanentAddress");


    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName(String fullName) {
        userNameInput.setValue(fullName);
        return this;
    }

    public TextBoxPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress) {
        permanentAddressInput.setValue(permanentAddress);
        return this;
    }

    public TextBoxPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkOutputFormVisible() {
        outputForm.shouldBe(visible);
        return this;
    }

    public TextBoxPage checkOutputResult(String name, String email, String currentAddress, String permanentAddress) {
        outputName.shouldHave(text("Name:" + name));
        outputEmail.shouldHave(text("Email:" + email));
        outputCurrentAddress.shouldHave(text("Current Address :" + currentAddress));
        outputPermanentAddress.shouldHave(text("Permananet Address :" + permanentAddress));
        return this;
    }

}
