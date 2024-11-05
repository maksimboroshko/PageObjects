package pages;
import com.codeborne.selenide.SelenideElement;
import pages.component.CalendarComponent;
import pages.component.ResultsTableComponent;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPages {

    private static SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            setGender = $("#genterWrapper"),

            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbieInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            setAddress = $("#currentAddress"),
            inputCity = $("#react-select-3-input"),
            inputState = $("#react-select-4-input"),
            submit = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    public RegistrationPages openPage() {
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPages setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPages setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPages emailInput(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPages numberInput(String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPages setGender(String value) {
        setGender.$(byText(value)).click();
        return this;
    }

    public RegistrationPages subjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPages hobbieInput(String value) {
        hobbieInput.$(byText(value)).click();
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

    public RegistrationPages inputState(String value) {
        inputState.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPages inputCity(String value) {
        inputCity.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPages submit() {
        submit.click();
        return this;
    }

    public RegistrationPages setDateOfBirthday(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate("18", "02", "2000");
        return this;
    }
    public ResultsTableComponent getResultsTableComponent() {
        return resultsTableComponent;
    }

}

