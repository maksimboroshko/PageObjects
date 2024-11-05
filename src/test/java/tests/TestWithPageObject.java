package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPages;
import static tests.TestData.*;
public class TestWithPageObject extends TestBase{

    
    RegistrationPages registrationPages =
            new RegistrationPages();
    @Test
    void successfulRegistrationTest() {
        registrationPages.openPage()
                .setFirstName(randomFirstName)
                .setLastName(randomLastName)
                .emailInput(RandomEmail)
                .setGender(randomGender)
                .numberInput(randomNumber)
                //.setDateOfBirthday(randomDay, month, year)
                .subjectsInput(randomSubjects)
                .hobbieInput(randomHobbie)
                .uploadPicture(picture)
                .setAddress(randomAdress)
                .inputCity(city)
                .inputState(state)
                .submit();

        // Проверяем, что модальное окно появилось
        registrationPages.getResultsTableComponent().checkModalAppears();

        // Проверяем значения, используя ResultsTableComponent
        registrationPages.getResultsTableComponent().checkResult("Student Name", randomFirstName + " " + randomLastName);
        registrationPages.getResultsTableComponent().checkResult("Student Email", RandomEmail);
        registrationPages.getResultsTableComponent().checkResult("Gender", randomGender);
        registrationPages.getResultsTableComponent().checkResult("Mobile", randomNumber);
        //registrationPages.getResultsTableComponent().checkResult("Date of Birth", randomDay + " " + month + "," + year);
        registrationPages.getResultsTableComponent().checkResult("Subjects", randomSubjects);
        registrationPages.getResultsTableComponent().checkResult("Hobbies", randomHobbie);
        registrationPages.getResultsTableComponent().checkResult("Picture", picture);
        registrationPages.getResultsTableComponent().checkResult("Address", randomAdress);
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