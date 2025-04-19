package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    RegistrationResultsModal registration = new RegistrationResultsModal();
    public static final String TITLE_TEXT = "Student Registration Form";
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");


    public RegistrationPage openPage() {
        open("/automation-practice-form");

        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;

    }

    public RegistrationPage clearLastName() {
        lastNameInput.clear();
        return this;

    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value);//todo selenide Elements
        return this;

    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText("Other")).click();//todo selenide Elements
        return this;

    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value);//todo selenide Elements
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }


    public RegistrationPage verifyRelutsModalAppears() {
        registration.verifyModalApears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registration.verifyResult(key, value);
        return this;
    }


}


