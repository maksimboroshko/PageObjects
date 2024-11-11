package pages;
import com.codeborne.selenide.SelenideElement;
import pages.component.CalendarComponent;
import pages.component.ResultsTableComponent;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPages {

    private static SelenideElement
            setFirstName = $("#firstName"),
            setLastName = $("#lastName"),
            setEmail = $("#userEmail"),
            setNumber = $("#userNumber"),
            setGender = $("#genterWrapper"),

            setCalendar = $("#dateOfBirthInput"),
            setSubjects = $("#subjectsInput"),
            setHobbies = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            setAddress = $("#currentAddress"),
                    setState = $("#state"),
                    setCity = $("#city"),

            submit = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    public RegistrationPages openPage() {
        open("automation-practice-form");
        return this;
    }

    public RegistrationPages removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPages setFirstName(String value) {
        setFirstName.setValue(value);
        return this;
    }

    public RegistrationPages setLastName(String value) {
        setLastName.setValue(value);
        return this;
    }

    public RegistrationPages setEmail(String value) {
        setEmail.setValue(value);
        return this;
    }

      public RegistrationPages setNumber(String value) {
        setNumber.setValue(value);
        return this;
    }

    public RegistrationPages setGender(String value) {
        setGender.$(byText(value)).click();
        return this;
    }

    public RegistrationPages setSubjects(String value) {
        setSubjects.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPages setHobbies(String value) {
        setHobbies.$(byText(value)).click();
        return this;
    }

    public RegistrationPages uploadPicture(String value) {
        uploadPicture.uploadFromClasspath("test.png");
        return this;
    }

    public RegistrationPages setAddress(String value) {
        setAddress.setValue(value);
        return this;
    }

    public RegistrationPages setState(String value) {
        setState.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPages setCity(String value) {
        setCity.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPages submit() {
        submit.click();
        return this;
    }

    public RegistrationPages setDateOfBirthday(int day, String month, int year) {
        setCalendar.click();
        calendarComponent.setDate("18", "02", "2000");
        return this;
    }
    public ResultsTableComponent getResultsTableComponent() {
        return resultsTableComponent;
    }

}

