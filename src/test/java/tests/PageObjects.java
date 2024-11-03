//package tests;
//
//import com.codeborne.selenide.Configuration;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import static com.codeborne.selenide.Condition.text;
//import static com.codeborne.selenide.Selectors.byText;
//import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.Selenide.$;
//
//public class PageObjects {
//    import com.codeborne.selenide.Configuration;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.Keys;
//import java.io.File;
//
//import static com.codeborne.selenide.Condition.text;
//import static com.codeborne.selenide.Selectors.byText;
//import static com.codeborne.selenide.Selenide.*;
//
//        @BeforeAll
//        static void beforeAll() {
//            Configuration.baseUrl = "https://demoqa.com/";
//            Configuration.browserSize = "1920 x 1080";
//            Configuration.pageLoadStrategy = "eager";
//            Configuration.holdBrowserOpen = true;
//            Configuration.timeout = 5000;
//        }
//        @Test
//        void formTest() {
//            open("automation-practice-form");
//            executeJavaScript("$('#fixedban').remove()");
//            executeJavaScript("$('footer').remove()");
//            $("#uploadPicture").uploadFromClasspath("test.png");
//            $("#firstName").setValue("Test");
//            $("#lastName").setValue("Testov");
//            $("#userEmail").setValue("test@gmail.com");
//            $("#userNumber").setValue("77777777777");
//            $("#dateOfBirthInput").click();
//            $(".react-datepicker__month-select").$(byText("February")).click();
//            $(".react-datepicker__year-select").$(byText("2000")).click();
//            $(".react-datepicker__day.react-datepicker__day--018").click();
//
//            //$("#dateOfBirthInput").sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "1");
//            //$("#dateOfBirthInput").setValue("8 Feb 2000").pressEnter();
//            $("#currentAddress").setValue("testovoeSms");
//            $("label[for='gender-radio-1']").click();
//            $("label[for='hobbies-checkbox-1']").scrollTo().click();
//            $("label[for='hobbies-checkbox-2']").scrollTo().click();
//            $("label[for='hobbies-checkbox-3']").scrollTo().click();
//            $("#react-select-3-input").setValue("NCR").pressEnter();
//            $("#react-select-4-input").setValue("Noida").pressEnter();
//            $("#subjectsInput").setValue("English").pressEnter();
//            $("#submit").scrollTo().click();
//
//            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//            $("thead th:nth-of-type(1)").shouldHave(text("Label"));
//            $("thead th:nth-of-type(2)").shouldHave(text("Values"));
//
//            $("tbody tr:nth-of-type(1) td:nth-of-type(2)").shouldHave(text("Test Testov"));
//            $("tbody tr:nth-of-type(2) td:nth-of-type(2)").shouldHave(text("test@gmail.com"));
//            $("tbody tr:nth-of-type(3) td:nth-of-type(2)").shouldHave(text("Male"));
//            $("tbody tr:nth-of-type(4) td:nth-of-type(2)").shouldHave(text("7777777777"));
//            $("tbody tr:nth-of-type(5) td:nth-of-type(2)").shouldHave(text("18 February,2000"));
//            $("tbody tr:nth-of-type(6) td:nth-of-type(2)").shouldHave(text("English"));
//            $("tbody tr:nth-of-type(7) td:nth-of-type(2)").shouldHave(text("Sports, Reading, Music"));
//            $("tbody tr:nth-of-type(8) td:nth-of-type(2)").shouldHave(text("test.png"));
//            $("tbody tr:nth-of-type(9) td:nth-of-type(2)").shouldHave(text("testovoeSms"));
//            $("tbody tr:nth-of-type(10) td:nth-of-type(2)").shouldHave(text("NCR Noida"));
//            $("#closeLargeModal").scrollTo().click();
//        }
//    }
//}
