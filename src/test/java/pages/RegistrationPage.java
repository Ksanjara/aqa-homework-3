package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


    public class RegistrationPage {
        private SelenideElement firstNameInput = $("#firstName"),
                lastNameInput = $("#lastName"),
                userEmailInput = $("#userEmail"),
                genderWrapper = $("#genterWrapper"),
                userNumberInput = $("#userNumber"),
                calendarInput = $("#dateOfBirthInput"),
                subjectInput = $("#subjectsInput"),
                hobbieInput = $("#hobbiesWrapper"),
                pictureLoader = $("#uploadPicture"),
                addressInput = $("#currentAddress"),
                stateInput = $("#state"),
                cityInput = $("#city"),
                submitButton = $("#submit"),
                resultTable = $(".table-responsive"),
                resultTitle = $("#example-modal-sizes-title-lg");

        CalendarComponent calendarComponent = new CalendarComponent();

        //Page methods
        public RegistrationPage openPage() {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");

            return this;
        }

        public RegistrationPage setFirstName(String value) {
            firstNameInput.setValue(value);

            return this;
        }

        public RegistrationPage setLastName(String value) {
            lastNameInput.setValue(value);

            return this;
        }

        public RegistrationPage setEmail(String value) {
            userEmailInput.setValue(value);

            return this;
        }

        public RegistrationPage setGender(String value) {
            genderWrapper.$(byText(value)).click();

            return this;
        }

        public RegistrationPage setUserNumber(String value) {
            userNumberInput.setValue(value);

            return this;
        }

        public RegistrationPage setDateOfBirth(String day, String month, String year) {
            calendarInput.click();
            calendarComponent.setDate(day, month, year);

            return this;
        }

        public RegistrationPage setSubjects(String subject){
            subjectInput.val(subject).pressEnter();

            return this;
        }

        public RegistrationPage setInterest(String hobbie){
            hobbieInput.findElement(byText(hobbie)).click();

            return this;
        }

        public RegistrationPage uploadPicture(String path){
            pictureLoader.uploadFromClasspath(path);

            return this;
        }

        public RegistrationPage setAddress(String address){
            addressInput.setValue(address);

            return this;
        }

        public RegistrationPage setState(String state){
            stateInput.click();
            stateInput.$(byText(state)).click();

            return this;
        }

        public RegistrationPage setCity(String city){
            cityInput.click();
            cityInput.$(byText(city)).click();

            return this;
        }

        public RegistrationPage submitForm(){
            submitButton.click();

            return this;
        }

        public RegistrationPage checkResult(String key, String value) {
            resultTable.$(byText(key)).parent()
                    .shouldHave(text(value));

            return this;
        }

        public RegistrationPage checkResultIsNotVisible(){
            resultTitle.shouldNotBe(visible);

            return this;
        }
    }

