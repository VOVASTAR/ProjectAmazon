package amazon.page.object;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class SingInPageLogic implements SignInPageLocators {

    @Step("Check title of SignIn form")
    public SingInPageLogic checkTitleOfForm(String title) {
        formTitle.shouldBe(visible).shouldHave(exactText(title));
        return this;
    }

    @Step("Fill up field email or mobile phone with data")
    public SingInPageLogic fillFieldEmailOrMobilePhone(String emailOrPhone) {
        fieldEmailOrMobilePhone.shouldBe(visible).clear();
        fieldEmailOrMobilePhone.sendKeys(emailOrPhone);
        return this;
    }

    @Step("Click on Continue button")
    public SingInPageLogic clickOnBtnContinue() {
        btnContinue.shouldBe(visible).click();
        return this;
    }

    @Step("Fill up field password with data")
    public SingInPageLogic fillFieldPassword(String password) {
        fieldPassword.shouldBe(visible).sendKeys(password);
        return this;
    }

    @Step("Click on Sign in button")
    public SingInPageLogic clickOnBtnSignIn() {
        btnSignIn.shouldBe(visible).click();
        return this;
    }

    @Step("Check alert message with incorrect data in the email or mobile phone field")
    public SingInPageLogic checkAlertMessageEmail(String alertText) {
        alertMessageInvalidEmail.shouldBe(visible).shouldHave(text(alertText));
        return this;
    }

    @Step("Check alert message near the email or mobile phone field")
    public SingInPageLogic checkAlertEmptyEmailField(String alertText) {
        alertMessageEmailField.shouldBe(visible).shouldHave(text(alertText));
        return this;
    }

    @Step("Check color of alert message near the email or mobile phone field")
    public SingInPageLogic checkAlertEmptyEmailFieldColor(String color) {
        alertMessageEmailField.shouldBe(visible).shouldHave(cssValue("color", color));
        return this;
    }

}
