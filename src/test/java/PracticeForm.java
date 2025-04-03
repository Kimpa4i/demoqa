import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void practiceFormTest() {
        String userName = "John";
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");


        $("#firstName").setValue(userName);
        $("#lastName").setValue("Wick");
        $("#userEmail").setValue("JohnWick@gmail.com");
//        $("#gender-radio-1").click(); //wrong
//        $("#gender-radio-1").parent().click();//good
//        $(byText("Other")).click();// not very good local lenguage
//        $("label[for = gender-radio-1]").click();// good
        $("#genterWrapper").$(byText("Other")).click();// best
        $("#userNumber").setValue("89777237756");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");  // or selectOptionByValue
//        $(".react-datepicker__month-select").selectOptionByValue("6");  // or selectOptionByValue
        $(".react-datepicker__year-select").selectOptionByValue("1994");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//        $x( "//*[@class=' react-datepicker__day--030'] [not (contains(@class, 'react-datepicker__day-outside-month'))]").click(); //xpath

        $("#subjectsInput").setValue("Math").pressEnter();
//        $$("div.subjects-auto-complete__option").findBy(text("Maths")).click();

        $("#hobbiesWrapper").$(byText("Sports")).click();// best
//        Мой вариант
//        $("#hobbies-checkbox-1").sibling(0).click();
//        $("#hobbies-checkbox-2").sibling(0).click();
//        $("#hobbies-checkbox-3").sibling(0).click();
//
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#uploadPicture").uploadFromClasspath("img/1.png"); //best
//        #uploadPicture
        $("#currentAddress").setValue("Some address 1");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
//        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();


        $("#submit").click();


        $(".modal-dialog").should(appear);
        $(".modal-header > .modal-title").shouldHave(text("Thanks for submitting the form"));
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text(userName), text("Wick"), text("JohnWick@gmail.com"));

//        $("#output").shouldBe(Condition.visible);
//        $("#output #name").shouldHave(text(userName));
//        $("#output #email").shouldHave(text("Egor@egor.com"));


//        sleep(5000);


    }
}
