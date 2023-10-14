package positiveTest;

import amazon.page.object.MainPageLogic;
import amazon.page.object.YourStorePageLogic;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static amazon.logic.ChromeOptionsConfig.getChromeOptions;
import static com.codeborne.selenide.Selenide.open;


public class UserSignIn {

    @BeforeTest
    public void before() {

        Configuration.browser = "chrome";
        open("https://www.amazon.com/");
        ChromeOptions chromeOptions = getChromeOptions();
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        WebDriverRunner.getWebDriver().manage().window().maximize();

    }


    @Test
    public void successSignInTest() {

        new MainPageLogic()
                .clickOnSignInBtn()
                .checkTitleOfForm("Sign in")
                .fillFieldEmailOrMobilePhone("v.starchevskyi@gmail.com")
                .clickOnBtnContinue()
                .fillFieldPassword("Q112233q")
                .clickOnBtnSignIn();

        new YourStorePageLogic().checkAccountName("BOBASTAR");
    }

}
