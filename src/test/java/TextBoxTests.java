import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }


    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Artem");
        $("#userEmail").setValue("Artem@mail.ru");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Another address 2");
        $("#submit").click();
        $("#output").shouldHave(text("Artem"), text("Artem@mail.ru"), text("Some address 1"), text("Another address 2"));

    }
}
