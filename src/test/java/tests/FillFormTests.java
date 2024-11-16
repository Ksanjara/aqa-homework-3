package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class FillFormTests extends TestBase {

    @Tag("Smoke")
    @DisplayName("Заполнение всех полей формы")
    @Test
    void fillFullFormTest() {
        step("Открыть страницу", () -> {
            registrationPage.openPage().removeBanners();
        });
        step("Заполнить все поля формы", () -> {
            registrationPage.setFirstName(testData.firstName)
                            .setLastName(testData.lastName)
                            .setEmail(testData.userEmail)
                            .setGender(testData.userGender)
                            .setUserNumber(testData.userNumber)
                            .setDateOfBirth(testData.birthdayDay)
                            .setSubjects(testData.userSubject)
                            .setInterest(testData.userInterest)
                            .uploadPicture(testData.picturePath)
                            .setAddress(testData.streetAddress)
                            .setState(testData.userState)
                            .setCity(testData.userCity);
                });
        step("Отправить форму", () -> {
                    registrationPage.submitForm();
                });
        step("Проверить отображение полей в таблице", () -> {
            registrationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Student Email", testData.userEmail)
                    .checkResult("Gender", testData.userGender)
                    .checkResult("Mobile", testData.userNumber)
                    .checkResult("Date of Birth", testData.birthdayDay.format(formatter))
                    .checkResult("Subjects", testData.userSubject)
                    .checkResult("Hobbies", testData.userInterest)
                    .checkResult("Picture", testData.picturePath)
                    .checkResult("Address", testData.streetAddress)
                    .checkResult("State and City", testData.userState + " " + testData.userCity);
        });

    }


    @Tag("Simple")
    @DisplayName("Заполнение только обязательных полей формы")
    @Test
    void fillRequiredOnlyTest() {
        step("Открыть страницу с формой", () -> {
            registrationPage.openPage()
                    .removeBanners();
        });
        step("Заполнить только обязательные поля", () -> {
            registrationPage.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setGender(testData.userGender)
                    .setUserNumber(testData.userNumber)
                    .setDateOfBirth(testData.birthdayDay);
        });
        step("Отправить форму", () -> {
            registrationPage.submitForm();
        });
        step("Проверить отображение заполненных полей в таблице", () -> {
            registrationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Gender", testData.userGender)
                    .checkResult("Mobile", testData.userNumber)
                    .checkResult("Date of Birth", testData.birthdayDay.format(formatter));
        });
    }

    @Tag("Smoke")
    @DisplayName("Неправильный номер пользователя")
    @Test
    void incorrectUserNumberTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.userGender)
                .setUserNumber(testData.shortUserNumber)
                .setDateOfBirth(testData.birthdayDay)
                .submitForm();

        registrationPage.checkNoResults();
    }
}

