package amazon.page.object;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class MainPageLogic implements MainPageLocators {

    @Step("Click on Sign in button")
    public SingInPageLogic clickOnSignInBtn() {
        signInBtn.shouldBe(visible).click();
        return page(SingInPageLogic.class);
    }

}
