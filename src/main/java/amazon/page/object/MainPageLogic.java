package amazon.page.object;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPageLogic implements MainPageLocators {

    public SingInPageLogic clickOnSignInBtn() {
        signInBtn.shouldBe(visible).click();
        return page(SingInPageLogic.class);
    }

    public MainPageLogic timeOut(int time){
        sleep(time);
        return this;
    }
}
