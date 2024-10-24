package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class GithubWikiTest {

    @BeforeAll
    static void preconditionsForAllTests() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void githubWikiHomeworkTest(){
        //open github selenide project
        open("selenide/selenide");

        //go to wiki page
        $("#wiki-tab").click();

        //open all pages
        $("#wiki-pages-box").$("button.Link--muted").click();

        //assert that SoftAssertions page is in Pages list
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));

        //open SoftAssertions page
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();

        //assert that page contains code example for JUnit 5
        $("div.markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));


    }
}