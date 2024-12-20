package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class FillFormTests extends TestBase {

    @Test
    void fillFullFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
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
                .setCity(testData.userCity)
                .submitForm();

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

    }


    @Test
    void fillRequiredOnlyTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.userGender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.birthdayDay)
                .submitForm();

        registrationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.userGender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.birthdayDay.format(formatter));
    }

    @Disabled
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

