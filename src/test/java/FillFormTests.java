import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class FillFormTests {

    @BeforeAll
    static void preconditionsForAllTests(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void fillForm(){
        open("https://demoqa.com/automation-practice-form");

        //remove banners
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //fill Name and Surname
        $("#firstName").setValue("Victoriia");
        $("#lastName").setValue("Mansurova");

        //fill email
        $("#userEmail").setValue("super@email.ru");

        //select gender
        $("#genterWrapper").findElement(byText("Female")).click();

        //enter phone number
        $("#userNumber").setValue("1234567890");

        //select date of birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__month").$(byText("17")).click();

        //select subjects
        $("#subjectsInput").val("Maths").pressEnter();
        $("#subjectsInput").val("Chemistry").pressEnter();

        //select interests
        $("#hobbiesWrapper").findElement(byText("Sports")).click();

        //upload picture
        $("#uploadPicture").uploadFromClasspath("Google_Test_passed.png");

        //enter address
        $("#currentAddress").setValue("some street \n and some house. Maybe 2?");

        //State and City fields
        $("#state").scrollIntoView(true).click();
        $("#state").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#city").$(byText("Lucknow")).click();

        //Submit form
        $("#submit").click();

        //checking result
        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(Condition.text("Victoriia Mansurova"));
        $(".table-responsive").shouldHave(Condition.text("super@email.ru"));
        $(".table-responsive").shouldHave(Condition.text("Female"));
        $(".table-responsive").shouldHave(Condition.text("1234567890"));
        $(".table-responsive").shouldHave(Condition.text("17 January,1995"));
        $(".table-responsive").shouldHave(Condition.text("Maths, Chemistry"));
        $(".table-responsive").shouldHave(Condition.text("Sports"));
        $(".table-responsive").shouldHave(Condition.text("Google_Test_passed.png"));
        $(".table-responsive").shouldHave(Condition.text("some street and some house. Maybe 2?"));
        $(".table-responsive").shouldHave(Condition.text("Uttar Pradesh Lucknow"));

    }
}