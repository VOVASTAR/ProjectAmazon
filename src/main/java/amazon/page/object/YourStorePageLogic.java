package amazon.page.object;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class YourStorePageLogic implements YourStorePageLocators {

    @Step("Check account name in header")
    public YourStorePageLogic checkAccountName(String name) {
        accountName.shouldBe(visible).shouldHave(text(name));
        return this;
    }
}
