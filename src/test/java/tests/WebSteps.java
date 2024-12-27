package tests;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import pages.ProfileBooksPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebSteps {
    static ProfileBooksPage profileBooksPage = new ProfileBooksPage();

    @Step("Открыть список добавленных книг пользователя")
    public static void openUserBooksPage(String userId, String expires, String token) {
        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", userId));
        getWebDriver().manage().addCookie(new Cookie("expires", expires));
        getWebDriver().manage().addCookie(new Cookie("token", token));
        open("/profile");
    }

    @Step("Проверить, что книга с названием {bookName} существует в профиле")
    public static void checkBookExistenceByName(String bookName) {
        profileBooksPage.findBookByName(bookName);
    }

    @Step("Удалить книгу с названием {bookName} из профиля пользователя")
    public static void deleteBookByName(String bookName) {
        profileBooksPage.deleteBookByName(bookName);
    }

    @Step("Проверить, что книга с названием {bookName} отсутствует в профиле")
    public static void checkBookAbsenceByName(String bookName) {
        profileBooksPage.findNotBookByName(bookName);
    }


}
