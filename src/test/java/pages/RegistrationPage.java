package pages;
import com.codeborne.selenide.SelenideElement;
import pages.component.CalendarComponent;
import pages.component.ResultsTableComponent;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

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

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        setFirstName.scrollTo().setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        setLastName.scrollTo().setValue(value);
        return this;
    }

    public RegistrationPage uploadPicture(String path) {
        uploadPicture.uploadFromClasspath(path);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        setEmail.scrollTo().setValue(value);
        return this;
    }

    public RegistrationPage setNumber(String value) {
        setNumber.scrollTo().setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        setGender.$(byText(value)).scrollTo().click();
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        setSubjects.scrollTo().setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        setHobbies.$(byText(value)).scrollTo().click();
        return this;
    }

    public RegistrationPage setAddress(String value) {
        setAddress.scrollTo().setValue(value);
        return this;
    }

    public RegistrationPage setState(String state) {
        setState.scrollTo().click();
        setState.$(byText(state)).click();

        return this;
    }

    public RegistrationPage setCity(String city) {
        setCity.scrollTo().click();
        setCity.$(byText(city)).click();

        return this;
    }


    public RegistrationPage submit() {
        submit.scrollTo().click();
        return this;
    }

    public RegistrationPage setDateOfBirthday(String day, String month, String year) {
        setCalendar.scrollTo().click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public ResultsTableComponent getResultsTableComponent() {
        return resultsTableComponent;
    }
}

