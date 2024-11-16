package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static io.qameta.allure.Allure.step;

public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Tag("Simple")
    @Tag("Smoke")
    @DisplayName("Заполнение простой формы регистрации. Все поля")
    @Test
    void fillFormTest() {
        step("Открыть страницу с формой", () -> {
            textBoxPage.openPage();
        });
        step("Заполнить поля формы", () -> {
            textBoxPage.setName("Kseniia")
                    .setEmail("my@email.ru")
                    .setCurrentAddress("My address now this")
                    .setPermanentAddress("My address is not house and is not street");
        });
        step("Отправить форму", () -> {
                    textBoxPage.submitForm();
        });
        step("Проверить отображение полей в таблице", () -> {
            textBoxPage.checkResult("Kseniia", "my@email.ru", "My address now this", "My address is not house and is not street");
        });
    }
}
