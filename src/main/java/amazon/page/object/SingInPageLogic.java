package amazon.page.object;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.sleep;

public class SingInPageLogic implements SignInPageLocators {

    public SingInPageLogic checkTitleOfForm(String title) {
        formTitle.shouldBe(visible).shouldHave(exactText(title));
        return this;
    }

    public SingInPageLogic fillFieldEmailOrMobilePhone(String emailOrPhone) {
        fieldEmailOrMobilePhone.shouldBe(visible).clear();
        fieldEmailOrMobilePhone.sendKeys(emailOrPhone);
        return this;
    }

    public SingInPageLogic clickOnBtnContinue() {
        btnContinue.shouldBe(visible).click();
        return this;
    }

    public SingInPageLogic fillFieldPassword(String password) {
        fieldPassword.shouldBe(visible).sendKeys(password);
        return this;
    }

    public SingInPageLogic clickOnBtnSignIn() {
        btnSignIn.shouldBe(visible).click();
        return this;
    }

    public SingInPageLogic checkAlertMessageEmail(String alertText) {
        alertMessageInvalidEmail.shouldBe(visible).shouldHave(text(alertText));
        return this;
    }

    public SingInPageLogic checkAlertEmptyEmailField(String alertText) {
        alertMessageEmailField.shouldBe(visible).shouldHave(text(alertText));
        return this;
    }

    public SingInPageLogic checkAlertEmptyEmailFieldColor(String color) {
        alertMessageEmailField.shouldBe(visible).shouldHave(cssValue("color", color));
        return this;
    }


    public SingInPageLogic timeOut(int time) {
        sleep(time);
        return this;
    }

}
