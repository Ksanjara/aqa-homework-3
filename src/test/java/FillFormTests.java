import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FillFormTests {

    @BeforeAll
    static void preconditionsForAllTests(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillForm(){
        open("https://demoqa.com/automation-practice-form");

        //fill Name and Surname
        $("#firstName").setValue("Victoriia");
        $("#lastName").setValue("Mansurova");

        //fill email
        $("#userEmail").setValue("super@email.ru");

        //select sex
        $(byText("Female")).click();

        //enter phone number
        $("#userNumber").setValue("1234567890");

        //select date of birth
        $("#dateOfBirthInput").setValue("17 Jan 2024").pressEnter();

        //select subjects
        $("#subjectsInput").val("Maths").pressEnter();
        $("#subjectsInput").val("Chemistry").pressEnter();

        //select interests
        $(byText("Sports")).click();

        //upload picture
        $("#uploadPicture").uploadFile(new File("C:\\Users\\Cherry\\Desktop\\Google_Test_passed.png"));

        //enter address
        $("#currentAddress").setValue("some street \n and some house. Maybe 2?");

        //State and City fields
        $("#state").scrollIntoView(true).click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Lucknow")).click();

        //Submit form
        $("#submit").click();

        //checking result
        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));

    }
}