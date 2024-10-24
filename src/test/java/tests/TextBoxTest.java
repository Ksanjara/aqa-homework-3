package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setName("Kseniia")
                .setEmail("my@email.ru")
                .setCurrentAddress("My address now this")
                .setPermanentAddress("My address is not house and is not street")
                .submitForm();

        textBoxPage.checkResult("Kseniia", "my@email.ru", "My address now this","My address is not house and is not street" );
    }
}
