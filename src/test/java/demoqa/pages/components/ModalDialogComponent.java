package demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalDialogComponent {
    SelenideElement tableResponsive = $(".table-responsive");

    public void matchKeyAndValue(String key, String value) {
        tableResponsive.$(byText(key)).parent().shouldHave(text(value));
    }

}
