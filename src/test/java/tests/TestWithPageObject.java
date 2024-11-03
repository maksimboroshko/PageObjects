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

    String email = "test@gmail.com";
    String firstName = "Test";
    String lastName = "Testov";
    String gender = "Other";
    int day = 18;
    int month = 02;
    int year = 2000;
    
    RegistrationPages registrationPages =
            new RegistrationPages();
    @Test
    void successfulRegistrationTest() {
        registrationPages.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .emailInput(email)
                .setGender(gender)
                .numberInput("77777777777")
                .setDateOfBirthday("18", "02", "2000")
                .subjectsInput("E")
                .hobbieInput("Music")
                .uploadPicture("test.png")
                .setAddress("gte-to")
                .inputCity("NCR")
                .inputState("Noida")
                .submit();

        // Проверяем, что модальное окно появилось
        registrationPages.getResultsTableComponent().checkModalAppears();

        // Проверяем значения, используя ResultsTableComponent
        registrationPages.getResultsTableComponent().checkResult("Student Name", firstName + " " + lastName);
        registrationPages.getResultsTableComponent().checkResult("Student Email", email);
        registrationPages.getResultsTableComponent().checkResult("Gender", gender);
        registrationPages.getResultsTableComponent().checkResult("Mobile", "7777777777");
        registrationPages.getResultsTableComponent().checkResult("Date of Birth", "18 February,2000");
        registrationPages.getResultsTableComponent().checkResult("Subjects", "English");
        registrationPages.getResultsTableComponent().checkResult("Hobbies", "Music");
        registrationPages.getResultsTableComponent().checkResult("Picture", "test.png");
        registrationPages.getResultsTableComponent().checkResult("Address", "gte-to");
        registrationPages.getResultsTableComponent().checkResult("State and City", "NCR Noida");
    }
}