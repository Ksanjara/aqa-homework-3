package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

import static utils.RandomUtils.*;

public class TestData {

    Faker faker = new Faker(new Locale("en"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userGender = faker.options().option("Male", "Female", "Other");
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String shortUserNumber = faker.phoneNumber().subscriberNumber(9);
    String streetAddress = faker.address().streetAddress();
    String birthdayDay = getBirthDay();
    String birthdayMonth = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "November", "December");
    String birthdayYear = String.valueOf(getRandomBirthYear());
    String userSubject = faker.options().option("Accounting", "Maths", "Arts", "Social Studies", "Chemistry", "Computer Science", "Commerce", "Physics", "Economics");
    String userInterest = faker.options().option("Sports", "Reading", "Music");
    String picturePath = "Google_Test_passed.png";
    String userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    String userCity = getRandomCityByState(userState);

}
