package negativeTest;

import amazon.page.object.MainPageLogic;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static amazon.logic.ChromeOptionsConfig.getChromeOptions;
import static com.codeborne.selenide.Selenide.open;


public class IncorrectEmail {
    private final static int MAX_RETRY_COUNT = 5;
    @BeforeMethod
    public void before() {

//        WebDriverManager.chromedriver().driverVersion("114.0.5735.133").setup();
        Configuration.browser = "chrome";
        ChromeOptions chromeOptions = getChromeOptions();
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);


        int retryCount = 0;
        while(true)
        {
            try
            {
                open("https://www.amazon.com/");
                break;
            }
            catch(SessionNotCreatedException e)
            {
                if( retryCount > MAX_RETRY_COUNT )
                {
                    throw new RuntimeException("Too many retries...", e);
                }

//                logger.warn("encountered exception : ", e);
//                logger.warn("Trying again...");

                retryCount++;
                try
                {
                    Thread.sleep(2_000);
                }
                catch (InterruptedException interruptedException)
                {
                    interruptedException.printStackTrace();
                }
                continue;
            }
        }

//        open("https://www.amazon.com/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Test()
    @Flaky()
    @Owner("Vova")
    @Description("Test check alert message with incorrect email")
    @Severity(SeverityLevel.NORMAL)
    public void checkAlertWithIncorrectEmail() {

        new MainPageLogic()
                .clickOnSignInBtn()
                .checkTitleOfForm("Sign in")
                .fillFieldEmailOrMobilePhone("v.starchevskyi@")
                .clickOnBtnContinue()
                .checkAlertMessageEmail("We cannot find an account with that email address");
    }

    @Test()
    @Flaky()
    @Owner("Vova")
    @Description("Test check alert message near to email/phone field with empty email field")
    @Severity(SeverityLevel.NORMAL)
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
