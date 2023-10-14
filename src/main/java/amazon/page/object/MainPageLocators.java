package amazon.page.object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface MainPageLocators{

    SelenideElement signInBtn = $(By.id("nav-link-accountList"));

}
