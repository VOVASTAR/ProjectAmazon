package amazon.logic;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsConfig {

    public static UserAgent getRandomUserAgent() {
        UserAgent[] userAgent = UserAgent.values();
        int randomIndex = (int) (Math.random() * userAgent.length);
        return userAgent[randomIndex];
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        chromeOptions.addArguments("--disable-features=AutomationControlled");
        chromeOptions.addArguments("--single-process");
//        chromeOptions.addArguments("--user-agent='" + getRandomUserAgent().userAgentName + "'");
        chromeOptions.addArguments("--ignore-certificate-errors");
        return chromeOptions;
    }

}
