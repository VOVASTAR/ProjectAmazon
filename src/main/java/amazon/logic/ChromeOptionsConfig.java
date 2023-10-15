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
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        chromeOptions.addArguments("--disable-features=AutomationControlled");
        chromeOptions.addArguments("--user-agent='" + getRandomUserAgent().userAgentName + "'");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--headless");
        return chromeOptions;
    }

}
