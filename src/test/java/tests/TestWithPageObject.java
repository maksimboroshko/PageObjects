package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPages;
import utils.RandomUtils;

public class TestWithPageObject extends TestBase {
    RegistrationPages registrationPages =
            new RegistrationPages();

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
    void successfulRegistrationTest() {
        registrationPages.openPage()
                .removeBanners()
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
        registrationPages.getResultsTableComponent().checkModalAppears();

        //Проверяем значения, используя ResultsTableComponent
        registrationPages.getResultsTableComponent().checkResult("Student Name", firstName + " " + lastName);
        registrationPages.getResultsTableComponent().checkResult("Student Email", emailAddress);
        registrationPages.getResultsTableComponent().checkResult("Gender", gender);
        registrationPages.getResultsTableComponent().checkResult("Mobile", subscriberNumber);
        registrationPages.getResultsTableComponent().checkResult("Date of Birth", day + " " + month + "," + year);
        registrationPages.getResultsTableComponent().checkResult("Subjects", subject);
        registrationPages.getResultsTableComponent().checkResult("Hobbies", hobbie);
        registrationPages.getResultsTableComponent().checkResult("Picture", picture);
        registrationPages.getResultsTableComponent().checkResult("Address", adress);
        registrationPages.getResultsTableComponent().checkResult("State and City", state + " " + city);
    }

    @Test
    void minCountPositiveTest (){
        registrationPages.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setNumber(subscriberNumber)
                .submit();

        registrationPages.getResultsTableComponent().checkModalAppears();

        registrationPages.getResultsTableComponent().checkResult("Student Name", firstName + " " + lastName);
        registrationPages.getResultsTableComponent().checkResult("Gender", gender);
        registrationPages.getResultsTableComponent().checkResult("Mobile", subscriberNumber);
    }
    @Test
    void negaitiveTest (){
        registrationPages.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .submit();

        registrationPages.getResultsTableComponent().checkResultNegative();
    }
}