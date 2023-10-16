package positiveTest;

import amazon.page.object.MainPageLogic;
import amazon.page.object.YourStorePageLogic;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static amazon.logic.ChromeOptionsConfig.getChromeOptions;
import static com.codeborne.selenide.Selenide.open;


public class UserSignIn {

    @BeforeTest
    public void before() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = getChromeOptions();
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        open("https://www.amazon.com/");

    }


    @Test()
    @Flaky()
    @Owner("Vova")
    @Description("Test check successful user login")
    @Severity(SeverityLevel.BLOCKER)
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
