import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubHoverTest {

    @BeforeAll
    static void preconditionsForAllTests() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void menuHoverTest(){
        //open github
        open("");
        //open solutions drop-down
        $("nav.HeaderMenu-nav").$(byText("Solutions")).hover();
        //open Enterprise page
        $("ul.list-style-none").$(byText("Enterprise")).click();
        // assert that opened page is correct
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" + "developer platform."));



    }
}
