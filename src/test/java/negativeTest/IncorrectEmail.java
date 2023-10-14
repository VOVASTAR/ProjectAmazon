package negativeTest;

import amazon.page.object.MainPageLogic;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static amazon.logic.ChromeOptionsConfig.getChromeOptions;
import static com.codeborne.selenide.Selenide.open;


public class IncorrectEmail {

    @BeforeMethod
    public void before() {

        Configuration.browser = "chrome";
        ChromeOptions chromeOptions = getChromeOptions();
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        open("https://www.amazon.com/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Test
    public void checkAlertWithIncorrectEmail() {

        new MainPageLogic()
//                .timeOut(10000)
                .clickOnSignInBtn()
                .checkTitleOfForm("Sign in")
                .fillFieldEmailOrMobilePhone("v.starchevskyi@")
                .clickOnBtnContinue()
                .checkAlertMessageEmail("We cannot find an account with that email address");
    }

    @Test
    public void checkAlertWithEmptyEmailField() {

        new MainPageLogic()
                .clickOnSignInBtn()
                .checkTitleOfForm("Sign in")
                .fillFieldEmailOrMobilePhone("")
                .clickOnBtnContinue()
                .checkAlertEmptyEmailField("Enter your email or mobile phone number")
                .checkAlertEmptyEmailFieldColor("rgba(196, 0, 0, 1)");
    }
}
