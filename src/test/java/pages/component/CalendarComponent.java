package pages.component;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;
public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
       $(".react-datepicker__month-select").$(byText("February")).click();
            $(".react-datepicker__year-select").$(byText("2000")).click();
        String daySelector = (day.length() == 1 ? "0" : "") + day;
        $(".react-datepicker__day.react-datepicker__day--" + daySelector).click();
}
}
