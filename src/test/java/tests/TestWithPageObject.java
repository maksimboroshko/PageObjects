package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPages;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
    import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
public class TestWithPageObject extends TestBase{

    RegistrationPages registrationPages =
            new RegistrationPages();
    @Test
    void successfulRegistrationTest(){
        registrationPages.openPage()
        .setFirstName("Test")
        .setLastName("Testov")
        .emailInput("test@gmail.com")
        .setGender("Other")
        .numberInput("77777777777")
        //.setDateOfBirthday("18", "02", "2000");
        .subjectsInput("E")
                .hobbiesCheckBox()
                .hobbiesCheckBox1()
                .hobbiesCheckBox2();
    }
}
