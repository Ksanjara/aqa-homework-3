package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    private SelenideElement nameInput = $("#userName"),
    emailInput = $("#userEmail"),
    currentAddressInput = $("#currentAddress"),
    permanentAddressInput = $("#permanentAddress"),
    submitButton =  $("#submit"),
    nameOutput = $("#output #name"),
    emailOutput = $("#output #email"),
    currentAddressOutput =  $("#output #currentAddress"),
    permanentAddressOutput = $("#output #permanentAddress");

    public TextBoxPage openPage(){
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage setName(String name){
        nameInput.setValue(name);

        return this;
    }

    public TextBoxPage setEmail(String email){
        emailInput.setValue(email);

        return this;
    }

    public TextBoxPage setCurrentAddress(String address){
        currentAddressInput.setValue(address);

        return this;
    }

    public TextBoxPage setPermanentAddress(String address){
        permanentAddressInput.setValue(address);

        return this;
    }

    public TextBoxPage submitForm(){
        submitButton.click();

        return this;
    }

    public TextBoxPage checkResult(String name, String email, String currentAddress, String permanentAddress){
        nameOutput.shouldHave(Condition.text(name));
        emailOutput.shouldHave(Condition.text(email));
        currentAddressOutput.shouldHave(Condition.text(currentAddress));
        permanentAddressOutput.shouldHave(Condition.text(permanentAddress));

        return this;
    }


}
