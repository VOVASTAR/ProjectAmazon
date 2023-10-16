package amazon.page.object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface SignInPageLocators {

    SelenideElement formTitle = $(By.xpath("//h1[@class='a-spacing-small']"));
    SelenideElement fieldEmailOrMobilePhone = $(By.id("ap_email"));
    SelenideElement fieldPassword = $(By.id("ap_password"));
    SelenideElement btnContinue = $(By.xpath("//span[@id='continue']"));
    SelenideElement btnSignIn = $(By.id("signInSubmit"));
    SelenideElement alertMessageEmailField = $(By.xpath("//*[@id='auth-email-missing-alert']//div[@class='a-alert-content']"));
    SelenideElement alertMessageInvalidEmail = $(By.xpath("//span[@class='a-list-item']"));

}
