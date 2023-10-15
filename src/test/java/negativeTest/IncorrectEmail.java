package negativeTest;

import amazon.page.object.MainPageLogic;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static amazon.logic.ChromeOptionsConfig.getChromeOptions;
import static com.codeborne.selenide.Selenide.open;


public class IncorrectEmail {
//    WebDriver driver;
//    WebDriverWait webDriverWait;
    @BeforeMethod
    public void before() {

//        WebDriverManager.chromedriver().setup();
//        Configuration.browser = "chrome";
//        FirefoxOptions firefoxOptions = getChromeOptions();
//        ChromeOptions chromeOptions = getChromeOptions();
//        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        open("https://www.amazon.com/");
        WebDriverRunner.getWebDriver().manage().window().maximize();

//        WebDriverManager.chromedriver().setup();
//         driver = new ChromeDriver();
//         webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5000));
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

    }

    @Test()
    @Flaky()
    @Owner("Vova")
    @Description("Test check alert message with incorrect email")
    @Severity(SeverityLevel.NORMAL)
    public void checkAlertWithIncorrectEmail() {
//        driver.get("https://www.amazon.com/");
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
