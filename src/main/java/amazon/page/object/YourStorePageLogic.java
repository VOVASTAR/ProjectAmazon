package amazon.page.object;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class YourStorePageLogic implements YourStorePageLocators {

    public YourStorePageLogic checkAccountName(String name) {
        accountName.shouldBe(visible).shouldHave(text(name));
        return this;
    }
}
