package amazon.page.object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface YourStorePageLocators {

    SelenideElement accountName = $(By.id("nav-link-accountList-nav-line-1"));

}
