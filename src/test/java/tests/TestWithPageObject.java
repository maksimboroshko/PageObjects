package tests;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPages;
import static tests.TestData.*;
public class TestWithPageObject extends TestBase{

    
    RegistrationPages registrationPages =
            new RegistrationPages();
    @Test
    void successfulRegistrationTest() {
        registrationPages.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .emailInput(email)
                .setGender(gender)
                .numberInput(number)
                .setDateOfBirthday(day, month, year)
                .subjectsInput(letter)
                .hobbieInput(hobbies)
                .uploadPicture(picture)
                .setAddress(adress)
                .inputCity(city)
                .inputState(state)
                .submit();

        // Проверяем, что модальное окно появилось
        registrationPages.getResultsTableComponent().checkModalAppears();

        // Проверяем значения, используя ResultsTableComponent
        registrationPages.getResultsTableComponent().checkResult("Student Name", firstName + " " + lastName);
        registrationPages.getResultsTableComponent().checkResult("Student Email", email);
        registrationPages.getResultsTableComponent().checkResult("Gender", gender);
        registrationPages.getResultsTableComponent().checkResult("Mobile", number);
        registrationPages.getResultsTableComponent().checkResult("Date of Birth", day + " " + month + "," + year);
        registrationPages.getResultsTableComponent().checkResult("Subjects", letter);
        registrationPages.getResultsTableComponent().checkResult("Hobbies", hobbies);
        registrationPages.getResultsTableComponent().checkResult("Picture", picture);
        registrationPages.getResultsTableComponent().checkResult("Address", adress);
        registrationPages.getResultsTableComponent().checkResult("State and City", city + " " + state);
    }

//    @Test
//    void minCountPositiveTest (){
//        registrationPages.openPage()
//                .setFirstName(firstName)
//                .setLastName(lastName)
//                .setGender(gender)
//                .numberInput("77777777777")
//                .submit();
//
//        registrationPages.getResultsTableComponent().checkModalAppears();
//
//        registrationPages.getResultsTableComponent().checkResult("Student Name", firstName + " " + lastName);
//        registrationPages.getResultsTableComponent().checkResult("Gender", gender);
//        registrationPages.getResultsTableComponent().checkResult("Mobile", "7777777777");
//    }
//    @Test
//    void negaitiveTest (){
//        registrationPages.openPage()
//                .setFirstName(firstName)
//                .setLastName(lastName)
//                .setGender(gender)
//                .submit();
//
//        registrationPages.getResultsTableComponent().checkResultNegative();
//    }
}