package tests;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;
import java.io.File;

public class TestWithPageObject extends TestBase {
    RegistrationPage registrationPage =
            new RegistrationPage();

    RandomUtils randomUtils = new RandomUtils();
    String firstName = randomUtils.generateRandomFirstName();
    String lastName = randomUtils.generateRandomLastName();
    String emailAddress = randomUtils.generateRandomEmail();
    String subscriberNumber = randomUtils.getRandomNumber();
    String day = randomUtils.generateRandomDay();
    String month = randomUtils.generateRandomMonth();
    String year = randomUtils.generateRandomYear();
    String gender = randomUtils.generateRandomGender();
    String subject = randomUtils.generateRandomSubject();
    String hobbie = randomUtils.generateRandomHobbies();
    String picture = randomUtils.generateRandomPicture();
    String adress = randomUtils.generateRandomAdress();
    String state = randomUtils.generateRandomState();
    String city = randomUtils.generateRandomCity(state);


    @Test
    @Step("Ввод данных в форму регистрации")
    @Tag("simple")
    void successfulRegistrationTest() {
        registrationPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(emailAddress)
                .setGender(gender)
                .setNumber(subscriberNumber)
                .setDateOfBirthday(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobbie)
                .uploadPicture(picture)
                .setAddress(adress)
                .setState(state)
                .setCity(city)
                .submit();

        // Проверяем, что модальное окно появилось
        registrationPage.getResultsTableComponent().checkModalAppears();

        //Проверяем значения, используя ResultsTableComponent
        registrationPage.getResultsTableComponent().checkResult("Student Name", firstName + " " + lastName);
        registrationPage.getResultsTableComponent().checkResult("Student Email", emailAddress);
        registrationPage.getResultsTableComponent().checkResult("Gender", gender);
        registrationPage.getResultsTableComponent().checkResult("Mobile", subscriberNumber);
        registrationPage.getResultsTableComponent().checkResult("Date of Birth", day + " " + month + "," + year);
        registrationPage.getResultsTableComponent().checkResult("Subjects", subject);
        registrationPage.getResultsTableComponent().checkResult("Hobbies", hobbie);
        registrationPage.getResultsTableComponent().checkResult("Picture", new File(picture).getName());
        registrationPage.getResultsTableComponent().checkResult("Address", adress);
        registrationPage.getResultsTableComponent().checkResult("State and City", state + " " + city);
    }

    @Test
    @Tag("other")
    void minCountPositiveTest (){
        registrationPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setNumber(subscriberNumber)
                .submit();

        registrationPage.getResultsTableComponent().checkModalAppears();

        registrationPage.getResultsTableComponent().checkResult("Student Name", firstName + " " + lastName);
        registrationPage.getResultsTableComponent().checkResult("Gender", gender);
        registrationPage.getResultsTableComponent().checkResult("Mobile", subscriberNumber);
    }
    @Test
    @Tag("other")
    void negaitiveTest (){
        registrationPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .submit();

        registrationPage.getResultsTableComponent().checkResultNegative();
    }
}

