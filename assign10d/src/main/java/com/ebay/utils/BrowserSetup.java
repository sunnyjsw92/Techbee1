package com.ebay.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserSetup {

    public static WebDriver startBrowser(WebDriver driver, String browserName, String url) {
        if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(BrowseCapabilities.firefoxOptionsSet());
        }
        else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if (browserName.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }
        else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(BrowseCapabilities.chromeOptionsSet());
        }
        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.get(url);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void quitBrowser(WebDriver driver) {
        driver.quit();
    }

}
