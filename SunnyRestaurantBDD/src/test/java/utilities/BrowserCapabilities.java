package utilities;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BrowserCapabilities {

    public static ChromeOptions chromeOptionsSet() {
        ChromeOptions chromeOptions = new ChromeOptions();
//        waits till page is completely loaded
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.addArguments("--ignore-certificate-errors");
//        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-extensions");
        return chromeOptions;
    }

    public static FirefoxOptions firefoxOptionsSet() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 1);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.manager.focusWhenStarting", false);
        profile.setPreference("browser.download.useDownloadDir", true);
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.download.manager.closeWhenDone", true);
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        profile.setPreference("browser.download.manager.useWindow", false);
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        // You will need to find the content-type of your app and set it here.
//        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");

        FirefoxOptions capabilities = new FirefoxOptions();
        capabilities.setCapability("browser", "Firefox");
        capabilities.setCapability("browser_version", "latest");
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("os_version", "10");
        capabilities.setCapability("build", "Selenium Java Firefox Profile");
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        capabilities.setProfile(profile);
        return capabilities;
    }

}
