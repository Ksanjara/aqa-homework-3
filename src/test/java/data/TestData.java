package data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;

import static utils.RandomUtils.getBirthDay;
import static utils.RandomUtils.getRandomCityByState;

public class TestData {

    public static final String picturePath = "Google_Test_passed.png";
    public static final String bookStoreLogin = System.getProperty("bookStoreLogin");
    public static final String bookStorePassword = System.getProperty("bookStorePassword");
    public static final String isbn = "9781449365035";
    public static final String bookName = "Speaking JavaScript";
    public final LocalDate birthdayDay = getBirthDay(14, 35);
    Faker faker = new Faker(new Locale("en"));
    public final String firstName = faker.name().firstName();
    public final String lastName = faker.name().lastName();
    public final String userEmail = faker.internet().emailAddress();
    public final String userGender = faker.options().option("Male", "Female", "Other");
    public final String userNumber = faker.phoneNumber().subscriberNumber(10);
    public final String shortUserNumber = faker.phoneNumber().subscriberNumber(9);
    public final String streetAddress = faker.address().streetAddress();
    public final String userSubject = faker.options().option("Accounting", "Maths", "Arts", "Social Studies", "Chemistry", "Computer Science", "Commerce", "Physics", "Economics");
    public final String userInterest = faker.options().option("Sports", "Reading", "Music");
    public final String userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public final String userCity = getRandomCityByState(userState);

}
