package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class FillFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFullForm(){
        registrationPage.openPage()
                        .setFirstName("Victoriia")
                        .setLastName("Mansurova")
                        .setEmail("super@email.ru")
                        .setGender("Female")
                        .setUserNumber("1234567890")
                        .setDateOfBirth("17", "January", "1995")
                        .setSubjects("Maths").setSubjects("Chemistry")
                        .setInterest("Sports")
                        .uploadPicture("Google_Test_passed.png")
                        .setAddress("some street \n and some house. Maybe 2?")
                        .setState("Uttar Pradesh")
                        .setCity("Lucknow")
                        .submitForm();

        registrationPage.checkResult("Student Name", "Victoriia Mansurova")
                .checkResult("Student Email", "super@email.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "17 January,1995")
                .checkResult("Subjects", "Maths, Chemistry")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "Google_Test_passed.png")
                .checkResult("Address", "some street and some house. Maybe 2?")
                .checkResult("State and City", "Uttar Pradesh Lucknow");

    }

    @Test
    void fillRequiredOnly(){
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Abramov")
                .setGender("Male")
                .setUserNumber("8900000000")
                .setDateOfBirth("15", "November", "1987")
                .submitForm();

        registrationPage.checkResult("Student Name", "Ivan Abramov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8900000000")
                .checkResult("Date of Birth", "15 November,1987");
    }

    @Test
    void incorrectUserNumber(){
        registrationPage.openPage()
                .setFirstName("Essa")
                .setLastName("Kuznetsova")
                .setGender("Other")
                .setUserNumber("1234")
                .setDateOfBirth("15", "December", "2005")
                .submitForm();

        registrationPage.checkResultIsNotVisible();
    }
}

