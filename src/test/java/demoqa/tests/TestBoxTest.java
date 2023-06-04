package demoqa.tests;

import org.junit.jupiter.api.Test;

public class TestBoxTest extends BaseTest {

    String fullName = "Petr Petrov";
    String email = "12@bzzz.com";
    String currentAddress = "Russia, Moscow, Red Square, 1";
    String permanentAddress = "Russia, Moscow, Manezhnaya Square, 1";

    @Test
    public void successfulTextBoxInput() {
        textBoxPage.openPage()
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit();
        textBoxPage.checkOutputFormVisible()
                .checkOutputResult(fullName, email, currentAddress, permanentAddress);
    }
}
