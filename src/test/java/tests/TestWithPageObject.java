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
                .removeBanners()
                .setFirstName(randomFirstName)
                .setLastName(randomLastName)
                .setEmail(randomEmail)
                .setGender(randomGender)
                .setNumber(randomNumber)
                .setDateOfBirthday(18,"February",02)
                .setSubjects(randomSubjects)
                .setHobbies(randomHobbie)
                .uploadPicture(picture)
                .setAddress(randomAdress)
                .setState(state)
                .setCity(city)
                .submit();

        // Проверяем, что модальное окно появилось
        registrationPages.getResultsTableComponent().checkModalAppears();

        //Проверяем значения, используя ResultsTableComponent
        registrationPages.getResultsTableComponent().checkResult("Student Name", randomFirstName + " " + randomLastName);
        registrationPages.getResultsTableComponent().checkResult("Student Email", randomEmail);
        registrationPages.getResultsTableComponent().checkResult("Gender", randomGender);
        registrationPages.getResultsTableComponent().checkResult("Mobile", randomNumber);
        registrationPages.getResultsTableComponent().checkResult("Date of Birth", 18 + "February" +  " ," + 02);
        registrationPages.getResultsTableComponent().checkResult("Subjects", randomSubjects);
        registrationPages.getResultsTableComponent().checkResult("Hobbies", randomHobbie);
        registrationPages.getResultsTableComponent().checkResult("Picture", picture);
        registrationPages.getResultsTableComponent().checkResult("Address", randomAdress);
        registrationPages.getResultsTableComponent().checkResult("State and City", randomCity + " " + randomState);
    }

    @Test
    void minCountPositiveTest (){
        registrationPages.openPage()
                .setFirstName(randomFirstName)
                .setLastName(randomLastName)
                .setGender(randomGender)
                .setNumber(randomNumber)
                .submit();

        registrationPages.getResultsTableComponent().checkModalAppears();

        registrationPages.getResultsTableComponent().checkResult("Student Name", randomFirstName + " " + randomLastName);
        registrationPages.getResultsTableComponent().checkResult("Gender", randomGender);
        registrationPages.getResultsTableComponent().checkResult("Mobile", randomNumber);
    }
    @Test
    void negaitiveTest (){
        registrationPages.openPage()
                .setFirstName(randomFirstName)
                .setLastName(randomLastName)
                .setGender(randomGender)
                .submit();

        registrationPages.getResultsTableComponent().checkResultNegative();
    }
}