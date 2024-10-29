package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static utils.RandomUtils.*;

public class FillFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker(new Locale("en"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userGender = getRandomGender();
    String userNumber = faker.number().digits(10);
    String shortUserNumber = faker.number().digits(9);
    String streetAddress = faker.address().streetAddress();
    String birthdayDay = String.valueOf(getRandomInt(5, 25));
    String birthdayMonth = getRandomMonth();

    String birthdayYear = String.valueOf(getRandomBirthYear());
    String userSubject = getRandomSubject();
    String userInterest = getRandomHobbie();
    String picturePath = "Google_Test_passed.png";
    String userState = getRandomState();
    String userCity = getRandomCityByState(userState);


    @Test
    void fillFullFormTest(){
        registrationPage.openPage()
                        .removeBanners()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(userEmail)
                        .setGender(userGender)
                        .setUserNumber(userNumber)
                        .setDateOfBirth(birthdayDay, birthdayMonth, birthdayYear)
                        .setSubjects(userSubject)
                        .setInterest(userInterest)
                        .uploadPicture(picturePath)
                        .setAddress(streetAddress)
                        .setState(userState)
                        .setCity(userCity)
                        .submitForm();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", birthdayDay + " " + birthdayMonth + "," + birthdayYear)
                .checkResult("Subjects", userSubject)
                .checkResult("Hobbies", userInterest)
                .checkResult("Picture", picturePath)
                .checkResult("Address", streetAddress)
                .checkResult("State and City", userState + " " + userCity);

    }

    @Test
    void fillRequiredOnlyTest(){
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(birthdayDay, birthdayMonth, birthdayYear)
                .submitForm();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", birthdayDay + " " + birthdayMonth + "," + birthdayYear);
    }

    @Test
    void incorrectUserNumberTest(){
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(shortUserNumber)
                .setDateOfBirth(birthdayDay, birthdayMonth, birthdayYear)
                .submitForm();

        registrationPage.checkNoResults();
    }
}

