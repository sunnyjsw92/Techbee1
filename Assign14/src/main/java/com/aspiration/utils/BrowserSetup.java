package com.aspiration.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.time.Duration;

public class BrowserSetup {

    public static WebDriver startBrowser(WebDriver driver, String browserName, String url) {
        if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver(com.aspiration.utils.BrowseCapabilities.firefoxOptionsSet());
            driver= new FirefoxDriver();
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
//            driver = new ChromeDriver(com.aspiration.utils.BrowseCapabilities.chromeOptionsSet());
            driver = new ChromeDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public static void quitBrowser(WebDriver driver) {
        driver.quit();
    }

}
