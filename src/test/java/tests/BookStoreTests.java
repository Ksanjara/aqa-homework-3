package tests;


import io.restassured.response.Response;
import models.books.AddBookRequestBodyModel;
import models.books.Isbn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static tests.ApiSteps.*;
import static tests.WebSteps.*;


public class BookStoreTests extends TestBase {
    @Tag("Simple")
    @Tag("Smoke")
    @DisplayName("Удаление книги из списка")
    @Test
    void deleteBookFromList() {
        Response responseLogin = login(testData.bookStoreLogin, testData.bookStorePassword);
        String token = responseLogin.path("token");
        String userId = responseLogin.path("userId");
        String expires = responseLogin.path("expires");
        clearListOfUserBooks(token, userId);
        Isbn isbn = new Isbn();
        isbn.setIsbn(testData.isbn);
        List<Isbn> listIsbns = List.of(isbn);
        AddBookRequestBodyModel bookData = new AddBookRequestBodyModel(userId, listIsbns);
        addBooks(token, bookData);
        openUserBooksPage(userId, expires, token);
        checkBookExistenceByName(testData.bookName);
        deleteBookByName(testData.bookName);
        checkBookAbsenceByName(testData.bookName);
    }
}
