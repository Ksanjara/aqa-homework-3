package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProfileBooksPage {
    private final SelenideElement tableWithUserBooks = $(".ReactTable"),
            searchField = $("#searchBox"),
            deleteIcon = $("#delete-record-undefined"),
            modalOkButton = $("#closeSmallModal-ok");

    public ProfileBooksPage findBookByName(String bookName) {
        tableWithUserBooks.shouldHave(text(bookName));

        return this;
    }

    public ProfileBooksPage deleteBookByName(String bookName) {
        searchField.setValue(bookName);
        deleteIcon.click();
        modalOkButton.click();

        return this;
    }

    public ProfileBooksPage findNotBookByName(String bookName) {
        tableWithUserBooks.shouldNotHave(text(bookName));

        return this;
    }
}
