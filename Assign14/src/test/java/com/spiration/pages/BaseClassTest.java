package com.spiration.pages;

import com.aspiration.pages.BaseClass;
import com.aspiration.utils.BrowserSetup;
import com.aspiration.utils.ReadPropertiesFiles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class BaseClassTest {

    private static WebDriver driver;
    private static String url;
    private static String browserName;
    private static BaseClass baseClass;
    private static Properties browserProperties;
    private static Properties xpathProperties;

    //    initialize baseclasss
    @BeforeTest
    public void init() throws IOException {
        browserProperties = ReadPropertiesFiles.readPropertiesFile("src/test/resources/Browser" +
                ".properties");
        xpathProperties = ReadPropertiesFiles.readPropertiesFile("src/test/resources/Xpath" +
                ".properties");
        url = browserProperties.getProperty("url");
        browserName = browserProperties.getProperty("browserName");
        driver = BrowserSetup.startBrowser(driver, browserName, url);
        baseClass = new BaseClass(driver, xpathProperties);
    }

    //    sanity check that the home page logo works
    @Test
    public void goToHomePageTest() {
        driver.get(url);
        baseClass.goToHomePage();
        String url1 = driver.getCurrentUrl();
        Assert.assertEquals(url, url1);
    }

    //    check that get started takes to the sign-up page
    @Test
    public void goToGetStartedTest() {
        driver.get(url);
        baseClass.goTogetStarted();
        By message = By.xpath(xpathProperties.getProperty("startedMessage"));
        String alertMessage = driver.findElement(message).getText();
        Assert.assertEquals("LET'S GET STARTED", alertMessage);
    }

    //    checking link of save and spend page
    @Test
    public void goToSpendAndSaveTest() {
        driver.get(url);
        baseClass.goTospendAndSave();
        String url1 = driver.getCurrentUrl();
        Assert.assertEquals("https://www.aspiration.com/spendandsave", url1);
    }

    @AfterTest
    public void closeDriver() {
        BrowserSetup.quitBrowser(driver);
    }


}
