package pages;
import com.codeborne.selenide.SelenideElement;
import pages.component.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPages {

    private static SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            setGender = $("#genterWrapper"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckBox = $("label[for='hobbies-checkbox-1']"),
            hobbiesCheckBox1 = $("label[for='hobbies-checkbox-1']"),
    hobbiesCheckBox2 = $("label[for='hobbies-checkbox-1']");

    CalendarComponent calendarComponent = new CalendarComponent();

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


    public RegistrationPages setDateOfBirthday(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPages subjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPages hobbiesCheckBox(){
        hobbiesCheckBox.click();
        return this;
    }
    public RegistrationPages hobbiesCheckBox1(){
        hobbiesCheckBox1.click();
        return this;
    }
    public RegistrationPages hobbiesCheckBox2(){
        hobbiesCheckBox2.click();
        return this;
    }
}

