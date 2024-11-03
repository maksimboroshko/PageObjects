package pages.component;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {

    public void checkModalAppears() {
        $(".modal-content").should(appear);
        $(".modal-content .h4").shouldHave(text("Thanks for submitting the form"));
    }

    public void checkResult (String key, String value) {
        $(".modal-body .table-responsive").$(byText(key)).parent().shouldHave(text(value));

    }
}