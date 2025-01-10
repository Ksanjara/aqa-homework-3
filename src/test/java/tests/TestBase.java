package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigReader;
import config.ProjectConfig;
import config.auth.AuthConfig;
import config.auth.BookStoreAuthConfigReader;
import config.web.WebConfig;
import data.TestData;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.ProfileBooksPage;
import pages.RegistrationPage;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    public static final AuthConfig authConfig = BookStoreAuthConfigReader.Instance.read();
    private static final WebConfig webConfig = ConfigReader.Instance.read();
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH);
    public TestData testData = new TestData();
    public RegistrationPage registrationPage = new RegistrationPage();
    public ProfileBooksPage profileBooksPage = new ProfileBooksPage();

    @BeforeAll
    static void preconditionsForAllTests() {
        ProjectConfig projectConfiguration = new ProjectConfig(webConfig, authConfig);
        projectConfiguration.webConfig();
        projectConfiguration.apiConfig();
    }

    @BeforeEach
    void preconditionsForEachTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();

    }
}
